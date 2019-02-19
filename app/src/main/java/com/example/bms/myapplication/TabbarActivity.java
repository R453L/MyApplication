package com.example.bms.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TabbarActivity extends AppCompatActivity implements ActionBar.TabListener {

    private ActionBar actionBar;
    private String[] tabs = {"hello","hi","hola"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        }

        for(String tab_name : tabs){
            if (actionBar != null) {
                actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
            }
        }

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Toast.makeText(this, tab.getPosition()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
