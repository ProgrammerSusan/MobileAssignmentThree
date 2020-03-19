package com.example.myapplication;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.ContactsContract;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private DatabaseManager db;
    public static Tracker t = new Tracker();
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

    public void deleteOptions(RadioGroup radioGroup){
        int dp = (int)(getResources().getDisplayMetrics().density);
        LinkedList<Manager> pass = db.all();
        Clicker click = new Clicker();
        for(int i = 0; i < pass.size(); i++){
            RadioButton rdbtn = new RadioButton(this);
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(pass.get(i).getWebsite());
            rdbtn.setOnClickListener(click);
            radioGroup.addView(rdbtn);
        }
    }

    public void updateFields(LinearLayout l){
        int dp = (int)(getResources().getDisplayMetrics().density);
        LinkedList<Manager> pass = db.all();
        if(t.getIds() != null){
            t.clearTracker();
        }
        for(int i = 0; i < pass.size(); i++){
            TextView place = new TextView(this);
            place.setText(pass.get(i).getWebsite());
            place.setId(TextView.generateViewId());
            int site = place.getId();
            place.setWidth(100 * dp);
            place.setHeight(50 * dp);
            place.setPadding(2,2,2,2);
            place.setBackgroundColor(Color.parseColor("#FFDDFF"));

            EditText update = new EditText(this);
            update.setId(TextView.generateViewId());
            int newPass = update.getId();
            update.setWidth(100 * dp);
            update.setHeight(50 * dp);
            update.setBackgroundColor(Color.parseColor("#DDDDDD"));
            place.setTextSize(10 * dp);
            update.setTextSize(10 * dp);

            t.addIds(site, newPass);

            l.addView(place);
            l.addView(update);
        }
    }

    public void submitUpdate(View v){
        LinkedList<Integer> texts = t.getIds();
        EditText e;
        String change;
        for(int i = 1; i < texts.size(); i += 2){
            e = (EditText)findViewById(texts.get(i));
            change = e.getText().toString();
            if(!change.equals("")){
                TextView t = (TextView)findViewById(texts.get(i-1));
                String website = t.getText().toString();
                db.update(website, change);
            }
        }
    }

    public void back(View v){
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TableLayout passwords =(TableLayout)findViewById(R.id.passwords);
        showPasswords(passwords);
    }

    public void add(View v){
        TextView site = (TextView)findViewById(R.id.site);
        TextView pass = (TextView)findViewById(R.id.newPass);

        try{
            String website = site.getText().toString();
            if(website.equals("")){
                Toast.makeText(this, "Invalid website", Toast.LENGTH_SHORT).show();
            }
            String password = pass.getText().toString();
            if(password.equals("")){
                Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
            }
            Manager m = new Manager(website, password);
            db.insert(m);
        }
        catch (Exception e){
            Toast.makeText(this, "Problem with input", Toast.LENGTH_SHORT).show();
        }
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
            RadioGroup r = (RadioGroup)findViewById(R.id.deleteOptions);
            deleteOptions(r);
            return true;
        }
        else if(id == R.id.update){
            setContentView(R.layout.updatecontent);
            LinearLayout l = (LinearLayout)findViewById(R.id.layout);
            updateFields(l);
            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }
    }
    public class Clicker implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            // get selected radio button from radioGroup
            RadioGroup r = (RadioGroup)findViewById(R.id.deleteOptions);
            int selectedId = r.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            String website = radioButton.getText().toString();
            db.delete(website);
            r.removeAllViews();
            deleteOptions(r);
        }
    }
}

