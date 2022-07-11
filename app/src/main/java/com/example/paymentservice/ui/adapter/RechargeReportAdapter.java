package com.example.paymentservice.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.paymentservice.R;
import com.example.paymentservice.databinding.PaymenthistorysinglerowBinding;
import com.example.paymentservice.databinding.RechargereportrowBinding;
import com.example.paymentservice.ui.model.ResultDataModel;
import com.example.paymentservice.ui.network.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RechargeReportAdapter extends RecyclerView.Adapter<RechargeReportAdapter.MyViewHolder> {


    private ArrayList<ResultDataModel> data;
    private Context context;
    RechargereportrowBinding binding;

    public RechargeReportAdapter(ArrayList<ResultDataModel> data, Context context) {
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ResultDataModel models=data.get(position);
        holder.binding.tvmobile.setText(models.mobileno.toString());
        holder.binding.tvrs.setText("\u20B9"+" "+models.amount.toString());
        holder.binding.tvoperator.setText(models.operatorname.toString());
        holder.binding.dateandtome.setText(models.reqdate.toString());
        String logo=ApiClient.BASE_URL+models.operatorImage;
        Log.d("image","result"+logo);
        Picasso.with(context)
                .load(logo)
                .into(holder.binding.imgoperator);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
