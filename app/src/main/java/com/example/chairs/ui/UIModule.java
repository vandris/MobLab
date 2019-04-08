package com.example.chairs.ui;

import android.content.Context;

public class UIModule {

    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    /*@Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }*/

}
