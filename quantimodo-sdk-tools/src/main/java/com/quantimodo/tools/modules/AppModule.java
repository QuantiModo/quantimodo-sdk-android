package com.quantimodo.tools.modules;

import android.content.Context;
import com.quantimodo.android.sdk.QuantimodoApiV2;
import com.quantimodo.tools.BuildConfig;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.activities.QuantimodoWebAuthenticatorActivity;
import com.quantimodo.tools.sdk.AuthHelper;
import com.quantimodo.tools.sync.SyncService;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module(
        injects = {
                QuantimodoWebAuthenticatorActivity.class,
                SyncService.class,
                AuthHelper.class
        },
        library = true
)
public class AppModule {

    private Context mContext;
    private QuantimodoApiV2 mClient;
    private AuthHelper mAuthHelper;
    private ToolsPrefs mPrefs;

    public AppModule(Context ctx,ToolsPrefs prefs) {
        mContext = ctx.getApplicationContext();
        mPrefs = prefs;
        mAuthHelper = new AuthHelper(mContext,mPrefs);
        mClient = QuantimodoApiV2.getInstance(mPrefs.getApiUrl());
    }


    @Provides
    public ToolsPrefs getPrefs(){
        return mPrefs;
    }

    @Provides
    public Context getCtx(){
        return mContext;
    }

    @Provides
    @Named("authToken")
    public String getToken(){
        return mAuthHelper.getAuthToken();
    }

    @Provides
    public AuthHelper getAuthHelper() {
        return mAuthHelper;
    }

    @Provides
    public QuantimodoApiV2 getClient() {
        return mClient;
    }

}
