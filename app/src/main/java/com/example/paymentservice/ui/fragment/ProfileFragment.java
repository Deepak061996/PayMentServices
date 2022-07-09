package com.example.paymentservice.ui.fragment;

import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paymentservice.R;
import com.example.paymentservice.ui.base.BaseFragment;


public class ProfileFragment extends BaseFragment implements View.OnClickListener {



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
    }

    @Override
    public void onClick(View view) {

    }
}