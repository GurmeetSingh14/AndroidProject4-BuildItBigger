package com.udacity.gradle.builditbigger;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;
import android.widget.Button;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Gurmeet on 16-01-2016.
 */

public class TellJokesTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity testMainActivity;
    private EndpointsAsyncTask testEndpointsAsyncTask;

    public TellJokesTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        testMainActivity = getActivity();
        testEndpointsAsyncTask = new EndpointsAsyncTask();
    }
    @MediumTest
    public void testGetJoke(){

        testEndpointsAsyncTask.execute(testMainActivity);
        try {
            String joke = testEndpointsAsyncTask.get(60, TimeUnit.SECONDS);
            Log.v("GS_LOG_TAG", joke);
            assertEquals("This is a Joke.", joke);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        //assertEquals();
    }
}
