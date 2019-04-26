package com.example.chairs.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chairs.db.DBHelper;
import com.example.chairs.ui.info.InfoActivity;
import com.example.chairs.ui.modify.ModifyActivity;
import com.example.chairs.R;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements MainScreen {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String KEY_CITIES = "KEY_CITIES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DBHelper.getInstance(this);
        feltolt();
    }

    public void feltolt(){
        if(DBHelper.getInstance(this).numberOfRows() == 0) {
            DBHelper.getInstance(this).insertCity(1, "Pécs", "18.23", "46.08", "24", "49", "1017");
            DBHelper.getInstance(this).insertCity(2, "Győr", "17.64", "47.68", "23", "43", "1014");
            DBHelper.getInstance(this).insertCity(3, "Eger", "20.37", "47.90", "22", "78", "1015");
            DBHelper.getInstance(this).insertCity(4, "Miskolc", "20.79", "48.10", "22", "88", "1016");
            DBHelper.getInstance(this).insertCity(5, "Székesfehérvár", "18.41", "47.19", "25", "36", "1015");
            DBHelper.getInstance(this).insertCity(6, "Siófok", "18.05", "46.91", "24", "41", "1013");
            DBHelper.getInstance(this).insertCity(7, "Debrecen", "21.63", "47.53", "26", "38", "1017");
            DBHelper.getInstance(this).insertCity(8, "Szolnok", "20.19", "47.18", "25", "36", "1016");
            DBHelper.getInstance(this).insertCity(9, "Szeged", "20.15", "46.25", "25", "61", "1016");
            DBHelper.getInstance(this).insertCity(10, "Sümeg", "17.28", "46.98", "22", "41", "1013");
            DBHelper.getInstance(this).insertCity(11, "Szombathely", "16.62", "47.23", "21", "41", "1013");
            DBHelper.getInstance(this).insertCity(12, "Budapest", "19.04", "47.50", "25", "36", "1015");
            DBHelper.getInstance(this).insertCity(13, "Teszt", "0.0", "0.0", "10", "10", "1000");
        }
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
            case R.id.searchButton:
                EditText et = (EditText)findViewById(R.id.searchEditText);
                //String city_name = et.getText().toString();

                String res = DBHelper.getInstance(this).getDataString(et.getText().toString());
                if(!res.equals("")) {
                    intent = new Intent(this, InfoActivity.class);
                    intent.putExtra(EXTRA_MESSAGE, res);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Nincs ilyen nevű település a listában!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.infoButton:
                intent = new Intent(this, InfoActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "");
                startActivity(intent);
                break;
            case R.id.modifyButton:
                intent = new Intent(this, ModifyActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "");
                startActivity(intent);
                break;
            case R.id.fab:
                intent = new Intent(this, ModifyActivity.class);
                intent.putExtra(EXTRA_MESSAGE, "");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void showCities(String citiesSearchTerm){
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.putExtra(KEY_CITIES, citiesSearchTerm);
        startActivity(intent);
    }
}
