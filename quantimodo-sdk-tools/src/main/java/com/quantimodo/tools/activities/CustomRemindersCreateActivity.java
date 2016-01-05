package com.quantimodo.tools.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.adapters.AutoCompleteListAdapter;
import com.quantimodo.tools.adapters.VariableCategorySelectSpinnerAdapter;
import com.quantimodo.tools.sdk.DefaultSdkResponseListener;
import com.quantimodo.tools.sdk.request.GetCategoriesRequest;
import com.quantimodo.tools.sdk.request.GetSuggestedVariablesRequest;
import com.quantimodo.tools.sdk.request.GetUnitsRequest;
import com.quantimodo.tools.utils.ConvertUtils;
import com.quantimodo.tools.utils.QtoolsUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Activity that displays the form to create a custom reminder
 */
public class CustomRemindersCreateActivity extends Activity {
    public static final String EXTRA_VARIABLE_NAME = "extra_variable_name";
    public static final String EXTRA_UNIT_ID = "extra_unit_id";
    public static final String EXTRA_CATEGORY_NAME = "extra_category_name";
    public static final String EXTRA_VALUE = "extra_value";
    public static final String EXTRA_FREQUENCY_INDEX = "extra_freq_index";

    private SpiceManager mSpiceManager = new SpiceManager(QTools.getInstance().getServiceClass());

    private TextView nameTextView;
    private ListView lvVariableSuggestions;
    private Spinner unitsSpinner;
    private ProgressBar progressView;
    private Spinner spVariableCategory;
    private TextView valueTextView;
    private View mainLayout;

    private AutoCompleteListAdapter autoCompleteListAdapter;
    private UnitSelectSpinnerAdapter unitAdapter;
    private ArrayList<Variable> suggestedVariables = new ArrayList<>();
    private ArrayList<Unit> mUnits = new ArrayList<>();
    private ArrayList<VariableCategory> allCategories;
    private Variable selectedVariable;
    private int selectedUnitIndex;
    private int refreshesRunning = 0;

    private String extraVariableName;
    private int extraUnitId;
    private String extraCategoryName;
    private String extraValue;
    private int extraFrequencyIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_reminder_create);
        extraVariableName = getIntent().getStringExtra(EXTRA_VARIABLE_NAME);
        extraUnitId = getIntent().getIntExtra(EXTRA_UNIT_ID, -1);
        extraValue = getIntent().getStringExtra(EXTRA_VALUE);
        extraCategoryName = getIntent().getStringExtra(EXTRA_CATEGORY_NAME);
        extraFrequencyIndex = getIntent().getIntExtra(EXTRA_FREQUENCY_INDEX, 0);

        initViews();
        loadAndInitData();

        if(!TextUtils.isEmpty(extraVariableName)){
            if(getActionBar() != null)
                getActionBar().setTitle(R.string.custom_reminders_edit);
            nameTextView.setEnabled(false);
            unitsSpinner.setEnabled(false);
            spVariableCategory.setEnabled(false);
        } else if(getActionBar() != null)
            getActionBar().setTitle(R.string.custom_reminders_create);
    }

    @Override
    public void onResume() {
        super.onResume();
        mSpiceManager.start(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
                anim.setDuration(350);
                mainLayout.setAnimation(anim);
                mainLayout.animate();
            }
        }, 500);
    }

    @Override
    public void onPause() {
        super.onPause();
        mSpiceManager.shouldStop();
    }

    private void initViews(){
        mainLayout = findViewById(R.id.custom_reminder_main_layout);
        unitsSpinner = (Spinner) findViewById(R.id.reminders_create_units_spinner);
        spVariableCategory = (Spinner) findViewById(R.id.spVariableCategory);
        progressView = (ProgressBar) findViewById(R.id.custom_reminder_progress);
        nameTextView = (TextView) findViewById(R.id.custom_reminder_variable_edit);
        nameTextView.addTextChangedListener(onVariableNameChanged);

        lvVariableSuggestions = (ListView) findViewById(R.id.lvVariableSuggestions);

        lvVariableSuggestions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nameTextView.setText(suggestedVariables.get(position).getName());
                selectedVariable = suggestedVariables.get(position);
                lvVariableSuggestions.setVisibility(View.GONE);
            }
        });

        autoCompleteListAdapter = new AutoCompleteListAdapter(this, suggestedVariables);
        lvVariableSuggestions.setAdapter(autoCompleteListAdapter);

        Spinner spinner = (Spinner) findViewById(R.id.reminders_create_freq_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mood_interval_entries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if(extraFrequencyIndex > 0){
            spinner.setSelection(extraFrequencyIndex, false);
        }

        valueTextView = (TextView) findViewById(R.id.reminders_create_value_text);
        if(!TextUtils.isEmpty(extraValue)){
            valueTextView.setText(extraValue);
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
        }
        else filter = null;
        getSpiceManager().execute(new GetSuggestedVariablesRequest(search, filter),
                new DefaultSdkResponseListener<GetSuggestedVariablesRequest.GetSuggestedVariablesResponse>() {
            @Override
            public void onRequestFailure(SpiceException spiceException) {
                super.onRequestFailure(spiceException);
//                getPublicVariables(search);
            }

            @Override
            public void onRequestSuccess(GetSuggestedVariablesRequest.GetSuggestedVariablesResponse response) {
                refreshesRunning--;
                if (refreshesRunning <= 0) {
                    progressView.setVisibility(View.GONE);
                }
                if(response.variables.size() == 0){
                    autoCompleteListAdapter.clear();
                    lvVariableSuggestions.setVisibility(View.GONE);
//                    getPublicVariables(search);
                }
                else {
                    if(!TextUtils.isEmpty(extraVariableName)){
                        for(Variable variable : response.variables){
                            if(variable.getName().equals(extraVariableName))
                                selectedVariable = variable;
                        }
                    }
                    suggestedVariables = response.variables;
                    autoCompleteListAdapter.clear();
                    autoCompleteListAdapter.addAll(response.variables);
                    if(selectedVariable != null && existOnVariables(selectedVariable.getId()) &&
                            nameTextView.getText().toString().equals(selectedVariable.getName()))
                        return;
                    lvVariableSuggestions.setVisibility(View.VISIBLE);
//                    openSearchVariable();
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
        if(!QtoolsUtils.hasInternetConnection(this)){
            Toast.makeText(this, R.string.network_connection_error_message, Toast.LENGTH_LONG).show();
            return;
        }

        getSpiceManager().execute(new GetUnitsRequest().getCachedSpiceRequest(), new DefaultSdkResponseListener<GetUnitsRequest.GetUnitsResponse>() {
            @Override
            public void onRequestSuccess(GetUnitsRequest.GetUnitsResponse getUnitsResponse) {
                mUnits = getUnitsResponse.units;
                unitsUpdated();
            }
        });

        getSpiceManager().execute(new GetCategoriesRequest().getCachedSpiceRequest(), new DefaultSdkResponseListener<GetCategoriesRequest.GetCategoriesResponse>() {
            @Override
            public void onRequestSuccess(GetCategoriesRequest.GetCategoriesResponse getCategoriesResponse) {
                allCategories = getCategoriesResponse.categories;
                categoriesUpdated();
            }
        });
        if(!TextUtils.isEmpty(extraVariableName)){
            nameTextView.setText(extraVariableName);
            refreshAutoComplete(extraVariableName);
        }
    }

    private void unitsUpdated() {
        Collections.sort(mUnits, new Comparator<Unit>() {
            @Override
            public int compare(Unit lhs, Unit rhs) {
                return lhs.getName().compareToIgnoreCase(rhs.getName());
            }
        });
        if(extraUnitId >= 0){
            for(int i=0; i<mUnits.size(); i++){
                if(mUnits.get(i).getId() == extraUnitId) selectedUnitIndex = i;
            }
        }
        else selectedUnitIndex = 0;
        initUnitPicker();
    }

    private void categoriesUpdated() {
        VariableCategorySelectSpinnerAdapter adapter = new VariableCategorySelectSpinnerAdapter(this, allCategories);
        spVariableCategory.setAdapter(adapter);
        if(!TextUtils.isEmpty(extraCategoryName)) {
            for (int i = 0; i < allCategories.size(); i++) {
                if (extraCategoryName.equals(allCategories.get(i).getName())){
                    spVariableCategory.setSelection(i);
                }
            }
        }
    }

    private void initUnitPicker() {
        unitAdapter = new UnitSelectSpinnerAdapter(this, mUnits);
        unitsSpinner.setAdapter(unitAdapter);
        unitsSpinner.setSelection(selectedUnitIndex);
        unitsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedUnitIndex = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
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
