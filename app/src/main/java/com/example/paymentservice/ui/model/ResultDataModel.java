package com.example.paymentservice.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultDataModel {

    @SerializedName("cus_id")
    @Expose
    public String cusId;
    @SerializedName("cus_name")
    @Expose
    public String cusName;
    @SerializedName("cus_type")
    @Expose
    public String cusType;
    @SerializedName("cus_mobile")
    @Expose
    public String cusMobile;
    @SerializedName("cus_state")
    @Expose
    public String cusState;
    @SerializedName("cus_city")
    @Expose
    public String cusCity;
    @SerializedName("cus_pincode")
    @Expose
    public String cusPincode;
    @SerializedName("cus_pass")
    @Expose
    public String cusPass;
    @SerializedName("cus_pin")
    @Expose
    public String cusPin;
    @SerializedName("cus_email")
    @Expose
    public String cusEmail;
    @SerializedName("package_id")
    @Expose
    public Object packageId;

    @SerializedName("opid")
    @Expose
    public String opid;
    @SerializedName("operatorname")
    @Expose
    public String operatorname;
    @SerializedName("opcodenew")
    @Expose
    public String opcodenew;
    @SerializedName("qr_opcode")
    @Expose
    public String qrOpcode;
    @SerializedName("opsertype")
    @Expose
    public String opsertype;
    @SerializedName("operator_image")
    @Expose
    public String operatorImage;

    @SerializedName("type")
    @Expose
    public Integer type;
    @SerializedName("mess")
    @Expose
    public String mess;
    @SerializedName("balance")
    @Expose
    public Integer balance;



    @SerializedName("recid")
    @Expose
    public String recid;
    @SerializedName("reqdate")
    @Expose
    public String reqdate;
    @SerializedName("recmedium")
    @Expose
    public String recmedium;
    @SerializedName("amount")
    @Expose
    public String amount;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("mobileno")
    @Expose
    public String mobileno;
    @SerializedName("dispute_status")
    @Expose
    public String disputeStatus;
    @SerializedName("statusdesc")
    @Expose
    public String statusdesc;
    @SerializedName("operator")
    @Expose
    public String operator;
    @SerializedName("retailer")
    @Expose
    public String retailer;
    @SerializedName("master")
    @Expose
    public String master;
    @SerializedName("distributor")
    @Expose
    public String distributor;
    @SerializedName("txn_id")
    @Expose
    public String txnId;
    @SerializedName("txn_clbal")
    @Expose
    public String txnClbal;
    @SerializedName("txn_opbal")
    @Expose
    public String txnOpbal;
    



}
