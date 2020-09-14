package com.example.ajanda2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class editAy extends AppCompatActivity {

    private EditText naInput;
    private EditText teInput;
    private EditText emaInput;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ay);

        prefs=getSharedPreferences("MY_DATA",MODE_PRIVATE);

        String na=prefs.getString("MY_NA","");
        String te=prefs.getString("MY_TE","");
        String ema=prefs.getString("MY_EMA","");

        naInput = (EditText)findViewById(R.id.tarih1Input);
        teInput = (EditText)findViewById(R.id.tarih2Input);
        emaInput = (EditText)findViewById(R.id.tarih3Input);

        naInput.setText(na);
        teInput.setText(te);
        emaInput.setText(ema);

    }
    public void SaveData(View view) {
        String na= naInput.getText().toString();
        String te= teInput.getText().toString();
        String ema= emaInput.getText().toString();

        SharedPreferences.Editor editor=prefs.edit();
        editor.putString("MY_NA", na);
        editor.putString("MY_TE", te);
        editor.putString("MY_EMA", ema);
        editor.apply();

        startActivity(new Intent(getApplicationContext(),Aylik.class));
    }
}