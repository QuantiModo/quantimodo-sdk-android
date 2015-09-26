package com.quantimodo.android.sdk;

import java.util.List;
import java.util.Map;

public class SdkResponse<T> {

    public static final int ERROR_NO = 0;
    public static final int ERROR_AUTH = 1;
    public static final int ERROR_NO_INTERNET = 2;
    public static final int ERROR_UNKNOWN = Integer.MAX_VALUE;

    private int mErrorCode = ERROR_NO;
    private int mHttpCode = 200;
    private Exception mCause;
    private String mMessage;
    private T mData;
    private Map<String,List<String>> mHeaders;

    public SdkResponse(){

    }

    public SdkResponse(T mData){
        mData = mData;
    }

    public SdkResponse(int mErrorCode, int mHttpCode, Exception mCause, String mMessage, T mData) {
        this.mErrorCode = mErrorCode;
        this.mHttpCode = mHttpCode;
        this.mCause = mCause;
        this.mMessage = mMessage;
        this.mData = mData;
    }

    public void setErrorCode(int mErrorCode) {
        this.mErrorCode = mErrorCode;
    }

    public void setHttpCode(int mHttpCode) {
        this.mHttpCode = mHttpCode;
    }

    public void setCause(Exception mCause) {
        this.mCause = mCause;
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public void setData(T mData) {
        this.mData = mData;
    }

    public int getHttpCode() {
        return mHttpCode;
    }

    public boolean isSuccessful(){
        return mErrorCode == ERROR_NO;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    public Exception getCause() {
        return mCause;
    }

    public String getMessage() {
        return mMessage;
    }

    public T getData() {
        return mData;
    }

    public Map<String, List<String>> getHeaders() {
        return mHeaders;
    }

    public void setHeaders(Map<String, List<String>> mHeaders) {
        this.mHeaders = mHeaders;
    }
}
