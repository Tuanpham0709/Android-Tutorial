package com.example.firstproject.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeResult {

@SerializedName("customerDetail")
@Expose
public CustomerDetail customerDetail;
@SerializedName("listNews")
@Expose
public List<News> listNews = null;
@SerializedName("listPromotion")
@Expose
public List<Promotions> listPromotion = null;

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    public List<News> getListNews() {
        return listNews;
    }

    public void setListNews(List<News> listNews) {
        this.listNews = listNews;
    }

    public List<Promotions> getListPromotion() {
        return listPromotion;
    }

    public void setListPromotion(List<Promotions> listPromotion) {
        this.listPromotion = listPromotion;
    }
}