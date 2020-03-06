package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Activity2 extends AppCompatActivity {
    private Model model = MainActivity.model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        EditText key = (EditText)findViewById(R.id.key);
        key.setText(model.getKey()+"");
    }

    public void save(View v){
        EditText key = (EditText)findViewById(R.id.key);
        int keyValue = Integer.parseInt(key.getText().toString());
        model.set(keyValue, this);

    }

    public void back(View v){
        Intent firstActivity = new Intent(this, MainActivity.class);
        startActivity(firstActivity);
    }

}
