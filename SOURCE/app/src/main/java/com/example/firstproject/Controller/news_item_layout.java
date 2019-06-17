package com.example.firstproject.Controller;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.firstproject.R;

public class news_item_layout extends AppCompatActivity {
    TextView tv_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item_layout);
        tv_date = findViewById(R.id.edt_date_picker);
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private  void chonNgay(){
        DatePickerDialog date =  new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            }
        }, 2019, 01, 01);
        date.show();
    }
}
