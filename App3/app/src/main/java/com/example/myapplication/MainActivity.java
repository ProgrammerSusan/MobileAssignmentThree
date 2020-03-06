package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void encrypt(View v){
        EditText message = (EditText)findViewById(R.id.message);
        String msg = message.getText().toString();
        Model model = new Model();

        message.setText(model.encrypt(msg));
    }

    public void decrypt(View v){
        EditText message = (EditText)findViewById(R.id.message);
        String msg = message.getText().toString();
        Model model = new Model();

        message.setText(model.encrypt(msg));
    }

    public void keyScreen(View v){

    }
}
