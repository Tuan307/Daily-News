package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private TabItem mhome,mscience,msport,mhealth,mtechno,mentertain;
    private PagerAdapter pagerAdapter;

    private String api = "46cc9d3f8a6d4497a19985680c6912a4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarmain);
        tabLayout = findViewById(R.id.include);
        mhealth = findViewById(R.id.helth);
        mhome = findViewById(R.id.home);
        mscience = findViewById(R.id.science);
        msport = findViewById(R.id.sports);
        mentertain = findViewById(R.id.entertainment);
        mtechno = findViewById(R.id.technology);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0
                || tab.getPosition() == 1|| tab.getPosition() == 2 || tab.getPosition() == 3
                || tab.getPosition() == 4 || tab.getPosition() ==5)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}