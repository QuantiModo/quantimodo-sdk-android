package com.quantimodo.tools.utils;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.activities.QuantimodoLoginActivity;
import com.quantimodo.tools.sdk.AuthHelper;

import java.io.IOException;

import javax.inject.Inject;

/**
 * Created by Andres on 30-10-2015.
 */
public class GetUsernameTask extends AsyncTask<Void, Void, Void> {

    ToolsPrefs mPrefs;

    QuantimodoLoginActivity mActivity;
    String mScope;
    String mEmail;

    public GetUsernameTask(QuantimodoLoginActivity activity, String name, String scope, ToolsPrefs mPrefs) {
        this.mActivity = activity;
        this.mScope = scope;
        this.mEmail = name;
        this.mPrefs = mPrefs;
    }

    /**
     * Executes the asynchronous job. This runs when you call execute()
     * on the AsyncTask instance.
     */
    @Override
    protected Void doInBackground(Void... params) {
        try {
            String token = fetchToken();
            if (token != null) {
                // **Insert the good stuff here.**
                // Use the token to access the user's Google data.
                Log.d("GetUsernameTask", "token correcto!!: " + token);

                Ion.with(mActivity)
                        .load(mPrefs.getApiSocialAuth())
                        .setBodyParameter("provider", "google")
                        .setBodyParameter("accessToken", token)
                        .asString()
                        .withResponse().setCallback(new FutureCallback<Response<String>>() {
                    @Override
                    public void onCompleted(Exception e, Response<String> response) {
                        if (e != null) {
                            e.printStackTrace();
                            return;
                        }
                        String result = response.getResult();
//                        JsonObject result = response.getResult();
                        if (result != null) {
                            try {
                                Log.d("GetUsernameTask", "json result!: " + result.toString());
//                                String accessToken = result.get("access_token").getAsString();
//                                String refreshToken = result.get("refresh_token").getAsString();
//                                int expiresIn = result.get("expires_in").getAsInt();

//                                authHelper.setAuthToken(new AuthHelper.AuthToken(accessToken, refreshToken, System.currentTimeMillis() / 1000 + expiresIn));

//                                finish();
                            } catch (NullPointerException ignored) {
                                Log.i(ToolsPrefs.DEBUG_TAG, "Error getting access token: ");
                            }
                        } else {
                            Log.d("GetUsernameTask", "result nulo, response.toString: " + response.toString());

                        }
                    }
                });
            }
            else
                Log.d("GetUsernameTask", "token null :( ");
        } catch (IOException e) {
            // The fetchToken() method handles Google-specific exceptions,
            // so this indicates something went wrong at a higher level.
            // TIP: Check for network connectivity before starting the AsyncTask.
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets an authentication token from Google and handles any
     * GoogleAuthException that may occur.
     */
    protected String fetchToken() throws IOException {
        try {
            Log.d("GetUsernameTask", "account id: " + GoogleAuthUtil.getAccountId(mActivity, mEmail));
            return GoogleAuthUtil.getToken(mActivity, mEmail, mScope);
        } catch (UserRecoverableAuthException userRecoverableException) {
            // GooglePlayServices.apk is either old, disabled, or not present
            // so we need to show the user some UI in the activity to recover.
            mActivity.handleException(userRecoverableException);
//            userRecoverableException.printStackTrace();
        } catch (GoogleAuthException fatalException) {
            // Some other type of unrecoverable exception has occurred.
            // Report and log the error as appropriate for your app.
            fatalException.printStackTrace();
        }
        return null;
    }
}