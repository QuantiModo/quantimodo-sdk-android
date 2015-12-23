package com.quantimodo.tools.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.quantimodo.tools.sync.SyncHelper;

/**
 * Used to setup sync alarm, should be defined in application AndroidManifest.xml
 */
public class QToolsBootReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent) {
	}
}
