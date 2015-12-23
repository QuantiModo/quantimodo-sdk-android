package com.quantimodo.tools.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;


/**
 * Receiver that tracks every certain time the position of the device and tracks the place
 */
public class TrackPlacesReceiver extends WakefulBroadcastReceiver implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = TrackPlacesReceiver.class.getSimpleName();
    private static final int REQUEST_ID = 217259940;
    private static final String EXTRA_ALARM = "extra_alarm";

    AlarmManager alarmMgr;
    PendingIntent alarmIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        //TODO: test this because is not working
        if(intent.hasExtra(EXTRA_ALARM)) {
            GoogleApiClient mGoogleApiClient;

            mGoogleApiClient = new GoogleApiClient
                    .Builder(context)
                    .addApi(Places.GEO_DATA_API)
                    .addApi(Places.PLACE_DETECTION_API)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();

            mGoogleApiClient.connect();

            com.google.android.gms.common.api.PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi
                    .getCurrentPlace(mGoogleApiClient, null);
            result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
                @Override
                public void onResult(PlaceLikelihoodBuffer likelyPlaces) {
                    for (PlaceLikelihood placeLikelihood : likelyPlaces) {
                        Log.i(TAG, String.format("Place '%s' has likelihood: %g",
                                placeLikelihood.getPlace().getName(),
                                placeLikelihood.getLikelihood()));
                    }
                    likelyPlaces.release();
                }
            });


            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.d(TAG, "Google places connected event");
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "Google places connection suspended event");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "Google places connection failed event");
    }

    public void setAlarm(Context context) {
        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, TrackPlacesReceiver.class);
        intent.putExtra(EXTRA_ALARM, true);

        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                10 * 1000, 10 * 1000, alarmIntent);

        alarmIntent = PendingIntent.getBroadcast(context, REQUEST_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        setBootReceiver(context, true);
    }

    /**
     * Cancels the alarm.
     * @param context current context
     */
    public void cancelAlarm(Context context) {
        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, TrackPlacesReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(context, REQUEST_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmMgr.cancel(alarmIntent);

        setBootReceiver(context, false);
    }

    /**
     * Enable or disable {@code RemindersBootReceiver} so that it will or not automatically
     * restart the alarm when the device is rebooted
     * @param context the curent context
     * @param setEnabled if true it will enable the {@code RemindersReceiver} when the device boot
     */
    private void setBootReceiver(Context context, boolean setEnabled){
//        ComponentName receiver = new ComponentName(context, RemindersBootReceiver.class);
//        PackageManager pm = context.getPackageManager();
//
//        if(setEnabled){
//            pm.setComponentEnabledSetting(receiver,
//                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
//                    PackageManager.DONT_KILL_APP);
//        }
//        else{
//            pm.setComponentEnabledSetting(receiver,
//                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//                    PackageManager.DONT_KILL_APP);
//        }
    }
}
