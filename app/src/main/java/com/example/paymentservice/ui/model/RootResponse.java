package com.example.paymentservice.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RootResponse {
    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("token")
    @Expose
    public String token;

    @SerializedName("news")
    @Expose
    public String news;

    @SerializedName("result")
    @Expose
    public ArrayList<ResultDataModel>  result;

    @SerializedName("banner")
    @Expose
    public ArrayList<BannerDataModel>  banner;

    @SerializedName("cusData")
    @Expose
    public ArrayList<CustDataModel>  cusData;


    public int walletBalance;
}
