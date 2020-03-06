package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    public static Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new Model(this);
        setContentView(R.layout.activity_main);
    }

    public void encrypt(View v){
        EditText message = (EditText)findViewById(R.id.message);
        String msg = message.getText().toString();

        message.setText(model.encrypt(msg));
    }

    public void decrypt(View v){
        EditText message = (EditText)findViewById(R.id.message);
        String msg = message.getText().toString();

        message.setText(model.encrypt(msg));
    }

    public void keyScreen(View v){

    }
}
