package com.example.app2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void next(View view)
    {
        Log.d("main", "enter method");

        int input = view.getId();
        Log.d("main", "input initialized to "+ input);

        int next  = findViewById(R.id.Next).getId();
        Log.d("main", "next initialized to "+ next);

        int next1 = findViewById(R.id.Next1).getId();
        int back1 = findViewById(R.id.Back1).getId();
        int next2 = findViewById(R.id.Next2).getId();
        int back2 = findViewById(R.id.Back2).getId();
        int next3 = findViewById(R.id.Next3).getId();
        int back3 = findViewById(R.id.Back3).getId();
        int back4 = findViewById(R.id.Back4).getId();



        if (input==next)
        {
            setContentView(R.layout.activity_credits);
            Log.d("main", "next to cred");
        }
        else if (input==next1)
        {
            setContentView(R.layout.activity_gradlvl);
            Log.d("main", "next to gradlvl");
        }
        else if (input==back1)
        {
            setContentView(R.layout.activity_main);
            Log.d("main", "back to main");
        }
        else if (input==next2)
        {
            setContentView(R.layout.activity_add_ons);
            Log.d("main", "next to addOns");
        }
        else if (input==back2)
        {
            setContentView(R.layout.activity_credits);
            Log.d("main", "back to credits");
        }
        else if (input==next3)
        {
            setContentView(R.layout.activity_total);
            Log.d("main", "next to total");
        }
        else if (input==back3)
        {
            setContentView(R.layout.activity_gradlvl);
            Log.d("main", "back to gradlvl");
        }
        else if (input==back4)
        {
            setContentView(R.layout.activity_add_ons);
            Log.d("main", "back to addons");
        }
        else
            Log.d("Main", "ErrorPageChoice");

    }

    public void back(View view) { setContentView(R.layout.activity_main); }
}
