package com.example.paymentservice.ui.network;

public interface ApiResponseInterface {
     void isError(String errorCode,int ServiceCode);
     void isSuccess(Object response, int ServiceCode);
}
