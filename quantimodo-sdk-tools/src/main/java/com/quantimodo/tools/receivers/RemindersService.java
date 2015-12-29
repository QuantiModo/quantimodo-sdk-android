package com.quantimodo.tools.receivers;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
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
                    .append(CustomRemindersHelper.removeTrailingZeros(reminder.value)).append(" ")
                    .append(reminder.unitName).append(" of ")
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
        Intent popupIntent = new Intent(this, CustomRemindersReceiver.class);


        snoozeIntent.putExtra(CustomRemindersReceiver.EXTRA_NOTIFICATION_ID, reminderId);
        snoozeIntent.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, reminderId);
        snoozeIntent.putExtra(CustomRemindersReceiver.EXTRA_REQUEST_SNOOZE, true);
        trackIntent.putExtra(CustomRemindersReceiver.EXTRA_NOTIFICATION_ID, reminderId);
        trackIntent.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, reminderId);
        trackIntent.putExtra(CustomRemindersReceiver.EXTRA_REQUEST_REMINDER, true);
        editIntent.putExtra(CustomRemindersReceiver.EXTRA_NOTIFICATION_ID, reminderId);
        editIntent.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, reminderId);
        editIntent.putExtra(CustomRemindersReceiver.EXTRA_REQUEST_EDIT, true);
        popupIntent.putExtra(CustomRemindersReceiver.EXTRA_NOTIFICATION_ID, reminderId);
        popupIntent.putExtra(CustomRemindersHelper.EXTRA_REMINDER_ID, reminderId);
        popupIntent.putExtra(CustomRemindersReceiver.EXTRA_REQUEST_POPUP, true);

        PendingIntent trackPendingIntent = PendingIntent.getBroadcast(this,
                Integer.parseInt(reminderId),
                trackIntent, PendingIntent.FLAG_ONE_SHOT);
        PendingIntent snoozePendingIntent = PendingIntent.getBroadcast(this,
                Integer.parseInt(reminderId) + 1,
                snoozeIntent, PendingIntent.FLAG_ONE_SHOT);
        PendingIntent editPendingIntent = PendingIntent.getBroadcast(this,
                Integer.parseInt(reminderId) + 2,
                editIntent, PendingIntent.FLAG_ONE_SHOT);
        PendingIntent popupPendingIntent= PendingIntent.getBroadcast(this,
                Integer.parseInt(reminderId) + 3,
                popupIntent, PendingIntent.FLAG_ONE_SHOT);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(getString(R.string.reminders_notif_subtitle))
                .setSmallIcon(android.R.drawable.ic_menu_recent_history)
                .setAutoCancel(true)
                .setContentIntent(popupPendingIntent)
                .addAction(new NotificationCompat.Action(0,
                        getString(R.string.reminders_notif_button_track), trackPendingIntent))
                .addAction(new NotificationCompat.Action(0,
                        getString(R.string.reminders_notif_button_snooze), snoozePendingIntent))
                .addAction(new NotificationCompat.Action(0,
                        getString(R.string.reminders_notif_button_edit), editPendingIntent))
                .setColor(getResources().getColor(R.color.card_button))
                .build();

        notification.flags = Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(Integer.parseInt(reminderId), notification);
    }
}
