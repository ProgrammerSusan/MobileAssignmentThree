package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Activity2 extends AppCompatActivity {
    private RetirementCalculator retirement = MainActivity.retirement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int dp = (int)(getResources().getDisplayMetrics().density);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        TableLayout growth =(TableLayout)findViewById(R.id.growth);
        int [] amount = retirement.calculateRetirement();
        for(int i = 1; i <= amount.length; i++){
            TableRow tr1 = new TableRow(this);
            tr1.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            TextView year = new TextView(this);
            year.setText(i+"  ");
            TextView payment = new TextView(this);
            payment.setText(amount[i-1]+"");
            year.setTextSize(10*dp);
            payment.setTextSize(10*dp);
            tr1.addView(year);
            tr1.addView(payment);
            growth.addView(tr1);
        }
    }

    public void back(View v){
        Intent firstActivity = new Intent(this, MainActivity.class);
        startActivity(firstActivity);
    }
}
