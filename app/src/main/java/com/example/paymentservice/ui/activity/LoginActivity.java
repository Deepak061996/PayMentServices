package com.example.paymentservice.ui.activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivityLoginBinding;
import com.example.paymentservice.ui.model.ResultDataModel;
import com.example.paymentservice.ui.model.RootResponse;
import com.example.paymentservice.ui.network.ApiManager;
import com.example.paymentservice.ui.network.ApiResponseInterface;
import com.example.paymentservice.ui.util.AppConstants;
import com.example.paymentservice.ui.util.CommonUtils;

import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ApiManager mApiManager;
    private ApiResponseInterface mInterFace;
    ActivityLoginBinding binding;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View   view=binding.getRoot();
        setContentView(view);
        editor=getSharedPreferences("isLogin",MODE_PRIVATE).edit();
        setUpNetWork();
        binding.btnNext.setOnClickListener(this);
        binding.tvsignup.setOnClickListener(this);
        binding.etpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        binding.tvforgetpassword.setOnClickListener(this);
    }

    private void setUpNetWork() {
        mInterFace=new ApiResponseInterface() {
            @Override
            public void isError(String errorCode,int ServiceCode) {
                if (ServiceCode==AppConstants.LOGIN_REQUEST) {
                    Toast.makeText(getApplicationContext(),errorCode,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void isSuccess(Object response, int ServiceCode) {
                if (ServiceCode==AppConstants.LOGIN_REQUEST)
                {
                    RootResponse rootResponse =(RootResponse) response;
                    editor.putString("token", rootResponse.token.toString());
                    editor.apply();
                    ArrayList<ResultDataModel> model= rootResponse.result;
                    if (model!=null && model.size()>=0)
                    {
                        for (int i=0;i<model.size();i++) {
                            Log.d("LoginActivity","onResponse"+((RootResponse) response).result.get(i).cusMobile);
                            editor.putString("Cust_id",model.get(i).cusId.toString());
                            editor.putString("Cust_name",model.get(i).cusName.toString());
                            editor.putString("Cust_type",model.get(i).cusType.toString());
                            editor.putString("Cust_Mobile",model.get(i).cusMobile.toString());
                            editor.putString("Cust_state",model.get(i).cusState.toString());
                            editor.putString("Cust_city",model.get(i).cusCity.toString());
                            editor.putString("Cust_email",model.get(i).cusEmail.toString());
                            editor.putString("Cust_pincode",model.get(i).cusPincode.toString());
                            editor.apply();
                        }
                        startActivity(new Intent(LoginActivity.this,FragmentActivity.class));
                    }else {
                        Log.d("LoginActivity","onResponse size not found");
                        startActivity(new Intent(LoginActivity.this,LoginActivity.class));
                    }

                }
            }
        };
        mApiManager=new ApiManager(this,mInterFace);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_next:
                if (isValidation()) {
                    String mobile = binding.etmobile.getText().toString();
                    String pass = binding.etpassword.getText().toString();
                    String deviceid = "1324276";
                    String devicename = CommonUtils.getDeviceName();
                    Log.d("device ","Name"+devicename);
                    String otp = "999999";
                    mApiManager.getLoginRequest(mobile, pass, deviceid, devicename, otp, AppConstants.LOGIN_REQUEST);
                }
                break;
            case R.id.tvsignup:
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                break;
            case R.id.tvforgetpassword:
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
                break;
        }
    }

    private boolean isValidation() {
        boolean result=true;
        if (binding.etmobile.getText().toString().isEmpty()) {
            binding.etmobile.setError("Enter Mobile Number");
            return false;
        }else if (binding.etpassword.getText().toString().isEmpty()) {
            binding.etpassword.setError("Enter Password");
            return false;
        }
        return result;
    }
}