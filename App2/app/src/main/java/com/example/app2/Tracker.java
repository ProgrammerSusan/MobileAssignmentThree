package com.example.app2;

public class Tracker
{

    int credits;
    boolean grad;
    boolean dorm;
    boolean dining;
    int totalCost;

    public Tracker()
    {
        credits = 0;
        grad=false;
        dorm=false;
        dining=false;
        totalCost=0;
    }

    public void setCredits(int n) { credits = n; }
    public int getCredits()
    {
        return credits;
    }

    public boolean isGrad() {return grad;}

    public boolean isDorm() {return dorm;}

    public boolean isDining() {return dining;}

    public int getTotalCost()
    {
        int runningtotal=0;

        if(grad)
            runningtotal=400*credits;
        else
            runningtotal=300*credits;

        if(dorm)
            runningtotal=runningtotal+1000;

        if(dining)
            runningtotal=runningtotal+500;

        totalCost=runningtotal;
        return runningtotal;
    }
}
