package com.example.app4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button n = (Button) findViewById(R.id.North);
    public Button s = (Button) findViewById(R.id.South);
    public Button e = (Button) findViewById(R.id.East);
    public Button w = (Button) findViewById(R.id.West);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v)
    {
        if (v==n)
        {
            //go to north page
        }
        else if (v==s)
        {
            //go to south page
        }
        else if (v==e)
        {
            //go to east page
        }
        else if (v==w)
        {
            //go to west page
        }
        else
        {
            //either error checking or if i can route the back button through here
        }
    }
}
