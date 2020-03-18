package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class total extends AppCompatActivity {
    private Tracker tracker = MainActivity.tracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
    }

    //pointer navigation method
    public void onClickT(View view) { }
}
