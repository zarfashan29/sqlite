package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText E_mail, Pass, Cpass;
    Databasehelper db;
    RadioGroup P_erson;
    Button register1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Databasehelper(this);
        E_mail = (TextInputEditText) findViewById(R.id.email);
        Pass = (TextInputEditText) findViewById(R.id.pass);
        Cpass = (TextInputEditText) findViewById(R.id.cpass);
        P_erson = (RadioGroup) findViewById(R.id.person);
        register1 = (Button) findViewById(R.id.btn_reg1);
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String E_mailval = E_mail.getText().toString();
                String Passval = Pass.getText().toString();
                String Cpassval = Cpass.getText().toString();
               // RadioButton checkbtn = findViewById(P_erson.getCheckedRadioButtonId());
                //String P_sersonval = checkbtn.getText().toString();
                if (E_mailval.equals("") || Passval.equals("") || Cpassval.equals("")) {
                    Toast.makeText(getApplicationContext(), "please fill the feilds", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Passval.equals(Cpassval)) {
                        Boolean chckemail = db.chckemail(E_mailval);
                        if(chckemail==true) {
                            Boolean insert = db.insert(E_mailval, Passval);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registration done", Toast.LENGTH_SHORT).show();
                            }
                        }
                            else {
                                Toast.makeText(getApplicationContext(), "Email in use", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Password did'nt recognized ", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

        });
    }
}
