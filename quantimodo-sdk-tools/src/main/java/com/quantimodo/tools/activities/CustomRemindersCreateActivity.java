package com.quantimodo.tools.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.quantimodo.android.sdk.model.Unit;
import com.quantimodo.android.sdk.model.Variable;
import com.quantimodo.android.sdk.model.VariableCategory;
import com.quantimodo.tools.QTools;
import com.quantimodo.tools.R;
import com.quantimodo.tools.adapters.AutoCompleteListAdapter;
import com.quantimodo.tools.adapters.VariableCategorySelectSpinnerAdapter;
import com.quantimodo.tools.sdk.DefaultSdkResponseListener;
import com.quantimodo.tools.sdk.request.GetCategoriesRequest;
import com.quantimodo.tools.sdk.request.GetSuggestedVariablesRequest;
import com.quantimodo.tools.sdk.request.GetUnitsRequest;
import com.quantimodo.tools.utils.ConvertUtils;
import com.quantimodo.tools.utils.CustomRemindersHelper;
import com.quantimodo.tools.utils.QtoolsUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Activity that displays the form to create or edit a custom reminder
 */
public class CustomRemindersCreateActivity extends Activity {
    public static final String EXTRA_FLAG_CREATING = "extra_flag_creating";
    public static final String EXTRA_REMINDER_ID = "extra_reminder_id";

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

    private AutoCompleteListAdapter autoCompleteListAdapter;
    private UnitSelectSpinnerAdapter unitAdapter;
    private ArrayList<Variable> suggestedVariables = new ArrayList<>();
//    private ArrayList<Unit> mUnits = new ArrayList<>();
    private ArrayList<VariableCategory> allCategories;
    private Variable selectedVariable;
    private int selectedUnitIndex;
    private int refreshesRunning = 0;
    private boolean isEditing = false;

    private String reminderId;
    private CustomRemindersHelper.Reminder mReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_reminder_create);
        reminderId = getIntent().getStringExtra(EXTRA_REMINDER_ID);
        if(!TextUtils.isEmpty(reminderId)) {
            isEditing = true;
            mReminder = CustomRemindersHelper.getReminder(this, reminderId);
        }
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
            if(getActionBar() != null)
                getActionBar().setTitle(R.string.custom_reminders_edit);
            nameTextView.setEnabled(false);
            spVariableCategory.setEnabled(false);
            removeButton.setText(R.string.custom_reminders_remove);
            valueTextView.requestFocus();
        } else if(getActionBar() != null)
            getActionBar().setTitle(R.string.custom_reminders_create);
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
                nameTextView.setText(suggestedVariables.get(position).getName());
                selectedVariable = suggestedVariables.get(position);
//                selectUnit(selectedVariable);
                if(selectedVariable.getDefaultValue() != null)
                    valueTextView.setText(selectedVariable.getDefaultValue().toString());
                unitsText.setText(selectedVariable.getUnit());

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
        });

        autoCompleteListAdapter = new AutoCompleteListAdapter(this, suggestedVariables);
        lvVariableSuggestions.setAdapter(autoCompleteListAdapter);

        frequencySpinner = (Spinner) findViewById(R.id.reminders_create_freq_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mood_interval_entries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frequencySpinner.setAdapter(adapter);
        frequencySpinner.setSelection(4); //Daily frequency as default
        frequencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)view).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        if(isEditing){
            frequencySpinner.setSelection(mReminder.frequencyIndex, false);
            valueTextView.setText(mReminder.value);
            unitsText.setText(mReminder.unitName);
        }

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
            // Only update if the text didn't change in the past 500ms
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (nameTextView != null && search.equals(nameTextView.getText().toString())) {
                        refreshAutoComplete(search);
                    }
                }
            }, 500);
        }
    };

    private void refreshAutoComplete(final String search) {
        Ion.getDefault(this).cancelAll(this);
        progressView.setVisibility(View.VISIBLE);
        refreshesRunning++;
        String filter;
        if(allCategories != null){
            filter = allCategories.get(spVariableCategory.getSelectedItemPosition()).getName();
            if(filter.equals("Misc")) filter = null;
        }
        else filter = null;
        getSpiceManager().execute(new GetSuggestedVariablesRequest(search, filter),
                new DefaultSdkResponseListener<GetSuggestedVariablesRequest.GetSuggestedVariablesResponse>() {
                    @Override
                    public void onRequestFailure(SpiceException spiceException) {
                        super.onRequestFailure(spiceException);
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
                            //if editing try to find the searched variable and select it
                            if (isEditing) {
                                for (int i=0; i<response.variables.size(); i++) {
                                    Variable variable = response.variables.get(i);
                                    if (variable.getName().equals(mReminder.name)) {
                                        selectedVariable = variable;
//                                        selectUnit(selectedVariable);
                                    }
                                }
                            }
                            suggestedVariables = response.variables;
                            autoCompleteListAdapter.clear();
                            autoCompleteListAdapter.addAll(response.variables);
                            if (selectedVariable != null && existOnVariables(selectedVariable.getId()) &&
                                    nameTextView.getText().toString().equals(selectedVariable.getName()))
                                return;
                            lvVariableSuggestions.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }

//    private void selectUnit(Variable variable){
//        if(mUnits == null) return;
//        String categoryUnit = null;
//        if(allCategories != null){
//            String category = allCategories.get(spVariableCategory.getSelectedItemPosition()).getName();
//            categoryUnit = "units";
//            if(category.equals("Food")) categoryUnit = "serving";
//            else if(category.equals("Symptoms") || category.equals("Emotions")) categoryUnit = "%";
//        }
//        int selectedUnit = -1, defaultUnit = -1;
//        for (int i = 0; i< mUnits.size(); i++){
//            Unit currentUnit = mUnits.get(i);
//            if (categoryUnit != null && categoryUnit.equals(currentUnit.getAbbreviatedName())){
//                defaultUnit = i;
//            }
//            if (variable != null && currentUnit.getAbbreviatedName().equals(variable.getTargetUnit())){
//                selectedUnit = i;
//            }
//        }
//
//        int unitIndex = selectedUnit == -1 ? (defaultUnit == -1 ? 0 : defaultUnit) : selectedUnit;
//
//        unitsText.setText(mUnits.get(unitIndex).getName());
//        selectedUnitIndex = unitIndex;
//    }

    private boolean existOnVariables(long id){
        for(Variable var : suggestedVariables){
            if(var.getId() == id) return true;
        }
        return false;
    }

    private void loadAndInitData() {
        if(!QtoolsUtils.hasInternetConnection(this)){
            Toast.makeText(this, R.string.network_connection_error_message, Toast.LENGTH_LONG).show();
            return;
        }

//        getSpiceManager().execute(new GetUnitsRequest().getCachedSpiceRequest(), new DefaultSdkResponseListener<GetUnitsRequest.GetUnitsResponse>() {
//            @Override
//            public void onRequestSuccess(GetUnitsRequest.GetUnitsResponse getUnitsResponse) {
//                mUnits = getUnitsResponse.units;
//                unitsUpdated();
//            }
//        });
        //get the categories just when creating a reminder
        if(!isEditing) {
            getSpiceManager().execute(new GetCategoriesRequest().getCachedSpiceRequest(),
                    new DefaultSdkResponseListener<GetCategoriesRequest.GetCategoriesResponse>() {
                @Override
                public void onRequestSuccess(GetCategoriesRequest.GetCategoriesResponse getCategoriesResponse) {
                    allCategories = getCategoriesResponse.categories;
                    categoriesUpdated();
                }
            });
        }
        else {
            nameTextView.setText(mReminder.name);
        }
    }

//    private void unitsUpdated() {
//        Collections.sort(mUnits, new Comparator<Unit>() {
//            @Override
//            public int compare(Unit lhs, Unit rhs) {
//                return lhs.getName().compareToIgnoreCase(rhs.getName());
//            }
//        });
//        //if editing the reminder find the unit on the list and fill the label
//        if(isEditing){
//            for(int i=0; i<mUnits.size(); i++){
//                if(mUnits.get(i).getId() == mReminder.unitId) selectedUnitIndex = i;
//            }
//            unitsText.setText(mUnits.get(selectedUnitIndex).getName());
//        }
//        else {
//            selectedUnitIndex = 0;
//            selectUnit(selectedVariable);
//        }
//    }

    private void categoriesUpdated() {
        for(int i=0; i<allCategories.size(); i++){
            String name = allCategories.get(i).getName().toLowerCase();
            if(!name.equals("emotions") && !name.equals("foods") && !name.equals("symptoms") &&
                    !name.equals("treatments")){
                allCategories.remove(i);
                i--;
            }
        }

        VariableCategory miscCategory = new VariableCategory("Misc");
        allCategories.add(miscCategory);
        VariableCategorySelectSpinnerAdapter adapter = new VariableCategorySelectSpinnerAdapter(this, allCategories);
        spVariableCategory.setAdapter(adapter);
        spVariableCategory.setSelection(allCategories.size() - 1);
        if(isEditing) {
            for (int i = 0; i < allCategories.size(); i++) {
                if (mReminder.variableCategory.equals(allCategories.get(i).getName())){
                    spVariableCategory.setSelection(i);
                }
            }
        }
//        selectUnit(selectedVariable);
    }

    /**
     * Click listener for Save Button, also validates the dat
     * @param view the Button view
     */
    public void onSave(View view){
        boolean error = false;
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
                isEditing ? mReminder.name : selectedVariable.getName(),
                isEditing ? mReminder.variableCategory : selectedVariable.getCategory(),
                isEditing ? mReminder.combinationOperation : selectedVariable.getCombinationOperation(),
                valueTextView.getText().toString(),
                isEditing ? mReminder.unitName : selectedVariable.getUnit(),
                frequencySpinner.getSelectedItemPosition()
        );
        CustomRemindersHelper.putReminder(this, newReminder);
        CustomRemindersHelper.setAlarm(this, newReminder.id);
        finish();
        Toast.makeText(getApplicationContext(),R.string.custom_reminder_save_message,
                Toast.LENGTH_LONG).show();
    }

    /**
     * Click listener for Remove Button, also used to cancel when creating a reminder
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
                        CustomRemindersHelper.removeReminder(CustomRemindersCreateActivity.this,
                                reminderId);
                        CustomRemindersCreateActivity.this.finish();
                        Toast.makeText(getApplicationContext(),
                                R.string.custom_reminders_remove_message, Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    /*
    **  Adapter for unit selection spinners
    */
    class UnitSelectSpinnerAdapter extends ArrayAdapter<Unit> {
        LayoutInflater inflater;
        int preferredHeight;

        // The view showing the current selection. Public so that it can be modified to update the spinner with a new value
        public TextView selectedView;

        public UnitSelectSpinnerAdapter(Context context, ArrayList<Unit> units) {
            //Creating new list, so unitAdapter wouldn't bound to unitsInCategory field
            super(context, 0, new ArrayList<>(units));
            this.inflater = LayoutInflater.from(context);
            this.preferredHeight = ConvertUtils.convertDpToPixel(48, context.getResources());

            selectedView = (TextView) inflater.inflate(android.R.layout.simple_spinner_dropdown_item, null);
            selectedView.setTextColor(Color.BLACK);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            selectedView.setText(getItem(position).name);
            return selectedView;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            LinearLayout view = (LinearLayout) inflater.inflate(R.layout.qmt_f_tracking_measurementsunit, null);

            Unit unit = getItem(position);

            TextView tvUnitReadable = (TextView) view.findViewById(R.id.tvUnitReadable);
            tvUnitReadable.setText(unit.name);

            TextView tvUnit = (TextView) view.findViewById(R.id.tvUnit);
            tvUnit.setText(unit.abbreviatedName);

            return view;
        }
    }

    private SpiceManager getSpiceManager(){
        return mSpiceManager;
    }
}
