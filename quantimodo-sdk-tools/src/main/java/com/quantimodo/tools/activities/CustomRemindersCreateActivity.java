package com.quantimodo.tools.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.quantimodo.android.sdk.model.Variable;
import com.quantimodo.android.sdk.model.VariableCategory;
import com.quantimodo.tools.QTools;
import com.quantimodo.tools.R;
import com.quantimodo.tools.adapters.AutoCompleteListAdapter;
import com.quantimodo.tools.adapters.VariableCategorySelectSpinnerAdapter;
import com.quantimodo.tools.sdk.AuthHelper;
import com.quantimodo.tools.sdk.DefaultSdkResponseListener;
import com.quantimodo.tools.sdk.request.GetCategoriesRequest;
import com.quantimodo.tools.sdk.request.GetSuggestedVariablesRequest;
import com.quantimodo.tools.sdk.request.NoNetworkConnection;
import com.quantimodo.tools.sync.SyncHelper;
import com.quantimodo.tools.utils.CustomRemindersHelper;
import com.quantimodo.tools.utils.QtoolsUtils;

import java.util.ArrayList;
import java.util.Calendar;

import javax.inject.Inject;

import io.swagger.client.ApiException;
import io.swagger.client.api.RemindersApi;
import io.swagger.client.model.TrackingReminderDelete;

/**
 * Activity that displays the form to create or edit a custom reminder
 */
public class CustomRemindersCreateActivity extends Activity {
    public static final String EXTRA_FLAG_CREATING = "extra_flag_creating";
    public static final String EXTRA_REMINDER_ID = "extra_reminder_id";
    public static final String EXTRA_VARIABLE = "extra_variable";

    private SpiceManager mSpiceManager = new SpiceManager(QTools.getInstance().getServiceClass());

    private TextView nameTextView;
    private ListView lvVariableSuggestions;
    private TextView unitsText;
    private ProgressBar progressView;
    private Spinner spVariableCategory;
    private TextView valueTextView;
    private View mainLayout;
    private Button removeButton;
    private Spinner frequencySpinner;
    private View containerLayout2;
    private View containerCategories;
    private View buttonsLayout;
    private ProgressDialog mProgress;
    private Button mInterval1;
    private Button mInterval2;
    private Button mInterval3;

    private AutoCompleteListAdapter autoCompleteListAdapter;
    private ArrayList<Variable> suggestedVariables = new ArrayList<>();
    private ArrayList<VariableCategory> allCategories;
    private Variable selectedVariable;
    private int refreshesRunning = 0;
    private boolean isEditing = false;
    private boolean avoidSearch = false;
    private Calendar mCalendarInterval1 = Calendar.getInstance();
    private Calendar mCalendarInterval2 = Calendar.getInstance();
    private Calendar mCalendarInterval3 = Calendar.getInstance();

    private String reminderId;
    private CustomRemindersHelper.Reminder mReminder;

    @Inject
    AuthHelper authHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QTools.getInstance().inject(this);

        setContentView(R.layout.custom_reminder_create);

        loadExtras();
        initViews();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
                anim.setDuration(350);
                mainLayout.setAnimation(anim);
                mainLayout.animate();
                mainLayout.setVisibility(View.VISIBLE);
            }
        }, 300);


        loadAndInitData();

        if(isEditing){
            containerCategories.setVisibility(View.GONE);
            containerLayout2.setVisibility(View.VISIBLE);
            buttonsLayout.setVisibility(View.VISIBLE);
            if(getActionBar() != null)
                getActionBar().setTitle(R.string.custom_reminders_edit);
            nameTextView.setEnabled(false);
            spVariableCategory.setEnabled(false);
            removeButton.setText(R.string.custom_reminders_remove);
            valueTextView.requestFocus();
        } else if(getActionBar() != null)
            getActionBar().setTitle(R.string.custom_reminders_create);

        //this is true when the Variable was passed via intent
        if(selectedVariable != null){
            avoidSearch = true;
            nameTextView.setEnabled(false);
            containerCategories.setVisibility(View.GONE);
            loadSelectVariable();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mSpiceManager.start(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mSpiceManager.shouldStop();
    }

    private void loadExtras(){
        reminderId = getIntent().getStringExtra(EXTRA_REMINDER_ID);
        if(!TextUtils.isEmpty(reminderId)) {
            mReminder = CustomRemindersHelper.getReminder(this, reminderId);
        }
        if(!getIntent().getBooleanExtra(EXTRA_FLAG_CREATING, false)) {
            isEditing = true;
        }
        selectedVariable = (Variable) getIntent().getSerializableExtra(EXTRA_VARIABLE);
    }

    private void initViews(){
        mainLayout = findViewById(R.id.custom_reminder_main_layout);
        unitsText = (TextView) findViewById(R.id.reminders_create_units_text);
        spVariableCategory = (Spinner) findViewById(R.id.spVariableCategory);
        progressView = (ProgressBar) findViewById(R.id.custom_reminder_progress);
        nameTextView = (TextView) findViewById(R.id.custom_reminder_variable_edit);
        if(!isEditing) //we need to search for variables just when creating a new reminder
            nameTextView.addTextChangedListener(onVariableNameChanged);
        removeButton = (Button) findViewById(R.id.reminders_create_remove_button);
        valueTextView = (TextView) findViewById(R.id.reminders_create_value_text);
        containerLayout2 = findViewById(R.id.custom_reminder_container_2);
        containerCategories = findViewById(R.id.custom_reminder_container_1);
        buttonsLayout = findViewById(R.id.reminders_create_buttons_layout);

        lvVariableSuggestions = (ListView) findViewById(R.id.lvVariableSuggestions);

        lvVariableSuggestions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //we avoid search just to prevent loading the list when editing the search box
                avoidSearch = true;
                selectVariable(position);
                avoidSearch = false;
            }
        });

        autoCompleteListAdapter = new AutoCompleteListAdapter(this, suggestedVariables);
        lvVariableSuggestions.setAdapter(autoCompleteListAdapter);
        initIntervalsViews();

        if(isEditing){
            frequencySpinner.setSelection(mReminder.frequencyIndex, false);
            valueTextView.setText(mReminder.value);
            unitsText.setText(mReminder.unitName);
        }

    }

    private void initIntervalsViews(){
        mCalendarInterval1.set(Calendar.HOUR_OF_DAY, 8);
        mCalendarInterval1.set(Calendar.MINUTE, 0);
        mCalendarInterval2.set(Calendar.HOUR_OF_DAY, 16);
        mCalendarInterval2.set(Calendar.MINUTE, 0);
        mCalendarInterval3.set(Calendar.HOUR_OF_DAY, 24);
        mCalendarInterval3.set(Calendar.MINUTE, 0);

        mInterval1 = (Button) findViewById(R.id.reminders_create_interval_1);
        mInterval2 = (Button) findViewById(R.id.reminders_create_interval_2);
        mInterval3 = (Button) findViewById(R.id.reminders_create_interval_3);
        mInterval1.setOnClickListener(onTimesClick);
        mInterval2.setOnClickListener(onTimesClick);
        mInterval3.setOnClickListener(onTimesClick);
        frequencySpinner = (Spinner) findViewById(R.id.reminders_create_freq_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.reminders_interval_entries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frequencySpinner.setAdapter(adapter);
        frequencySpinner.setSelection(0); //Daily frequency as default
        frequencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)view).setTextColor(Color.BLACK);
                mInterval1.setVisibility(View.GONE);
                mInterval2.setVisibility(View.GONE);
                mInterval3.setVisibility(View.GONE);
                if(position == 0){
                    mInterval1.setVisibility(View.VISIBLE);
                }
                else if(position == 1){
                    mInterval1.setVisibility(View.VISIBLE);
                    mInterval2.setVisibility(View.VISIBLE);
                }
                else if(position == 2){
                    mInterval1.setVisibility(View.VISIBLE);
                    mInterval2.setVisibility(View.VISIBLE);
                    mInterval3.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    View.OnClickListener onTimesClick = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            Calendar calendarTemp = Calendar.getInstance();
            if(view == mInterval1){
                calendarTemp = mCalendarInterval1;
            } else if(view == mInterval2){
                calendarTemp = mCalendarInterval2;
            } else if(view == mInterval3){
                calendarTemp = mCalendarInterval3;
            }
            final Calendar calendar = calendarTemp;
            new TimePickerDialog(
                    CustomRemindersCreateActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker pickerView, int hourOfDay, int minute) {
                    String format = "%s:%s %s";
                    String pmAm;
                    String hour;
                    String stringMinute;
                    if(hourOfDay > 11){
                        pmAm = "PM";
                        hour = Integer.toString(hourOfDay - 12);
                    }
                    else{
                        pmAm = "AM";
                        hour = Integer.toString(hourOfDay);
                    }
                    if(hour.equals("0")) hour = "12";

                    stringMinute = Integer.toString(minute);
                    if(minute < 10)
                        stringMinute = "0" + stringMinute;
                    ((Button) view).setText(String.format(format, hour, stringMinute, pmAm));

                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minute);
                }
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
        }
    };

    /**
     * Selects the Variable to use from the suggestedVariables list
     * @param position position on the list
     */
    private void selectVariable(int position){
        selectedVariable = suggestedVariables.get(position);
        nameTextView.setText(selectedVariable.getName());
        if(selectedVariable.getDefaultValue() != null)
            valueTextView.setText(selectedVariable.getDefaultValue().toString());
        unitsText.setText(selectedVariable.getDefaultAbbreviatedUnitName());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
                anim.setDuration(350);
                lvVariableSuggestions.setVisibility(View.GONE);
                buttonsLayout.setAnimation(anim);
                containerLayout2.setAnimation(anim);
                buttonsLayout.animate();
                containerLayout2.animate();
                buttonsLayout.setVisibility(View.VISIBLE);
                containerLayout2.setVisibility(View.VISIBLE);
            }
        }, 300);
    }

    private void loadSelectVariable(){
        nameTextView.setText(selectedVariable.getName());
        if(selectedVariable.getDefaultValue() != null)
            valueTextView.setText(selectedVariable.getDefaultValue().toString());
        unitsText.setText(selectedVariable.getDefaultAbbreviatedUnitName());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
                anim.setDuration(350);
                lvVariableSuggestions.setVisibility(View.GONE);
                buttonsLayout.setAnimation(anim);
                containerLayout2.setAnimation(anim);
                buttonsLayout.animate();
                containerLayout2.animate();
                buttonsLayout.setVisibility(View.VISIBLE);
                containerLayout2.setVisibility(View.VISIBLE);
            }
        }, 300);
    }

    private TextWatcher onVariableNameChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            final String search = editable.toString();
            if(!avoidSearch) {
                // Only update if the text didn't change in the past 500ms
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (nameTextView != null &&
                                search.equals(nameTextView.getText().toString())) {
                            refreshAutoComplete(search);
                        }
                    }
                }, 500);
            }
        }
    };

    private void refreshAutoComplete(final String search) {
        Ion.getDefault(this).cancelAll(this);
        progressView.setVisibility(View.VISIBLE);
        refreshesRunning++;
        String filter;
        if(allCategories != null){
            filter = allCategories.get(spVariableCategory.getSelectedItemPosition()).getName();
            if(filter.equals("Anything")) filter = null;
        }
        else filter = null;
        getSpiceManager().execute(new GetSuggestedVariablesRequest(search, filter, 10),
                new DefaultSdkResponseListener<GetSuggestedVariablesRequest.GetSuggestedVariablesResponse>() {
                    @Override
                    public void onRequestFailure(SpiceException spiceException) {
                        super.onRequestFailure(spiceException);
                        spiceException.printStackTrace();
                    }

                    @Override
                    public void onRequestSuccess(GetSuggestedVariablesRequest.GetSuggestedVariablesResponse response) {
                        refreshesRunning--;
                        if (refreshesRunning <= 0) {
                            progressView.setVisibility(View.GONE);
                        }
                        //if no results hide the result list view holder
                        if (response.variables.size() == 0) {
                            autoCompleteListAdapter.clear();
                            lvVariableSuggestions.setVisibility(View.GONE);
                        } else {
                            suggestedVariables = response.variables;
                            autoCompleteListAdapter.clear();
                            autoCompleteListAdapter.addAll(response.variables);

                            //if we successfully found the Variable, so not showing the suggestions
                            if (selectedVariable != null && existOnVariables(selectedVariable.getId()) &&
                                    nameTextView.getText().toString().equals(selectedVariable.getName()))
                                return;
                            lvVariableSuggestions.setVisibility(View.VISIBLE);
                            buttonsLayout.setVisibility(View.GONE);
                            containerLayout2.setVisibility(View.GONE);
                        }
                    }
                });
    }

    private boolean existOnVariables(long id){
        for(Variable var : suggestedVariables){
            if(var.getId() == id) return true;
        }
        return false;
    }

    private void loadAndInitData() {
        if (!QtoolsUtils.hasInternetConnection(this)){
            Toast.makeText(this, R.string.network_connection_error_message, Toast.LENGTH_LONG).show();
            return;
        }

        //get the categories just when creating a reminder
        if(!isEditing) {
            getSpiceManager().execute(new GetCategoriesRequest().getCachedSpiceRequest(),
                    new DefaultSdkResponseListener<GetCategoriesRequest.GetCategoriesResponse>() {
                @Override
                public void onRequestSuccess(GetCategoriesRequest.GetCategoriesResponse getCategoriesResponse) {
                    allCategories = getCategoriesResponse.categories;
                    categoriesUpdated();
                }
                @Override
                public void onRequestFailure(SpiceException spiceException) {
                    super.onRequestFailure(spiceException);
                    spiceException.printStackTrace();
                    Toast.makeText(CustomRemindersCreateActivity.this,
                            R.string.network_connection_error_message, Toast.LENGTH_LONG).show();
                }

            });
        }
        else {
            nameTextView.setText(mReminder.name);
        }
    }

    private void categoriesUpdated() {
        for(int i=0; i<allCategories.size(); i++){
            String name = allCategories.get(i).getName().toLowerCase();
            //if not matching one of these, remove it because is not used.
            if(!name.equals("emotions") && !name.equals("foods") && !name.equals("symptoms") &&
                    !name.equals("treatments") && !name.equals("physical activity")){
                allCategories.remove(i);
                i--;
            }
        }

        VariableCategory anyCategory = new VariableCategory("Anything");
        allCategories.add(anyCategory);
        VariableCategorySelectSpinnerAdapter adapter = new VariableCategorySelectSpinnerAdapter(this, allCategories);
        spVariableCategory.setAdapter(adapter);
        spVariableCategory.setSelection(allCategories.size() - 1);
    }

    /**
     * Click listener for Save Button, also validates the dat
     * @param view the Button view
     */
    public void onSave(View view){
        boolean error = false;
        //validating the data before saving
        if(!isEditing && selectedVariable == null || lvVariableSuggestions.getVisibility() == View.VISIBLE) {
            nameTextView.setError(getString(R.string.custom_reminders_error_variable));
            error = true;
        }
        if(TextUtils.isEmpty(valueTextView.getText())){
            valueTextView.setError(getString(R.string.custom_reminders_error_value));
            error = true;
        }
        if(frequencySpinner.getSelectedItemPosition() == 0){
            TextView spinnerText = (TextView) frequencySpinner.getSelectedView();
            spinnerText.setError("");
            spinnerText.setTextColor(Color.RED);
            spinnerText.setText(getString(R.string.custom_reminders_error_frequency));
            error = true;
        }
        if(error) return;

        //when editing the reminder, selectedVariable is always null
        CustomRemindersHelper.Reminder newReminder = new CustomRemindersHelper.Reminder(
                isEditing ? mReminder.id : Long.toString(selectedVariable.getId()),
                isEditing ? mReminder.remoteId : -1,
                isEditing ? mReminder.name : selectedVariable.getName(),
                isEditing ? mReminder.variableCategory : selectedVariable.getCategory(),
                isEditing ? mReminder.combinationOperation : selectedVariable.getCombinationOperation(),
                valueTextView.getText().toString(),
                isEditing ? mReminder.unitName : selectedVariable.getDefaultAbbreviatedUnitName(),
                getFrequencyFromItemPosition(frequencySpinner.getSelectedItemPosition()),
                true
        );
        CustomRemindersHelper.putReminder(this, newReminder);
        CustomRemindersHelper.setAlarm(this, newReminder.id);
        SyncHelper.invokeSync(this);
        finish();
        Toast.makeText(getApplicationContext(),R.string.custom_reminder_save_message,
                Toast.LENGTH_LONG).show();
    }

    private CustomRemindersHelper.FrequencyType getFrequencyFromItemPosition(int position){
        String string = getResources().getStringArray(R.array.reminders_interval_entries)[position];
        if(string.equals(getString(R.string.interval_once_day)) ||
                string.equals(getString(R.string.interval_daily))){
            return CustomRemindersHelper.FrequencyType.DAILY;
        }
        else if(string.equals(getString(R.string.interval_twice_day)) ||
                string.equals(getString(R.string.interval_twicedaily))){
            return CustomRemindersHelper.FrequencyType.TWICE_A_DAY;
        }
        else if(string.equals(getString(R.string.interval_three_times_day))) {
            return CustomRemindersHelper.FrequencyType.THREE_TIMES_A_DAY;
        }
        else if(string.equals(getString(R.string.interval_hourly))){
            return CustomRemindersHelper.FrequencyType.HOURLY;
        }
        else if(string.equals(getString(R.string.interval_everythreehours))){
            return CustomRemindersHelper.FrequencyType.EVERY_THREE_HOURS;
        }
        return CustomRemindersHelper.FrequencyType.NEVER;
    }

    /**
     * Click listener for Remove Button, also used to Cancel when creating a reminder
     * @param view the Button view
     */
    public void onRemove(View view){
        if(!isEditing){
            finish();
            return;
        }
        new AlertDialog.Builder(this)
                .setMessage(R.string.custom_reminders_remove_confirmation)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteReminder();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private void deleteReminder(){
        if (!QtoolsUtils.hasInternetConnection(this)) {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.error_no_connection,
                    Toast.LENGTH_LONG
            ).show();
            return;
        }
        mProgress = new ProgressDialog(this);
        mProgress.setIndeterminate(true);
        mProgress.setMessage(getString(R.string.please_wait_message));
        mProgress.show();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                RemindersApi api = new RemindersApi();
                try {
                    CustomRemindersHelper.Reminder reminder = CustomRemindersHelper.getReminder(
                            getApplicationContext(), reminderId);
                    if(reminder == null){
                        showErrorMessage();
                        return;
                    }
                    TrackingReminderDelete body = new TrackingReminderDelete();
                    body.setId(reminder.remoteId);
                    boolean succeed = api.v1TrackingRemindersDeletePost(body,
                            authHelper.getAuthTokenWithRefresh()).getSuccess();
                    if (succeed) {
                        deleteLocally();
                    }
                    else{
                        showErrorMessage();
                    }
                } catch (NoNetworkConnection e) {
                    showErrorMessage();
                    e.printStackTrace();
                } catch (ApiException apiException) {
                    apiException.printStackTrace();
                    if (apiException.getMessage().toLowerCase().contains("not found") ||
                            apiException.getMessage().toLowerCase().contains("unauthorized")) {
                        deleteLocally();
                    }
                    else{
                        showErrorMessage();
                    }
                }
            }
        });
        thread.start();
    }

    private void showErrorMessage(){
        if(mProgress != null && mProgress.isShowing()) mProgress.dismiss();
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(
                        getApplicationContext(),
                        R.string.error_try_again,
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }

    private void deleteLocally(){
        if(mProgress != null && mProgress.isShowing()) mProgress.dismiss();
        CustomRemindersHelper.removeReminder(CustomRemindersCreateActivity.this,
                reminderId);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),
                        R.string.custom_reminders_remove_message, Toast.LENGTH_LONG).show();
            }
        });
        CustomRemindersCreateActivity.this.finish();
    }

    private SpiceManager getSpiceManager(){
        return mSpiceManager;
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
        }
    }
}
