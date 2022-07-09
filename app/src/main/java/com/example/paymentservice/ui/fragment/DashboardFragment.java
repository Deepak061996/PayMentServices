package com.example.paymentservice.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.DashboardFragmentBinding;
import com.example.paymentservice.ui.activity.OtpVerify;
import com.example.paymentservice.ui.base.BaseFragment;


public class DashboardFragment extends BaseFragment implements View.OnClickListener{

    DashboardFragmentBinding binding;
    NavController  navController;
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

        binding.cardprepad.setOnClickListener(this);
        binding.cardpospaid.setOnClickListener(this);
        binding.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "jvdhjdvhjd", Toast.LENGTH_SHORT).show();
            }
        });



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
        }
    }
}