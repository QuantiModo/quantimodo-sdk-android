package com.quantimodo.tools.activities;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.quantimodo.android.sdk.QuantimodoApiV2;
import com.quantimodo.android.sdk.model.QuantimodoUser;
import com.quantimodo.tools.QTools;
import com.quantimodo.tools.R;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.UserPreferences;
import com.quantimodo.tools.sdk.AuthHelper;
import com.quantimodo.tools.utils.GetUsernameTask;
import com.quantimodo.tools.utils.QtoolsUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.inject.Inject;

/**
 * Activity used to log in the user using either the google account or facebook account
 */
public class QuantimodoLoginActivity extends Activity {
    private static final String TAG = QuantimodoLoginActivity.class.getSimpleName();
    public static final java.lang.String KEY_SHOW_LOGIN_AGAIN = "show_login_again";
    public static final java.lang.String KEY_APP_NAME = "app_name";
    public static final java.lang.String HELP_MESSAGE_PREFERENCE = "import";
    //    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userinfo.profile";
//    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/plus.me " +
//        "https://www.googleapis.com/auth/plus.login " +
//        "https://www.googleapis.com/auth/plus.profile.emails.read";
    private static final String SCOPE = "oauth2:" +
            "https://www.googleapis.com/auth/userinfo.profile " +
            "https://www.googleapis.com/auth/plus.login " +
            "https://www.googleapis.com/auth/plus.me " +
//        "https://www.googleapis.com/auth/plus.profile.emails.read " +
            "profile " +
            "email " +
            "openid";
    public static final int REQUEST_CODE_WEB_AUTHENTICATE = 2;
    private static final int REQUEST_CODE_PICK_ACCOUNT = 1000;
    private static final int REQUEST_CODE_RECOVER_FROM_AUTH_ERROR = 1;
    static final int REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR = 1001;

    @Inject
    ToolsPrefs mPrefs;

    @Inject
    AuthHelper authHelper;

    @Inject
    QuantimodoApiV2 quantimodoApiV2;

    private CallbackManager callbackManager;
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.moodimodo",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String keyHash = Base64.encodeToString(md.digest(), Base64.DEFAULT);
                Log.d("KeyHash:", keyHash);
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        QTools.getInstance().inject(this);
        setContentView(R.layout.qmt_login);
        View buttonGoogle = findViewById(R.id.qmt_signin_google);
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(QuantimodoLoginActivity.this) == ConnectionResult.SUCCESS)
                    pickUserAccount();
                else {
                    new AlertDialog.Builder(QuantimodoLoginActivity.this)
                            .setMessage(R.string.signing_error_google_play)
                            .setTitle(android.R.string.dialog_alert_title)
                            .setPositiveButton(android.R.string.ok, null)
                            .create()
                            .show();
                }
            }
        });
        Button buttonMoodi = (Button) findViewById(R.id.qmt_signin_moodimodo);
        if(getIntent().hasExtra(KEY_APP_NAME)){
            String appName = getIntent().getExtras().getString(KEY_APP_NAME);
            buttonMoodi.setText(String.format(getString(R.string.signin_moodimodo_button), appName));

            String preference = getIntent().getExtras().getString(HELP_MESSAGE_PREFERENCE,"");
            String helpMessage = "";
            String helpTitle = appName;

            if (preference.equals(getString(R.string.help_import))){
                helpTitle = getString(R.string.help_import);
                helpMessage = getString(R.string.help_content_01);
            } else if (preference.equals(getString(R.string.help_prediction))) {
                helpTitle = getString(R.string.help_prediction);
                helpMessage = getString(R.string.help_content_02);
            }


            final SharedPreferences sharedPref = getSharedPreferences(
                    QuantimodoLoginActivity.class.getSimpleName(), Context.MODE_PRIVATE);
            if (helpMessage.length() > 0 && sharedPref.getBoolean(preference, true)) {
                new AlertDialog.Builder(this)
                        .setTitle(helpTitle)
                        .setMessage(helpMessage)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        })
                        .setCancelable(false)
                        .create().show();
                sharedPref.edit().putBoolean(preference, false).apply();
            }
        }
        else{
            buttonMoodi.setText(getString(R.string.signin_button));
        }
        buttonMoodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuantimodoLoginActivity.this, QuantimodoWebAuthenticatorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_WEB_AUTHENTICATE);
            }
        });
        callbackManager = CallbackManager.Factory.create();
        Button loginButton = (Button) findViewById(R.id.qmt_signin_facebook);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logInWithReadPermissions(QuantimodoLoginActivity.this, Arrays.asList("public_profile"));
            }
        });
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                final String token = loginResult.getAccessToken().getToken();
                Log.d(TAG, "Token: " + token);
                sendFbToken(token);
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "login fb cancel");
            }

            @Override
            public void onError(FacebookException error) {
                Intent intent = new Intent(QuantimodoLoginActivity.this, QuantimodoWebAuthenticatorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_WEB_AUTHENTICATE);
                Log.d(TAG, "login fb error");
                error.printStackTrace();
            }
        });
        if(AccessToken.getCurrentAccessToken() != null && !AccessToken.getCurrentAccessToken().isExpired()){
            Log.d(TAG, "fb accesstoken: " + AccessToken.getCurrentAccessToken().getToken());
//            sendFbToken(AccessToken.getCurrentAccessToken().getToken());
        }

        if (getIntent().hasExtra(KEY_SHOW_LOGIN_AGAIN) && getIntent().getExtras().getBoolean(KEY_SHOW_LOGIN_AGAIN,false)) {
            Toast.makeText(this, R.string.oauth_refresh_failed, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult, request code: " + requestCode);
        if(requestCode == REQUEST_CODE_WEB_AUTHENTICATE){

            if (resultCode == RESULT_OK) {
                //if the web auth went ok there is nothing to do here
                //the user was correctly authenticated
                Toast.makeText(getApplicationContext(), getString(R.string.signin_success), Toast.LENGTH_LONG).show();
                finish();
            }
            else if(resultCode == RESULT_CANCELED){
                Log.e(TAG, "The user canceled or an error occurred while trying to sign in");
                //TODO: Show toast to the user informing about an error
                Toast.makeText(getApplicationContext(), getString(R.string.signin_error), Toast.LENGTH_LONG).show();
            }
        }
        else if (requestCode == REQUEST_CODE_PICK_ACCOUNT) {
            if (resultCode == RESULT_OK) {
                mEmail = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                getAuthToken();
            } else if (resultCode == RESULT_CANCELED) {
                //Do nothing
            }
        } else if ((requestCode == REQUEST_CODE_RECOVER_FROM_AUTH_ERROR ||
                requestCode == REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR)
                && resultCode == RESULT_OK) {
            getAuthToken();
        }
    }

    private void pickUserAccount() {
        Toast.makeText(this, "Choose your account", Toast.LENGTH_SHORT).show();
        String[] accountTypes = new String[]{"com.google"};
        Intent intent = AccountPicker.newChooseAccountIntent(null, null,
                accountTypes, false, null, null, null, null);
        startActivityForResult(intent, REQUEST_CODE_PICK_ACCOUNT);
    }

    /**
     * Attempts to retrieve the username.
     * If the account is not yet known, invoke the picker. Once the account is known,
     * start an instance of the AsyncTask to get the auth token and do work with it.
     */
    private void getAuthToken() {
        if (mEmail == null) {
            pickUserAccount();
        } else {
            if (QtoolsUtils.hasInternetConnection(this)) {
                Toast.makeText(this, "Getting username from Google", Toast.LENGTH_SHORT).show();
                new GetUsernameTask(QuantimodoLoginActivity.this, mEmail, SCOPE, mPrefs).execute();
            } else {
                Toast.makeText(this, "You must have internet connection to proceed", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * This method is a hook for background threads and async tasks that need to
     * provide the user a response UI when an exception occurs.
     */
    public void handleException(final Exception e) {
        // Because this call comes from the AsyncTask, we must ensure that the following
        // code instead executes on the UI thread.
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (e instanceof GooglePlayServicesAvailabilityException) {
                    // The Google Play services APK is old, disabled, or not present.
                    // Show a dialog created by Google Play services that allows
                    // the user to update the APK
                    Log.e(TAG, "GooglePlayServicesAvailabilityException: " + e.getMessage());
                    int statusCode = ((GooglePlayServicesAvailabilityException) e)
                            .getConnectionStatusCode();
                    Dialog dialog = GooglePlayServicesUtil.getErrorDialog(statusCode,
                            QuantimodoLoginActivity.this,
                            REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
                    dialog.show();
                } else if (e instanceof UserRecoverableAuthException) {
                    // Unable to authenticate, such as when the user has not yet granted
                    // the app access to the account, but the user can fix this.
                    // Forward the user to an activity in Google Play services.

                    Log.e(TAG, "UserRecoverableAuthException: " + e.getMessage());
                    Intent intent = ((UserRecoverableAuthException) e).getIntent();
                    startActivityForResult(intent,
                            REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
                }
            }
        });
    }

    private void sendFbToken(final String token){
        Log.d(TAG, "Sending Fb token to QM server...");
        Toast.makeText(this, "Communicating with server", Toast.LENGTH_SHORT).show();
        sendNativeSocialToken("facebook", token);
    }
    public void sendNativeSocialToken(final String provider, final String token){
        if(token == null){
            Log.e(TAG, "Token from " + provider + " is null! Falling back to QuantiModo Login");
            Toast.makeText(this, "Token from " + provider + " is null! Falling back to QuantiModo Login", Toast.LENGTH_SHORT).show();
            return;
//            Intent intent = new Intent(QuantimodoLoginActivity.this, QuantimodoWebAuthenticatorActivity.class);
//            startActivityForResult(intent, REQUEST_CODE_WEB_AUTHENTICATE);
        }
        String url = mPrefs.getApiSocialAuth() + "?provider=" + provider + "&accessToken=" + token + "&client_id=" + authHelper.getClientId();
        Log.d(TAG, "sendNativeSocialToken making request to : " + url);
        Toast.makeText(this, "Communicating with server", Toast.LENGTH_SHORT).show();
        Ion.with(QuantimodoLoginActivity.this)
                .load(url)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject response) {
                        if (response != null){
                            Log.d(TAG, "sendNativeSocialToken response");
                            setAuthTokenFromJson(response);
                        } else {
                            Log.e(TAG, "sendNativeSocialToken response null! exception: " + e.getMessage());
                        }
                    }
                });
    }
    public void setAuthTokenFromJson(final JsonObject result){
        Log.d(TAG, "setAuthTokenFromJson result");
        if(result == null){
            Log.e(TAG, "Error when requesting token from QM Server: result json null!");
            Toast.makeText(this, "Null token response from server!  Please contact mike@quantimo.do", Toast.LENGTH_SHORT).show();
            return;
        } else if(!result.get("success").getAsBoolean()){
            Log.e(TAG, "Error when requesting token from QM Server: " + result.get("error").getAsString());
            Toast.makeText(this, result.get("error").getAsString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuantimodoLoginActivity.this, QuantimodoWebAuthenticatorActivity.class);
            startActivityForResult(intent, REQUEST_CODE_WEB_AUTHENTICATE);
            return;
        }

        Toast.makeText(this, "Authenticated with server", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Result from QM Server as string: " + result.toString());
        try {
            if (result.get("data").getAsJsonObject().get("access_token").getAsString() != null){
                try {
                    String accessToken = result.get("data").getAsJsonObject().get("access_token").getAsString();
                    String refreshToken = result.get("data").getAsJsonObject().get("refresh_token").getAsString();
                    int expiresIn = result.get("data").getAsJsonObject().get("expires_in").getAsInt();
                    authHelper.setAuthToken(new AuthHelper.AuthToken(accessToken, refreshToken, System.currentTimeMillis()/1000 + expiresIn));
                    QuantimodoUser user = quantimodoApiV2.getUser(this, authHelper.getAuthToken()).getData();
                    UserPreferences.setFullUserdata(this, user);
                    setResult(RESULT_OK);
                    finish();
                } catch (NullPointerException ignored) {
                    Log.e(ToolsPrefs.DEBUG_TAG,"Error getting access token: " + result.get("error").getAsString()
                            + ", " + result.get("error_description").getAsString());

                    Toast.makeText(this, result.get("error_description").getAsString(), Toast.LENGTH_SHORT).show();

                }
            } else {
                final String QMToken = result.get("data").getAsJsonObject().get("token").getAsString();
                Intent intent = new Intent(this, QuantimodoWebValidatorActivity.class);
                intent.putExtra(QuantimodoWebValidatorActivity.KEY_AUTH_TOKEN, QMToken);
                startActivityForResult(intent, REQUEST_CODE_WEB_AUTHENTICATE);
            }

//            String refreshToken = result.get("refresh_token").getAsString();
//            int expiresIn = result.get("expires_in").getAsInt();
//            Log.d(TAG, "data from json, accessToken: " + accessToken + ", refreshToken: " + refreshToken + ", expiration: " + expiresIn);
//            authHelper.setAuthToken(new AuthHelper.AuthToken(accessToken, refreshToken, System.currentTimeMillis() / 1000 + expiresIn));
        } catch(NullPointerException e){
            e.printStackTrace();
            Log.e(TAG, "setAuthTokenFromJson: " + e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
