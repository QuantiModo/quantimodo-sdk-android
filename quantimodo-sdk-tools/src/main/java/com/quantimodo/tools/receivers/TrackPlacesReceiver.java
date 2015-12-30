package com.quantimodo.tools.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.quantimodo.tools.QTools;
import com.quantimodo.tools.ToolsPrefs;

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
    }
}
