package com.example.paymentservice.ui.fragment;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;
import com.example.paymentservice.R;
import com.example.paymentservice.databinding.FragmentRoportBinding;
import com.example.paymentservice.ui.base.BaseFragment;


public class ReportFragment extends BaseFragment implements View.OnClickListener{

  FragmentRoportBinding binding;
  NavController navController;

    public static ReportFragment newInstance(Bundle args) {
        ReportFragment fragment = new ReportFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected void init() {
        layoutId=R.layout.fragment_roport;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void setUpUi(View view, ViewDataBinding viewDataBinding) {
        binding = (FragmentRoportBinding) viewDataBinding;
        navController= NavHostFragment.findNavController(this);
//        navController= Navigation.findNavController(getActivity(),R.id.fragmentContainerView);
        binding.card2.setOnClickListener(this);
        binding.card5.setOnClickListener(this);
        binding.card7.setOnClickListener(this);
        binding.card11.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.card2:
                navController.navigate(R.id.walletSummaryActivity);
                break;
            case R.id.card5:
                navController.navigate(R.id.paymentReport);
                break;
            case R.id.card7:
                navController.navigate(R.id.rechargeReportActivity);
                break;
            case R.id.card11:
                navController.navigate(R.id.DTHReportActivity);
                break;

        }
    }
}