package com.example.bms.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentActivity extends AppCompatActivity implements ActionBar.TabListener  {

    private ActionBar actionBar;
    private ViewPager viewPager;
    private TabsAdapter mAdapter;
    private String[] tabs = {"hi","hello ","hola"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        }
        viewPager = findViewById(R.id.pager);
        mAdapter  = new TabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for(String tab_name : tabs){
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
