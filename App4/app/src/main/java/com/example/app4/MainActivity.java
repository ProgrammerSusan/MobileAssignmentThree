package com.example.app4;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button n, s, e, w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v)
    {
        n = (Button) findViewById(R.id.North);
        s = (Button) findViewById(R.id.South);
        e = (Button) findViewById(R.id.East);
        w = (Button) findViewById(R.id.West);
        Log.d("main", "buttons initialized");

        if (v==n)
        {
            Log.d("main", "enter n");
            setContentView(R.layout.activity_north);
        }
        else if (v==s)
        {
            Log.d("main", "enter s");
            setContentView(R.layout.activity_south);
        }
        else if (v==e)
        {
            Log.d("main", "enter e");
            setContentView(R.layout.activity_east);
        }
        else if (v==w)
        {
            Log.d("main", "enter w");
            setContentView(R.layout.activity_west);
        }
        else
        {
            Log.d("nav", "enter m");
            setContentView(R.layout.activity_main);
        }
    }
}
