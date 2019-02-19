package com.example.bms.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    EditText et1,et2;

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        b1 = findViewById(R.id.add);
        b2 = findViewById(R.id.subtract);
        b3 = findViewById(R.id.multiply);
        b4 = findViewById(R.id.divide);
        et1 =findViewById(R.id.et1);
        et2 =findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = et1.getText().toString();
                String input2 = et2.getText().toString();
                if (input.isEmpty()||input2.isEmpty())
                    Toast.makeText(CalculatorActivity.this, "Enter value", Toast.LENGTH_SHORT).show();
                else{
                    // do whatever conversions
                    int a = Integer.parseInt(input);
                    int b = Integer.parseInt(input2);
                    int c= a+b;
                    tv1.setText("Sum is " +c);
                    Toast.makeText(CalculatorActivity.this, "Calculation is done", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = et1.getText().toString();
                String input2 = et2.getText().toString();
                if(input.isEmpty() ||input2.isEmpty()){
                    Toast.makeText(CalculatorActivity.this, "Enter value", Toast.LENGTH_SHORT).show();
                }else{
                    int a = Integer.parseInt(input);
                    int b = Integer.parseInt(input2);
                    int c = a-b;
                    tv1.setText("Subtraction is "+c);
                    Toast.makeText(CalculatorActivity.this, "Calculation is done", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = et1.getText().toString();
                String input2 = et2.getText().toString();
                if (input.isEmpty()||input2.isEmpty())
                    Toast.makeText(CalculatorActivity.this, "Enter value", Toast.LENGTH_SHORT).show();
                else{
                    // do whatever conversions
                    int a = Integer.parseInt(input);
                    int b = Integer.parseInt(input2);
                    int c= a*b;
                    tv1.setText("Multiplication is " +c);
                    Toast.makeText(CalculatorActivity.this, "Calculation is done", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = et1.getText().toString();
                String input2 = et2.getText().toString();
                if (input.isEmpty()||input2.isEmpty())
                    Toast.makeText(CalculatorActivity.this, "Enter value", Toast.LENGTH_SHORT).show();
                else{
                    // do whatever conversions
                    int a = Integer.parseInt(input);
                    int b = Integer.parseInt(input2);
                    int c= a/b;
                    tv1.setText("Division is " +c);
                    Toast.makeText(CalculatorActivity.this, "Calculation is done", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
