package com.quantimodo.tools.utils;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.activities.QuantimodoLoginActivity;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * AsynkTask to fetch the google token and handling the result
 */
public class GetUsernameTask extends AsyncTask<Void, Void, JsonObject> {
    private static final String TAG = GetUsernameTask.class.getSimpleName();

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
    protected JsonObject doInBackground(Void... params) {
        try {
            String token = fetchToken();
            if (token != null) {
                Log.d(TAG, "correct token!!: " + token);
                try {
                    return Ion.with(mActivity)
                            .load(mPrefs.getApiSocialAuth())
                            .setBodyParameter("provider", "google")
                            .setBodyParameter("accessToken", token)
                            .asJsonObject()
                            .get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }

            }
            else
                Log.d(TAG, "token null :( ");
        } catch (IOException e) {
            // The fetchToken() method handles Google-specific exceptions,
            // so this indicates something went wrong at a higher level.
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(JsonObject result) {
        if(result != null) {
            final String accessToken = result.get("access_token").getAsString();
            final String refreshToken = result.get("refresh_token").getAsString();
            final int expiresIn = result.get("expires_in").getAsInt();
            mActivity.setAuthToken(accessToken, refreshToken, expiresIn);
        }
        else{
            Log.e(TAG, "result from QM server was null!");
        }
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