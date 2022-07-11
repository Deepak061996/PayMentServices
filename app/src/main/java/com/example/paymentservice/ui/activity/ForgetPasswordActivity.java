package com.example.paymentservice.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivityForgetPasswordBinding;
import com.example.paymentservice.databinding.ActivityLoginBinding;
import com.example.paymentservice.ui.model.ResultDataModel;
import com.example.paymentservice.ui.model.RootResponse;
import com.example.paymentservice.ui.network.ApiManager;
import com.example.paymentservice.ui.network.ApiResponseInterface;
import com.example.paymentservice.ui.util.AppConstants;

import java.util.ArrayList;


public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener{
    private ApiManager mApiManager;
    private ApiResponseInterface mInterFace;
    ActivityForgetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.btnNext.setOnClickListener(this);
        binding.etConfpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        binding.etpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        setUpNetWork();
    }

    private void setUpNetWork() {
        mInterFace=new ApiResponseInterface() {
            @Override
            public void isError(String errorCode,int ServiceCode) {
                if (ServiceCode== AppConstants.Forgetpassword_REQUEST) {
                    Toast.makeText(getApplicationContext(),errorCode,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void isSuccess(Object response, int ServiceCode) {
                if (ServiceCode==AppConstants.Forgetpassword_REQUEST)
                {


                }
            }
        };
        mApiManager=new ApiManager(this,mInterFace);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_next:
                if (isValidation()) {
                    String cus_id=binding.etcusId.getText().toString();
                    String pass=binding.etpassword.getText().toString();
                    String confirmpass=binding.etConfpassword.getText().toString();
                    Toast.makeText(getApplicationContext(),"ghsadhda",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    private boolean isValidation() {
        boolean result=true;
        String pass1=binding.etpassword.getText().toString();
        String pass2=binding.etConfpassword.getText().toString();
        if (binding.etcusId.getText().toString().isEmpty()) {
            binding.etcusId.setError("Please Enter Customer ID");
            return false;
        }else if (!pass1.equals(pass2)) {
            binding.etConfpassword.setError("Please Enter Correct Password");
            return false;
        }

        return result;
    }
}