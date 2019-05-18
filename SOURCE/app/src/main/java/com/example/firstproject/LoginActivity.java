package com.example.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
    }
    void init() {
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        RelativeLayout rlLogin = findViewById(R.id.rl_login_button);
        ImageView imgFb = findViewById(R.id.img_fb_login);
        ImageView imggg = findViewById(R.id.img_gg_login);
        rlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, edtPhoneNumber.getText().toString(), Toast.LENGTH_SHORT).show();
                boolean isValid  = checkValid();
                if(checkValid()){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Vui lòng kiểm tra lại số điện thoại và thử lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    boolean checkValid(){
        int phoneLength = edtPhoneNumber.getText().toString().length();
        return (phoneLength > 9);
    }
}

