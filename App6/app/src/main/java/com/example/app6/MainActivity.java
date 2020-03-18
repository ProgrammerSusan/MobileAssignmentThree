package com.example.app6;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.*;
import static com.example.app6.Interface.resetid;
import static com.example.app6.Interface.resumeid;
import static com.example.app6.Interface.saveid;

public class MainActivity extends AppCompatActivity
{
    private Interface ainterface;
    private Model model;
    private static final String fileName = "boardFile";

    @RequiresApi(api = VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        model = new Model();
        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);

        int width = screenSize.x/9;
        ainterface = new Interface(this, 9, width);

        //dispersing all 81 listeners
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                TextChangeHandler temp = new TextChangeHandler(i, j);
                Interface.setHandler(i, j, temp);
            }
        }

        onClickListener handler = new onClickListener();


        setContentView(ainterface);

    }

    public class onClickListener implements OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Log.d("Debugger","view: "+v.getId());
            if (v.getId() == resetid)
            {
                Log.d("Debugger","reset");

            }
            else if (v.getId() == saveid)
            {
                Log.d("Debugger","save");
                try
                {
                    FileOutputStream fout = openFileOutput(fileName, Context.MODE_PRIVATE);
                } catch (FileNotFoundException e) { e.printStackTrace(); }

            }
            else if (v.getId() == resumeid)
            {
                Log.d("Debugger","resume");

            }
        }
    }

    public class TextChangeHandler implements TextWatcher
    {
        //build textlistener
        //this is so we know the location
        public int x,y;
        public TextChangeHandler(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        //these two classes are here because they have to be
        public void beforeTextChanged(CharSequence c, int i, int j, int k){}
        public void onTextChanged(CharSequence c, int i, int j, int k){}

        //what we're really interested in; the stuff handler
        public void afterTextChanged(Editable e)
        {
            int xcoord = x;
            int ycoord = y;
            String in = e.toString();
            int input;

            //error handling
            try
            {
                input = Integer.parseInt(in);
            }
            catch (NumberFormatException p)
            {
                input = 0;
                Log.d("Debugger",p+"");
            }

            //Log.d("Debugger",in);
            //Log.d("Debugger",input+"");
            if (in=="")
                Model.setBoard(x, y, 0);
            else if (input>9)
                e.clear();
            else if (input == 0)
            {
                e.clear();
                Model.setBoard(x, y, 0);
            }
            else if(Model.isValid(x,y,input))
                Model.setBoard(x, y, input);
            else
            {
                Model.setBoard(x, y, 0);
                e.clear();
            }

            //check if solved
            if(Interface.isSolved())
            {
                int ID = Interface.dispId;
                TextView output = (TextView) findViewById(ID);
                output.setText("You've Won!");
            }
        }
    }
}
