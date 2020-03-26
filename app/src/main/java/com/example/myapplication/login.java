package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {
    TextInputEditText E_mail, Pass;
    Button register, login;
    Databasehelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new Databasehelper(this);
        E_mail= (TextInputEditText) findViewById(R.id.email);
        Pass = (TextInputEditText) findViewById(R.id.pass);
        register = (Button)findViewById(R.id.btn_reg);
        login = (Button)findViewById(R.id.btn_log);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String E_mailval = E_mail.getText().toString();
                String Passval = Pass.getText().toString();
                Boolean chckemailnpass = db.emailnpass(E_mailval, Passval);
                if(chckemailnpass==true) {
                    Intent intent = new Intent (com.example.myapplication.login.this, firstpage.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter correct password and mail", Toast.LENGTH_SHORT).show();
                }
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.myapplication.login.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    }

