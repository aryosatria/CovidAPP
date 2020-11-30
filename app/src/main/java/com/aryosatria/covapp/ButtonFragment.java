package com.aryosatria.covapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Aryo Wahyu Satria on 15/05/2020.
 */

public class ButtonFragment extends Fragment {

    ListView lvsetting;

    public ButtonFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_button, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvsetting = view.findViewById(R.id.lvsetting);
        lvsetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                        startActivity(mIntent);
                        break;
                    case 1:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.flMain, profileFragment)
                            .commit();
                        break;
                }
            }
        });
    }
}