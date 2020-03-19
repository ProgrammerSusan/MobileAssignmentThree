package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class total extends AppCompatActivity {
    private Tracker tracker = Controller.tracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        TextView total = findViewById(R.id.sum);
        Log.d("tracker", "cred: "+tracker.getCredits());
        Log.d("tracker", "grad: "+tracker.isGrad());
        Log.d("tracker", "ding: "+tracker.isDining());
        Log.d("tracker", "dorm: "+tracker.isDorm());
        Log.d("tracker", "totl: "+tracker.getTotalCost());
        total.setText(tracker.getTotalCost()+"");
    }

    //navigation method
    public void onClickT(View view)
    {
        finish();
    }
}
