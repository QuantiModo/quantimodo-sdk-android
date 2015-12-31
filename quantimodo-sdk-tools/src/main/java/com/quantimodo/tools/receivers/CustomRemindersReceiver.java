package com.quantimodo.tools.receivers;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

import com.octo.android.robospice.SpiceManager;
import com.quantimodo.android.sdk.model.Measurement;
import com.quantimodo.android.sdk.model.MeasurementSet;
import com.quantimodo.tools.QTools;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.dialogs.CustomReminderDialog;
import com.quantimodo.tools.sdk.DefaultSdkResponseListener;
import com.quantimodo.tools.sdk.request.SendMeasurementsRequest;
import com.quantimodo.tools.utils.CustomRemindersHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Broadcast receiver that gets the triggered alarms and display a popup to track custom measurements
 */
public class CustomRemindersReceiver extends WakefulBroadcastReceiver {
    public static final String EXTRA_REQUEST_ALARM = "extra_request_alarm";
    public static final String EXTRA_REQUEST_REMINDER = "extra_request_reminder";
    public static final String EXTRA_REQUEST_SNOOZE = "extra_request_snooze";
    public static final String EXTRA_REQUEST_EDIT = "extra_request_edit";
    public static final String EXTRA_REQUEST_POPUP = "extra_request_popup";
    public static final String EXTRA_NOTIFICATION_ID = "extra_notification_id";

    @Inject
    ToolsPrefs mPrefs;

    @Override
    public void onReceive(final Context context, Intent intent) {
        QTools.getInstance().inject(this);
        Bundle extras = intent.getExtras();
        final CustomRemindersHelper.Reminder reminder = CustomRemindersHelper.getReminder(
                context, extras.getString(CustomRemindersHelper.EXTRA_REMINDER_ID, ""));
        if(intent.hasExtra(EXTRA_REQUEST_ALARM)) {
            Intent service = new Intent(context, RemindersService.class);
            //shows the popup dialog
            CustomReminderDialog.getInstance().show(context, reminder.id);
            service.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, reminder.id);
            // Start the service, keeping the device awake while it is launching.
            //this service shows the notification and set the events for buttons
            startWakefulService(context, service);
        }
        else if(intent.hasExtra(EXTRA_REQUEST_REMINDER)){
            cancelNotification(context, Integer.parseInt(extras.getString(EXTRA_NOTIFICATION_ID, "0")));

            //when it's a custom reminder we need to directly send the measurement
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    final HashMap<String, MeasurementSet> measurementSets = new HashMap<>();
                    long timestampSeconds = new Date().getTime() / 1000;

                    Measurement measurement = new Measurement(timestampSeconds, Float.parseFloat(reminder.value));
                    MeasurementSet newSet = new MeasurementSet(
                            reminder.name, null, reminder.variableCategory, reminder.unitName,
                            reminder.combinationOperation, mPrefs.getApplicationSource());
                    newSet.getMeasurements().add(measurement);
                    measurementSets.put(reminder.unitName, newSet);

                    SpiceManager mSpiceManager = new SpiceManager(QTools.getInstance().getServiceClass());
                    mSpiceManager.start(context.getApplicationContext());
                    mSpiceManager.execute(new SendMeasurementsRequest(null, new ArrayList<>(measurementSets.values())),
                            new DefaultSdkResponseListener<Boolean>() {
                                @Override
                                public void onRequestSuccess(Boolean aBoolean) {
                                    Toast.makeText(context, "Tracked!", Toast.LENGTH_LONG).show();
                                }
                            });
                }
            });
            thread.start();
        }
        else if(intent.hasExtra(EXTRA_REQUEST_SNOOZE)){
            cancelNotification(context, Integer.parseInt(extras.getString(EXTRA_NOTIFICATION_ID, "0")));
            CustomRemindersHelper.setAlarm(context, reminder.id, CustomRemindersHelper.FrequencyType.SNOOZE);
        }
        else if(intent.hasExtra(EXTRA_REQUEST_EDIT)){
            cancelNotification(context, Integer.parseInt(extras.getString(EXTRA_NOTIFICATION_ID, "0")));
            startTracking(context, reminder.name);
        }
        else if(intent.hasExtra(EXTRA_REQUEST_POPUP)){
            cancelNotification(context, Integer.parseInt(extras.getString(EXTRA_NOTIFICATION_ID, "0")));
            CustomReminderDialog.getInstance().show(context, reminder.id);
        }
    }

    private void startTracking(Context context, String varName){
        Intent trackIntent = new Intent(context,
                CustomRemindersHelper.getInstance().getRegisteredActivity());
        trackIntent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_SINGLE_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK);
        trackIntent.putExtra(CustomRemindersHelper.EXTRA_VARIABLE_NAME, varName);
        context.startActivity(trackIntent);
    }

    private void cancelNotification(Context context, int notifId){
        NotificationManager notifManager = (NotificationManager) context.getSystemService(
                Context.NOTIFICATION_SERVICE);
        notifManager.cancel(notifId);
        //the same time when closing the notification we close the popup if any.
        if(CustomReminderDialog.getInstance().isShowing())
            CustomReminderDialog.getInstance().dismiss(context);
    }
}
