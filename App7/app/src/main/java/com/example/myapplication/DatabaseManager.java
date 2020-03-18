package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.LinkedList;

public class DatabaseManager extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "PASSWORDS_DB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "PASSWORDS_TABLE";
    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String command = "CREATE TABLE " + TABLE_NAME + "(" +
                            "WEBSITE text, " +
                            "PASSWORD text)";
        db.execSQL(command);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Manager m){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("WEBSITE", m.getWebsite());
        row.put("PASSWORD", m.getPassword());
    }

    public void delete(String site){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, "NAME = ?", new String[]{site});
        db.close();
    }

    public void update(Manager m){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put("WEBSITE", m.getWebsite());
        row.put("PASSWORD", m.getPassword());
        db.update(TABLE_NAME, row, "WEBSITE = ?", new String[]{m.getWebsite()});
        db.close();
    }

    public LinkedList<Manager> select(String site){
        SQLiteDatabase db = getWritableDatabase();

        LinkedList<Manager> list = new LinkedList<Manager>();

        Cursor cursor = db.query(TABLE_NAME, new String[]{"WEBSITE", "PASSWORD"},
                "WEBSITE = ?", new String[]{site},
                null, null, null);

        while(cursor.moveToNext()){
            String website = cursor.getString(0);
            String password = cursor.getString(1);
            Manager m = new Manager(website, password);
            list.addLast(m);
        }
        cursor.close();
        db.close();

        return list;
    }

    public LinkedList<Manager> all(){
        SQLiteDatabase db = getWritableDatabase();
        LinkedList<Manager> list = new LinkedList<Manager>();
        Cursor cursor = db.query(TABLE_NAME, new String[]{"WEBSITE", "PASSWORD"},
                        null, null, null, null, null, null);
        while(cursor.moveToNext()){
            String website = cursor.getString(0);
            String password = cursor.getString(1);
            Manager m = new Manager(website, password);
            list.addLast(m);
        }
        cursor.close();
        db.close();

        return list;
    }
}