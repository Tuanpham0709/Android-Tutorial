package com.example.firstproject.Controller.Main.Adapter;

import android.content.Context;
import android.graphics.drawable.LayerDrawable;
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
import com.example.firstproject.model.Promotions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PromotionAdaprer  extends RecyclerView.Adapter<PromotionAdaprer.PromotionViewHolder> {
    Context context;
    List<Promotions> listPromotions = new ArrayList<>();

    public void setData(List<Promotions> listPromotions){
        this.listPromotions = listPromotions;

    }
    public void setContext(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_news_item_layout, viewGroup, false);
        return new PromotionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder promotionViewHolder, int i) {
        Promotions promotions = listPromotions.get(i);
        promotionViewHolder.tvTitle.setText(promotions.getTitle());
        Picasso.get().load(promotions.getUrlImage()).into(promotionViewHolder.imgBg);

    }

    @Override
    public int getItemCount() {
        return listPromotions.size();
    }

    class PromotionViewHolder extends  RecyclerView.ViewHolder{
        ImageView imgBg;
        TextView tvTitle;
        LinearLayout btnDetail;

        public PromotionViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBg = itemView.findViewById(R.id.img_background);
            tvTitle = itemView.findViewById(R.id.tv_titleNews);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
