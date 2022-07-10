package com.example.paymentservice.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustDataModel {

    @SerializedName("cus_id")
    @Expose
    public String cusId;
    @SerializedName("cus_type")
    @Expose
    public String cusType;
    @SerializedName("cus_email")
    @Expose
    public String cusEmail;
    @SerializedName("cus_name")
    @Expose
    public String cusName;
    @SerializedName("profile_img")
    @Expose
    public String profileImg;
    @SerializedName("aeps_kyc_status")
    @Expose
    public String aepsKycStatus;
    @SerializedName("newaepskyc_status")
    @Expose
    public String newaepskycStatus;
}
