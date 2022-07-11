package com.example.paymentservice.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivityPaymentReportBinding;
import com.example.paymentservice.databinding.ActivityRechargeReport2Binding;
import com.example.paymentservice.ui.adapter.PaymentHistoryAdapter;
import com.example.paymentservice.ui.adapter.RechargeReportAdapter;
import com.example.paymentservice.ui.model.ResultDataModel;
import com.example.paymentservice.ui.model.RootRecharge;
import com.example.paymentservice.ui.model.RootResponse;
import com.example.paymentservice.ui.network.ApiManager;
import com.example.paymentservice.ui.network.ApiResponseInterface;
import com.example.paymentservice.ui.util.AppConstants;
import com.example.paymentservice.ui.util.CommonUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RechargeReportActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<String> data;
    ActivityRechargeReport2Binding binding;
    SharedPreferences loginpfe;
    private ApiManager mApiManager;
    SharedPreferences.Editor editor;
    private ApiResponseInterface mInterFace;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRechargeReport2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        loginpfe=getSharedPreferences("isLogin",MODE_PRIVATE);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.Rechargerepoart);
        ColorDrawable drawable = new ColorDrawable(Color.parseColor("#300D83"));
        getSupportActionBar().setBackgroundDrawable(drawable);
        setUpNetWork();
        token=loginpfe.getString("token","null");
        String Mobile=loginpfe.getString("Cust_Mobile","null");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDate=formatter.format(date);
        mApiManager.getRechargeHistoryRequest(token,Mobile,currentDate, AppConstants.MobileRecharge_REQUEST);
        binding.imgfrom.setOnClickListener(this);
        binding.imgto.setOnClickListener(this);
        binding.btnsearch.setOnClickListener(this);

    }

    private void setUpNetWork() {
        mInterFace=new ApiResponseInterface() {
            @Override
            public void isError(String errorCode,int ServiceCode) {
                if (ServiceCode==AppConstants.MobileRecharge_REQUEST) {
                    Toast.makeText(getApplicationContext(),errorCode,Toast.LENGTH_SHORT).show();
                }
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void isSuccess(Object response, int ServiceCode) {
                if (ServiceCode==AppConstants.MobileRecharge_REQUEST)
                {
                    RootResponse OperatorResponse =(RootResponse) response;
                    ArrayList<ResultDataModel> models = OperatorResponse.result;
                     if (models!=null && models.size()>0) {
                         RechargeReportAdapter adapter = new RechargeReportAdapter(models, getApplicationContext());
                         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                         binding.recyclerviewActiveproperty.setLayoutManager(layoutManager);
                         binding.recyclerviewActiveproperty.setItemAnimator(new DefaultItemAnimator());
                         binding.recyclerviewActiveproperty.setAdapter(adapter);
                         binding.recyclerviewActiveproperty.setVisibility(View.VISIBLE);
                         binding.imgerror.setVisibility(View.GONE);
                     }else {
                         binding.recyclerviewActiveproperty.setVisibility(View.GONE);
                         binding.imgerror.setVisibility(View.VISIBLE);
                     }

                }
            }
        };
        mApiManager=new ApiManager(this,mInterFace);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Intent intent = new Intent(RechargeReportActivity.this, FragmentActivity.class);
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
            case R.id.imgfrom:
                final Calendar newCalendar = Calendar.getInstance();
                final DatePickerDialog  StartTime = new DatePickerDialog(RechargeReportActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        String myFormat="yyyy-MM-dd";
                        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
                        binding.edfromdate.setText(dateFormat.format(newDate.getTime()));
                    }
                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                StartTime.show();
                break;
            case R.id.imgto:
                final Calendar newCalendar1 = Calendar.getInstance();
                final DatePickerDialog  StartTime1 = new DatePickerDialog(RechargeReportActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        String myFormat="yyyy-MM-dd";
                        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
                        binding.edtodate.setText(dateFormat.format(newDate.getTime()));
                    }
                }, newCalendar1.get(Calendar.YEAR), newCalendar1.get(Calendar.MONTH), newCalendar1.get(Calendar.DAY_OF_MONTH));
                StartTime1.show();
                break;
            case R.id.btnsearch:
                String mobile=binding.edmobile.getText().toString();
//                String fromdate=binding.edfromdate.getText().toString();
//                String fromdate= CommonUtils.getDateFormat(binding.edfromdate.getText().toString());
//                String todate=CommonUtils.getDateFormat(binding.edfromdate.getText().toString());
                String datefrmate="yyyy-MM-dd";
                SimpleDateFormat dateFormat=new SimpleDateFormat(datefrmate, Locale.US);
                String fromdate=binding.edfromdate.getText().toString();
                String todate=binding.edtodate.getText().toString();
                Log.d("todate","date to"+todate);
                Log.d("todate","date to"+mobile);
                Log.d("fromdate","date to"+fromdate);
                mApiManager.getRechargeHistoryfromandtoRequest(token,mobile,fromdate,todate,AppConstants.MobileRecharge_REQUEST);
                break;
        }
    }

}