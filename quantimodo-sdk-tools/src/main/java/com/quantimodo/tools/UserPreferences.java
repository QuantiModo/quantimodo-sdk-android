package com.quantimodo.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Class to manage the user data like name, id, and others
 */
public class UserPreferences {
    private static final String PREFERENCES_NAME = "QMPreferencesId";
    private static final String PREF_USER_NAME = "userDisplayName";

    public static String getUserName(final Context context){
        return getPrefs(context).getString(PREF_USER_NAME, null);
    }
    public static void setUserName(final Context context, final String userName){
        getPrefs(context).edit().putString(PREF_USER_NAME, userName).apply();
    }

    private static SharedPreferences getPrefs(final Context context){
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }
}
