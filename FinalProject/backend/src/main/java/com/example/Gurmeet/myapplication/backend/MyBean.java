package com.example.Gurmeet.myapplication.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;
    private String mCurrentJoke;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    public String getCurrentJoke() {
        return mCurrentJoke;
    }

    public void setCurrentJoke(String joke){
        mCurrentJoke = joke;
    }


}