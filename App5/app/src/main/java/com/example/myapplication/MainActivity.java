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
                double in = Integer.parseInt(inches.getText().toString());
                double cm = in * 2.34;
                output.setText(cm + "");
            }
        }
    }
}

