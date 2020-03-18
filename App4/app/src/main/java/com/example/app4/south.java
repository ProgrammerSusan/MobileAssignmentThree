package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class south extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south);
    }

    public void click(View V) { }

    public void back(View view)
    {
        Intent mactivity = new Intent(this, MainActivity.class);
        Log.d("nav", "enter m");
        startActivity(mactivity);
        overridePendingTransition(R.anim.mincoming, 0);
    }
}
