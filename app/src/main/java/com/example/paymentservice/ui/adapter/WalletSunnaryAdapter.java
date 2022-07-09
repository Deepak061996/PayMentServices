package com.example.paymentservice.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.WalletsinglerowBinding;

import java.util.ArrayList;

public class WalletSunnaryAdapter extends RecyclerView.Adapter<WalletSunnaryAdapter.MyViewHolder> {


    private ArrayList<String> data;
    private Context context;
    WalletsinglerowBinding binding;

    public WalletSunnaryAdapter(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        WalletsinglerowBinding binding;
        public MyViewHolder(@NonNull WalletsinglerowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        binding=WalletsinglerowBinding.inflate(inflater,parent,false);
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
