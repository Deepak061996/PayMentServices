package com.example.paymentservice.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivityPaymentReportBinding;
import com.example.paymentservice.databinding.ActivityRechargeReport2Binding;
import com.example.paymentservice.ui.adapter.PaymentHistoryAdapter;
import com.example.paymentservice.ui.adapter.RechargeReportAdapter;

import java.util.ArrayList;

public class RechargeReportActivity extends AppCompatActivity {

    private ArrayList<String> data;
    ActivityRechargeReport2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRechargeReport2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.Rechargerepoart);
        ColorDrawable drawable = new ColorDrawable(Color.parseColor("#300D83"));
        getSupportActionBar().setBackgroundDrawable(drawable);
        RechargeReportAdapter adapter = new RechargeReportAdapter(data, getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerviewActiveproperty.setLayoutManager(layoutManager);
        binding.recyclerviewActiveproperty.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerviewActiveproperty.setAdapter(adapter);
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
}