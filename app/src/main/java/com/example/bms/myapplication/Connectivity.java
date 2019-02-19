package com.example.bms.myapplication;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Connectivity {
    Context context;

    public Connectivity(Context context) {
        this.context = context;
    }

    public boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(connectivityManager != null){
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if(info != null){
                if(info.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }
}
