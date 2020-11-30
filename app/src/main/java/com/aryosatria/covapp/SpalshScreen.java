package com.aryosatria.covapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.aryosatria.covapp.activity.MainActivity;

/**
 * Created by Aryo Wahyu Satria on 15/05/2020.
 */

public class SpalshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spalsh_screen);

        int waktu_loading = 500;
        new Handler().postDelayed(() -> {

            Intent home=new Intent(SpalshScreen.this, MainActivity.class);
            startActivity(home);
            finish();

        }, waktu_loading);
    }
}