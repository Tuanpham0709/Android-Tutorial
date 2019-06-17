package com.example.firstproject.Controller.Main.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firstproject.R;
import com.example.firstproject.model.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter2 extends RecyclerView.Adapter<NewsAdapter2.NewsViewHolder> {
    List<News> data  = new ArrayList<>();
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<News> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_news_item_layout, viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        News news = data.get(i);
        newsViewHolder.tvTitle.setText(news.getTitle());
        Picasso.get().load(news.getUrlImage()).into(newsViewHolder.imgBg);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

      class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBg;
        TextView tvTitle;
        LinearLayout btnDetail;

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBg = itemView.findViewById(R.id.img_background);
            tvTitle = itemView.findViewById(R.id.tv_titleNews);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
