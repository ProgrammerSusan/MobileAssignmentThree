package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {
    private RetirementCalculator retirement = MainActivity.retirement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
    }

    public void back(View v){
        Intent firstActivity = new Intent(this, MainActivity.class);
        startActivity(firstActivity);
    }
}
