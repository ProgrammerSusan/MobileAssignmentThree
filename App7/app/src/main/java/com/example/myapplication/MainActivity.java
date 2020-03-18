package com.example.myapplication;

import android.app.ActionBar;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.ContactsContract;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private DatabaseManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DatabaseManager(this);
        TableLayout passwords =(TableLayout)findViewById(R.id.passwords);
        showPasswords(passwords);
    }

    public void showPasswords(TableLayout passwords){
        int dp = (int)(getResources().getDisplayMetrics().density);
        LinkedList<Manager> pass = db.all();
        for(int i = 0; i < pass.size(); i++){
            TableRow tr1 = new TableRow(this);
            tr1.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            TextView year = new TextView(this);
            year.setText(pass.get(i).getWebsite());
            TextView payment = new TextView(this);
            payment.setText(pass.get(i).getPassword());
            year.setTextSize(10*dp);
            payment.setTextSize(10*dp);
            tr1.addView(year);
            tr1.addView(payment);
            passwords.addView(tr1);
        }
    }

    public void back(View v){
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add) {
            setContentView(R.layout.addcontent);
            return true;
        }
        else if (id == R.id.delete) {
            setContentView(R.layout.deletecontent);
            return true;
        }
        else if(id == R.id.update){
            setContentView(R.layout.updatecontent);
            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }


    }
}
