package com.example.paymentservice.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannerDataModel {


    @SerializedName("bid")
    @Expose
    public String bid;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("type")
    @Expose
    public String type;

}
