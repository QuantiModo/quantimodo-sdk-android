package com.quantimodo.tools.receivers;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.quantimodo.android.sdk.Utils;
import com.quantimodo.tools.sdk.AuthHelper;
import com.quantimodo.tools.sdk.request.NoNetworkConnection;
import com.quantimodo.tools.utils.CustomRemindersHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.swagger.client.ApiException;
import io.swagger.client.api.MeasurementApi;
import io.swagger.client.model.MeasurementPost;
import io.swagger.client.model.MeasurementValue;

/**
 * Broadcast receiver that gets the triggered alarms and display a popup to track custom measurements
 */
public class CustomRemindersReceiver extends WakefulBroadcastReceiver {
    public static final String EXTRA_REQUEST_ALARM = "extra_request_alarm";
    public static final String EXTRA_REQUEST_REMINDER = "extra_request_reminder";
    public static final String EXTRA_REQUEST_SNOOZE = "extra_request_snooze";
    public static final String EXTRA_REQUEST_EDIT = "extra_request_edit";
    public static final String EXTRA_NOTIFICATION_ID = "extra_notification_id";

    @Inject
    AuthHelper authHelper;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        CustomRemindersHelper.Reminder reminder = CustomRemindersHelper.getReminder(
                context, extras.getString(CustomRemindersHelper.EXTRA_REMINDER_ID, ""));
        //TODO: testear app para desplegar notification, luego crear popup dialog
        if(intent.hasExtra(EXTRA_REQUEST_ALARM)) {
            Intent service = new Intent(context, RemindersService.class);
            //shows the popup dialog
//            ReminderDialog.getInstance().show(context, reminder.id);
            service.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, reminder.id);
            // Start the service, keeping the device awake while it is launching.
            //this service shows the notification and set the events for buttons
            startWakefulService(context, service);
        }
        else if(intent.hasExtra(EXTRA_REQUEST_REMINDER)){
            cancelNotification(context, extras.getInt(EXTRA_NOTIFICATION_ID));

            //when it's a custom reminder we need to directly send the measurement
            MeasurementApi api = new MeasurementApi();
            MeasurementPost body = new MeasurementPost();
            body.setVariableId(Integer.parseInt(reminder.id));
            body.setUnitId(reminder.unitId);
            List<MeasurementValue> values = new ArrayList<>(1);
            MeasurementValue value = new MeasurementValue();
            value.setStartTime(Utils.formatDateToString(new Date()));
            value.setValue(Float.parseFloat(reminder.value));
            values.add(value);
            try {
                api.measurementsPost(authHelper.getAuthTokenWithRefresh(), body);
            } catch (ApiException | NoNetworkConnection e) {
                e.printStackTrace();
            }

        }
        else if(intent.hasExtra(EXTRA_REQUEST_SNOOZE)){
            cancelNotification(context, extras.getInt(EXTRA_NOTIFICATION_ID));
            CustomRemindersHelper.setAlarm(context, reminder.id, CustomRemindersHelper.FrecuencyType.SNOOZE);
        }
        else if(intent.hasExtra(EXTRA_REQUEST_EDIT)){
            cancelNotification(context, extras.getInt(EXTRA_NOTIFICATION_ID));
            startTracking(context, reminder.id);
        }
    }

    private void startTracking(Context context, String id){
        Intent trackIntent = new Intent(context,
                CustomRemindersHelper.getInstance().getRegisteredActivity().getClass());
        trackIntent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_SINGLE_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK);
        trackIntent.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, id);
        context.startActivity(trackIntent);
    }

    private void cancelNotification(Context context, int notifId){
        NotificationManager notifManager = (NotificationManager) context.getSystemService(
                Context.NOTIFICATION_SERVICE);
        notifManager.cancel(notifId);
    }
}
