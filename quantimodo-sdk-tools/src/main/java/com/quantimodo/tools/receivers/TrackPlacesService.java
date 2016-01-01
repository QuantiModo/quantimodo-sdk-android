package com.quantimodo.tools.receivers;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.quantimodo.android.sdk.model.Measurement;
import com.quantimodo.android.sdk.model.MeasurementSet;
import com.quantimodo.tools.QTools;
import com.quantimodo.tools.R;
import com.quantimodo.tools.sdk.DefaultSdkResponseListener;
import com.quantimodo.tools.sdk.SdkException;
import com.quantimodo.tools.sdk.request.SendMeasurementsRequest;
import com.quantimodo.tools.utils.CustomRemindersHelper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * This Service gets the nearby place and send a measurement with the info
 */
public class TrackPlacesService extends Service implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,LocationListener {
    private static final String TAG = TrackPlacesService.class.getSimpleName();
    public static final String EXTRA_SOURCE = "extra_source";

    private GoogleApiClient mGoogleApiClient;
    int mStartMode = START_REDELIVER_INTENT;       // indicates how to behave if the service is killed
    String appSource;
    int startId;

    @Override
    public void onCreate(){
        Log.d(TAG, "onCreate");
        super.onCreate();
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        // The service is starting, due to a call to startService()
        this.startId = startId;
        appSource = intent.getStringExtra(EXTRA_SOURCE);
        mGoogleApiClient.connect();
        return mStartMode;
    }
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
//        LocationServices.FusedLocationApi.removeLocationUpdates(
//                mGoogleApiClient, this);
        mGoogleApiClient.disconnect();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // A client is binding to the service with bindService()
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
    }


    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Google places connected event");
        requestGooglePlace();
//        final LocationRequest mLocationRequestHighAccuracy = LocationRequest
//                .create().setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
//                .setInterval(0)
//                .setFastestInterval(0)
//                .setNumUpdates(1)
//                .setExpirationTime(60*1000);
//        LocationServices.FusedLocationApi.requestLocationUpdates(
//                mGoogleApiClient, mLocationRequestHighAccuracy, this);
    }

    private void requestGooglePlace(){
        com.google.android.gms.common.api.PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi
                .getCurrentPlace(mGoogleApiClient, null);
        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
            @Override
            public void onResult(PlaceLikelihoodBuffer likelyPlaces) {
                final Context context = mGoogleApiClient.getContext();
                if (!likelyPlaces.getStatus().isSuccess()) {
                    Log.d(TAG, "No places found");
                    Toast.makeText(context.getApplicationContext(),
                            "Tracker: No places found", Toast.LENGTH_LONG).show();
                    likelyPlaces.release();
                    stopSelfResult(startId);
                    return;
                }
                final PlaceLikelihood placeLikelihood = likelyPlaces.get(0);
                String message = String.format("Place '%s' has likelihood: %g",
                        placeLikelihood.getPlace().getName(),
                        placeLikelihood.getLikelihood());
                Log.i(TAG, message);
                final String placeName = placeLikelihood.getPlace().getName().toString();

                final HashMap<String, MeasurementSet> measurementSets = new HashMap<>();
                long timestampSeconds = new Date().getTime() / 1000;

                Measurement measurement = new Measurement(timestampSeconds, 60);
                MeasurementSet newSet = new MeasurementSet(
                        placeName,
                        null,
                        "Location", //Category
                        "min", //unit name
                        "MEAN", //combination operation
                        appSource);
                newSet.getMeasurements().add(measurement);
                measurementSets.put("min", newSet);

                SpiceManager mSpiceManager = new SpiceManager(QTools.getInstance().getServiceClass());
                mSpiceManager.start(context.getApplicationContext());
                mSpiceManager.execute(new SendMeasurementsRequest(null, new ArrayList<>(measurementSets.values())),
                        new DefaultSdkResponseListener<Boolean>() {
                            @Override
                            public void onRequestSuccess(Boolean aBoolean) {
                                String message;
                                if (aBoolean)
                                    message = "Succeed sending measurement!: " + placeName;
                                else
                                    message = "Error when sending measurement:(!: " + placeName;
                                Log.d(TAG, message);
                                sendCrashlyticsLog(message);
                                Toast.makeText(context.getApplicationContext(),
                                        "Tracker: "+message, Toast.LENGTH_LONG).show();
                                stopSelfResult(startId);
                            }

                            @Override
                            public void onRequestFailure(SpiceException spiceException) {
                                Log.d(TAG, "onRequestFailure");
                                spiceException.printStackTrace();
                                sendCrashlyticsLog(spiceException.getMessage());
                                Toast.makeText(context.getApplicationContext(),
                                        "Tracker: "+spiceException.getMessage(), Toast.LENGTH_LONG).show();
                                stopSelfResult(startId);
                            }
                        }
                );
                likelyPlaces.release();
            }
        });
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Google places connection suspended event");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i(TAG, "Google places connection failed event");
    }

    private void sendCrashlyticsLog(String message){
        try {
            //We log payload if we have Crashlytics
            Class cls = Class.forName("com.crashlytics.android.Crashlytics");
            Class[] cArg = new Class[1];
            cArg[0] = String.class;
            Method method = cls.getMethod("log",cArg);
            method.invoke(null, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, "Location changed", Toast.LENGTH_SHORT).show();
        requestGooglePlace();
    }
}
