package com.quantimodo.tools.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.quantimodo.tools.utils.CustomRemindersHelper;

/**
 * Used to setup sync alarm, should be defined in application AndroidManifest.xml
 */
public class QToolsBootReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent) {

		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
			//set the alarms when the phone turn on
			for(CustomRemindersHelper.Reminder reminder : CustomRemindersHelper.getRemindersList(context)) {
				CustomRemindersHelper.setAlarm(context, reminder.id);
			}
            //start tracking places
            TrackPlacesReceiver trackPlacesReceiver = new TrackPlacesReceiver();
            trackPlacesReceiver.setAlarm(context);
		}
	}
}
