package com.example.app2;

public class Tracker
{

    int credits;
    boolean grad;
    boolean dorm;
    boolean dining;
    int totalCost;
    int nextScreen;
    int lastScreen;

    public Tracker()
    {
        credits = 0;
        grad=false;
        dorm=false;
        dining=false;
        totalCost=0;
        nextScreen=0;
        lastScreen=0;
    }

    public void setNext(int n)
    {
        nextScreen = n;
    }
    public void setLast(int n)
    {
        lastScreen = n;
    }
}
