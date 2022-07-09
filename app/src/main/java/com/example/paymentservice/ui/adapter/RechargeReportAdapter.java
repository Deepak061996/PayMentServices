package com.example.paymentservice.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paymentservice.databinding.PaymenthistorysinglerowBinding;
import com.example.paymentservice.databinding.RechargereportrowBinding;

import java.util.ArrayList;

public class RechargeReportAdapter extends RecyclerView.Adapter<RechargeReportAdapter.MyViewHolder> {


    private ArrayList<String> data;
    private Context context;
    RechargereportrowBinding binding;

    public RechargeReportAdapter(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RechargereportrowBinding binding;
        public MyViewHolder(@NonNull RechargereportrowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        binding=RechargereportrowBinding.inflate(inflater,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }


}
