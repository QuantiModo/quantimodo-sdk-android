package io.swagger.client.test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import io.swagger.client.api.OauthApi;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ApiTest {

    @Test
    public void testGetOAuthToken(){
        OauthApi api = new OauthApi();
    }

}
