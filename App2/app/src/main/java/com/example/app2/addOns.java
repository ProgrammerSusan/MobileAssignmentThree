package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        if(view.isSelected())
            Controller.tracker.dorm = true;
        else
            Controller.tracker.dorm = false;
    }


    public void dining(View view)
    {
        if(view.isSelected())
            Controller.tracker.dining = true;
        else
            Controller.tracker.dining = false;
    }
}
