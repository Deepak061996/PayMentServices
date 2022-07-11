package com.example.paymentservice.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.FragmentProfileBinding;
import com.example.paymentservice.ui.base.BaseFragment;


public class ProfileFragment extends BaseFragment implements View.OnClickListener {


    FragmentProfileBinding binding;
    SharedPreferences loginpfe;
    public static ProfileFragment newInstance(Bundle args) {
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void init() {
        layoutId=R.layout.fragment_profile;
    }

    @Override
    protected void setUpUi(View view, ViewDataBinding viewBinding) {
        super.setUpUi(view, viewBinding);
        binding=(FragmentProfileBinding) viewBinding;
        loginpfe=getContext().getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        makeEdiBox(false);
        binding.edname.setText(loginpfe.getString("Cust_name","null"));
        binding.edtype.setText(loginpfe.getString("Cust_type","null"));
        binding.edcusid.setText(loginpfe.getString("Cust_id","null"));
        binding.edmobile.setText(loginpfe.getString("Cust_Mobile","null"));
        binding.edstate.setText(loginpfe.getString("Cust_state","null"));
        binding.edcity.setText(loginpfe.getString("Cust_city","null"));
        binding.edemail.setText(loginpfe.getString("Cust_email","null"));
        binding.edpincode.setText(loginpfe.getString("Cust_pincode","null"));
    }

    private void makeEdiBox(boolean isclick) {
        if (isclick)
        {
            binding.edname.setEnabled(true);
            binding.edtype.setEnabled(true);
            binding.edmobile.setEnabled(true);
            binding.edstate.setEnabled(true);
            binding.edcity.setEnabled(true);
            binding.edemail.setEnabled(true);
            binding.edpincode.setEnabled(true);
        }else {
            binding.edname.setEnabled(false);
            binding.edtype.setEnabled(false);
            binding.edmobile.setEnabled(false);
            binding.edstate.setEnabled(false);
            binding.edcity.setEnabled(false);
            binding.edemail.setEnabled(false);
            binding.edpincode.setEnabled(false);
        }
    }

    @Override
    public void onClick(View view) {

    }
}