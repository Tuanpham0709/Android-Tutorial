package com.example.firstproject.Utils;

import android.content.ContentValues;
import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class Utll {
    public static String loadJSONFromAsser(Context context){
        String str;

        try {
            InputStream is = context.getAssets().open("home.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            str =new String(buffer, "UTF-8");



        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return str;
    }
}
