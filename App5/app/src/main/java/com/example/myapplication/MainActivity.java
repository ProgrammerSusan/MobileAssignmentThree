package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    public EditText miles, kilometers, feet, meters, inches, centimeters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void back(View v){
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.milekm) {
            setContentView(R.layout.contentmi);
            EditText miles = (EditText)findViewById(R.id.miles);
            EditText kilometers = (EditText)findViewById(R.id.kilometers);
            miles.addTextChangedListener(new Converter(findViewById(R.id.miles)));
            kilometers.addTextChangedListener(new Converter(findViewById(R.id.kilometers)));
            return true;
        }
        if (id == R.id.feet) {
            setContentView(R.layout.contentft);
            EditText feet = (EditText)findViewById(R.id.feet);
            EditText meters = (EditText)findViewById(R.id.meters);
            feet.addTextChangedListener(new Converter(findViewById(R.id.feet)));
            meters.addTextChangedListener(new Converter(findViewById(R.id.meters)));
            return true;
        }
        if (id == R.id.incm) {
            setContentView(R.layout.contentin);
            EditText inches = (EditText)findViewById(R.id.inches);
            EditText centimeters = (EditText)findViewById(R.id.centimeters);
            inches.addTextChangedListener(new Converter(findViewById(R.id.inches)));
            centimeters.addTextChangedListener(new Converter(findViewById(R.id.centimeters)));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class Converter implements TextWatcher {
        //build textlistener
        //this is so we know caller
        public View view;
        public Converter(View v)
        {
            this.view=v;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(view.getId()== R.id.inches){
                EditText inches = (EditText)findViewById(R.id.inches);
                TextView output = (TextView)findViewById(R.id.inOut);
                double in;
                try {
                    in = Integer.parseInt(inches.getText().toString());
                }
                catch(Exception e){
                    in = 0;
                }
                double cm = in * 2.34;
                output.setText(cm + "");
            }
            else if(view.getId() == R.id.centimeters){
                EditText centimeters = (EditText)findViewById(R.id.centimeters);
                TextView output = (TextView)findViewById(R.id.cmOut);
                double cm;
                try {
                    cm = Integer.parseInt(centimeters.getText().toString());
                }
                catch(Exception e){
                    cm = 0;
                }
                double in = cm / 2.34;
                output.setText(in + "");
            }
            else if(view.getId() == R.id.miles){
                EditText miles = (EditText)findViewById(R.id.miles);
                TextView output = (TextView)findViewById(R.id.miOut);
                double mi;
                try {
                    mi = Integer.parseInt(miles.getText().toString());
                }
                catch(Exception e){
                    mi = 0;
                }
                double km = mi * 0.62137;
                output.setText(km + "");
            }
            else if(view.getId() == R.id.kilometers){
                EditText kilometers = (EditText)findViewById(R.id.kilometers);
                TextView output = (TextView)findViewById(R.id.kmOut);
                double km =  0;
                try {
                    km = Integer.parseInt(kilometers.getText().toString());
                }
                catch(Exception e){
                    km = 0;
                }
                double mi = km / 0.62137;
                output.setText(mi + "");
            }
            else if(view.getId() == R.id.feet){
                EditText feet = (EditText)findViewById(R.id.feet);
                TextView output = (TextView)findViewById(R.id.inOut);
                double ft;
                try {
                    ft = Integer.parseInt(feet.getText().toString());
                }
                catch(Exception e){
                    ft = 0;
                }
                double m = ft * 3.281;
                output.setText(m + "");
            }
            else{
                EditText meters = (EditText)findViewById(R.id.meters);
                TextView output = (TextView)findViewById(R.id.inOut);
                double m;
                try {
                    m = Integer.parseInt(meters.getText().toString());
                }
                catch(Exception e){
                    m = 0;
                }
                double ft = m / 3.281;
                output.setText(ft + "");
            }
        }
    }
}

