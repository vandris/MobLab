package com.example.chairs;

import android.app.Application;

public class WeatherDemoApplication extends Application {

    public static WeatherDemoApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        /*injector =
                DaggerWeatherDemoApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();*/
    }

}
