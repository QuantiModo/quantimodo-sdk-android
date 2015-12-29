package com.quantimodo.tools.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
import com.octo.android.robospice.SpiceManager;
import com.quantimodo.android.sdk.model.Measurement;
import com.quantimodo.android.sdk.model.MeasurementSet;
import com.quantimodo.tools.QTools;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.sdk.DefaultSdkResponseListener;
import com.quantimodo.tools.sdk.SdkException;
import com.quantimodo.tools.sdk.request.SendMeasurementsRequest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.inject.Inject;


/**
 * Receiver that tracks every certain time the position of the device and tracks the place
 */
public class TrackPlacesReceiver extends BroadcastReceiver {
    private static final String TAG = TrackPlacesReceiver.class.getSimpleName();
    private static final int REQUEST_ID = 217259940;
    private static final String EXTRA_ALARM = "extra_alarm";

    AlarmManager alarmMgr;
    PendingIntent alarmIntent;

    @Inject
    ToolsPrefs mPrefs;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        QTools.getInstance().inject(this);
        if(intent.hasExtra(EXTRA_ALARM)) {
            Intent newIntent = new Intent(context, TrackPlacesService.class);
            newIntent.putExtra(TrackPlacesService.EXTRA_SOURCE, mPrefs.getApplicationSource());
            context.startService(newIntent);
        }
    }

    public void setAlarm(Context context) {
        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, TrackPlacesReceiver.class);
        intent.putExtra(EXTRA_ALARM, true);

        alarmIntent = PendingIntent.getBroadcast(context, REQUEST_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, AlarmManager.INTERVAL_HOUR, alarmIntent);
//        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, 60 * 1000, alarmIntent);

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
