package com.example.paymentservice.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivityDthrechargeBinding;
import com.example.paymentservice.ui.model.ResultDataModel;
import com.example.paymentservice.ui.model.RootRecharge;
import com.example.paymentservice.ui.model.RootResponse;
import com.example.paymentservice.ui.network.ApiManager;
import com.example.paymentservice.ui.network.ApiResponseInterface;
import com.example.paymentservice.ui.util.AppConstants;

import java.util.ArrayList;
import java.util.HashMap;

public class DTHRechargeActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityDthrechargeBinding binding;
    SharedPreferences loginpfe;
    SharedPreferences operator;
    SharedPreferences dashboard;
    SharedPreferences.Editor editor;
    private HashMap<Integer, String> OperatorlistMap;
    private ApiManager mApiManager;
    private ApiResponseInterface mInterFace;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDthrechargeBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        loginpfe=getSharedPreferences("isLogin",MODE_PRIVATE);
        dashboard=getSharedPreferences("Dashboard",MODE_PRIVATE);
        operator=getSharedPreferences("Opertaor",MODE_PRIVATE);
        editor=operator.edit();
        OperatorlistMap=new HashMap<>();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.DTH);
        ColorDrawable drawable=new ColorDrawable(Color.parseColor("#300D83"));
        getSupportActionBar().setBackgroundDrawable(drawable);

        binding.tvtotalBalance.setText("\u20B9"+" "+dashboard.getInt("balance",0));
        setUpNetWork();
        {
            token=loginpfe.getString("token","null");
            String mobile="dth";
            mApiManager.getOperatorRequest(token,mobile, AppConstants.Operator_REQUEST);
        }

        binding.btnRecharge.setOnClickListener(this);
    }

    private void setUpNetWork() {
        mInterFace=new ApiResponseInterface() {
            @Override
            public void isError(String errorCode,int ServiceCode) {
                if (ServiceCode==AppConstants.Operator_REQUEST) {
                    Toast.makeText(getApplicationContext(),errorCode,Toast.LENGTH_SHORT).show();
                }
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void isSuccess(Object response, int ServiceCode) {
                if (ServiceCode==AppConstants.Operator_REQUEST)
                {
                    RootResponse OperatorResponse =(RootResponse) response;
                    ArrayList<ResultDataModel> models = OperatorResponse.result;
                    String[] OperatorList=new String[models.size()+1];
                    OperatorList[0]="Select Operator";
                    OperatorlistMap.put(0,"0");
                    for (int i=1;i<=models.size();i++) {
                        OperatorlistMap.put(i,models.get(i-1).opcodenew);
                        OperatorList[i]=models.get(i-1).operatorname;
                        editor.putString("operatorid",models.get(i-1).opcodenew.toString());
                        editor.apply();
                    }
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_text,OperatorList);
                    adapter.setDropDownViewResource(R.layout.spinner_item);
                    binding.spoperator.setAdapter(adapter);

                }else if (ServiceCode==AppConstants.PrepaidRecharge_REQUEST)
                {
                    RootRecharge recharge=(RootRecharge) response;
                    binding.tvtotalBalance.setText("\u20B9"+" " + recharge.result.balance.toString());
                    Toast.makeText(getApplicationContext(),recharge.result.mess.toString(),Toast.LENGTH_SHORT).show();
                    Log.d("recharge","response"+recharge.result.mess);
                }
            }
        };
        mApiManager=new ApiManager(this,mInterFace);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnRecharge:
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}