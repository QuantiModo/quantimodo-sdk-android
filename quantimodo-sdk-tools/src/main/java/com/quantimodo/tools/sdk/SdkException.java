package com.quantimodo.tools.sdk;

import com.quantimodo.android.sdk.SdkResponse;

public class SdkException extends Exception {
    protected int mHttpCode;
    protected int mErrorCode;

    public SdkException(SdkResponse sdkResponse){
        super(sdkResponse.getMessage(),sdkResponse.getCause());
        mHttpCode = sdkResponse.getHttpCode();
        mErrorCode = sdkResponse.getErrorCode();
    }

    public int getHttpCode() {
        return mHttpCode;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

}
