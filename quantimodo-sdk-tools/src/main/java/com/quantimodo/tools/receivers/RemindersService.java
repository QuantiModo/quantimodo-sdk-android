package com.quantimodo.tools.receivers;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import com.quantimodo.tools.R;
import com.quantimodo.tools.utils.CustomRemindersHelper;

/**
 * This {@code IntentService} does the app's actual work.
 * {@code SampleAlarmReceiver} (a {@code WakefulBroadcastReceiver}) holds a
 * partial wake lock for this service while the service does its work. When the
 * service is finished, it calls {@code completeWakefulIntent()} to release the
 * wake lock.
 */
public class RemindersService extends IntentService {
    private static final String TAG = RemindersService.class.getSimpleName();

    public RemindersService() {
        super("RemindersService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent.hasExtra(CustomRemindersHelper.EXTRA_REMINDER_ID)){
            String reminderId = intent.getExtras().getString(
                    CustomRemindersHelper.EXTRA_REMINDER_ID);
            CustomRemindersHelper.Reminder reminder = CustomRemindersHelper.getReminder(this, reminderId);
            StringBuilder builder = new StringBuilder();
            builder
                    .append("Track ")
                    .append(reminder.value).append(" ")
                    .append(reminder.unitName).append(" ")
                    .append(reminder.name).append("?");

            sendNotification(reminderId, builder.toString());
        }
        else
            Log.d(TAG, "onHandleIntent has no extras");
        // Release the wake lock provided by the BroadcastReceiver.
        CustomRemindersReceiver.completeWakefulIntent(intent);
    }

    /**
     * Popup the notification and prepares de action over notifications
     * @param reminderId the reminder id that will also be used to identify the notification
     * @param title the title to put on the notification
     */
    private void sendNotification(String reminderId, String title) {
        NotificationManager notificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent snoozeIntent = new Intent(this, CustomRemindersReceiver.class);
        Intent trackIntent = new Intent(this, CustomRemindersReceiver.class);
        Intent editIntent = new Intent(this, CustomRemindersReceiver.class);


        snoozeIntent.putExtra(CustomRemindersReceiver.EXTRA_NOTIFICATION_ID, reminderId);
        snoozeIntent.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, reminderId);
        snoozeIntent.putExtra(CustomRemindersReceiver.EXTRA_REQUEST_SNOOZE, true);
        trackIntent.putExtra(CustomRemindersReceiver.EXTRA_NOTIFICATION_ID, reminderId);
        trackIntent.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, reminderId);
        trackIntent.putExtra(CustomRemindersReceiver.EXTRA_REQUEST_REMINDER, true);
        editIntent.putExtra(CustomRemindersReceiver.EXTRA_NOTIFICATION_ID, reminderId);
        editIntent.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, reminderId);
        editIntent.putExtra(CustomRemindersReceiver.EXTRA_REQUEST_EDIT, true);

        PendingIntent trackPendingIntent = PendingIntent.getBroadcast(this,
                0,
                trackIntent, PendingIntent.FLAG_ONE_SHOT);
        PendingIntent snoozePendingIntent = PendingIntent.getBroadcast(this,
                1,
                snoozeIntent, PendingIntent.FLAG_ONE_SHOT);
        PendingIntent editPendingIntent = PendingIntent.getBroadcast(this,
                2,
                editIntent, PendingIntent.FLAG_ONE_SHOT);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(getString(R.string.reminders_notif_subtitle))
                .setSmallIcon(R.drawable.clock)
                .setAutoCancel(true)
                .setContentIntent(trackPendingIntent)
                .build();

        if (Build.VERSION.SDK_INT >= 16) {
            RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.custom_reminder);
            contentView.setTextViewText(R.id.notification_reminder_title, title);
            contentView.setOnClickPendingIntent(R.id.custom_reminder_track, trackPendingIntent);
            contentView.setOnClickPendingIntent(R.id.custom_reminder_snooze, snoozePendingIntent);
            contentView.setOnClickPendingIntent(R.id.custom_reminder_edit, editPendingIntent);
            notification.bigContentView = contentView;
        }

        notification.flags = Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(Integer.parseInt(reminderId), notification);
    }
}
