package com.example.firstproject.Controller.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstproject.R;
import com.example.firstproject.model.User;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    TextView textPhone, tvName, tvEdit;
    CircleImageView imgAvata;
    LinearLayout btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getData();
        remove();

    }
    void init(){
        textPhone = findViewById(R.id.tv_phone_number);
        tvName = findViewById(R.id.tv_name);
        tvEdit = findViewById(R.id.tv_edit);
        imgAvata = findViewById(R.id.profile_image);
        btnHome = findViewById(R.id.btn_home);
    }
    void getData(){
        User user  = (User) getIntent().getSerializableExtra("info");
        textPhone.setText(user.getPhoneNumber());
        tvName.setText(user.getUsername());
        Picasso.get().load(user.getProfileUrl()).into(imgAvata);
    }
    void stateProgeressBar(){

    }

    public void remove(){
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

    }

}

