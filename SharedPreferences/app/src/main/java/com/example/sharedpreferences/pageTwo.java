package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class pageTwo extends AppCompatActivity {

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        display= findViewById(R.id.txtDisplay);

        SharedPreferences sharedPref = getApplication().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String uname= sharedPref.getString("Prefuser", "");

        display.setText(" " + uname);


    }
}