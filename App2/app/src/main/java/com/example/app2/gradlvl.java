package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class gradlvl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradlvl);
    }


    //navigation method
    public void onClickG(View view)
    {
        if (view.getId() == findViewById(R.id.Next).getId())
        {
            Log.d("grad", "enter next");
            Intent page = new Intent(this, addOns.class);
            startActivity(page);
        }
        else
        {
            finish();
        }
    }

    public void grad(View view)
    {
        RadioButton grad = (RadioButton) view;
        if(grad.isChecked())
            Controller.tracker.grad = true;
        else
            Controller.tracker.grad = false;
        Log.d("addo", "grad: "+Controller.tracker.isGrad());
    }
}
