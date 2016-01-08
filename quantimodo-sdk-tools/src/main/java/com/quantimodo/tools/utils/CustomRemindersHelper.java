package com.quantimodo.tools.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.quantimodo.tools.R;
import com.quantimodo.tools.receivers.CustomRemindersReceiver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This class saves the custom reminders as preferences
 */
public class CustomRemindersHelper {
    private static final String TAG = CustomRemindersHelper.class.getSimpleName();
    private static final String PREFERENCES_KEY = "custom_reminders_preferences";
    private static final String KEY_NAME = "name";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_COMBINATION_OPERATION = "combination_oepration";
    private static final String KEY_VALUE = "value";
    private static final String KEY_UNIT_NAME = "unit_name";
    private static final String KEY_UNIT_ID = "unit_id";
    private static final String KEY_FREQUENCY = "frequency_index";
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
        SNOOZE;

        @Override
        public String toString() {
            switch(this) {
                case NEVER: return "Never";
                case HOURLY: return "Hourly";
                case EVERY_THREE_HOURS: return "Every three hours";
                case TWICE_A_DAY: return "Twice a day";
                case DAILY: return "Daily";
                case SNOOZE: return "Snooze";
                default: throw new IllegalArgumentException();
            }
        }
    }

    private static final CustomRemindersHelper INSTANCE = new CustomRemindersHelper();

    private CustomRemindersHelper(){

    }

    public static CustomRemindersHelper getInstance(){
        return INSTANCE;
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
        FrequencyType frequencyType = FrequencyType.values()[getReminder(context, reminderId).frequencyIndex];
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
        mEdit1.remove("reminder_" + reminder.id + KEY_UNIT_ID);
        mEdit1.putInt("reminder_" + reminder.id + KEY_UNIT_ID, reminder.unitId);
        mEdit1.remove("reminder_" + reminder.id + KEY_FREQUENCY);
        mEdit1.putInt("reminder_" + reminder.id + KEY_FREQUENCY, reminder.frequencyIndex);

        Set<String> remindersSet = new HashSet<>(
                preferences.getStringSet(KEY_REMINDERS_LIST, new HashSet<String>()));
        if(!remindersSet.contains(reminder.id)) remindersSet.add(reminder.id);
        mEdit1.putStringSet(KEY_REMINDERS_LIST, remindersSet);

        mEdit1.apply();
    }

    public static void removeReminder(Context context, String reminderId){
        SharedPreferences preferences = getPreferences(context);
        Reminder reminder = getReminder(context, reminderId);
        SharedPreferences.Editor mEdit1 = preferences.edit();

        mEdit1.remove("reminder_" + reminder.id + KEY_NAME);
        mEdit1.remove("reminder_" + reminder.id + KEY_CATEGORY);
        mEdit1.remove("reminder_" + reminder.id + KEY_COMBINATION_OPERATION);
        mEdit1.remove("reminder_" + reminder.id + KEY_VALUE);
        mEdit1.remove("reminder_" + reminder.id + KEY_UNIT_NAME);
        mEdit1.remove("reminder_" + reminder.id + KEY_UNIT_ID);
        mEdit1.remove("reminder_" + reminder.id + KEY_FREQUENCY);

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

    public static Reminder getReminder(Context context, String id){
        SharedPreferences preferences = getPreferences(context);
        return new Reminder(
                id,
                preferences.getString("reminder_" + id + KEY_NAME, ""),
                preferences.getString("reminder_" + id + KEY_CATEGORY, ""),
                preferences.getString("reminder_" + id + KEY_COMBINATION_OPERATION, ""),
                preferences.getString("reminder_" + id + KEY_VALUE, ""),
                preferences.getString("reminder_" + id + KEY_UNIT_NAME, ""),
                preferences.getInt("reminder_" + id + KEY_UNIT_ID, 0),
                preferences.getInt("reminder_" + id + KEY_FREQUENCY, 0)
        );
    }

    private static SharedPreferences getPreferences(Context context){
        return context.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);
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
        public final String id;
        public final String name;
        public final String variableCategory;
        public final String combinationOperation;
        public final String value;
        public final String unitName;
        public final int unitId;
        public final int frequencyIndex;

        public Reminder(String id, String name, String variableCategory, String combinationOperation,
                        String value, String unitName, int unitId, int frequency){
            this.id = id;
            this.name = name;
            this.variableCategory = variableCategory;
            this.combinationOperation = combinationOperation;
            this.value = value;
            this.unitName = unitName;
            this.unitId =unitId;
            this.frequencyIndex = frequency;
        }
    }
}
