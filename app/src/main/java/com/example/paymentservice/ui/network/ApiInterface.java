package com.example.paymentservice.ui.network;

import com.example.paymentservice.ui.model.RootRecharge;
import com.example.paymentservice.ui.model.RootResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("applogin/userLogin")
    Call<RootResponse> getLoginRequest(@Field("user_mobile")String mobile, @Field("user_password")String pass, @Field("deviceId")String deviceid, @Field("deviceName")String devicename, @Field("otp")String otp);

    @FormUrlEncoded
    @POST("appapi/dashboard")
    Call<RootResponse> getDashboardRequest(@Field("token")String token, @Field("cus_mobile")String mobile);

    @FormUrlEncoded
    @POST("appapi/rechargeHistory")
    Call<RootResponse> getRechargeHistoryRequest(@Field("token")String token, @Field("cus_mobile")String mobile,@Field("date")String date);

    @FormUrlEncoded
    @POST("appapi/rechargeHistoryFromTo")
    Call<RootResponse> getRechargeHistoryfromandtoRequest(@Field("token")String token, @Field("cus_mobile")String mobile,@Field("fromDate")String fromdate,@Field("toDate")String todate);



    @FormUrlEncoded
    @POST("appapi/walletBalance")
    Call<RootResponse> getWalletBalanceRequest(@Field("token")String token, @Field("cus_mobile")String mobile);


    @FormUrlEncoded
    @POST("appapi/getOperators")
    Call<RootResponse> getOperatorRequest(@Field("token")String token, @Field("operator_type")String mobile);

    @FormUrlEncoded
    @POST("Rechargeapi/recharge")
    Call<RootRecharge> getPrepadiRechargeRequest(@Field("token")String token, @Field("mobile")String mobile ,@Field("amount")String Amount,@Field("cus_id")String cus_id,@Field("cus_type")String cus_type,@Field("operator")String operator );
}
