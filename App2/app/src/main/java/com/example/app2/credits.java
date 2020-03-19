package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class credits extends AppCompatActivity
{
	public static Tracker tracker = MainActivity.tracker;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        textChangedHandler handler = new textChangedHandler();
        EditText cred = (EditText) findViewById(R.id.credits);
        //cred.addTextChangedListener(handler);
        setContentView(R.layout.activity_credits);
    }

    public class textChangedHandler implements TextWatcher
    {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }

        @Override
        public void afterTextChanged(Editable s)
        {
            String input = s.toString();
            Controller.tracker.setCredits(Integer.parseInt(input));
            Log.d("cred", Controller.tracker.getCredits()+"");
        }
    }

    //navigation method
    public void onClickC(View view)
    {
        if (view.getId() == findViewById(R.id.Next).getId())
        {
            EditText input = findViewById(R.id.credits);
            Controller.tracker.setCredits(Integer.parseInt(input.getText().toString()));
            Log.d("cred", Controller.tracker.getCredits()+"");
            Intent page = new Intent(this, gradlvl.class);
            startActivity(page);
            Log.d("cred", "enter next");
        }
        else
        {
            finish();
        }
    }

}
