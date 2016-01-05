package com.quantimodo.tools.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
    List<CustomRemindersHelper.Reminder> reminderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_reminder_main);
        initListView();
        Button addButton = (Button) findViewById(R.id.custom_reminder_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomRemindersActivity.this, CustomRemindersCreateActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initListView(){
        // create the mapping list
        String[] from = new String[] {"title", "frequency"};
        int[] to = new int[] { R.id.custom_reminder_title_text, R.id.custom_reminder_freq_text };

        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<>();
        reminderList = CustomRemindersHelper.getRemindersList(this);
        for(CustomRemindersHelper.Reminder reminder : reminderList){
            HashMap<String, String> map = new HashMap<>();
            map.put(from[0], reminder.value + " " + reminder.unitName + " of " + reminder.name);
            map.put(from[1], CustomRemindersHelper.FrequencyType.values()[reminder.frequencyIndex].toString());
            fillMaps.add(map);
        }

        // fill in the layout with the map
        SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, R.layout.custom_reminder_item, from, to);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomRemindersHelper.Reminder reminder = reminderList.get(position);
                Intent intent = new Intent(CustomRemindersActivity.this, CustomRemindersCreateActivity.class);
                intent.putExtra(CustomRemindersCreateActivity.EXTRA_VARIABLE_NAME, reminder.name);
                intent.putExtra(CustomRemindersCreateActivity.EXTRA_CATEGORY_NAME, reminder.variableCategory);
                intent.putExtra(CustomRemindersCreateActivity.EXTRA_UNIT_ID, reminder.unitId);
                intent.putExtra(CustomRemindersCreateActivity.EXTRA_VALUE, reminder.value);
                intent.putExtra(CustomRemindersCreateActivity.EXTRA_FREQUENCY_INDEX, reminder.frequencyIndex);

                startActivity(intent);
            }
        });
        getListView().setDividerHeight(0);
        getListView().setDivider(null);

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
