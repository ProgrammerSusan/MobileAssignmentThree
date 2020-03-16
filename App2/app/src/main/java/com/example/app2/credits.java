package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

public class credits extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        textChangedHandler handler = new textChangedHandler();
        EditText cred = (EditText) findViewById(R.id.credits);
        cred.addTextChangedListener(handler);
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


    //pointer navigation method
    public void onClickC(View view) { }

}
