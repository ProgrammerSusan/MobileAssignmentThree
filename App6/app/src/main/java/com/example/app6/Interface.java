package com.example.app6;

import android.graphics.Color;
import android.os.Build.VERSION_CODES;
import android.widget.*;
import android.util.*;
import android.view.*;
import android.content.*;
import androidx.annotation.*;
import com.example.app6.MainActivity.TextChangeHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Scanner;


public class Interface extends GridLayout
{
    private int size;
    private static EditText[][] box;
    public static int dispId=0, resetid=0, saveid=0, resumeid=0;
    public static int[][] board, ogboard=new int[9][9];
    private onClickListener handler = new onClickListener();
    private static final String fileName = "File.txt";
    File f = new File(fileName);
    private int w;
    private Context cont;

    @RequiresApi(api = VERSION_CODES.JELLY_BEAN_MR1)
    public Interface(Context context, int size, int width) {
        super(context);

        final int dp = (int) (getResources().getDisplayMetrics().density);

        this.size = 9;
        setRowCount(size + 3);
        setColumnCount(size);
        w = width;

        //getting board info from blackbox
        board = Model.makeboard();
        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j<size; j++)
            {
                ogboard[i][j] = board[i][j];
            }
        }
        cont = context;
        buildBoard(board);

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

    public void buildBoard(int[][] board)
    {
        //setup and population of board
        box = new EditText[size][size];
        for(int i = 0; i<size;i++)
        {
            for(int j = 0; j<size; j++)
            {
                box[i][j] = new EditText(cont);
                if(board[i][j]==0) {
                    box[i][j].setBackgroundColor(Color.parseColor("#E0E4E3"));
                }
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
                params.width = w;
                params.height = w;
                params.rowSpec = GridLayout.spec(i,1);
                params.columnSpec = GridLayout.spec(j, 1);
                params.topMargin = params.bottomMargin = 1;
                params.leftMargin = params.rightMargin = 1;
                box[i][j].setLayoutParams(params);
                addView(box[i][j]);

            }
        }
    }

    public void fillboard(int[][] board)
    {
        for (int i =0; i<size; i++) {
            for(int j = 0; j<size;j++) {
                box[i][j].setBackgroundColor(Color.parseColor("#E0E4E3"));
                box[i][j].setText(board[i][j]+"");
            }
        }
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
                board=Model.makeboard();
                buildBoard(board);

            }
            else if (v.getId() == saveid)
            {
                String line="";
                String line2="";
                Log.d("Debugger","save");
                try
                {
                    OutputStreamWriter fout = new OutputStreamWriter(cont.openFileOutput("File.txt", Context.MODE_PRIVATE));
                    for(int i = 0; i<size; i++)
                    {
                        for(int j =0; j<size; j++)
                        {
                            //if(board[i][j]!=null)
                            line = line+board[i][j]+" ";

                            line2= line2+ogboard[i][j]+"";
                        }
                        //line=line+"\n";
                        //line2=line2+"\n";
                    }
                    //line = line+"*";
                    //line2=line2+"*";

                    fout.write(line2);
                    fout.write("\n");
                    fout.write(line);
                    fout.flush();
                    fout.close();
                } catch (IOException e)
                {
                    File f = new File(fileName);
                    e.printStackTrace();
                    TextView disp = findViewById(dispId);
                    disp.setText("Error: could not save");
                }

            }
            else if (v.getId() == resumeid)
            {
                String line="",line2="";
                Log.d("Debugger","resume");
                try
                {
                    File in = new File("File.txt");
                    Scanner file = new Scanner(in);

                    line=line+file.nextLine();
                    Log.d("Debugger","line: "+line);

                    String temp[] = line.split(" ");

                    for (int i = 0; i<size; i++)
                    {
                        for (int j=0; j<size; j++)
                        {
                            board[i][j] = Integer.parseInt(temp[i+j]);
                        }
                    }
                    buildBoard(board);

                    file.nextLine();
                    line=line+file.nextLine();
                    Log.d("Debugger","line2: "+line);
                    temp = line.split(" ");
                    for (int i = 0; i<size; i++)
                    {
                        for (int j=0; j<size; j++)
                        {
                            board[i][j] = Integer.parseInt(temp[i+j]);
                        }
                    }
                    file.close();

                    fillboard(board);

                } catch (Exception e)
                {
                    File f = new File(fileName);
                    e.printStackTrace();
                    TextView disp = findViewById(dispId);
                    disp.setText("Error: could not resume");
                }
            }
        }
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