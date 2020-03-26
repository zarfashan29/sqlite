package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frag_container, new mainfrag());
        fragmentTransaction.commit();
        //mainfrag main_frag = new mainfrag();
        //getSupportFragmentManager().beginTransaction().add(R.id.frag_container, main_frag).commit();
    }
}
