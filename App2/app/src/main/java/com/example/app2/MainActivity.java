package com.example.app2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static Tracker tracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    //navigation methods
    public void onClick(View view)
    {
        Log.d("main", "enter next");

        if (view.getId() == findViewById(R.id.Next).getId()) {
            Intent page = new Intent(this, credits.class);
            startActivity(page);
            Controller.tracker.setLast(R.layout.activity_main);
            Controller.tracker.setNext(R.layout.activity_credits);
            setContentView(Controller.tracker.nextScreen);
        }
    }
    public void onClickC(View view)
    {
        if (view.getId() == findViewById(R.id.Next).getId())
        {
            Intent page = new Intent(this, credits.class);
            startActivity(page);
            Log.d("cred", "enter next");

            Controller.tracker.setLast(R.layout.activity_credits);
            Controller.tracker.setNext(R.layout.activity_gradlvl);
            setContentView(Controller.tracker.nextScreen);

        }
        else
        {
            Log.d("cred", "enter back");
            Intent page = new Intent(this, MainActivity.class);
            startActivity(page);
            Controller.tracker.setLast(R.layout.activity_main);
            Controller.tracker.setNext(R.layout.activity_main);
            setContentView(Controller.tracker.lastScreen);

        }
    }
    public void onClickG(View view)
    {
        if (view.getId() == findViewById(R.id.Next).getId())
        {
            Log.d("grad", "enter next");
            Intent page = new Intent(this, addOns.class);
            startActivity(page);
            Controller.tracker.setLast(R.layout.activity_gradlvl);
            Controller.tracker.setNext(R.layout.activity_add_ons);
            setContentView(Controller.tracker.nextScreen);
        }
        else
        {
            Log.d("grad", "enter back");
            Intent page = new Intent(this, credits.class);
            startActivity(page);
            Controller.tracker.setLast(R.layout.activity_credits);
            Controller.tracker.setNext(R.layout.activity_gradlvl);
            setContentView(Controller.tracker.lastScreen);


        }
    }
    public void onClickA(View view)
    {
        if (view.getId() == findViewById(R.id.Next).getId())
        {
            Log.d("add", "enter next");
            Intent page = new Intent(this, total.class);
            startActivity(page);
            Controller.tracker.setLast(R.layout.activity_add_ons);
            Controller.tracker.setNext(R.layout.activity_total);
            setContentView(Controller.tracker.nextScreen);
        }
        else
        {
            Log.d("add", "enter back");
            Intent page = new Intent(this, gradlvl.class);
            startActivity(page);
            Controller.tracker.setLast(R.layout.activity_gradlvl);
            Controller.tracker.setNext(R.layout.activity_add_ons);
            setContentView(Controller.tracker.lastScreen);

        }
    }
    public void onClickT(View view)
    {
        Log.d("tot", "enter back");
        Intent page = new Intent(this, addOns.class);
        startActivity(page);
        Controller.tracker.setLast(R.layout.activity_add_ons);
        Controller.tracker.setNext(R.layout.activity_total);
        setContentView(Controller.tracker.lastScreen);
    }
}
