package com.example.paymentservice.ui.network;



import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.paymentservice.ui.model.RootRecharge;
import com.example.paymentservice.ui.model.RootResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {
    private Context mContext;
    private String jsessionid="";
    private ProgressDialog dialog;
    static SharedPreferences loginpref;

    private ApiResponseInterface mApiResponseInterface;
    public ApiManager(Context context, ApiResponseInterface apiResponseInterface) {
        this.mContext = context;
        this.mApiResponseInterface = apiResponseInterface;
        dialog = new ProgressDialog(mContext);
    }

    /**
     * The purpose of this method is to show the dialog
     *
     * @param message
     */
    private void showDialog(String message) {
        dialog.setMessage(message);
        dialog.show();

    }
    /**
     * The purpose of this method is to close the dialog
     */
    private void closeDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
    public void getLoginRequest(String mobile,String pass,String deviceid,String devicename,String otp, int req) {
        showDialog("");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<RootResponse> call = apiService.getLoginRequest(mobile,pass,deviceid,devicename,otp);
        call.enqueue(new Callback<RootResponse>() {
            @Override
            public void onResponse(Call<RootResponse> call, Response<RootResponse> response) {
                closeDialog();
                if (response.body()!=null ) {
                    mApiResponseInterface.isSuccess(response.body(),req);
                } else {
                    mApiResponseInterface.isError("Failed",req);
                }
            }
            @Override
            public void onFailure(Call<RootResponse> call, Throwable t) {
                closeDialog();
                if(t instanceof IOException)
                {
                    mApiResponseInterface.isError("Internet is not Connected",req);
                } else {
                    mApiResponseInterface.isError("Please Contact to Administrator",req);
                }
            }
        });
    }

    public void getDashboardRequest(String token,String mobile, int req) {
        showDialog("");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<RootResponse> call = apiService.getDashboardRequest(token,mobile);

        call.enqueue(new Callback<RootResponse>() {
            @Override
            public void onResponse(Call<RootResponse> call, Response<RootResponse> response) {
                closeDialog();
                if (response.body()!=null ) {

                    mApiResponseInterface.isSuccess(response.body(),req);
                } else {
                    mApiResponseInterface.isError("Failed",req);
                }
            }
            @Override
            public void onFailure(Call<RootResponse> call, Throwable t) {
                closeDialog();

                if(t instanceof IOException)
                {
                    mApiResponseInterface.isError("Internet is not Connected",req);
                } else {
                    mApiResponseInterface.isError("Please Contact to Administrator",req);
                }
            }
        });
    }





    public void getRechargeHistoryRequest(String token,String mobile,String date, int req) {
        showDialog("");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<RootResponse> call = apiService.getRechargeHistoryRequest(token,mobile,date);

        call.enqueue(new Callback<RootResponse>() {
            @Override
            public void onResponse(Call<RootResponse> call, Response<RootResponse> response) {
                closeDialog();
                Log.d("History","recharge"+response.body().message);
                if (response.body()!=null ) {
                    mApiResponseInterface.isSuccess(response.body(),req);
                } else {
                    mApiResponseInterface.isError("Failed",req);
                }
            }
            @Override
            public void onFailure(Call<RootResponse> call, Throwable t) {
                closeDialog();
                Log.d("History","recharge"+t.getMessage());
                if(t instanceof IOException)
                {
                    mApiResponseInterface.isError("Internet is not Connected",req);
                } else {
                    mApiResponseInterface.isError("Please Contact to Administrator",req);
                }
            }
        });
    }




    public void getRechargeHistoryfromandtoRequest(String token,String mobile,String fromdate,String todate, int req) {
        showDialog("");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<RootResponse> call = apiService.getRechargeHistoryfromandtoRequest(token,mobile,fromdate,todate);

        call.enqueue(new Callback<RootResponse>() {
            @Override
            public void onResponse(Call<RootResponse> call, Response<RootResponse> response) {
                closeDialog();
                Log.d("History","recharge"+response.body().message);
                if (response.body()!=null ) {
                    mApiResponseInterface.isSuccess(response.body(),req);
                } else {
                    mApiResponseInterface.isError("Failed",req);
                }
            }
            @Override
            public void onFailure(Call<RootResponse> call, Throwable t) {
                closeDialog();
                Log.d("History","recharge"+t.getMessage());
                if(t instanceof IOException)
                {
                    mApiResponseInterface.isError("Internet is not Connected",req);
                } else {
                    mApiResponseInterface.isError("Please Contact to Administrator",req);
                }
            }
        });
    }



    public void getWalletBalanceRequest(String token,String mobile, int req) {
        showDialog("");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<RootResponse> call = apiService.getWalletBalanceRequest(token,mobile);

        call.enqueue(new Callback<RootResponse>() {
            @Override
            public void onResponse(Call<RootResponse> call, Response<RootResponse> response) {
                closeDialog();
                if (response.body()!=null ) {

                    mApiResponseInterface.isSuccess(response.body(),req);
                } else {
                    mApiResponseInterface.isError("Failed",req);
                }
            }
            @Override
            public void onFailure(Call<RootResponse> call, Throwable t) {
                closeDialog();

                if(t instanceof IOException)
                {
                    mApiResponseInterface.isError("Internet is not Connected",req);
                } else {
                    mApiResponseInterface.isError("Please Contact to Administrator",req);
                }
            }
        });
    }


    public void getOperatorRequest(String token,String mobile, int req) {
        showDialog("");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<RootResponse> call = apiService.getOperatorRequest(token,mobile);
        call.enqueue(new Callback<RootResponse>() {
            @Override
            public void onResponse(Call<RootResponse> call, Response<RootResponse> response) {
                closeDialog();
                if (response.body()!=null ) {
                    mApiResponseInterface.isSuccess(response.body(),req);
                } else {
                    mApiResponseInterface.isError("Failed",req);
                }
            }
            @Override
            public void onFailure(Call<RootResponse> call, Throwable t) {
                closeDialog();
                if(t instanceof IOException)
                {
                    mApiResponseInterface.isError("Internet is not Connected",req);
                } else {
                    mApiResponseInterface.isError("Please Contact to Administrator",req);
                }
            }
        });
    }

    public void getPrepadiRechargeRequest(String mobile,String Amount,String cus_id,String cus_type,String operator,String token, int req) {
        showDialog("");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Log.d("ApiManager","responsepoint1");
        Call<RootRecharge> call = apiService.getPrepadiRechargeRequest(token,mobile,Amount,cus_id,cus_type,operator);
        Log.d("ApiManager","responsepoint2");
        call.enqueue(new Callback<RootRecharge>() {
            @Override
            public void onResponse(Call<RootRecharge> call, Response<RootRecharge> response) {
                closeDialog();
                if (response.body()!=null ) {
                    Log.d("Recharge1","response"+response.body().result.mess);
                    mApiResponseInterface.isSuccess(response.body(),req);
                } else {
                    mApiResponseInterface.isError("Failed",req);
                }
            }
            @Override
            public void onFailure(Call<RootRecharge> call, Throwable t) {
                closeDialog();
                Log.d("ApiManager","response"+t.getMessage());
                if(t instanceof IOException)
                {
                    mApiResponseInterface.isError("Internet is not Connected",req);
                } else {
                    mApiResponseInterface.isError("Please Contact to Administrator",req);
                }
            }
        });
    }




}
