package com.example.firstproject.Controller.Auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.firstproject.Controller.Main.HomeActivity;
import com.example.firstproject.R;
import com.example.firstproject.Utils.AppConfig;
import com.example.firstproject.model.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {
    CircleImageView circleImageView;
    EditText edtPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
       removeTitleBar();
    }
    void init() {

        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        RelativeLayout rlLogin = findViewById(R.id.rl_login_button);
        ImageView imgFb = findViewById(R.id.img_fb_login);
        ImageView imggg = findViewById(R.id.img_gg_login);
        final ImageView imageView = findViewById(R.id.profile_image);

        rlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isValid  = checkValid();
                if(checkValid()){
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    User user = new User();
                    user.setUsername("Pham Minh Tuan");
                    user.setPhoneNumber("0979281869");
                    user.setProfileUrl("https://i.ytimg.com/vi/pbMwTqkKSps/maxresdefault.jpg");
                    intent.putExtra("info", user);
                    /*Luu so dien thoai vao de lan sau thẳng man hinh user
                        *Use share preferences
                        *b1: tao mo file
                        *b2 : Dùng tool sửa: Editor
                        *b3: sửa file. lưu file.
                    */

                    AppConfig.savePhoneNumber(user.getPhoneNumber(), LoginActivity.this);

                    startActivity(intent);
                    finish();

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



    void removeTitleBar(){
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }
}

