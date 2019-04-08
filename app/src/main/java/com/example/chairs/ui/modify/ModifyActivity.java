package com.example.chairs.ui.modify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chairs.R;

public class ModifyActivity extends AppCompatActivity implements ModifyScreen{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    public void showCityDatas() {

    }

    @Override
    public void saveCityDatas() {

    }

}
