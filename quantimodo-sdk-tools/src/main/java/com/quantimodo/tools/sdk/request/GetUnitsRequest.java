package com.quantimodo.tools.sdk.request;

import com.quantimodo.android.sdk.SdkResponse;
import com.quantimodo.android.sdk.model.Unit;
import com.quantimodo.tools.models.DaoSession;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Get units request
 * Can be cached see {@link #getCachedSpiceRequest() getCachedSpiceRequest} method, by default cached for 2 days
 */
public class GetUnitsRequest extends SdkRequest<GetUnitsRequest.GetUnitsResponse> {

    @Inject
    DaoSession mSession;

    public GetUnitsRequest() {
        super(GetUnitsResponse.class);
    }

    @Override
    public GetUnitsResponse loadDataFromNetwork() throws Exception {
        List<com.quantimodo.tools.models.Unit> units = mSession.getUnitDao().loadAll();
        ArrayList<Unit> result = new ArrayList<>();
        if (units.size() > 0){
            for (com.quantimodo.tools.models.Unit u : units){
                result.add(u.toUnit());
            }
        } else {
            SdkResponse<ArrayList<Unit>> response = getClient().getUnits(getCtx(), getToken());
            checkResponse(response);
            result.addAll(response.getData());
            for (Unit u : result){
                units.add(com.quantimodo.tools.models.Unit.fromWsUnit(u));
            }
            mSession.getUnitDao().insertOrReplaceInTx(units);
        }

        return new GetUnitsResponse(result);
    }

    @Override
    protected long getCacheTime() {
        return 0; //0 moved to database cache
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

