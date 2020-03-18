package com.example.app6;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.graphics.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.*;
import android.widget.*;

import java.lang.*;

public class MainActivity extends AppCompatActivity
{
    private Interface ainterface;
    private Model model;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
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


        setContentView(ainterface);

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
