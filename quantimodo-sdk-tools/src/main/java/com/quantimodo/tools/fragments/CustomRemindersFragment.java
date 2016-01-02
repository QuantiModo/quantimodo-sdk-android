package com.quantimodo.tools.fragments;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IntDef;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.quantimodo.android.sdk.model.Measurement;
import com.quantimodo.android.sdk.model.MeasurementSet;
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
import com.quantimodo.tools.sdk.request.GetPublicSuggestedVariablesRequest;
import com.quantimodo.tools.sdk.request.GetSuggestedVariablesRequest;
import com.quantimodo.tools.sdk.request.GetUnitsRequest;
import com.quantimodo.tools.sdk.request.SendMeasurementsRequest;
import com.quantimodo.tools.utils.ConvertUtils;
import com.quantimodo.tools.utils.CustomRemindersHelper;
import com.quantimodo.tools.utils.QtoolsUtils;
import com.quantimodo.tools.utils.ViewUtils;
import com.quantimodo.tools.utils.tracking.MeasurementCardHolder;
import com.quantimodo.tools.views.ScrollViewExt;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Used to search Variables for later add an Alarm that will inform the user to track that variable.
 * Search can be narrowed to one category, check {@link #newInstance(int) newInstance(int)} method for more details
 */
public class CustomRemindersFragment extends QFragment {

    EditText etVariableName;
    ListView lvVariableSuggestions;
    ProgressBar pbAutoCompleteLoading;
    LinearLayout lnCardsContainer;
    ScrollViewExt svCardsContainer;
    View vwVariableNameShadow;

    RelativeLayout lnAddVariableContainer;
    EditText etVariableNameNew;
    Spinner spVariableCategory;
    RadioGroup rgVariableCombinationOperation;

    @Inject
    ToolsPrefs mPrefs;

    private static final String KEY_TYPE = "type";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_SEARCH = "search";

    @IntDef({TYPE_ALL,TYPE_DIET,TYPE_MOOD,TYPE_SYMPTOMS,TYPE_TREATMENTS, TYPE_EMOTIONS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TrackingType{}

    /**
     * Category definition, that defines some params of tracking fragment like
     * <ul>
     *     <li>Action bar title</li>
     *     <li>Category name, that would used in search variables request</li>
     *     <li>Default value</li>
     *     <li>Default unit</li>
     *     <li>Hint for search variable edit input</li>
     *     <li>Default combine type of new variable</li>
     * </ul>
     *
     * There are several predefined CategoryDefs
     * <ul>
     *     <li>Diet &ndash; {@link #TYPE_DIET}</li>
     *     <li>Treatments &ndash; {@link #TYPE_TREATMENTS}</li>
     *     <li>Symptoms &ndash; {@link #TYPE_SYMPTOMS}</li>
     *     <li>Mood &ndash; {@link #TYPE_MOOD}</li>
     * </ul>
     */
    public static class CategoryDef implements Serializable{
        final String filter;
        final Double defaultValue;
        final String defaultUnit;
        final int hintId;
        final int titleId;
        final String combineType;

        /**
         * @param filter Category name
         * @param defaultValue Default value
         * @param defaultUnit Default unit
         * @param hintId hint resource
         * @param combineType combineType should be {@link com.quantimodo.android.sdk.SdkDefs#COMBINE_SUM} or {@link com.quantimodo.android.sdk.SdkDefs#COMBINE_MEAN}
         * @param titleId title for action bar
         */
        public CategoryDef(String filter, Double defaultValue, String defaultUnit, int hintId, String combineType,int titleId) {
            this.filter = filter;
            this.defaultValue = defaultValue;
            this.defaultUnit = defaultUnit;
            this.hintId = hintId;
            this.combineType = combineType;
            this.titleId = titleId;
        }


        public String getFilter() {
            return filter;
        }

        public Double getDefaultValue() {
            return defaultValue;
        }

        public String getDefaultUnit() {
            return defaultUnit;
        }

        public int getHintId() {
            return hintId;
        }
    }

    //this category has to be in the same orther of the TYPE_ constants
    private static final CategoryDef[] mCategoryFilter = {
            new CategoryDef(null,Double.NaN,"units", R.string.tracking_item_no_category, null,R.string.tracking_fragment_no_category_title),
            new CategoryDef("Foods",1d,"serving", R.string.tracking_item_diet_question, Variable.COMBINE_SUM,R.string.tracking_fragment_diet_title),
            new CategoryDef("Treatments",1d,"units", R.string.tracking_item_treatments_question, Variable.COMBINE_SUM,R.string.tracking_fragment_treatments_title),
            new CategoryDef("Symptoms",1d,"%", R.string.tracking_item_symptoms_question, Variable.COMBINE_MEAN,R.string.tracking_fragment_symptoms_title),
            new CategoryDef("Mood",0d,"serving", R.string.tracking_item_mood_question, Variable.COMBINE_MEAN,R.string.tracking_fragment_mood_title),
            new CategoryDef("Emotions",1d,"%", R.string.tracking_item_emotions_question, Variable.COMBINE_SUM,R.string.tracking_fragment_emotions_title),
    };

    public static final int TYPE_ALL = 0;
    public static final int TYPE_DIET = 1;
    public static final int TYPE_TREATMENTS = 2;
    public static final int TYPE_SYMPTOMS = 3;
    public static final int TYPE_MOOD = 4;
    public static final int TYPE_EMOTIONS = 5;

    private CategoryDef mCategoryDef;
    private int mType;

    // Adapter for the autocomplete listview
    private AutoCompleteListAdapter autoCompleteListAdapter;

    // QM API stuff
    private ArrayList<Variable> suggestedVariables = new ArrayList<>();              // Variables in autocomplete
    private ArrayList<Unit> mUnits;                            // All units from QM
    private ArrayList<VariableCategory> allCategories;           // All variable categories from QM

    // The variable the user selected
    Variable selectedVariable;
    int selectedDefaultUnitIndex;

    private String mSearchText = null;

    /**
     * Creates new TrackingFragment
     * @param type category definition see {@link CustomRemindersFragment.CategoryDef CategoryDef} for more info
     * @return new instance of TrackingFragment
     */
    public static CustomRemindersFragment newInstance(int type){
        return newInstance(type, "");
    }

    public static CustomRemindersFragment newInstance(int type, String searchText){
        CustomRemindersFragment fragment = new CustomRemindersFragment();

        Bundle args = new Bundle();
        args.putInt(KEY_TYPE, type);
        args.putString(KEY_SEARCH, searchText);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QTools.getInstance().inject(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mType = TYPE_ALL;
        if (getArguments() != null){
            mType = getArguments().getInt(KEY_TYPE,TYPE_ALL);
            mSearchText = getArguments().getString(KEY_SEARCH, "");
        }
        mCategoryDef = mCategoryFilter[mType];


        ActionBar bar = getActivity().getActionBar();
        if(bar != null){
            bar.setTitle(mCategoryDef.titleId);
        }
    }

    // ButterKnife doesn't work on apklibs
    void initView(View view){
        etVariableName = (EditText) view.findViewById(R.id.etVariableName);
        lvVariableSuggestions = (ListView) view.findViewById(R.id.lvVariableSuggestions);
        pbAutoCompleteLoading = (ProgressBar) view.findViewById(R.id.pbAutoCompleteLoading);
        lnCardsContainer = (LinearLayout) view.findViewById(R.id.lnCardsContainer);
        svCardsContainer = (ScrollViewExt) view.findViewById(R.id.svCardsContainer);
        vwVariableNameShadow = view.findViewById(R.id.vwVariableNameShadow);

        lnAddVariableContainer = (RelativeLayout) view.findViewById(R.id.lnAddVariableContainer);
        lnAddVariableContainer.findViewById(R.id.btOverflow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spVariableCategory.setVisibility(View.VISIBLE);
                rgVariableCombinationOperation.setVisibility(View.VISIBLE);
            }
        });

        etVariableNameNew = (EditText) view.findViewById(R.id.etVariableNameNew);
        spVariableCategory = (Spinner) view.findViewById(R.id.spVariableCategory);
        rgVariableCombinationOperation = (RadioGroup) view.findViewById(R.id.rgVariableCombinationOperation);

        etVariableName.setHint(mCategoryDef.hintId);

        lvVariableSuggestions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onVariableClick(parent, view, position, id);
            }
        });

        registerForContextMenu(lvVariableSuggestions);
    }

    void cleanViews(){
        unregisterForContextMenu(lvVariableSuggestions);
        etVariableName = null;
        lvVariableSuggestions = null;
        pbAutoCompleteLoading = null;
        lnCardsContainer = null;
        svCardsContainer = null;
        vwVariableNameShadow = null;

        lnAddVariableContainer = null;
        etVariableNameNew = null;
        spVariableCategory = null;
        rgVariableCombinationOperation = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.qmt_f_tracking, container,false);
        initView(view);

        // These listeners makes the autocomplete disappear/appear when you click outside/inside the variable name textbox
        view.setOnTouchListener(onRootViewFocusChanged);
        etVariableName.setOnFocusChangeListener(onVariableNameFocusChanged);

        // Add the "Add new variable" button to the bottom of the autocomplete suggestions
        View lvVariableSuggestionsFooter = inflater.inflate(R.layout.qmt_f_tracking_autocompletefooter, null);
        //Using Global.FOOTER for testing purposes, more intfo at
        // https://code.google.com/p/android-test-kit/wiki/EspressoSamples#Matching_a_view_that_is_a_footer/header_in_a_ListView
        lvVariableSuggestions.addFooterView(lvVariableSuggestionsFooter, ToolsPrefs.FOOTER, true);

        // Configure the autocomplete listview
        autoCompleteListAdapter = new AutoCompleteListAdapter(this.getActivity(),suggestedVariables);
        lvVariableSuggestions.setAdapter(autoCompleteListAdapter);

        // Add a textwatcher so that we can update our custom autocomplete when the user types
        etVariableName.addTextChangedListener(onVariableNameChanged);

        // Makes the shadow animate as you scroll the cards
        final float scrollDist = getResources().getDimensionPixelSize(R.dimen.scroll_dist_shadow);
        svCardsContainer.setScrollViewListener(new ScrollViewExt.ScrollViewListener() {
            @Override
            public void onScrollChanged(ScrollViewExt scrollView, int x, int y, int oldx, int oldy) {
                if (y <= scrollDist) {
                    vwVariableNameShadow.setAlpha(y / scrollDist);
                } else {
                    vwVariableNameShadow.setAlpha(1);
                }
            }
        });

        // Creates the card that lets you add a new variable
        etVariableNameNew.setText(etVariableName.getText());


        // Load units/categories if they're not already loaded. Otherwise call xUpdated so that the spinners are filled
        loadAndInitData();

        return view;
    }

    @TrackingType
    public int getType() {
        return mType;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        cleanViews();
    }

    @Override
    public void onPause() {
        super.onPause();
        etVariableName.setOnFocusChangeListener(null);
    }

    @Override
    public void onResume() {
        super.onResume();
        etVariableName.setOnFocusChangeListener(onVariableNameFocusChanged);
    }

    private void loadAndInitData() {
        if(!QtoolsUtils.hasInternetConnection(getActivity())){
            Toast.makeText(getActivity(), R.string.network_connection_error_message, Toast.LENGTH_LONG).show();
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
        if(!TextUtils.isEmpty(mSearchText)) refreshAutoComplete(mSearchText);
        else refreshAutoComplete("");
    }

    /*
        **  Clears the focus of the variable entry edittext when the user clicks anywhere else
        */
    View.OnTouchListener onRootViewFocusChanged = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
//            int action = motionEvent.getAction();
//            if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_POINTER_DOWN) {
//                etVariableName.clearFocus();
//            }
            return false;
        }
    };

    /*
    ** Toggles the autocomplete on/off based on whether the user selects the variable name edittext
    */
    View.OnFocusChangeListener onVariableNameFocusChanged = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, final boolean hasFocus) {
            setAutoCompleteVisibility(hasFocus);
        }
    };

    /*
    **  Called when the user modified the variable name in the EditText
    **  Requests an autocomplete refresh
    */
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
                    if (etVariableName != null && search.equals(etVariableName.getText().toString())) {
                        refreshAutoComplete(search);
                    }
                }
            }, 500);
        }
    };

    /**
     * Method to call when an item on the list was clicked
     * @param parent The AdapterView where the click happened.
     * @param view The view within the AdapterView that was clicked (this
     *            will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that was clicked.
     */
    void onVariableClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "onVariableClick called!", Toast.LENGTH_SHORT).show();

    }


    private void unitsUpdated() {
        Collections.sort(mUnits, new Comparator<Unit>() {
            @Override
            public int compare(Unit lhs, Unit rhs) {
                return lhs.getName().compareToIgnoreCase(rhs.getName());
            }
        });
        selectedDefaultUnitIndex = 0;
    }

    private void categoriesUpdated() {
        VariableCategorySelectSpinnerAdapter adapter = new VariableCategorySelectSpinnerAdapter(this.getActivity(), allCategories);
        spVariableCategory.setAdapter(adapter);
        if (!mCategoryDef.equals(mCategoryFilter[0])){
            int position = adapter.getPosition(mCategoryDef.getFilter());
            if (position != -1){
                spVariableCategory.setSelection(position);
                spVariableCategory.setVisibility(View.GONE);
            }
        }
    }

    /*
    **  Toggles the visibility of the autocomplete listview/card
    */
    private void setAutoCompleteVisibility(final boolean visible) {
        AnimatorSet animatorSet;
        if (visible) {
            ObjectAnimator backgroundAnimation = ObjectAnimator.ofFloat(lnCardsContainer, View.ALPHA, 1, 0.25f);
            ObjectAnimator translateAnimation = ObjectAnimator.ofFloat(lvVariableSuggestions, View.TRANSLATION_Y, ConvertUtils.convertDpToPixel(-10, getResources()), 0);
            ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(lvVariableSuggestions, View.ALPHA, 0, 1);

            lvVariableSuggestions.setVisibility(View.VISIBLE);

            animatorSet = new AnimatorSet();
            animatorSet.setDuration(250);
            animatorSet.play(backgroundAnimation).with(translateAnimation).with(alphaAnimation);

        } else {
            ObjectAnimator backgroundAnimation = ObjectAnimator.ofFloat(lnCardsContainer, View.ALPHA, 0.25f, 1);
            ObjectAnimator translateAnimation = ObjectAnimator.ofFloat(lvVariableSuggestions, View.TRANSLATION_Y, 0, ConvertUtils.convertDpToPixel(-10, getResources()));
            ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(lvVariableSuggestions, View.ALPHA, 1, 0);

            animatorSet = new AnimatorSet();
            animatorSet.setDuration(250);
            animatorSet.play(backgroundAnimation).with(translateAnimation).with(alphaAnimation);
            if (!isVisible() || getActivity().isFinishing()){
                return;
            }
            animatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    if (isVisible()) {
                        lnCardsContainer.setAlpha(1.0f);
                        lvVariableSuggestions.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                    lvVariableSuggestions.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                }
            });
        }

        if (getActivity() != null && !getActivity().isFinishing()){
            animatorSet.start();
        }
    }

    /*
    **  Refreshes the list of suggested variable names
    */
    private int refreshesRunning = 0;

    private void refreshAutoComplete(final String search) {
        Ion.getDefault(this.getActivity()).cancelAll(this.getActivity());
        pbAutoCompleteLoading.setVisibility(View.VISIBLE);
        refreshesRunning++;
        getSpiceManager().execute(new GetSuggestedVariablesRequest(search,mCategoryDef.filter), new DefaultSdkResponseListener<GetSuggestedVariablesRequest.GetSuggestedVariablesResponse>() {
            @Override
            public void onRequestFailure(SpiceException spiceException) {
                super.onRequestFailure(spiceException);
                getPublicVariables(search);
            }

            @Override
            public void onRequestSuccess(GetSuggestedVariablesRequest.GetSuggestedVariablesResponse response) {
                if(response.variables.size() == 0){
                    getPublicVariables(search);
                }
                else {
                    suggestedVariables = response.variables;
                    autoCompleteListAdapter.clear();
                    autoCompleteListAdapter.addAll(response.variables);
                    refreshesRunning--;
                    if (refreshesRunning <= 0) {
                        if (isVisible()) {
                            pbAutoCompleteLoading.setVisibility(View.GONE);
                        }
                    }
                    openSearchVariable();
                }
            }
        });
    }

    private void getPublicVariables(final String search){
        getSpiceManager().execute(
                new GetPublicSuggestedVariablesRequest(search,mCategoryDef.filter),
                new DefaultSdkResponseListener<GetPublicSuggestedVariablesRequest.Response>() {
            @Override
            public void onRequestFailure(SpiceException spiceException) {
                super.onRequestFailure(spiceException);
                refreshesRunning--;
                if (refreshesRunning <= 0) {
                    pbAutoCompleteLoading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onRequestSuccess(GetPublicSuggestedVariablesRequest.Response response) {
                suggestedVariables = response.variables;
                autoCompleteListAdapter.clear();
                autoCompleteListAdapter.addAll(response.variables);
                refreshesRunning--;
                if (refreshesRunning <= 0) {
                    if (isVisible()) {
                        pbAutoCompleteLoading.setVisibility(View.GONE);
                    }
                }
                openSearchVariable();
            }
        });
    }

    /**
     * Opens the variable that was previously setted, using {@link #mSearchText}
     */
    private void openSearchVariable(){
        if(mSearchText == null) return;
        for(int i = 0; i < suggestedVariables.size(); i++){
            Variable variable = suggestedVariables.get(i);
            if(variable.getName().equals(mSearchText)) onVariableClick(null, null, i, 0);
        }
        mSearchText = null;
    }
}