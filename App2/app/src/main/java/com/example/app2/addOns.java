package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.*;
import android.os.Bundle;
import android.widget.*;

public class addOns extends AppCompatActivity {
    private Tracker tracker = MainActivity.tracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ons);
    }

    //navigation method
    public void onClickA(View view)
    {
        if (view.getId() == findViewById(R.id.Next).getId())
        {
            Log.d("add", "enter next");
            Intent page = new Intent(this, total.class);
            startActivity(page);
        }
        else
        {
            finish();

        }
    }

    public void dorm(View view)
    {
        CheckBox dormatory = (CheckBox) view;
        if(dormatory.isChecked())
            Controller.tracker.dorm = true;
        else
            Controller.tracker.dorm = false;
        Log.d("addo", "dorm: "+Controller.tracker.isDorm());
    }


    public void dining(View view)
    {
        CheckBox dining = (CheckBox) view;
        if(dining.isChecked())
            Controller.tracker.dining = true;
        else
            Controller.tracker.dining = false;
        Log.d("addo", "dining: "+Controller.tracker.isDining());
    }
}
