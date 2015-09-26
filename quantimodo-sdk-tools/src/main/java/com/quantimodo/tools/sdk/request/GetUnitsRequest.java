package com.quantimodo.tools.sdk.request;

import com.quantimodo.android.sdk.SdkResponse;
import com.quantimodo.android.sdk.model.Unit;

import java.util.ArrayList;

/**
 * Get units request
 * Can be cached see {@link #getCachedSpiceRequest() getCachedSpiceRequest} method, by default cached for 2 days
 */
public class GetUnitsRequest extends SdkRequest<GetUnitsRequest.GetUnitsResponse> {

    public GetUnitsRequest() {
        super(GetUnitsResponse.class);
    }

    @Override
    public GetUnitsResponse loadDataFromNetwork() throws Exception {
        SdkResponse<ArrayList<Unit>> response = getClient().getUnits(getCtx(), getToken());
        checkResponse(response);
        return new GetUnitsResponse(response.getData());
    }

    @Override
    protected long getCacheTime() {
        return 2 * 24 * 3600; //2 days
    }

    @Override
    protected String getCacheKey() {
        return "getUnits";
    }

    public static final class GetUnitsResponse{
        final public ArrayList<Unit> units;

        public GetUnitsResponse(ArrayList<Unit> units) {
            this.units = units;
        }
    }
}

