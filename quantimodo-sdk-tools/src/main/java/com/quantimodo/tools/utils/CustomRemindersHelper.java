package com.quantimodo.tools.utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Log;

import com.quantimodo.tools.receivers.CustomRemindersReceiver;
import com.quantimodo.tools.receivers.QToolsBootReceiver;

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
    public static final String EXTRA_REQUEST_REMINDER = "extra_request_reminder";

    public static final long INTERVAL_THREE_HOURS = 3 * AlarmManager.INTERVAL_HOUR;

    public enum FrecuencyType{
        HOURLY,
        EVERY_THREE_HOURS,
        TWICE_A_DAY,
        DAILY,
        SNOOZE
    }

    private static final CustomRemindersHelper INSTANCE = new CustomRemindersHelper();
    private Activity registeredActivity;

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
    public void registerActivity(Activity activity){
        this.registeredActivity = activity;
    }

    public Activity getRegisteredActivity(){
        return registeredActivity;
    }

    public static void setAlarm(Context context, String reminderId,  FrecuencyType frecuencyType) {
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, CustomRemindersReceiver.class);
        intent.putExtra(CustomRemindersReceiver.EXTRA_REQUEST_ALARM, true);
        intent.putExtra(EXTRA_REMINDER_ID, reminderId);

        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, Integer.parseInt(reminderId),
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        switch(frecuencyType){
            case HOURLY:
                alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        //Testing line:
                        10 * 1000, 120 * 1000, alarmIntent);
//                        AlarmManager.INTERVAL_HOUR, AlarmManager.INTERVAL_HOUR, alarmIntent);
                break;
            case EVERY_THREE_HOURS:
                alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        INTERVAL_THREE_HOURS, INTERVAL_THREE_HOURS, alarmIntent);
                break;
            case TWICE_A_DAY:
                alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        AlarmManager.INTERVAL_HALF_DAY, AlarmManager.INTERVAL_HALF_DAY, alarmIntent);
                break;
            case DAILY:
                alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        AlarmManager.INTERVAL_DAY, AlarmManager.INTERVAL_DAY, alarmIntent);
                break;
            case SNOOZE:
                //Create a one time reminder to run in one hour as a snooze of a previous reminder
                //We crete a new intent to not replace the running ones
                alarmIntent = PendingIntent.getBroadcast(context, (int) new Date().getTime(),
                        intent, PendingIntent.FLAG_ONE_SHOT);
                alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        //Testing line:
                        SystemClock.elapsedRealtime() + 10*1000, alarmIntent);
//                        AlarmManager.INTERVAL_HOUR, alarmIntent);
                break;
        }
        setBootReceiver(context, true);
    }

    /**
     * Cancels the alarm.
     * @param context current context
     */
    public static void cancelAlarm(Context context, String id) {
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, CustomRemindersReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, Integer.parseInt(id),
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmMgr.cancel(alarmIntent);

        setBootReceiver(context, false);
    }

    /**
     * Enable or disable {@code RemindersBootReceiver} so that it will or not automatically
     * restart the alarm when the device is rebooted
     * @param context the curent context
     * @param setEnabled if true it will enable the {@code RemindersReceiver} when the device boot
     */
    private static void setBootReceiver(Context context, boolean setEnabled){
        ComponentName receiver = new ComponentName(context, QToolsBootReceiver.class);
        PackageManager pm = context.getPackageManager();

        if(setEnabled){
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
        }
        else{
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP);
        }
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

        Set<String> remindersSet = new HashSet<String>(
                preferences.getStringSet(KEY_REMINDERS_LIST, new HashSet<String>()));
        if(!remindersSet.contains(reminder.id)) remindersSet.add(reminder.id);
        mEdit1.putStringSet(KEY_REMINDERS_LIST, remindersSet);

        mEdit1.apply();
    }

    public static ArrayList<Reminder> getRemindersList(Context context){
        SharedPreferences preferences = getPreferences(context);

        Set<String> remindersSet = new HashSet<String>(
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
