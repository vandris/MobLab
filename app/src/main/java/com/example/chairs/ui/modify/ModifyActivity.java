package com.example.chairs.ui.modify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chairs.R;
import com.example.chairs.db.DBHelper;
import com.example.chairs.ui.info.InfoActivity;
import com.example.chairs.ui.main.MainActivity;

import java.util.ArrayList;

public class ModifyActivity extends AppCompatActivity implements ModifyScreen{

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    String message;
    int id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        showCityDatas();
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    public void sendButton(View view){
        Intent intent;
        switch(view.getId()) {
            case R.id.saveButton:
                saveCityDatas();
                intent = new Intent(this, MainActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void showCityDatas() {
        String[] str = message.split(";");

        EditText cityEt = (EditText)findViewById(R.id.cityinfoEditText);
        EditText coordEt = (EditText) findViewById(R.id.coordinfoEditText);
        EditText tempEt = (EditText) findViewById(R.id.tempinfoEditText);
        EditText humEt = (EditText) findViewById(R.id.humidinfoEditText);
        EditText pressureEt = (EditText) findViewById(R.id.pressureinfoEditText);

        if(str.length == 7){
            id = Integer.parseInt(str[0]);
            cityEt.setText(str[1]);
            coordEt.setText("N " +  str[2] + ", E " + str[3]);
            tempEt.setText(str[4] + " °C");
            humEt.setText(str[5] + " %");
            pressureEt.setText(str[6] + " hPa");
        }
    }

    @Override
    public void saveCityDatas() {
        EditText cityEt = (EditText)findViewById(R.id.cityinfoEditText);
        EditText coordEt = (EditText) findViewById(R.id.coordinfoEditText);
        EditText tempEt = (EditText) findViewById(R.id.tempinfoEditText);
        EditText humEt = (EditText) findViewById(R.id.humidinfoEditText);
        EditText pressureEt = (EditText) findViewById(R.id.pressureinfoEditText);

        String[] str = coordEt.getText().toString().split(",");
        str[0] = str[0].replace("N", "");
        str[0] = str[0].replace(" ", "");
        str[0] = str[0].replace(",", "");
        str[1] = str[1].replace("E", "");
        str[1] = str[1].replace(" ", "");

        if (id == -1)
            DBHelper.getInstance(this).insertCity(DBHelper.getInstance(this).maxID() + 1, cityEt.getText().toString(), str[0], str[1], tempEt.getText().toString().replace(" °C", ""), humEt.getText().toString().replace(" %", ""), pressureEt.getText().toString().replace(" hPa", ""));
        else
            DBHelper.getInstance(this).updateCity(id, cityEt.getText().toString(), str[0], str[1], tempEt.getText().toString().replace(" °C", ""), humEt.getText().toString().replace(" %", ""), pressureEt.getText().toString().replace(" hPa", ""));
    }

}
