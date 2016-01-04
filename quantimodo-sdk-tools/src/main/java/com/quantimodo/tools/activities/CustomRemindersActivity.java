package com.quantimodo.tools.activities;

import android.app.ListActivity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.quantimodo.tools.R;
import com.quantimodo.tools.utils.CustomRemindersHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Activity that display the list of created reminders and a button to add a new one
 */
public class CustomRemindersActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_reminder_main);
        // create the grid item mapping
        String[] from = new String[] {"title", "frequency"};
        int[] to = new int[] { R.id.custom_reminder_title_text, R.id.custom_reminder_freq_text };



        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<>();
        for(CustomRemindersHelper.Reminder reminder : CustomRemindersHelper.getRemindersList(this)){

            HashMap<String, String> map = new HashMap<>();
            map.put(from[0], reminder.value + " " + reminder.unitName + " of " + reminder.name);
            map.put(from[1], CustomRemindersHelper.FrequencyType.values()[reminder.frequencyIndex].toString());
            fillMaps.add(map);
        }

        // fill in the grid_item layout
        SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, R.layout.custom_reminder_item, from, to);

        setListAdapter(adapter);
        getListView().setDividerHeight(0);
        getListView().setDivider(null);
    }
}