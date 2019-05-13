package com.example.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        // Tao doi tuong user

        User windUser = new User();
        windUser.setId(23423423);
        windUser.setPhoneNumber("034123");
        windUser.setProfileUrl("http://sss");
        windUser.setUsername("Tuanpm");

        // Toast.makeText(this, windUser.getUsername(), Toast.LENGTH_LONG).show();
        // Sử dụng đối tượng được khai báo và khời tạo trong file xml

        EditText edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtPhoneNumber.setText("Hello morterfucker");
        TextView evUserName = findViewById(R.id.tv_hello);
        evUserName.setText(windUser.getUsername());

    }
}

