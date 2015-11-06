package com.quantimodo.tools.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.amazon.device.associates.AssociatesAPI;
import com.amazon.device.associates.NotInitializedException;
import com.amazon.device.associates.OpenSearchPageRequest;
import com.quantimodo.android.sdk.SdkDefs;
import com.quantimodo.android.sdk.model.Correlation;
import com.quantimodo.android.sdk.model.CorrelationPost;
import com.quantimodo.tools.R;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.adapters.CorrelationAdapter;
import com.quantimodo.tools.dialogs.CorrelationConfirmDialog;
import com.quantimodo.tools.sdk.DefaultSdkResponseListener;
import com.quantimodo.tools.sdk.request.SearchCustomCorrelationsRequest;
import com.quantimodo.tools.sdk.request.VoteCorrelationRequest;
import com.quantimodo.tools.sdk.request.SearchCorrelationsRequest;

import java.util.ArrayList;

/**
 * Used to show positive/negative factors
 * Should be in init with {@link #newInstance(int, String) newInstance(int, String)} method
 * Fetch both types of factors same time, so same instance can be used to show positive and negative factors,
 * and can be switched between types by {@link #setType(int) setType(int)} method.
 */
public class FactorsFragment extends QListFragment implements CorrelationAdapter.CorrelationButtonOnClick, CorrelationConfirmDialog.DialogListener {


    private TextView mHeader;
    private int mType;
    private String mVariableName;
    private boolean isPublic = true;
    public static final String ARG_TYPE = "type";
    public static final String ARG_VARIABLE = "variable";
    public static final String ARG_PUBLIC = "is_public";

    /**
     * Creates and init new instance of Factors fragment
     * @param type defines what type would have fragment TYPE_POSITIVE or TYPE_NEGATIVE, see {@link com.quantimodo.tools.adapters.CorrelationAdapter.CorrelationType CorrelationType}
     * @param variableName variable name, which should be used as effect
     * @return instance of factors fragment
     */
    public static FactorsFragment newInstance(@CorrelationAdapter.CorrelationType int type,String variableName){
        return newInstance(type,variableName, CorrelationAdapter.PREDICTOR_COMMON);
    }

    public static FactorsFragment newInstance(@CorrelationAdapter.CorrelationType int type,
                                              String variableName, @CorrelationAdapter.PredictorType int predictorType){
        FactorsFragment factorsFragment = new FactorsFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_TYPE, type);
        args.putString(ARG_VARIABLE, variableName);
        args.putBoolean(ARG_PUBLIC, predictorType == CorrelationAdapter.PREDICTOR_COMMON);
        factorsFragment.setArguments(args);

        return factorsFragment;
    }

    public int getType() {
        return mType;
    }

    /**
     * Switch fragment type
     * @param mType TYPE_POSITIVE or TYPE_NEGATIVE, see {@link com.quantimodo.tools.adapters.CorrelationAdapter.CorrelationType CorrelationType}
     */
    public void setType(@CorrelationAdapter.CorrelationType int mType) {
        if (mType == this.mType){
            return;
        }
        this.mType = mType;
        if (getListAdapter() != null){
            ((CorrelationAdapter)getListAdapter()).setType(mType);
        }
        mHeader.setText(getHeaderText());
    }

    private String getHeaderText(){
        if(isPublic)
            return getString(R.string.header_factors_common);
        else
            return getString(R.string.header_factors_yours);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mType = getArguments().getInt(ARG_TYPE);
        mVariableName = getArguments().getString(ARG_VARIABLE);
        isPublic = getArguments().getBoolean(ARG_PUBLIC, true);
        if(getArguments().getBoolean(ARG_PUBLIC, true)){
            getSpiceManager().execute(
                    new SearchCorrelationsRequest(mVariableName, SdkDefs.CORRELATION_EFFECT).getCachedSpiceRequest(),
                    new DefaultSdkResponseListener<SearchCorrelationsRequest.CorrelationsResponse>() {
                        @Override
                        public void onRequestSuccess(SearchCorrelationsRequest.CorrelationsResponse correlationsResponse) {
                            updateData(correlationsResponse.correlations);
                        }
                    });
        }
        else{
            getSpiceManager().execute(
                    new SearchCustomCorrelationsRequest().getCachedSpiceRequest(),
                    new DefaultSdkResponseListener<SearchCustomCorrelationsRequest.CorrelationsResponse>() {
                        @Override
                        public void onRequestSuccess(SearchCustomCorrelationsRequest.CorrelationsResponse correlationsResponse) {
                            updateData(correlationsResponse.correlations);
                        }
                    });
        }


        View v = View.inflate(getActivity(), R.layout.qmt_list_view_header, null);
        mHeader = (TextView) v.findViewById(R.id.text);
        mHeader.setText(getHeaderText());
        getListView().addHeaderView(v);
    }

    private void updateData(final ArrayList<Correlation> data){
        CorrelationAdapter adapter = new CorrelationAdapter(getActivity(), data, mType);
        adapter.setButtonListener(FactorsFragment.this);
        setListAdapter(adapter);
    }

    @Override
    public void onClick(View view, @CorrelationAdapter.CorrelationButton int buttonType, int position, Correlation item) {

        switch (buttonType){
            case CorrelationAdapter.BUTTON_SHOP:
                try {
                    AssociatesAPI.getLinkService().openRetailPage(new OpenSearchPageRequest(item.getCause()));
                } catch (NotInitializedException e) {
                    e.printStackTrace();
                }
                break;

            case CorrelationAdapter.BUTTON_THUMBS_UP:
                buttonVote(item,CorrelationAdapter.STATE_UP);
                break;

            case CorrelationAdapter.BUTTON_THUMBS_DOWN:
                buttonVote(item,CorrelationAdapter.STATE_DOWN);
                break;
        }
    }


    private void buttonVote(Correlation correlation, int state){
        SharedPreferences prefs = getActivity().getSharedPreferences(ToolsPrefs.QUANTIMODO_PREF_KEY, Context.MODE_PRIVATE);
        if (!!prefs.getBoolean(ToolsPrefs.PREF_SHOW_CORRELATION_CONFIRM,false)) {
            CorrelationConfirmDialog dialog = CorrelationConfirmDialog.createDialog(correlation, mType, state);
            dialog.setTargetFragment(this, 1);
            dialog.show(getFragmentManager(), null);
        } else {
            onConfirm(correlation,state);
        }
    }

    private void submitVote(final Correlation correlation, final int vote){
        CorrelationPost post = new CorrelationPost(correlation.getCause(),correlation.getEffect(),correlation.getCorrelationCoefficient(),vote);
        getSpiceManager().execute(new VoteCorrelationRequest(post), new DefaultSdkResponseListener<Void>() {
            @Override
            public void onRequestSuccess(Void aVoid) {
                int state = vote == 0 ? CorrelationAdapter.STATE_DOWN : CorrelationAdapter.STATE_UP;
                ((CorrelationAdapter) getListAdapter()).setState(correlation, state);
            }
        });
    }


    @Override
    public void onConfirm(Correlation correlation, @CorrelationAdapter.CorrelationState int state) {
        int vote = state == CorrelationAdapter.STATE_UP ? 1 : 0;
        submitVote(correlation,vote);
    }
}
