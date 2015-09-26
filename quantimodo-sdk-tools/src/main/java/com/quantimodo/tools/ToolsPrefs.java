package com.quantimodo.tools;

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

    private final String mApiUrl;
    private final String mApiScopes;
    private final String mApplicationSource;

    /**
     * @param mApiUrl API url , for example ( https://app.quantimo.do/ )
     * @param mApiScopes OAuth2 scopes, that app would need
     * @param mApplicationSource Application name, used to submit and search data
     */
    public ToolsPrefs(String mApiUrl, String mApiScopes, String mApplicationSource) {
        this.mApiUrl = mApiUrl;
        this.mApiScopes = mApiScopes;
        this.mApplicationSource = mApplicationSource;
    }

    public String getApiScopes() {
        return mApiScopes;
    }

    public String getApiUrl() {
        return mApiUrl;
    }

    public String getApplicationSource() {
        return mApplicationSource;
    }
}
