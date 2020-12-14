package com.example.login;


import android.app.Application;

public class GlobalClass extends Application {
    public static final String BASE_URL = "http://192.168.1.222/api_HadiSewuAyamMobile/api_login/";


    private static GlobalClass singleton;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    public static GlobalClass getInstance() {
        return singleton;
    }
}