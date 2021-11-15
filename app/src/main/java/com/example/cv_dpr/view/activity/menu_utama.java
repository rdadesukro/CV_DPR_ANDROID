package com.example.cv_dpr.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.cv_dpr.R;
import com.example.cv_dpr.adapter.ViewPagerAdapter;
import com.example.cv_dpr.view.fragment.fragment_home;
import com.example.cv_dpr.view.fragment.fragment_setoran;
import com.example.cv_dpr.view.fragment.fragment_uang_jalan;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu_utama extends AppCompatActivity {

    fragment_home home;
    fragment_uang_jalan uang_jalan;
    fragment_setoran setoran;
    ViewPager vg;
    int value;
    MenuItem prevMenuItem;
    BottomNavigationView bottomNavigationView;
    public static BadgeDrawable badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        vg = (ViewPager) findViewById(R.id.vg);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home:
                                vg.setCurrentItem(0);
                                getSupportActionBar().setTitle("HOME");
                                break;
                            case R.id.uang_jalan:
                                vg.setCurrentItem(1);
                                getSupportActionBar().setTitle("UANG JALAN");
                                break;
                            case R.id.setoran:
                                vg.setCurrentItem(2);
                                getSupportActionBar().setTitle("SETORAN");
                                break;
                            case R.id.profil:
                                vg.setCurrentItem(3);
                                getSupportActionBar().setTitle("PROFIL");
                                break;
                        }
                        return false;
                    }
                });

        vg.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                if (position == 0) {
                    getSupportActionBar().setTitle("Home");
                } else if (position == 1) {
                    getSupportActionBar().setTitle("UANG JALAN");
                } else if (position == 2) {
                    getSupportActionBar().setTitle("SETORAN");
                }else {
                    getSupportActionBar().setTitle("Profil");
                }
                Log.d("page", "onPageSelected: " + position);

                Log.i("posisi", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(vg);
        vg.setCurrentItem(0);


    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        home = new fragment_home();
        uang_jalan = new fragment_uang_jalan();
        setoran = new fragment_setoran();




        adapter.addFragment(home);
        adapter.addFragment(uang_jalan);


        viewPager.setAdapter(adapter);
    }
}