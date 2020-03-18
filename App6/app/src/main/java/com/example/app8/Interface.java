package com.example.app6;

import android.graphics.Color;
import android.os.Build;
import android.widget.*;
import android.util.*;
import android.view.*;
import android.content.*;
import androidx.annotation.RequiresApi;


public class Interface extends GridLayout
{
    private final int size;
    private static EditText[][] box;
    public static int dispId = 0;
    public static int[][] board;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Interface(Context context, int size, int width)
    {
        super(context);

        final int dp = (int)(getResources().getDisplayMetrics().density);

        this.size = 9;
        setRowCount(size+1);
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
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
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
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = width*size;
        params.height = LayoutParams.WRAP_CONTENT;
        params.rowSpec = GridLayout.spec(size,1);
        params.columnSpec = GridLayout.spec(0, size);
        params.topMargin = params.bottomMargin = 1;
        params.leftMargin = params.rightMargin = 1;
        display.setLayoutParams(params);
        addView(display);

    }

    //to clear a board space
    //public static void clear(int x, int y)
    //{
        //Model.setBoard(x,y,0);
        //Log.d("Debugger",box[x][y].getText().toString());
        //box[x][y].getText().clear();
    //}

    //method called from controller to get the handlers attached
    public static void setHandler(int n, int p, MainActivity.TextChangeHandler handler)
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