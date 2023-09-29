package com.darshmashru.madm2practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.MessageFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Locale;

public class TimePickerActivity extends AppCompatActivity {
    String setTime;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        time = findViewById(R.id.timeSelected);
    }
    public void timePickeronClick(View view) {
        MaterialTimePicker timePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
                .setTitleText("Select Time")
                .build();
        timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime = MessageFormat.format("{0}:{1}",
                        String.format(Locale.getDefault(), "%02d", timePicker.getHour()),
                        String.format(Locale.getDefault(), "%02d", timePicker.getMinute()));
                time.setText(setTime);
            }
        });
        timePicker.show(getSupportFragmentManager(), "tag");
    }
    public void goToNextPage(View view) {
        Intent i = new Intent(TimePickerActivity.this, TimePickerActivityPg2.class);
        i.putExtra("time", setTime);
        startActivity(i);
    }
}