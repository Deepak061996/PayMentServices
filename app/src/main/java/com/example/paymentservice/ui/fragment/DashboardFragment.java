package com.example.paymentservice.ui.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.DashboardFragmentBinding;
import com.example.paymentservice.ui.base.BaseFragment;
import com.example.paymentservice.ui.model.BannerDataModel;
import com.example.paymentservice.ui.model.RootResponse;
import com.example.paymentservice.ui.network.ApiManager;
import com.example.paymentservice.ui.network.ApiResponseInterface;
import com.example.paymentservice.ui.util.AppConstants;

import java.util.ArrayList;


public class DashboardFragment extends BaseFragment implements View.OnClickListener{

    DashboardFragmentBinding binding;
    NavController  navController;
    SharedPreferences.Editor editor;
    SharedPreferences loginfre;
    SharedPreferences dashboard;
    private ApiManager mApiManager;
    private ApiResponseInterface mInterFace;
    public static DashboardFragment newInstance(Bundle args) {
        DashboardFragment fragment = new DashboardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void init() {
        layoutId=R.layout.dashboard_fragment;
    }
    @Override
    protected void setUpUi(View view, ViewDataBinding viewDataBinding) {
        binding = (DashboardFragmentBinding) viewDataBinding;
        navController= NavHostFragment.findNavController(this);
        loginfre=getActivity().getSharedPreferences("isLogin",MODE_PRIVATE);
        dashboard=getActivity().getSharedPreferences("Dashboard",MODE_PRIVATE);
        editor=dashboard.edit();
        setUpNetWork();
        Log.d("token","responsepoint1"+loginfre.getString("token","null"));
        Log.d("mobile","responsepoint1"+loginfre.getString("Cust_Mobile","null"));
        String token=loginfre.getString("token","null");
        String mobile=loginfre.getString("Cust_Mobile","null");
        {
          mApiManager.getWalletBalanceRequest(token,mobile,AppConstants.WalletBalance_REQUEST);
        }

        mApiManager.getDashboardRequest(token,mobile,AppConstants.Dashboard_REQUEST);
        binding.cardprepad.setOnClickListener(this);
        binding.cardpospaid.setOnClickListener(this);
        binding.carddth.setOnClickListener(this);
        binding.cardlandline.setOnClickListener(this);
        binding.cardelectric.setOnClickListener(this);
        binding.cardGas.setOnClickListener(this);
        binding.cardinsurance.setOnClickListener(this);
        binding.cardbroadband.setOnClickListener(this);
        binding.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "jvdhjdvhjd", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpNetWork() {

        mInterFace=new ApiResponseInterface() {
            @Override
            public void isError(String errorCode, int ServiceCode) {

            }

            @Override
            public void isSuccess(Object response, int ServiceCode) {
                if (ServiceCode==AppConstants.Dashboard_REQUEST) {
                    RootResponse rootDashboard = (RootResponse) response;
                    Log.d("DashBoard","onresponse"+rootDashboard.news);
                    ArrayList<BannerDataModel> models=rootDashboard.banner;
                    for (int i=0;i<models.size();i++)
                    {

                    }
                }else if (ServiceCode==AppConstants.WalletBalance_REQUEST)
                {
                    RootResponse rootDashboard = (RootResponse) response;
                    editor.putInt("balance",rootDashboard.walletBalance);
                    editor.apply();
                    binding.tvbalance.setText("\u20B9"+" "+rootDashboard.walletBalance);
                }
            }
        };
        mApiManager=new ApiManager(getContext(),mInterFace);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.cardprepad:
                navController.navigate(R.id.prepaidActivity);
                break;
            case R.id.cardpospaid:
                navController.navigate(R.id.pospaidActivity);
                break;
            case R.id.carddth:
                navController.navigate(R.id.DTHRechargeActivity);
                break;
            case R.id.cardlandline:
                Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardelectric:
                Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardGas:
                Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardinsurance:
                Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardbroadband:
                Toast.makeText(getContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}