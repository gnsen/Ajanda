package com.example.ajanda2;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Gunluk extends AppCompatActivity {

    TextView month, day, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunluk);

        //YAPILACAKLAR//

        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Gunluk.this,edit.class));
            }
        });

        SharedPreferences prefs=getSharedPreferences("MY_DATA",MODE_PRIVATE);

        String en=prefs.getString("MY_EN", "no en");
        String on=prefs.getString("MY_ON", "no on");
        String az=prefs.getString("MY_AZ", "no az");

        ((TextView)findViewById(R.id.enon)).setText(en);
        ((TextView)findViewById(R.id.on)).setText(on);
        ((TextView)findViewById(R.id.azon)).setText(az);

        //TARİH//
        month = findViewById(R.id.month);
        day = findViewById(R.id.day);
        year = findViewById(R.id.year);

        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);

        String[] splitDate = formattedDate.split(",");

        Log.d("mayLog", currentTime.toString());
        Log.d("mayLog", formattedDate);

        day.setText(splitDate[0]);
        month.setText(splitDate[1]);
        year.setText(splitDate[2]);
        Log.d("myLog", splitDate[0].trim());
        Log.d("myLog", splitDate[1].trim());
        Log.d("myLog", splitDate[2].trim());

        //BASLIK//
        this.setTitle("Öğrenci Ajandası");

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
            Intent intent = new Intent(Gunluk.this, Gunluk.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.item2) {
            Intent intent = new Intent(Gunluk.this, Aylik.class);
            startActivity(intent);
        }
        if (id == R.id.item3) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        if (id == R.id.item4) {
            Intent intent = new Intent(Gunluk.this, EditDers.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);

    }
    public void showEdit() {
        startActivity(new Intent(getApplicationContext(), edit.class));

    }

}


