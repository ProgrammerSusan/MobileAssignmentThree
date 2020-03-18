package com.example.app6;
import android.util.*;

public class Model
{
    static int[][] board;
    public static int[][] makeboard()
    {
        board = Sudoku.generate();
        return board;
    }

    //get board set
    public static void setBoard(int x, int y, int e)
    {
        board[x][y] = e;
    }

    public static boolean isValid(int x, int y, int e)
    {
        Log.d("Debug","("+x+","+y+")");
        //cannibalized from blackbox code
        //y line
        for (int j = 0; j < 9; j++)
            if (board[x][j] == e)
            {
                Log.d("Debug","already at ("+x+","+j+")");
                return false;
            }
        //x line
        for (int i = 0; i < 9; i++)
            if (board[i][y] == e)
            {
                Log.d("Debug","already at ("+i+","+y+")");
                return false;
            }
//--------local group-------------------------------------------------------------------------------
        if(y==0||y==3||y==6)
        {   //if y on the left of group
            if (x==0 || x==3 || x==6)//SECTION A
            {   //if x on left of group
                Log.d("Debug","SECTION A");
                Log.d("Debug","x bracket is x("+x+","+(x+2)+")");
                Log.d("Debug","y bracket is y("+y+","+(y+2)+")");
                for (int i = x; i < x + 2; x++)
                    for (int j = y; j < y + 2; j++)
                        if (board[i][j] == e)
                        {
                            Log.d("Debug","already at ("+i+","+j+")");
                            return false;
                        }
            }
            else if (x==1 || x==4 || x==7)//SECTION B
            {   //if x middle of group
                Log.d("Debug","SECTION B");
                Log.d("Debug","x bracket is x("+(x-1)+","+(x+1)+")");
                Log.d("Debug","y bracket is y("+(y)+","+(y+2)+")");
                for (int i = x - 1; i < x + 1; i++)
                    for (int j = y; j < y + 2; j++)
                        if (board[i][j] == e)
                        {
                            Log.d("Debug","already at ("+j+","+i+")");
                            return false;
                        }
            }
            else//SECTION C
            {   //if x on right of group
                Log.d("Debug","SECTION C");
                Log.d("Debug","x bracket is x("+(x-2)+","+(x)+")");
                Log.d("Debug","y bracket is y("+(y)+","+(y+2)+")");
                for (int i = x - 2; i < x; i++)
                    for (int j = y; j < y + 2; j++)
                        if (board[i][j] == e)
                        {
                            Log.d("Debug","already at ("+i+","+j+")");
                            return false;
                        }
            }
        }
        else if (y==1 || y==4 || y==7)// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        {   //if y in the middle of of group
            if (x==0 || x==3 || x==6)//SECTION D
            {   //if x on left of group
                Log.d("Debug","SECTION D");
                Log.d("Debug","x bracket is x("+(x)+","+(x+2)+")");
                Log.d("Debug","y bracket is y("+(y-1)+","+(y+1)+")");
                for (int i = x; i < x + 2; i++)
                    for (int j = y-1; j < y+1; j++)
                        if (board[i][j] == e)
                        {
                            Log.d("Debug","already at ("+i+","+j+")");
                            return false;
                        }
            }
            else if (x==1 || x==4 || x==7)//SECTION E
            {   //if x middle of group
                Log.d("Debug","SECTION E");
                Log.d("Debug","x bracket is x("+(x-1)+","+(x+1)+")");
                Log.d("Debug","y bracket is y("+(y-1)+","+(y+1)+")");
                for (int i = x-1; i < x+1; i++)
                    for (int j = y-1; j < y+1; j++)
                        if (board[i][j] == e)
                        {
                            Log.d("Debug","already at ("+i+","+j+")");
                            return false;
                        }
            }
            else//SECTION F
            {   //if x on right of group
                Log.d("Debug","SECTION F");
                Log.d("Debug","x bracket is x("+(x-2)+","+(x)+")");
                Log.d("Debug","y bracket is y("+(y-1)+","+(y+1)+")");
                for (int i = x - 2; i < x; i++)
                    for (int j = y-1; j < y+1; j++)
                        if (board[i][j] == e)
                        {
                            Log.d("Debug","already at ("+i+","+j+")");
                            return false;
                        }
            }
        }
        else if (y==2 || y==5 || y==8)// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        {   //if y in the middle of of group
            if (x==0 || x==3 || x==6)//SECTION G
            {   //if x on left of group
                Log.d("Debug","SECTION G");
                Log.d("Debug","x bracket is x("+(x)+","+(x+2)+")");
                Log.d("Debug","y bracket is y("+(y-2)+","+(y)+")");
                for (int i = x; i < x + 2; i++)
                    for (int j = y-2; j < y; j++)
                        if (board[i][j] == e)
                        {
                            Log.d("Debug","already at ("+i+","+j+")");
                            return false;
                        }
            }
            else if (x==1 || x==4 || x==7)//SECTION H
            {   //if x middle of group
                Log.d("Debug","SECTION H");
                Log.d("Debug","x bracket is x("+(x-1)+","+(x+1)+")");
                Log.d("Debug","y bracket is y("+(y-2)+","+(y)+")");
                for (int i = x - 1; i < x + 1; i++)
                    for (int j = y-2; j < y; j++)
                        if (board[i][j] == e)
                        {
                            Log.d("Debug","already at ("+i+","+j+")");
                            return false;
                        }
            }
            else//SECTION I
            {   //if x on right of group
                Log.d("Debug","SECTION I");
                Log.d("Debug","x bracket is x("+(x-2)+","+(x)+")");
                Log.d("Debug","y bracket is y("+(y-2)+","+(y)+")");
                for (int i = x - 2; i < x; i++)
                    for (int j = y-2; j < y; j++)
                        if (board[i][j] == e)
                        {
                            Log.d("Debug","already at ("+i+","+j+")");
                            return false;
                        }
            }
        }
        return true;
    }
}
