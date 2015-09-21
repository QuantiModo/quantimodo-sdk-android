package com.quantimodo.tools;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.web.sugar.Web;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import com.quantimodo.sdk.testing.utils.Utils;
import com.quantimodo.tools.activities.QuantimodoWebAuthenticatorActivity;
import com.quantimodo.tools.sdk.AuthHelper;
import com.quantimodo.tools.testhelpers.TestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.web.webdriver.DriverAtoms.*;
import static android.support.test.espresso.web.webdriver.Locator.*;

@RunWith(AndroidJUnit4.class)
public class WebAuthActivityTest extends ActivityInstrumentationTestCase2<QuantimodoWebAuthenticatorActivity> {

    @Inject
    AuthHelper mAuthHelper;

    public WebAuthActivityTest() {
        super(QuantimodoWebAuthenticatorActivity.class);
        QTools.getInstance().inject(this);
    }

    @Before
    public void before() throws Exception{
        this.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        Utils.unlockScreen(getActivity(), InstrumentationRegistry.getInstrumentation());

        mAuthHelper.logOut();
    }

    @After
    public void tearDown() throws Exception{
        Utils.closeAllActivities(InstrumentationRegistry.getInstrumentation());
    }


    @Test
    public void testAuthAndGrant() throws Exception{

        Thread.sleep(5000);

        Web.WebInteraction wi = Web.onWebView(withId(R.id.web));

        wi
                .withElement(findElement(ID,"user_login")).perform(webKeys(TestHelper.TEST_USERNAME))
                .withElement(findElement(ID,"user_pass")).perform(webKeys(TestHelper.TEST_PASSWORD))
                .withElement(findElement(ID,"wp-submit")).perform(webClick());

        //Wait sometime until page is loaded
        Thread.sleep(3000);

        String text = wi.withElement(findElement(ID,"request-heading")).perform(getText()).get().toString();
        assertTrue(text.contains("would like to"));
        wi.withElement(findElement(ID,"button-approve")).perform(webClick());

        Thread.sleep(3000);
        assertTrue(mAuthHelper.isLoggedIn());
        assertTrue(getActivity().isFinishing());
    }

}
