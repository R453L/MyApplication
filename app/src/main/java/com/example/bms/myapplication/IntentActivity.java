package com.example.bms.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IntentActivity extends AppCompatActivity {

    Button btncap,btnsave;
    Boolean camsave = false;
    ImageView imgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        btncap = findViewById(R.id.btncapture);
        btnsave = findViewById(R.id.btnsave);
        imgv = findViewById(R.id.img);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        btncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if (ContextCompat.checkSelfPermission(IntentActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                {

                    ActivityCompat.requestPermissions(IntentActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
                else
                {
                    camsave = true;
                }
                if(camsave) {
                    Bitmap imageFromImageView = ((BitmapDrawable) imgv.getDrawable()).getBitmap();
                    FileOutputStream outStream = null;
                    File sdCard = Environment.getExternalStorageDirectory();
                    File dir = new File(sdCard.getAbsolutePath() + "/myfolder");
                    if(!dir.exists())
                        dir.mkdirs();
                    String fileName = String.format("IMG%d.jpg", System.currentTimeMillis());
                    File outFile = new File(dir, fileName);
                    try {
                        outStream = new FileOutputStream(outFile);
                        imageFromImageView.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                        outStream.flush();
                        outStream.close();
                        Toast.makeText(getApplicationContext(), "Image Saved", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(IntentActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            Bundle bundle = data.getExtras();
            Bitmap imageFromCamera = (Bitmap) bundle.get("data");
            imgv.setImageBitmap(imageFromCamera);
            btnsave.setEnabled(true);
        }
        else if(requestCode == 1 && resultCode == RESULT_CANCELED)
        {
            Toast.makeText(getApplicationContext(), "User Cancelled Operation", Toast.LENGTH_LONG).show();
        }
        else if (resultCode == RESULT_OK && requestCode == 2) {
            if (data.hasExtra("returnKey1")) {
                Toast.makeText(this, data.getExtras().getString("returnKey1"),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    camsave = true;
                } else {
                    camsave = false;
                }
                return;
            }
        }
    }
}
