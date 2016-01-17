package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.example.gurmeet.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import gurmeet.example.com.telljokesandroidlib.ViewJokesActivity;

/**
 * Created by Gurmeet on 15-01-2016.
 */
public class EndpointsAsyncTask extends AsyncTask<MainActivity, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;
    private static MainActivity mainActivity;

    @Override
    protected String doInBackground(MainActivity... arg) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1192.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            mainActivity = arg[0];
            myApiService = builder.build();

        }

        try {
            return myApiService.getJoke().execute().getCurrentJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        if(mainActivity != null) {
            mainActivity.displayJoke(result);
        }
    }
}
