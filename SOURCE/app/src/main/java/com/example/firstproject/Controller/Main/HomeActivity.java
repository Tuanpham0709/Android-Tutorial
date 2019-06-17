package com.example.firstproject.Controller.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.firstproject.Controller.Main.Adapter.NewsAdaper;
import com.example.firstproject.Controller.Main.Adapter.PromotionAdaprer;
import com.example.firstproject.R;
import com.example.firstproject.model.HomeData;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rvNews, rvPromotion;

    HomeData homeData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String strHomeData = loadJSONFromAsset();
        Gson gson = new Gson();
        homeData = gson.fromJson(strHomeData, HomeData.class);
        init();
        configRvNews();
        configRvPromotion();
        removeTitleBar();

    }


    void init(){
        rvNews= findViewById(R.id.rc_view_news);
        rvPromotion= findViewById(R.id.rc_view_promotion);

    }

    public String loadJSONFromAsset(){
        String str;

        try {
            InputStream is = getAssets().open("home.json");
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
    void configRvNews(){
        LinearLayoutManager linearLayoutManagerRvNews =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvNews.setLayoutManager(linearLayoutManagerRvNews);
        NewsAdaper adaperNews = new NewsAdaper();
        adaperNews.setData(homeData.getResult().getListNews());
        adaperNews.setContext(this);
        rvNews.setAdapter(adaperNews);

    }
    void configRvPromotion(){
        LinearLayoutManager linearLayoutManagerRvPromotion  =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvPromotion.setLayoutManager(linearLayoutManagerRvPromotion);
        PromotionAdaprer adaprerPromotion = new PromotionAdaprer();
        adaprerPromotion.setContext(this);
        adaprerPromotion.setData(homeData.getResult().getListPromotion());
        rvPromotion.setAdapter(adaprerPromotion);

    }

    void removeTitleBar(){
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }
}

