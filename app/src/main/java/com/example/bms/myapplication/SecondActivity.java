package com.example.bms.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView refNo, uniqueID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        refNo = findViewById(R.id.tvrefno);
        uniqueID = findViewById(R.id.tvuid);

        Intent in = getIntent();
        String ref = in.getStringExtra("ref");
        String uid = in.getStringExtra("uid");

        refNo.setText("Ref. No : "+ref);
        uniqueID.setText("Unique ID : "+uid);
    }
}
