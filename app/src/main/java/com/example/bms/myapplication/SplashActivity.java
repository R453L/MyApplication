package com.example.bms.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        int time = 2000;
     new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
             Intent intent = new Intent(SplashActivity.this,MainActivity.class);
             startActivity(intent);
             finish();
         }
     },time);
    }
}
