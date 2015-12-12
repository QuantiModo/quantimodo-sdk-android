package com.quantimodo.android.sdk.login;

/**
 * Configuration of toolprefs and quantimodo app
 */
public class ToolsPrefs {

    public static final String DEBUG_TAG = "qm-tools";
    public static final String QUANTIMODO_PREF_KEY = "syncPrefs";
    public static final String PREF_SYNC_FROM = "loadDataFrom";
    public static final String PREF_SYNC_ENABLED = "enableSync";
    public static final String PREF_LAST_SYNC_TIMESTAMP = "lastSuccessfulSync";
    public static final String PREF_SHOW_CORRELATION_CONFIRM = "correlationConfirm";
    public static final String FOOTER = "D_FOOTER";

    private String mApiUrl;
    private String mApiScopes;
    private String mApplicationSource;
    private String mApiSocialAuth;
    private static ToolsPrefs instance = new ToolsPrefs();
    private boolean isInitialized = false;

    public static ToolsPrefs getInstance() {
        return instance;
    }

    /**
     * @param mApiUrl API url , for example ( https://app.quantimo.do/ )
     * @param mApiScopes OAuth2 scopes, that app would need
     * @param mApplicationSource Application name, used to submit and search data
     */
    public void initialize(String mApiUrl, String mApiScopes, String mApplicationSource, String mApiSocialAuth) {
        this.mApiUrl = mApiUrl;
        this.mApiScopes = mApiScopes;
        this.mApplicationSource = mApplicationSource;
        this.mApiSocialAuth = mApiSocialAuth;
    }

    private ToolsPrefs(){

    }

    private void checkInitialized(){
        if(!isInitialized){
            throw new RuntimeException("You need to call ToolsPrefs.initialize() first.");
        }
    }
    public String getApiScopes() {
        checkInitialized();
        return mApiScopes;
    }

    public String getApiUrl() {
        checkInitialized();
        return mApiUrl;
    }

    public String getApiSocialAuth(){
        checkInitialized();
        return mApiSocialAuth;
    }

    public String getApplicationSource() {
        checkInitialized();
        return mApplicationSource;
    }
}
