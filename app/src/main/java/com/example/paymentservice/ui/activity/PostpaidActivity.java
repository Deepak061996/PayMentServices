package com.example.paymentservice.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivityPospaidBinding;
import com.example.paymentservice.ui.model.ResultDataModel;
import com.example.paymentservice.ui.model.RootRecharge;
import com.example.paymentservice.ui.model.RootResponse;
import com.example.paymentservice.ui.network.ApiManager;
import com.example.paymentservice.ui.network.ApiResponseInterface;
import com.example.paymentservice.ui.util.AppConstants;

import java.util.ArrayList;
import java.util.HashMap;

public class PostpaidActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityPospaidBinding binding;
    SharedPreferences loginpfe;
    SharedPreferences operator;
    private ApiManager mApiManager;
    SharedPreferences.Editor editor;
    private ApiResponseInterface mInterFace;
    private String token;
    private HashMap<Integer, String> OperatorlistMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityPospaidBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.Postpaid);
        ColorDrawable drawable=new ColorDrawable(Color.parseColor("#300D83"));
        getSupportActionBar().setBackgroundDrawable(drawable);
        loginpfe=getSharedPreferences("isLogin",MODE_PRIVATE);
        operator=getSharedPreferences("Opertaor",MODE_PRIVATE);
        editor=operator.edit();
        OperatorlistMap=new HashMap<>();
        setUpNetWork();
        {
            token=loginpfe.getString("token","null");
            String mobile="mobile";
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
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Intent intent = new Intent(PostpaidActivity.this, FragmentActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onNavigateUp() {
        super.onBackPressed();
        return super.onNavigateUp();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnRecharge:
                String mobile = binding.edmobile.getText().toString();
                String Amount = binding.edamount.getText().toString();
                String cus_id = loginpfe.getString("Cust_id", "null");
                String cus_type = loginpfe.getString("Cust_type", "null");
                String operator = binding.spoperator.getSelectedItem().toString();
//                String operator1 =operator.getString("operatorid","null");
                Log.d("name.....", "name" + operator);
                mApiManager.getPrepadiRechargeRequest(mobile, Amount, cus_id, cus_type, operator, token, AppConstants.PrepaidRecharge_REQUEST);
                break;
        }

    }
}