package com.quantimodo.android.sdk;


import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.util.Log;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.koushikdutta.ion.builder.FutureBuilder;
import com.quantimodo.android.sdk.model.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.quantimodo.android.sdk.SdkDefs.QUANTIMODO_ADDRESS;

/*
   API class to interact with QuantiModo web-service
   All method are synchronous
 */
public class QuantimodoApiV2 {

    private static final String TAG = "qmApi";
    private static final String XDEBUG_SESSION = "PHPSTORM";

    private String mToken;
    private final String mBaseUrl;
    private boolean mDebugMode;


    @StringDef({SdkDefs.CORRELATION_CAUSE,SdkDefs.CORRELATION_EFFECT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CauseOrEffect {}

    public static QuantimodoApiV2 getInstance(String mBaseUrl){
        return new QuantimodoApiV2(mBaseUrl,null);
    }

    public static QuantimodoApiV2 getInstance(String baseUrl,String token){
        return new QuantimodoApiV2(baseUrl,token);
    }

    private QuantimodoApiV2(String baseUrl,String token){
        mToken = token;
        mBaseUrl = baseUrl == null ? SdkDefs.QUANTIMODO_ADDRESS : baseUrl;
    }

    public void setToken(String token){
        mToken = token;
    }

    public String getAccessToken(Context context, Account account, String clientId, String clientSecret, String scopes) throws AuthenticatorException, OperationCanceledException, IOException {
        Bundle bundle = new Bundle();
        bundle.putString("clientId", clientId);
        bundle.putString("clientSecret", clientSecret);
        Bundle result = AccountManager.get(context).getAuthToken(account, scopes, bundle, true, null, null).getResult();
        Intent intent = bundle.getParcelable(AccountManager.KEY_INTENT);

        //TODO check intent for NULL, if NULL show notification to let the user sign in again (if scopes == "cookie") or reauthorize.
        return result.getString(AccountManager.KEY_AUTHTOKEN);
    }

    private Type getErrorType(){
        return new TypeToken<ResponseError>(){}.getType();
    }

    private void applyError(Context context,SdkResponse response, Response<String> responseIon){
        ResponseError error = Ion.getDefault(context).configure().getGson().fromJson(responseIon.getResult(), getErrorType());
        response.setMessage(error.getErrorMessage());
        if (responseIon.getHeaders().getResponseCode() == 401){
            response.setErrorCode(SdkResponse.ERROR_AUTH);
        } else {
            response.setErrorCode(SdkResponse.ERROR_UNKNOWN);
        }
    }

    private <T> void executeRequest(Context context, SdkResponse<T> sdkResponse,TypeToken<T> type,FutureBuilder requestBuilder){
        try {
            Response<String> stringResponse = requestBuilder.asString().withResponse().get();
            sdkResponse.setHeaders(stringResponse.getHeaders().toMultimap());
            sdkResponse.setHttpCode(stringResponse.getHeaders().getResponseCode());
            if (sdkResponse.getHttpCode() <= 300){
                if (!type.getRawType().equals(Void.TYPE)) {
                    T result = Ion.getDefault(context).configure().getGson().fromJson(stringResponse.getResult(), type.getType());
                    sdkResponse.setData(result);
                }
            } else {
                applyError(context, sdkResponse, stringResponse);
            }
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.d(TAG, e.getMessage());
            }
            sdkResponse.setErrorCode(SdkResponse.ERROR_UNKNOWN);
            sdkResponse.setCause(e);
        }
    }

    public SdkResponse<ArrayList<HistoryMeasurement>> getMeasurmentHistory(Context context, String token, Date startTime, Date endTime, String variableName, String source, String toUnitName){
        return getMeasurmentHistory(context, token, startTime, endTime, variableName, source, toUnitName,null,null);
    }

    public SdkResponse<ArrayList<HistoryMeasurement>> getMeasurmentHistory(Context context, String token, Date startTime, Date endTime,
                                                                           String variableName, String source, String toUnitName,Integer limit, Integer offset) {
        setupIon(context);

        SdkResponse<ArrayList<HistoryMeasurement>> sdkResponse = new SdkResponse<>();

        Uri.Builder uriBuilder = Uri.parse(mBaseUrl + "api/measurements").buildUpon();
        if (startTime != null) {
            uriBuilder.appendQueryParameter("startTime", "" + startTime.getTime() / 1000);
        }
        if (endTime != null) {
            uriBuilder.appendQueryParameter("endTime", "" + endTime.getTime() / 1000);
        }
        if (variableName != null) {
            uriBuilder.appendQueryParameter("variableName", variableName);
        }
        if (source != null) {
            uriBuilder.appendQueryParameter("source", source);
        }
        if (toUnitName != null) {
            uriBuilder.appendQueryParameter("unit", toUnitName);
        }
        if (limit != null) {
            uriBuilder.appendQueryParameter("limit",limit.toString());
        }
        if (offset != null){
            uriBuilder.appendQueryParameter("offset",offset.toString());
        }

        FutureBuilder futureBuilder = Ion.with(context)
                .load(uriBuilder.build().toString())
                .setTimeout(120000)
                .setHeader("Authorization", "Bearer " + token);

        executeRequest(context, sdkResponse, new TypeToken<ArrayList<HistoryMeasurement>>() {
        }, futureBuilder);

        return sdkResponse;
    }

    public SdkResponse<Integer> putMeasurements(Context context, String token, List<MeasurementSet> measurementSets) {
        setupIon(context);

        SdkResponse<Integer> sdkResponse = new SdkResponse<>();

        try {
            Log.i("QMSDK", "Sending " + measurementSets.size() + " measurement sets");
            Response<String> response = Ion.with(context)
                    .load(mBaseUrl + "api/measurements/v2")
                    .setHeader("Authorization", "Bearer " + token)
                    .setJsonPojoBody(measurementSets)
                    .asString()
                    .withResponse()
                    .get();

            sdkResponse.setHttpCode(response.getHeaders().getResponseCode());

            JsonParser parser = new JsonParser();
            JsonObject jsonResponse = (JsonObject) parser.parse(response.getResult());

            if (jsonResponse.has("success") && jsonResponse.get("success").getAsBoolean()) {
                Log.i(TAG, "Done sending measurement sets");
                sdkResponse.setData(1);
            } else {
                applyError(context,sdkResponse,response);
            }

        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.d(TAG, e.getMessage());
            }
            sdkResponse.setErrorCode(SdkResponse.ERROR_UNKNOWN);
            sdkResponse.setCause(e);
        }

        return sdkResponse;
    }

    public SdkResponse<ArrayList<Variable>> searchVariables(Context context, String token, String search, int limit, int offset, String source, String category) {
        setupIon(context);

        if (search == null) {
            throw new IllegalArgumentException("\"search\" cannot be null");
        }

        SdkResponse<ArrayList<Variable>> sdkResponse = new SdkResponse<>();


        try {
            search = URLEncoder.encode(search, "utf-8");
            search = "*" + search + "*";

            Uri.Builder uriBuilder = Uri.parse(mBaseUrl + "api/variables/search/" + search).buildUpon();
            uriBuilder.appendQueryParameter("limit", "" + limit);
            uriBuilder.appendQueryParameter("offset", "" + offset);

            if (source != null) {
                uriBuilder.appendQueryParameter("source", source);
            }
            if (category != null) {
                uriBuilder.appendQueryParameter("categoryName", category);
            }

            FutureBuilder futureBuilder = Ion.with(context)
                    .load(uriBuilder.build().toString())
                    .setHeader("Authorization", "Bearer " + token);

            executeRequest(context, sdkResponse, new TypeToken<ArrayList<Variable>>() {
            }, futureBuilder);
        } catch (UnsupportedEncodingException e) {
            Log.d(TAG, e.getMessage());
            sdkResponse.setErrorCode(SdkResponse.ERROR_UNKNOWN);
            sdkResponse.setCause(e);
        }

        return sdkResponse;
    }


    public SdkResponse<ArrayList<Unit>> getUnits(Context context, String token) {
        setupIon(context);

        SdkResponse<ArrayList<Unit>> sdkResponse = new SdkResponse<>();

        FutureBuilder futureBuilder =  Ion.with(context)
                .load(mBaseUrl + "api/units")
                .setHeader("Authorization", "Bearer " + token);

        executeRequest(context, sdkResponse, new TypeToken<ArrayList<Unit>>() {
        }, futureBuilder);

        return sdkResponse;
    }

    public SdkResponse<ArrayList<Correlation>> searchCorrelations(Context context, String token,String variableName,@CauseOrEffect String causeOrEffect){
        setupIon(context);

        if (variableName == null || causeOrEffect == null){
            throw new IllegalArgumentException("On of required params is null");
        }

        SdkResponse<ArrayList<Correlation>> sdkResponse = new SdkResponse<>();

        Uri.Builder uriBuilder = Uri.parse(mBaseUrl + "api/public/correlations/search/").buildUpon();
        uriBuilder.appendPath(variableName);
        uriBuilder.appendQueryParameter("causeOrEffect", causeOrEffect);

        FutureBuilder futureBuilder =  Ion.with(context)
                .load(uriBuilder.build().toString())
                .setHeader("Authorization", "Bearer " + token);

        executeRequest(context, sdkResponse, new TypeToken<ArrayList<Correlation>>() {
        }, futureBuilder);

        return sdkResponse;
    }

    public SdkResponse<ArrayList<VariableCategory>> getCategories(Context context, String token) {
        setupIon(context);

        SdkResponse<ArrayList<VariableCategory>> sdkResponse = new SdkResponse<>();

        FutureBuilder futureBuilder = Ion.with(context)
                .load(mBaseUrl + "api/variableCategories")
                .setHeader("Authorization", "Bearer " + token);

        executeRequest(context, sdkResponse,new TypeToken<ArrayList<VariableCategory>>(){}, futureBuilder);

        return sdkResponse;
    }

    public SdkResponse<ArrayList<Variable>> getVariables(Context context, String token) {
        setupIon(context);

        SdkResponse<ArrayList<Variable>> sdkResponse = new SdkResponse<>();
        FutureBuilder futureBuilder = Ion.with(context)
                .load(mBaseUrl + "api/variables")
                .setHeader("Authorization", "Bearer " + token);

        executeRequest(context, sdkResponse, new TypeToken<ArrayList<Variable>>() {
        }, futureBuilder);

        return sdkResponse;
    }

    public SdkResponse<QuantimodoUser> getUser(Context context, String token) {
        setupIon(context);

        SdkResponse<QuantimodoUser> sdkResponse = new SdkResponse<>();
        FutureBuilder futureBuilder = Ion.with(context)
                .load(mBaseUrl + "api/user")
                .setHeader("Authorization", "Bearer " + token);
        executeRequest(context, sdkResponse, new TypeToken<QuantimodoUser>() {
        }, futureBuilder);

        return sdkResponse;
    }

    @Deprecated
    public SdkResponse<Void> postCorrelation(Context context,String token,CorrelationPost correlation){
        setupIon(context);

        SdkResponse<Void> sdkResponse = new SdkResponse<>();
        FutureBuilder futureBuilder = Ion.with(context)
                .load(mBaseUrl + "api/v1/correlations")
                .setHeader("Authorization", "Bearer " + token)
                .setJsonPojoBody(correlation);

        executeRequest(context,sdkResponse,new TypeToken<Void>(){},futureBuilder);

        return sdkResponse;
    }

    public SdkResponse<Void> voteCorrelation(Context context,String token,CorrelationPost correlationPost){
        setupIon(context);

        SdkResponse<Void> sdkResponse = new SdkResponse<>();
        FutureBuilder futureBuilder = Ion.with(context)
                .load(mBaseUrl + "api/v1/votes")
                .setHeader("Authorization", "Bearer " + token)
                .setJsonPojoBody(correlationPost);

        executeRequest(context,sdkResponse,new TypeToken<Void>(){},futureBuilder);

        return sdkResponse;
    }

    private void setupIon(Context context) {
        Ion defaultIon = Ion.getDefault(context);
        defaultIon.getCookieMiddleware().getCookieStore().removeAll();
        defaultIon.getCookieMiddleware().clear();

        if (mDebugMode) {
            defaultIon.configure().setLogging("QMSDK", Log.DEBUG);
            URI uri = URI.create(mBaseUrl);
            HttpCookie httpCookie = new HttpCookie("XDEBUG_SESSION",XDEBUG_SESSION);
            httpCookie.setDomain(uri.getHost());
            defaultIon.getCookieMiddleware().getCookieStore().add(uri,httpCookie);
        } else {
            defaultIon.configure().setLogging("QMSDK", Log.INFO);
        }


        GsonBuilder builder = new GsonBuilder();
        // Convert epoch returned by API to date
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong() * 1000);
            }
        });
        Gson gson = builder.create();
        defaultIon.configure().setGson(gson);
    }
}
