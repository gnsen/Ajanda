package com.example.ajanda2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.prefs.PreferenceChangeEvent;

public class edit extends AppCompatActivity {

    private EditText enInput;
    private EditText onInput;
    private EditText azInput;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        prefs=getSharedPreferences("MY_DATA",MODE_PRIVATE);

        String name=prefs.getString("MY_EN", "");
        String tell=prefs.getString("MY_ON", "");
        String email=prefs.getString("MY_AZ", "");

        enInput=(EditText)findViewById(R.id.enInput);
        onInput=(EditText)findViewById(R.id.onInput);
        azInput=(EditText)findViewById(R.id.azInput);

        enInput.setText(name);
        onInput.setText(tell);
        azInput.setText(email);
    }
    public void saveData(View view){
        String en=enInput.getText().toString();
        String on=onInput.getText().toString();
        String az=azInput.getText().toString();

        SharedPreferences.Editor editor=prefs.edit();
        editor.putString("MY_EN",en);
        editor.putString("MY_ON",on);
        editor.putString("MY_AZ",az);
        editor.apply();

        startActivity(new Intent(getApplicationContext(),Gunluk.class));

    }
    @Override
    //MENU//
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.item1) {
            Intent intent = new Intent(edit.this, Gunluk.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.item2) {
            Intent intent = new Intent(edit.this, Aylik.class);
            startActivity(intent);
        }
        if (id == R.id.item3) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        if (id == R.id.item4) {
            Intent intent = new Intent(edit.this, EditDers.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);

    }
}