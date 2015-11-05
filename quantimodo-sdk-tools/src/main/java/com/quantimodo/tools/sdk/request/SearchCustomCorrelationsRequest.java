package com.quantimodo.tools.sdk.request;

import android.support.annotation.StringDef;
import com.quantimodo.android.sdk.SdkDefs;
import com.quantimodo.android.sdk.SdkResponse;
import com.quantimodo.android.sdk.model.Correlation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/**
 * Search correlations by effect or by cause
 Can be cached see {@link #getCachedSpiceRequest() getCachedSpiceRequest} method, by default cached for 2 min
 */
public class SearchCustomCorrelationsRequest extends SdkRequest<SearchCustomCorrelationsRequest.CorrelationsResponse> {

    @StringDef({SdkDefs.CORRELATION_CAUSE, SdkDefs.CORRELATION_EFFECT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CauseOrEffect {}

    private final String variableName;
    private final String causeOrEffect;

    public SearchCustomCorrelationsRequest(String variableName, @CauseOrEffect String causeOrEffect) {
        super(CorrelationsResponse.class);
        this.variableName = variableName;
        this.causeOrEffect = causeOrEffect;
    }

    @Override
    protected long getCacheTime() {
        return 2 * 60 * 1000; //2 min
    }

    @Override
    protected String getCacheKey() {
        return "getCorrelation_"+variableName+"_"+causeOrEffect;
    }

    @Override
    public CorrelationsResponse loadDataFromNetwork() throws Exception {
//        SdkResponse<ArrayList<Correlation>> response = getClient().searchCorrelations(getCtx(), getToken(), variableName, causeOrEffect);
        SdkResponse<ArrayList<Correlation>> response = getClient().searchCustomCorrelations(getCtx(), getToken());
        checkResponse(response);
        return new CorrelationsResponse(response.getData());
    }

    public static final class CorrelationsResponse{
        public final ArrayList<Correlation> correlations;

        public CorrelationsResponse(ArrayList<Correlation> correlations) {
            this.correlations = correlations;
        }
    }
}
