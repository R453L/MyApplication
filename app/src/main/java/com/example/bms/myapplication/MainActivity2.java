package com.example.bms.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String value[] = {"calculator","intent","dialog","tabbar","battery","wifi","menu","toast","internet","fragment"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findViewById(R.id.listview);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,value);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String item = (String)adapterView.getItemAtPosition(i);
        if(item.equals("calculator")){
            Intent intent = new Intent(MainActivity2.this,CalculatorActivity.class);
            startActivity(intent);
        }else if(item.equals("intent")){
            Intent intent = new Intent(MainActivity2.this,IntentActivity.class);
            startActivity(intent);
        }else if(item.equals("internet")){
            Intent intent = new Intent(MainActivity2.this,InternetActivity.class);
            startActivity(intent);
        }
        else if(item.equals("dialog")){
            Intent intent =new Intent(MainActivity2.this,SimpleDialogActivity.class);
            startActivity(intent);
        }else if(item.equals("tabbar")) {
            Intent intent = new Intent(MainActivity2.this, TabbarActivity.class);
            startActivity(intent);
        }else if(item.equals("battery")) {
            Intent intent = new Intent(MainActivity2.this, BatteryActivity.class);
            startActivity(intent);
        }else if(item.equals("wifi")) {
            Intent intent = new Intent(MainActivity2.this, WifiActivity.class);
            startActivity(intent);
        }else if(item.equals("menu")) {
            Intent intent = new Intent(MainActivity2.this, MenuesActivity.class);
            startActivity(intent);
        }else if(item.equals("toast")) {
            Toast.makeText(this, "This is the simple toast", Toast.LENGTH_SHORT).show();
        }else if(item.equals("fragment")) {
            Intent intent = new Intent(MainActivity2.this, FragmentActivity.class);
            startActivity(intent);
        }else {

        }


    }
}
