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

public class EditDers extends AppCompatActivity {

    private EditText ptsInput;
    private EditText salInput;
    private EditText carInput;
    private EditText perInput;
    private EditText cuInput;

    private SharedPreferences prefs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ders);


        prefs2 = getSharedPreferences("DERS_KAYIT", MODE_PRIVATE);

        String ptesi = prefs2.getString("PAZARTESI_K", "");
        String sal = prefs2.getString("SALI_K", "");
        String car = prefs2.getString("CARSAMBA_K", "");
        String per = prefs2.getString("PERSEMBE_K", "");
        String cuma = prefs2.getString("CUMA_K", "");

        ptsInput = findViewById(R.id.ptsidersk);
        salInput = findViewById(R.id.sdersk);
        carInput = findViewById(R.id.cdersk);
        perInput = findViewById(R.id.pdersk);
        cuInput = findViewById(R.id.cudersk);

        ptsInput.setText(ptesi);
        salInput.setText(sal);
        carInput.setText(car);
        perInput.setText(per);
        cuInput.setText(cuma);
    }

    public void saveData2(View view) {
        String ptesi = ptsInput.getText().toString();
        String sal = salInput.getText().toString();
        String car = carInput.getText().toString();
        String per = perInput.getText().toString();
        String cuma = cuInput.getText().toString();

        SharedPreferences.Editor editor = prefs2.edit();
        editor.putString("PAZARTESI_K", ptesi);
        editor.putString("SALI_K", sal);
        editor.putString("CARSAMBA_K", car);
        editor.putString("PERSEMBE_K", per);
        editor.putString("CUMA_K", cuma);
        editor.apply();

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
            Intent intent = new Intent(EditDers.this, Gunluk.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.item2) {
            Intent intent = new Intent(EditDers.this, Aylik.class);
            startActivity(intent);
        }
        if (id == R.id.item3) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        if (id == R.id.item4) {
            Intent intent = new Intent(EditDers.this, EditDers.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}