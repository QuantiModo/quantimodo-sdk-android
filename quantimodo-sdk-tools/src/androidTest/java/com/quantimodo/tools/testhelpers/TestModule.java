package com.quantimodo.tools.testhelpers;

import android.content.Context;
import com.quantimodo.android.sdk.QuantimodoApiV2;
import com.quantimodo.tools.FactorsFragmentTest;
import com.quantimodo.tools.TestMainActivityTest;
import com.quantimodo.tools.WebAuthActivityTest;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.activities.QuantimodoWebAuthenticatorActivity;
import com.quantimodo.tools.fragments.ImportWebFragment;
import com.quantimodo.tools.fragments.TrackingFragment;
import com.quantimodo.tools.sdk.AuthHelper;
import com.quantimodo.tools.sdk.request.*;
import dagger.Module;
import dagger.Provides;

import java.util.concurrent.ExecutionException;

@Module(
        injects = {
                QuantimodoWebAuthenticatorActivity.class,
                TestService.class,

                ImportWebFragment.class,
                TrackingFragment.class,

                //Requests
                SearchCorrelationsRequest.class,
                VoteCorrelationRequest.class,
                GetUnitsRequest.class,
                GetCategoriesRequest.class,
                GetSuggestedVariablesRequest.class,
                SendMeasurementsRequest.class,

                //Tests
                TestMainActivityTest.class,
                WebAuthActivityTest.class,
                FactorsFragmentTest.class
        }
)
public class TestModule {

    //Application context
    private Context ctx;
    private String token;
    private QuantimodoApiV2 client;
    private ToolsPrefs mPrefs;
    private AuthHelper mAuthHelper;

    public TestModule(Context applicationContext, ToolsPrefs prefs) throws ExecutionException, InterruptedException {
        ctx = applicationContext;
        client = QuantimodoApiV2.getInstance(prefs.getApiUrl(),null);
        mPrefs = prefs;
        mAuthHelper = new TestAuthHelper(applicationContext,prefs);
        token = "";
    }


    @Provides
    public Context getCtx(){
        return ctx;
    }


    public String getToken(){
        return token;
    }

    @Provides
    public QuantimodoApiV2 getClient(){
        return client;
    }

    @Provides
    public AuthHelper getAuthHelper(){
        return mAuthHelper;
    }

    @Provides
    public ToolsPrefs getToolPrefs(){
        return mPrefs;
    }


}
