package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class mainfrag extends Fragment {
    Button loc, appoint;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View mainview = inflater.inflate(R.layout.fragment_mainfrag, container,false);
        loc = (Button) mainview.findViewById(R.id.btn_loc);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), hospitalmap.class);
                getActivity().startActivity(intent);
                //FragmentTransaction fragnew = getFragmentManager().beginTransaction();
                //fragnew.replace(R.id.frag_container, new map());
                //fragnew.commit();

                    }
                });

                appoint = (Button) mainview.findViewById(R.id.btn_app);
                appoint.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentTransaction fragapp = getFragmentManager().beginTransaction();
                        fragapp.replace(R.id.frag_container, new location());
                        fragapp.commit();
                    }
                });
                return mainview;
            }
}