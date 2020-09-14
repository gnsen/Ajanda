package com.example.ajanda2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.edittext_username);
        e2=(EditText)findViewById(R.id.edittext_password);
        mButtonLogin=(Button)findViewById(R.id.button_login);
        mTextViewRegister=(TextView)findViewById(R.id.textview_register);

        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, Kayit.class);
                startActivity(registerIntent);
            }
        });
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kad=e1.getText().toString();
                String password=e2.getText().toString();
                Boolean checkadpass=db.kadpassword(kad,password);
                if (checkadpass==true) {
                    Toast.makeText(getApplicationContext(),"Başarılı bir şekilde giriş yapıldı.", Toast.LENGTH_SHORT).show();

                    Intent registerIntent = new Intent(MainActivity.this, Gunluk.class);
                    startActivity(registerIntent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Kullanıcı adı ya da şifre yanlış.",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
    