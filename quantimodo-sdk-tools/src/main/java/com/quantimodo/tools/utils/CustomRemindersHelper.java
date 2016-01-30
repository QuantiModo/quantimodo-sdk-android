package com.quantimodo.tools.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.quantimodo.tools.R;
import com.quantimodo.tools.receivers.CustomRemindersReceiver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import io.swagger.client.ApiException;
import io.swagger.client.api.RemindersApi;
import io.swagger.client.model.TrackingReminderPending;
import io.swagger.client.model.TrackingReminderPendingSkip;
import io.swagger.client.model.TrackingReminderPendingSnooze;
import io.swagger.client.model.TrackingReminderPendingTrack;

/**
 * This class saves the custom reminders as preferences
 */
public class CustomRemindersHelper {
    private static final String TAG = CustomRemindersHelper.class.getSimpleName();
    private static final String PREFERENCES_KEY = "custom_reminders_preferences";
    private static final String KEY_REMOTE_ID = "remote_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_COMBINATION_OPERATION = "combination_oepration";
    private static final String KEY_VALUE = "value";
    private static final String KEY_UNIT_NAME = "unit_name";
    private static final String KEY_FREQUENCY = "frequency_index";
    private static final String KEY_UPDATE = "need_update";
    private static final String KEY_REMINDERS_LIST = "reminders_list";
    /**
     * Extra used to broadcast the alarm when triggered
     */
    public static final String EXTRA_REMINDER_ID = "extra_reminder_id";
    /**
     * Extra used to send the variable name to the Activity that will open a
     * view to edit it
     */
    public static final String EXTRA_VARIABLE_NAME = "extra_variable_name";

    public static final long INTERVAL_THREE_HOURS = 3 * AlarmManager.INTERVAL_HOUR;

    public enum FrequencyType {
        NEVER,
        HOURLY,
        EVERY_THREE_HOURS,
        TWICE_A_DAY,
        DAILY,
        SNOOZE,
        THREE_TIMES_A_DAY;

        @Override
        public String toString() {
            switch(this) {
                case NEVER: return "Never";
                case HOURLY: return "Hourly";
                case EVERY_THREE_HOURS: return "Every three hours";
                case TWICE_A_DAY: return "Twice a day";
                case DAILY: return "Once a day";
                case SNOOZE: return "Snooze";
                case THREE_TIMES_A_DAY: return "Three times a day";
                default: throw new IllegalArgumentException();
            }
        }
    }

    private static final CustomRemindersHelper INSTANCE = new CustomRemindersHelper();
    private Class registeredActivity;

    private CustomRemindersHelper(){

    }

    public static CustomRemindersHelper getInstance(){
        return INSTANCE;
    }

    /**
     * Registers the activity that will be use to edit the measurement
     * This class has to be care of taking the Intent and open the
     * {@link com.quantimodo.tools.fragments.TrackingFragment} loading the data
     * @param activity the Activity to register
     */
    public void registerActivity(Class activity){
        this.registeredActivity = activity;
    }

    public Class getRegisteredActivity(){
        return registeredActivity;
    }

    public static void setAlarm(Context context, String reminderId, FrequencyType frequencyType) {
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, CustomRemindersReceiver.class);
        intent.putExtra(CustomRemindersReceiver.EXTRA_REQUEST_ALARM, true);
        intent.putExtra(EXTRA_REMINDER_ID, reminderId);

        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, Integer.parseInt(reminderId),
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        switch(frequencyType){
            case NEVER:
                cancelAlarm(context, reminderId);
                break;
            case HOURLY:
                alarmMgr.setRepeating(AlarmManager.RTC,
                        //Testing line:
//                        System.currentTimeMillis() + 10 * 1000, 120 * 1000, alarmIntent);
                        System.currentTimeMillis() + AlarmManager.INTERVAL_HOUR,
                        AlarmManager.INTERVAL_HOUR, alarmIntent);
                break;
            case EVERY_THREE_HOURS:
                alarmMgr.setRepeating(AlarmManager.RTC,
                        System.currentTimeMillis() + INTERVAL_THREE_HOURS,
                        INTERVAL_THREE_HOURS,
                        alarmIntent);
                break;
            case TWICE_A_DAY:
                alarmMgr.setRepeating(AlarmManager.RTC,
                        System.currentTimeMillis() + AlarmManager.INTERVAL_HALF_DAY,
                        AlarmManager.INTERVAL_HALF_DAY,
                        alarmIntent);
                break;
            case DAILY:
                alarmMgr.setRepeating(AlarmManager.RTC,
                        System.currentTimeMillis() + AlarmManager.INTERVAL_DAY,
                        AlarmManager.INTERVAL_DAY,
                        alarmIntent);
                break;
            case SNOOZE:
                //Create a one time reminder to run in one hour as a snooze of a previous reminder
                //We crete a new intent to not replace the running ones
                alarmIntent = PendingIntent.getBroadcast(context, (int) new Date().getTime(),
                        intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.set(AlarmManager.RTC,
                        //Testing line:
//                        SystemClock.elapsedRealtime() + 10*1000, alarmIntent);
                        System.currentTimeMillis() + AlarmManager.INTERVAL_HOUR, alarmIntent);
                Toast.makeText(context, R.string.reminders_snooze_message, Toast.LENGTH_LONG).show();
                break;
        }
    }

    public static void setAlarm(Context context, String reminderId) {
        Reminder reminder = getReminder(context,reminderId);
        if(reminder == null) return;
        FrequencyType frequencyType = FrequencyType.values()[reminder.frequencyIndex];
        setAlarm(context, reminderId, frequencyType);
    }

    /**
     * Cancels an alarm
     * @param reminderId the reminder identifier
     * @param context current context
     */
    public static void cancelAlarm(Context context, String reminderId) {
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, CustomRemindersReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, Integer.parseInt(reminderId),
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmMgr.cancel(alarmIntent);
    }

    /**
     * Saves a new or update a reminder by it's id
     * @param context the current context
     * @param reminder the {@link com.quantimodo.tools.utils.CustomRemindersHelper.Reminder} to save
     */
    public static void putReminder(Context context, Reminder reminder){
        SharedPreferences preferences = getPreferences(context);
        SharedPreferences.Editor mEdit1 = preferences.edit();

        mEdit1.remove("reminder_" + reminder.id + KEY_REMOTE_ID);
        mEdit1.putInt("reminder_" + reminder.id + KEY_REMOTE_ID, reminder.remoteId);
        mEdit1.remove("reminder_" + reminder.id + KEY_NAME);
        mEdit1.putString("reminder_" + reminder.id + KEY_NAME, reminder.name);
        mEdit1.remove("reminder_" + reminder.id + KEY_CATEGORY);
        mEdit1.putString("reminder_" + reminder.id + KEY_CATEGORY, reminder.variableCategory);
        mEdit1.remove("reminder_" + reminder.id + KEY_COMBINATION_OPERATION);
        mEdit1.putString("reminder_" + reminder.id + KEY_COMBINATION_OPERATION, reminder.combinationOperation);
        mEdit1.remove("reminder_" + reminder.id + KEY_VALUE);
        mEdit1.putString("reminder_" + reminder.id + KEY_VALUE, reminder.value);
        mEdit1.remove("reminder_" + reminder.id + KEY_UNIT_NAME);
        mEdit1.putString("reminder_" + reminder.id + KEY_UNIT_NAME, reminder.unitName);
        mEdit1.remove("reminder_" + reminder.id + KEY_FREQUENCY);
        mEdit1.putInt("reminder_" + reminder.id + KEY_FREQUENCY, reminder.frequencyIndex);
        mEdit1.remove("reminder_" + reminder.id + KEY_UPDATE);
        mEdit1.putBoolean("reminder_" + reminder.id + KEY_UPDATE, reminder.needUpdate);

        Set<String> remindersSet = new HashSet<>(
                preferences.getStringSet(KEY_REMINDERS_LIST, new HashSet<String>()));
        if(!remindersSet.contains(reminder.id)) remindersSet.add(reminder.id);
        mEdit1.putStringSet(KEY_REMINDERS_LIST, remindersSet);

        mEdit1.apply();
    }

    public static void removeReminder(Context context, String reminderId){
        SharedPreferences preferences = getPreferences(context);
        Reminder reminder = getReminder(context, reminderId);
        if(reminder == null) return;
        SharedPreferences.Editor mEdit1 = preferences.edit();

        mEdit1.remove("reminder_" + reminder.id + KEY_REMOTE_ID);
        mEdit1.remove("reminder_" + reminder.id + KEY_NAME);
        mEdit1.remove("reminder_" + reminder.id + KEY_CATEGORY);
        mEdit1.remove("reminder_" + reminder.id + KEY_COMBINATION_OPERATION);
        mEdit1.remove("reminder_" + reminder.id + KEY_VALUE);
        mEdit1.remove("reminder_" + reminder.id + KEY_UNIT_NAME);
        mEdit1.remove("reminder_" + reminder.id + KEY_FREQUENCY);
        mEdit1.remove("reminder_" + reminder.id + KEY_UPDATE);

        Set<String> remindersSet = new HashSet<>(
                preferences.getStringSet(KEY_REMINDERS_LIST, new HashSet<String>()));
        if(remindersSet.contains(reminder.id)) remindersSet.remove(reminder.id);
        mEdit1.putStringSet(KEY_REMINDERS_LIST, remindersSet);

        mEdit1.apply();
        cancelAlarm(context, reminderId);
    }

    public static ArrayList<Reminder> getRemindersList(Context context){
        SharedPreferences preferences = getPreferences(context);

        Set<String> remindersSet = new HashSet<>(
                preferences.getStringSet(KEY_REMINDERS_LIST, new HashSet<String>()));
        ArrayList<Reminder> result = new ArrayList<>();
        for(String id : remindersSet){
            result.add(getReminder(context, id));
        }

        return result;
    }

    /**
     * Gets the corresponding reminder if exist
     * @param context the current context
     * @param id the reminder id
     * @return the #Reminder instance of null if not exist
     */
    public static Reminder getReminder(Context context, String id){
        if(!existReminder(context, id)) return null;
        SharedPreferences preferences = getPreferences(context);
        return new Reminder(
                id,
                preferences.getInt("reminder_" + id + KEY_REMOTE_ID, -1),
                preferences.getString("reminder_" + id + KEY_NAME, ""),
                preferences.getString("reminder_" + id + KEY_CATEGORY, ""),
                preferences.getString("reminder_" + id + KEY_COMBINATION_OPERATION, ""),
                preferences.getString("reminder_" + id + KEY_VALUE, ""),
                preferences.getString("reminder_" + id + KEY_UNIT_NAME, ""),
                FrequencyType.values()[preferences.getInt("reminder_" + id + KEY_FREQUENCY, 0)],
                preferences.getBoolean("reminder_" + id + KEY_UPDATE, true)
        );
    }

    private static SharedPreferences getPreferences(Context context){
        return context.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
    }

    /**
     * Check if there is a reminder associated with the given id
     * @param context the current app context
     * @param id the reminder/Variable id
     * @return true if the reminder exist for that Variable id, false otherwise
     */
    public static boolean existReminder(Context context, String id){
        SharedPreferences preferences = getPreferences(context);
        return !preferences.getString("reminder_" + id + KEY_NAME, "").equals("");
    }

    public static void postRemoteSnooze(final int reminderRemoteId, final String token){
        //TODO: uncomment when getting pending id
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                RemindersApi api = new RemindersApi();
//                TrackingReminderPendingSnooze body = new TrackingReminderPendingSnooze();
//                body.setId(reminderRemoteId);
//                try {
//                    if (api.v1TrackingRemindersPendingSnoozePost(body, token).getSuccess()) {
//                        Log.d(TAG, "postRemoteSnooze succeed!");
//                    } else {
//                        Log.d(TAG, "postRemoteSnooze failed :(!");
//                    }
//                } catch (ApiException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
    }

    public static void postRemoteTrack(final int reminderRemoteId, final String token){
        //TODO: uncomment when getting pending id
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    RemindersApi api = new RemindersApi();
//                    TrackingReminderPendingTrack body = new TrackingReminderPendingTrack();
//                    body.setId(reminderRemoteId);
//                    if (api.v1TrackingRemindersPendingTrackPost(body, token).getSuccess()) {
//                        Log.d(TAG, "postRemoteTrack succeed!");
//                    } else {
//                        Log.d(TAG, "postRemoteTrack failed :(!");
//                    }
//                } catch (ApiException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
    }

    public static void postRemoteSkip(final int reminderRemoteId, final String token){
        //TODO: uncomment when getting pending id
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                RemindersApi api = new RemindersApi();
//                TrackingReminderPendingSkip body = new TrackingReminderPendingSkip();
//                body.setId(reminderRemoteId);
//                try {
//                    if (api.v1TrackingRemindersPendingSkipPost(body, token).getSuccess()) {
//                        Log.d(TAG, "postRemoteSkip succeed!");
//                    } else {
//                        Log.d(TAG, "postRemoteSkip failed :(!");
//                    }
//                } catch (ApiException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
    }

    @NonNull
    public static String removeTrailingZeros(@NonNull String number){
        int i;
        if(!number.contains("."))
            return number;
        for(i = number.toCharArray().length - 1;i >= 0; i--){
            char c = number.toCharArray()[i];
            if(Character.getNumericValue(c) > 0)
                break;
            if(c == '.'){
                i--;
                break;
            }
        }
        return number.substring(0, i + 1);
    }

    public static class Reminder{
        public final int remoteId;
        public final String id;
        public final String name;
        public final String variableCategory;
        public final String combinationOperation;
        public final String value;
        public final String unitName;
        public final int frequencyIndex;
        public final boolean needUpdate;

        public Reminder(String id, String name, String variableCategory, String combinationOperation,
                        String value, String unitName, FrequencyType frequency){
            this(id, -1, name, variableCategory, combinationOperation, value, unitName, frequency, true);
        }

        public Reminder(String id, int remoteId, String name, String variableCategory, String combinationOperation,
                        String value, String unitName, FrequencyType frequency, boolean needUpdate){
            this.id = id;
            this.remoteId = remoteId;
            this.name = name;
            this.variableCategory = variableCategory;
            this.combinationOperation = combinationOperation;
            this.value = value;
            this.unitName = unitName;
            this.frequencyIndex = frequency.ordinal();
            this.needUpdate = needUpdate;
        }
    }
}
