package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    public static RetirementCalculator retirement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v){
        EditText principal = (EditText)findViewById(R.id.principalInput);
        EditText addition = (EditText)findViewById(R.id.annualInput);
        EditText rate = (EditText)findViewById(R.id.returnInput);
        EditText year = (EditText)findViewById(R.id.yearsInput);
        EditText [] inputs = {principal, addition, rate, year};

        float [] values = new float[4];

        //goes through EditTexts and parses to float
        //sets boolean to prevent retirement calculation on error
        //sets background color to red for incorrect inputs
        boolean valid = true;
        for(int i = 0; i < inputs.length; i++){
            try{
                values[i] = Float.parseFloat(inputs[i].getText().toString());
                inputs[i].setBackgroundColor(Color.parseColor("#E0E4E3"));
            }
            catch(Exception e){
                inputs[i].setBackgroundColor(Color.RED);
                valid = false;
            }
        }
        if(valid){
            float current = values[0];
            float annual = values[1];
            float returnRate = values[2];
            int numYears = (int)values[3];

            retirement = new RetirementCalculator(current, annual, returnRate, numYears);

            Intent secondActivity = new Intent(this, Activity2.class);
            startActivity(secondActivity);
        }
    }
}
