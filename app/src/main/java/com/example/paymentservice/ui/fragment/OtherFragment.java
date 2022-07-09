package com.example.paymentservice.ui.fragment;

import android.os.Bundle;

import androidx.databinding.ViewDataBinding;

import android.view.View;


import com.example.paymentservice.R;
import com.example.paymentservice.ui.base.BaseFragment;


public class OtherFragment extends BaseFragment implements View.OnClickListener {

    public static OtherFragment newInstance(Bundle args) {
        OtherFragment fragment = new OtherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void init() {
        layoutId=R.layout.fragment_other;
    }

    @Override
    protected void setUpUi(View view, ViewDataBinding viewBinding) {
        super.setUpUi(view, viewBinding);
    }

    @Override
    public void onClick(View view) {

    }
}