package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    public void next(View view)
    {
        setContentView(R.layout.activity_gradlvl);

    }

    public void back(View view) {
        setContentView(R.layout.activity_main);
    }
}
