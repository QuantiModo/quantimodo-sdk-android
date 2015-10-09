package io.swagger.client.test;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import io.swagger.client.ApiInvoker;
import io.swagger.client.api.MeasurementsApi;
import io.swagger.client.api.OauthApi;
import io.swagger.client.model.Measurement;
import io.swagger.client.model.MeasurementSet;
import io.swagger.client.model.ValueObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ApiTest {

    @Test
    public void testPutMeasurements() throws Exception {
        String token = TestHelper.logIn(InstrumentationRegistry.getContext());
        ApiInvoker apiInvoker = ApiInvoker.getInstance();
        apiInvoker.addDefaultHeader("Authorization", "Bearer " + token);

        //Variable Category : Mood
        //Variable : Overall Mood
        //Unit : /5 ( from 1 to 5 )
        //Source name : Sample application
        MeasurementSet sets = new MeasurementSet();
        sets.setCategory("Mood");
        sets.setName("Overall Mood");
        sets.setUnit("/5");
        sets.setSource("Sample application");
        sets.setCombinationOperation(MeasurementSet.CombinationOperationEnum.MEAN);

        //Measurement with Overall Mood, with 5 out of 5 rating, that submitted right now
        ValueObject measurement = new ValueObject();
        measurement.setTimestamp(System.currentTimeMillis() / 1000);
        measurement.setValue(5.0d);
        measurement.setNote("Measurement from test");

        //Adding measurement into set
        List<ValueObject> measurements = new ArrayList<>();
        measurements.add(measurement);
        sets.setMeasurements(measurements);


        MeasurementsApi api = new MeasurementsApi();
        api.v1MeasurementsPost(sets);
    }

}
