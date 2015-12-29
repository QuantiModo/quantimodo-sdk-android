package com.quantimodo.tools.receivers;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

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
import com.quantimodo.tools.R;
import com.quantimodo.tools.sdk.DefaultSdkResponseListener;
import com.quantimodo.tools.sdk.SdkException;
import com.quantimodo.tools.sdk.request.SendMeasurementsRequest;
import com.quantimodo.tools.utils.CustomRemindersHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * This Service gets the nearby place and send a measurement with the info
 */
public class TrackPlacesService extends Service implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = TrackPlacesService.class.getSimpleName();
    public static final String EXTRA_SOURCE = "extra_source";

    private GoogleApiClient mGoogleApiClient;
    int mStartMode = START_REDELIVER_INTENT;       // indicates how to behave if the service is killed
    String appSource;
    int startId;

    @Override
    public void onCreate(){
        super.onCreate();
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // The service is starting, due to a call to startService()
        this.startId = startId;
        appSource = intent.getStringExtra(EXTRA_SOURCE);
        mGoogleApiClient.connect();
        return mStartMode;
    }
    @Override
    public void onDestroy() {
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
        Log.d(TAG, "Google places connected event");
        com.google.android.gms.common.api.PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi
                .getCurrentPlace(mGoogleApiClient, null);
        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
            @Override
            public void onResult(PlaceLikelihoodBuffer likelyPlaces) {
                if (!likelyPlaces.getStatus().isSuccess()) {
                    likelyPlaces.release();
                    mGoogleApiClient.disconnect();
                    return;
                }
                final PlaceLikelihood placeLikelihood = likelyPlaces.get(0);
                String message = String.format("Place '%s' has likelihood: %g",
                        placeLikelihood.getPlace().getName(),
                        placeLikelihood.getLikelihood());
                Log.i(TAG, message);
                final String placeName = placeLikelihood.getPlace().getName().toString();
                final Context context = mGoogleApiClient.getContext();

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
                            }

                            @Override
                            public void onSdkException(SdkException ex) {
                                ex.printStackTrace();
                            }
                        }
                );


                likelyPlaces.release();
                stopSelfResult(startId);
            }
        });
    }
    @Override
    public void onConnectionSuspended(int i) {
        Log.d(TAG, "Google places connection suspended event");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "Google places connection failed event");
    }
}
