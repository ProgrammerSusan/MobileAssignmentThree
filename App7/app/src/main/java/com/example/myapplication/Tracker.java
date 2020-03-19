package com.example.myapplication;

import java.util.LinkedList;

public class Tracker {
    private LinkedList<Integer> ids = new LinkedList<Integer>();

    public LinkedList<Integer> getIds(){
        return ids;
    }

    public void addIds(int text, int edit){
        ids.add(text);
        ids.add(edit);
    }

    public void clearTracker(){
        ids.clear();
    }
}
