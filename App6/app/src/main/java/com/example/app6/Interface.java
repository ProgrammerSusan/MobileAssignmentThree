package com.example.app6;

import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.widget.*;
import android.util.*;
import android.view.*;
import android.content.*;
import android.widget.GridLayout.LayoutParams;

import androidx.annotation.RequiresApi;

import com.example.app6.MainActivity.TextChangeHandler;
import com.example.app6.MainActivity.onClickListener;


public class Interface extends GridLayout
{
    private int size;
    private static EditText[][] box;
    public static int dispId=0, resetid=0, saveid=0, resumeid=0;
    public static int[][] board;
    public onClickListener handler = new onClickListener();


    @RequiresApi(api = VERSION_CODES.JELLY_BEAN_MR1)
    public Interface(Context context, int size, int width)
    {
        super(context);

        final int dp = (int)(getResources().getDisplayMetrics().density);

        this.size = 9;
        setRowCount(size+3);
        setColumnCount(size);

        //getting board info from blackbox
        board = Model.makeboard();

        //setup and population of board
        box = new EditText[size][size];
        for(int i = 0; i<size;i++)
        {
            for(int j = 0; j<size; j++)
            {
                box[i][j] = new EditText(context);
                if(board[i][j]==0)
                    box[i][j].setBackgroundColor(Color.parseColor("#E0E4E3"));
                else
                {
                    box[i][j].setBackgroundColor(Color.parseColor("#AEC4C0"));
                    box[i][j].setText(board[i][j]+"");
                    box[i][j].setEnabled(false);
                }
                box[i][j].setTextColor(Color.parseColor("#000000"));
                box[i][j].setTextSize((int)(size*2));
                box[i][j].setGravity(Gravity.CENTER);
                LayoutParams params = new LayoutParams();
                params.width = width;
                params.height = width;
                params.rowSpec = GridLayout.spec(i,1);
                params.columnSpec = GridLayout.spec(j, 1);
                params.topMargin = params.bottomMargin = 1;
                params.leftMargin = params.rightMargin = 1;
                box[i][j].setLayoutParams(params);
                addView(box[i][j]);
            }
        }

        TextView display = new TextView(context);
        display.setId(TextView.generateViewId());
        dispId = display.getId();
        display.setTextColor(Color.parseColor("#000000"));
        display.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        display.setPadding(15*dp, 15*dp, 15*dp, 15*dp);
        display.setBackgroundColor(Color.parseColor("#B5AEC4"));
        LayoutParams params = new LayoutParams();
        params.width = width*size;
        params.height = LayoutParams.WRAP_CONTENT;
        params.rowSpec = GridLayout.spec(size,1);
        params.columnSpec = GridLayout.spec(0, size);
        params.topMargin = params.bottomMargin = 1;
        params.leftMargin = params.rightMargin = 1;
        display.setLayoutParams(params);
        addView(display);

        Button reset = new Button(context);
        reset.setId(Button.generateViewId());
        resetid = reset.getId();
        reset.setTextColor(Color.parseColor("#000000"));
        reset.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        reset.setPadding(15*dp, 15*dp, 15*dp, 15*dp);
        reset.setBackgroundColor(Color.parseColor("#B5AEC4"));
        reset.setText("New Board");
        params = new LayoutParams();
        params.width = width*(size/3);
        params.rowSpec = GridLayout.spec(size+1,1);
        params.columnSpec = GridLayout.spec(0,3);
        params.topMargin = params.bottomMargin = 1;
        params.leftMargin = params.rightMargin = 1;
        reset.setLayoutParams(params);
        reset.setOnClickListener(handler);
        addView(reset);

        Button save = new Button(context);
        save.setId(Button.generateViewId());
        saveid = save.getId();
        save.setTextColor(Color.parseColor("#000000"));
        save.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        save.setPadding(15*dp, 15*dp, 15*dp, 15*dp);
        save.setBackgroundColor(Color.parseColor("#B5AEC4"));
        save.setText("Save");
        params = new LayoutParams();
        params.width = width*(size/3);
        params.rowSpec = GridLayout.spec(size+1,1);
        params.columnSpec = GridLayout.spec(3,3);
        params.topMargin = params.bottomMargin = 1;
        params.leftMargin = params.rightMargin = 1;
        save.setLayoutParams(params);
        save.setOnClickListener(handler);
        addView(save);

        Button resume = new Button(context);
        resume.setId(Button.generateViewId());
        resumeid = resume.getId();
        resume.setTextColor(Color.parseColor("#000000"));
        resume.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        resume.setPadding(15*dp, 15*dp, 15*dp, 15*dp);
        resume.setBackgroundColor(Color.parseColor("#B5AEC4"));
        resume.setText("Resume");
        params = new LayoutParams();
        params.width = width*(size/3);
        params.rowSpec = GridLayout.spec(size+1,1);
        params.columnSpec = GridLayout.spec(6,3);
        params.topMargin = params.bottomMargin = 1;
        params.leftMargin = params.rightMargin = 1;
        resume.setLayoutParams(params);
        resume.setOnClickListener(handler);
        addView(resume);

    }

    //method called from controller to get the handlers attached
    public static void setHandler(int n, int p, TextChangeHandler handler)
    {
        //Log.d("Debugger","X is "+ n);
        //Log.d("Debugger","Y is "+ p);
        //Log.d("Debugger",""+box[n][p].getText().toString());
        box[n][p].addTextChangedListener(handler);
    }

    //to see if the game is won
    public static boolean isSolved()
    {
        boolean solved = true;
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                if (board[i][j] == 0)
                {
                    solved = false;
                    break;
                }
            }
        }
        return solved;
    }
}