package com.example.ajanda2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Kayit extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1;
    EditText e2;
    EditText e3;
    Button b1;
    TextView mTextViewLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        db = new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.edittext_username);
        e2=(EditText)findViewById(R.id.edittext_password);
        e3=(EditText)findViewById(R.id.edittext_cnf_password);
        b1=(Button)findViewById(R.id.button_register);
        mTextViewLogin=(TextView)findViewById(R.id.textview_login);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(Kayit.this,MainActivity.class);
                startActivity(LoginIntent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("")||s2.equals("")||s3.equals("")) {
                    Toast.makeText(getApplicationContext(),"Alanlar Boş Bırakılamaz!",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s2.equals(s3)) {
                        Boolean checkad=db.checkad(s1);
                        if (checkad) {

                            Boolean insert=db.insert(s1,s2);

                            if (insert) {
                                Toast.makeText(getApplicationContext(),"Başarılı bir şekilde kayıt olundu.", Toast.LENGTH_SHORT).show();

                                Intent LoginIntent = new Intent(Kayit.this,MainActivity.class);
                                startActivity(LoginIntent);
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Kullanıcı adı zaten mevcut.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Şifreler Eşleşmiyor.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}