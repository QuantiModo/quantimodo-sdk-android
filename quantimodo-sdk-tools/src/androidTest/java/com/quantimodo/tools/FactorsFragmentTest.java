package com.quantimodo.tools;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import com.quantimodo.android.sdk.model.Correlation;
import com.quantimodo.tools.adapters.CorrelationAdapter;
import com.quantimodo.tools.fragments.FactorsFragment;
import com.quantimodo.tools.sdk.AuthHelper;
import com.quantimodo.tools.testhelpers.TestMainActivity;
import com.quantimodo.sdk.testing.utils.Utils;
import espresso.QMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class FactorsFragmentTest {

    public static final String CAUSE_NAME = "Exercise";

    @Inject
    AuthHelper mAuthHelper;

    @Rule
    public ActivityTestRule<TestMainActivity> mActivityRule = new ActivityTestRule<>(TestMainActivity.class,true);

    @Rule
    public UiThreadTestRule mUiThreadRule = new UiThreadTestRule();

    private TestMainActivity mActivity;


    @Before
    public void setUp(){
        mActivity = mActivityRule.getActivity();
        if (mAuthHelper == null){
            QTools.getInstance().inject(this);
        }
    }

    @Test
    public void testFactorsLoad() throws Throwable {
        mActivity.openFactors(CorrelationAdapter.POSITIVE, "Overall Mood");
        Thread.sleep(1000);
        Utils.waitForCondition(new Utils.Condition() {
            @Override
            public boolean check() {
                FactorsFragment factorsFragment = mActivity.getFactorsFragment();
                return factorsFragment != null && factorsFragment.getListAdapter() != null && factorsFragment.getListAdapter().getCount() > 0;
            }
        }, 30000);
    }

}
