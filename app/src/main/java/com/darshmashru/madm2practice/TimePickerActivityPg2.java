package com.darshmashru.madm2practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TimePickerActivityPg2 extends AppCompatActivity {
    TextView Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_pg2);

        Time = findViewById(R.id.selectedTime);

        Bundle bundle = getIntent().getExtras();
        String time = bundle.getString("time");

        Time.setText(time);
    }
}