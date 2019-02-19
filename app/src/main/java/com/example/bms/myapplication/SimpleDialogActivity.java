package com.example.bms.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleDialogActivity extends AppCompatActivity {
    Button btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_dialog);
        btn =findViewById(R.id.bt1);
        context =this;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom);
                dialog.setTitle("This is dialog box");


                TextView text = dialog.findViewById(R.id.textView);
                text.setText("Hello");
                ImageView image =dialog.findViewById(R.id.img1);
                image.setImageResource(R.drawable.ic_launcher_background);


                Button dialogButton = dialog.findViewById(R.id.dialogButton);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
