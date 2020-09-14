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
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Aylik extends AppCompatActivity  {

    private EditText editText;
    private CalendarView calendarView;


    private static final String TAG = "CalendarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aylik);

        //YAPILACAKLAR//
        SharedPreferences prefs = getSharedPreferences("MY_DATA",MODE_PRIVATE);

        String na=prefs.getString("MY_NA","no na");
        String te=prefs.getString("MY_TE","no te");
        String ema=prefs.getString("MY_EMA", "no ema");

        ((TextView)findViewById(R.id.tarih1text)).setText(na);
        ((TextView)findViewById(R.id.tarih2text)).setText(te);
        ((TextView)findViewById(R.id.tarih3text)).setText(ema);

        //TAKVİM//
        calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int i, int i1, int i2) {
                String date= i + "/" + i1 + "/" + i2;
                Log.d(TAG,"onSelectedDateChange: date: "+ date);

            }
        });

    }

    @Override
    //MENU//
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.item1){
            Intent intent=new Intent(Aylik.this,Gunluk.class);
            startActivity(intent);
            return true;
        }
        if(id==R.id.item2){
            Intent intent=new Intent(Aylik.this,Aylik.class);
            startActivity(intent);
        }
        if(id==R.id.item3){
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        if(id==R.id.item4){
            Intent intent=new Intent(Aylik.this,EditDers.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }
    public void showEditT(View view) {
        startActivity(new Intent(getApplicationContext(), editAy.class));
    }

}