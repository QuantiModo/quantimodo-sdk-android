package com.quantimodo.tools.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Contacts;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.quantimodo.tools.R;
import com.quantimodo.tools.utils.CustomRemindersHelper;
import com.quantimodo.tools.utils.ViewUtils;

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
        if (getActionBar() != null)
            getActionBar().setTitle(R.string.custom_reminders_title);
        initListView();
        Button addButton = (Button) findViewById(R.id.custom_reminder_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomRemindersActivity.this, CustomRemindersCreateActivity.class);
                startActivity(intent);
            }
        });
        setProgressBarIndeterminate(true);
    }

    private void initListView() {
        new ListLoaderTask().execute();
    }

    private class ListLoaderTask extends AsyncTask<Void, Void, SimpleAdapter> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setProgressBarIndeterminateVisibility(true);
        }

        @Override
        protected SimpleAdapter doInBackground(Void... params) {
            // create the mapping list
            String[] from = new String[]{"title", "frequency"};
            int[] to = new int[]{R.id.custom_reminder_title_text, R.id.custom_reminder_freq_text};

            // prepare the list of all records
            List<HashMap<String, String>> fillMaps = new ArrayList<>();
            reminderList = CustomRemindersHelper.getRemindersList(CustomRemindersActivity.this);
            for (CustomRemindersHelper.Reminder reminder : reminderList) {
                HashMap<String, String> map = new HashMap<>();
                map.put(from[0], reminder.value + " " + reminder.unitName + " of " + reminder.name);
                map.put(from[1], CustomRemindersHelper.FrequencyType.values()[reminder.frequencyIndex].toString());
                fillMaps.add(map);
            }

            // fill in the layout with the map
            return new SimpleAdapter(CustomRemindersActivity.this,
                    fillMaps, R.layout.custom_reminder_item, from, to);

//            return null;
        }

        @Override
        protected void onPostExecute(SimpleAdapter adapter) {
            super.onPostExecute(adapter);
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
            ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
            anim.setDuration(350);
            getListView().setAnimation(anim);
            getListView().animate();

            setProgressBarIndeterminateVisibility(false);
        }
    }
}
