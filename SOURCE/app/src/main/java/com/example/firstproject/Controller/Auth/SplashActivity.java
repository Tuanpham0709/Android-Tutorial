package com.example.firstproject.Controller.Auth;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.firstproject.Controller.Main.HomeActivity;
import com.example.firstproject.R;
import com.example.firstproject.Utils.AppConfig;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                screenRouter();
            }
        }, 2000);
    }
    void screenRouter(){

        String phone_number = AppConfig.getPhoneNumber(this);
        if(phone_number == null){
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }else {
            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
