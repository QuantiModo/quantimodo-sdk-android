package com.quantimodo.tools.sdk.request;

import com.quantimodo.android.sdk.SdkResponse;
import com.quantimodo.android.sdk.model.VariableCategory;

import java.util.ArrayList;

/**
 * Get categories request
 * Can be cached see {@link #getCachedSpiceRequest() getCachedSpiceRequest} method, by default cached for 2 days
 */
public class GetCategoriesRequest extends SdkRequest<GetCategoriesRequest.GetCategoriesResponse> {

    public GetCategoriesRequest() {
        super(GetCategoriesResponse.class);
    }

    @Override
    public GetCategoriesResponse loadDataFromNetwork() throws Exception {
        SdkResponse<ArrayList<VariableCategory>> categorySdkResponse = getClient().getCategories(getCtx(), getToken());
        checkResponse(categorySdkResponse);
        return new GetCategoriesResponse(categorySdkResponse.getData());
    }

    @Override
    protected long getCacheTime() {
        return 2 * 24 * 3600; //2 days
    }

    @Override
    protected String getCacheKey() {
        return "getCategories";
    }

    public static final class GetCategoriesResponse{
        final public ArrayList<VariableCategory> categories;


        public GetCategoriesResponse(ArrayList<VariableCategory> categories) {
            this.categories = categories;
        }
    }
}
