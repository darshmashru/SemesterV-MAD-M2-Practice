package com.darshmashru.madm2practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.MainPgListView);

        String[] listviewdetails = {
                "Web View",
                "Camera View (Photo)",
                "Camera View (Video)",
                "Date Picker",
                "Time Picker",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listviewdetails);
        listview.setAdapter(adapter);

//        This code below is optional
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent webview_intent = new Intent(MainActivity.this, WebViewActivity.class);
                        startActivity(webview_intent);
                        break;
                    case 1:
                        Intent pcameraview_intent = new Intent(MainActivity.this, clickPicture.class);
                        startActivity(pcameraview_intent);
                        break;
                    case 2:
                        Intent vcameraview_intent = new Intent(MainActivity.this, clickVideo.class);
                        startActivity(vcameraview_intent);
                        break;
                    case 3:
                        Intent dateview_intent = new Intent(MainActivity.this, DatePickerActivity.class);
                        startActivity(dateview_intent);
                        break;
                    case 4:
                        Intent timeview_intent = new Intent(MainActivity.this, TimePickerActivity.class);
                        startActivity(timeview_intent);
                        break;
                }
            }
        });
    }
}