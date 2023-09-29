package com.darshmashru.madm2practice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatePickerActivity extends AppCompatActivity {
    String setDate;
    TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        date = findViewById(R.id.dateSelected);
    }
    public void datePickeronClick(View view) {
        MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) { // Type "new" within the Round Brackets for this function
                setDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date(selection));
                date.setText(setDate);
            }
        });
        materialDatePicker.show(getSupportFragmentManager(), "tag");
    }
}