package com.example.app4;

import android.app.Activity;
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
            Intent nactivity = new Intent(this, north.class);
            Log.d("main", "enter n");
            startActivity(nactivity);
            overridePendingTransition(R.anim.nincoming,R.anim.mnoutgoing);
        }
        else if (v==s)
        {
            Intent sactivity = new Intent(this, south.class);
            Log.d("main", "enter s");
            startActivity(sactivity);
            overridePendingTransition(R.anim.sincoming,R.anim.msoutgoing);
        }
        else if (v==e)
        {
            Intent eactivity = new Intent(this, east.class);
            Log.d("main", "enter e");
            startActivity(eactivity);
            overridePendingTransition(R.anim.eincoming, R.anim.meoutgoing);
        }
        else if (v==w)
        {
            Intent wactivity = new Intent(this, west.class);
            Log.d("main", "enter w");
            startActivity(wactivity);
            overridePendingTransition(R.anim.wincoming, R.anim.mwoutgoing);
        }
        else { }
    }
}
