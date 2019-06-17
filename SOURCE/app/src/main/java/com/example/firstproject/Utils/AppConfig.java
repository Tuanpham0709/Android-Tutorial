package com.example.firstproject.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfig {
    public static final String PREF_NAME = "ANDROID005";
    public static  void savePhoneNumber(String phoneNumber , Context context){
        SharedPreferences sharedPreferences =  context.getSharedPreferences("Android005", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("phone_number", phoneNumber);
        editor.apply();
    }
    public static String getPhoneNumber(Context context){
      SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
      return  sharedPreferences.getString("phone_number", null);
    }
}
