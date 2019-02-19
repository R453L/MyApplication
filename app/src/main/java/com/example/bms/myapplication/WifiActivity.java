package com.example.bms.myapplication;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WifiActivity extends AppCompatActivity {

    Button enable,disable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        enable = findViewById(R.id.enable);
        disable = findViewById(R.id.disable);

        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                if (wifiManager != null) {
                    wifiManager.setWifiEnabled(true);
                }
            }
        });
        disable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                if (wifiManager != null) {
                    wifiManager.setWifiEnabled(false);
                }
            }
        });

    }
}
