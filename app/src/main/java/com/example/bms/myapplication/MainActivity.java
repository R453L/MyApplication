package com.example.bms.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 2;
    EditText refNo, uniqueID;
    TextView tvBattery;
    Button btnFind, btnBattery, btnCamera;
    ImageView ivCamera;
    Bitmap bitmap;
    AlertDialog.Builder builder;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refNo = findViewById(R.id.refno);
        uniqueID = findViewById(R.id.uniqid);

        btnFind = findViewById(R.id.findbutton);

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ref = refNo.getText().toString();
                final String uid = uniqueID.getText().toString();

                if(ref.length() < 4){
                    Toast.makeText(getApplicationContext(),"Invalid Data", Toast.LENGTH_SHORT).show();


//                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//                        builder = new AlertDialog.Builder(getApplicationContext(), android.R.style.Theme_Material_Dialog_Alert);
//                    }else{
//                        builder = new AlertDialog.Builder(getApplicationContext());
//                    }
//                    builder.setTitle("Invalid Data")
//                            .setCancelable(false)
//                            .setMessage("Provided data is invalid.")
//                            .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
//                                    secondIntent.putExtra("ref",ref);
//                                    secondIntent.putExtra("uid",uid);
//
//                                    MainActivity.this.startActivity(secondIntent);
//                                    finish();
//                                }
//                            })
//                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    finish();
//                                }
//                            })
//                            .setNeutralButton("Close", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//
//                                }
//                            })
//                            .create()
//                            .show();
                }else{
                    Intent secondIntent = new Intent(MainActivity.this, SecondActivity.class);
                    secondIntent.putExtra("ref",ref);
                    secondIntent.putExtra("uid",uid);

                    MainActivity.this.startActivity(secondIntent);
                    //finish();
                }
            }
        });
        tvBattery = findViewById(R.id.tvbattery);
        btnBattery = findViewById(R.id.btnbattery);
        btnBattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBattery.setText("getting info...");
                BatteryManager bm = (BatteryManager) getSystemService(BATTERY_SERVICE);
                int batterylevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
                tvBattery.setText(String.valueOf(batterylevel)+"%");
            }
        });
        ivCamera = findViewById(R.id.ivcamera);
        btnCamera = findViewById(R.id.btncamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                //camIntent.putExtra(MediaStore.EXTRA_OUTPUT, file);
                startActivityForResult(camIntent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == AppCompatActivity.RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap)bundle.get("data");
            ivCamera.setImageBitmap(bitmap);
        }
    }
}
