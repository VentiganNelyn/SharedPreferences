package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView username, password;
    Button save, log;
    String userStr, passStr;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
        save= findViewById(R.id.btnSave);
        log= findViewById(R.id.btnLog);


        sharedPref=getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userStr=username.getText().toString();
                passStr=password.getText().toString();

                if(userStr.isEmpty() || passStr.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter Username and Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences.Editor editor = sharedPref.edit();

                    editor.putString("Prefuser", userStr);
                    editor.putString("Prefpass", passStr);
                    editor.commit();

                    Toast.makeText(getApplicationContext(), "Saved successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userStr=username.getText().toString();
                passStr=password.getText().toString();

                if (userStr.isEmpty() || passStr.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter Username and Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), pageTwo.class);
                    startActivity(intent);
                }
            }
        });

    }
}