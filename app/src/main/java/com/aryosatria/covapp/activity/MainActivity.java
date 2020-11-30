package com.aryosatria.covapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aryosatria.covapp.ButtonFragment;
import com.aryosatria.covapp.ProfileFragment;
import com.aryosatria.covapp.R;
import com.aryosatria.covapp.fragment.CountryFragment;
import com.aryosatria.covapp.fragment.RingkasanFragment;
import com.aryosatria.covapp.fragment.RiwayatFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Aryo Wahyu Satria on 15/05/2020.
 */

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    boolean doubleBackToExitPressedOnce = false;
    private Fragment pageContent = new ButtonFragment();
    public static final String KEY_FRAGMENT = "fragment";
    TextView tvToday;
    String hariIni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            //Restore the fragment's instance
            pageContent = getSupportFragmentManager().getFragment(savedInstanceState, "myFragmentName");
            ButtonFragment buttonFragment = new ButtonFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.flMain, buttonFragment)
                    .commit();
        }

        if (savedInstanceState == null) {
            RingkasanFragment ringkasanFragment = new RingkasanFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.flMain, ringkasanFragment)
                    .commit();
        }

        tvToday = findViewById(R.id.tvDate);
        Date dateNow = Calendar.getInstance().getTime();
        hariIni = (String) DateFormat.format("EEEE", dateNow);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getToday();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        getSupportFragmentManager().putFragment(outState, KEY_FRAGMENT, pageContent);
//        super.onSaveInstanceState(outState);
//    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String tanggal = (String) DateFormat.format("d MMMM yyyy", date);
        String formatFix = hariIni + ", " + tanggal;
        tvToday.setText(formatFix);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.summaryMenu:
                RingkasanFragment ringkasanFragment = new RingkasanFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, ringkasanFragment)
                        .commit();
                return true;

            case R.id.summaryIdnMenu:
                CountryFragment countryFragment = new CountryFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, countryFragment)
                        .commit();
                return true;

            case R.id.historyMenu:
                RiwayatFragment riwayatFragment = new RiwayatFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, riwayatFragment)
                        .commit();
                return true;

            case R.id.settingMenu:
                ButtonFragment buttonFragment = new ButtonFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, buttonFragment)
                        .commit();
                return true;
        }
        return false;
    }

    void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.lvsetting, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
