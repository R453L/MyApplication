package com.example.bms.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InternetActivity extends AppCompatActivity {

    Button check;
    Connectivity connectivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);
        check = findViewById(R.id.btcheck);

        connectivity = new Connectivity(this);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(connectivity.isConnected()){
                    Toast.makeText(InternetActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(InternetActivity.this, "Not Connected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
