package com.example.firstproject.model;

import android.app.DatePickerDialog;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.example.firstproject.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditInfo extends AppCompatActivity {
    TextView tv_date;
    RadioButton rbtnMale, rbtnFemale;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        init();
        tv_date = findViewById(R.id.edt_date_picker);
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay();
            }
        });
    }
    void init(){
        rbtnMale =findViewById(R.id.rbtn_male);
        rbtnFemale = findViewById(R.id.rbn_female);
    }
    private  void chonNgay(){
        final Calendar calendar = Calendar.getInstance();
        int ngay  = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nawm = calendar.get(Calendar.YEAR);
        DatePickerDialog date =  new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                tv_date.setText(simpleDateFormat.format(calendar.getTime()));

            }
        }, nawm, thang, ngay);
        date.show();
    }
}
