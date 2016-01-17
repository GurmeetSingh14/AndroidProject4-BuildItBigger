/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Gurmeet.myapplication.backend;

import com.example.TellJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import sun.rmi.runtime.Log;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.Gurmeet.example.com",
    ownerName = "backend.myapplication.Gurmeet.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        TellJokes tellJokes = new TellJokes();
        String joke = tellJokes.getJoke();
        response.setData("Hi, " + joke);

        return response;
    }

    /** A simple endpoint method that retrieves joke from telljokesjavalibrary */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        TellJokes tellJokes = new TellJokes();
        String joke = tellJokes.getJoke();
        response.setCurrentJoke(joke);

        return response;
    }
}
