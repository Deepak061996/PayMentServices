package com.example.paymentservice.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
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
import com.example.paymentservice.databinding.ActivityDthreportBinding;

import com.example.paymentservice.ui.adapter.RechargeReportAdapter;
import com.example.paymentservice.ui.fragment.ReportFragment;

import java.util.ArrayList;

public class DTHReportActivity extends AppCompatActivity {

    ActivityDthreportBinding binding;
    private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDthreportBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.DTHrepoart);
        ColorDrawable drawable = new ColorDrawable(Color.parseColor("#300D83"));
        getSupportActionBar().setBackgroundDrawable(drawable);
//        RechargeReportAdapter adapter = new RechargeReportAdapter(data, getApplicationContext());
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        binding.recyclerviewActiveproperty.setLayoutManager(layoutManager);
//        binding.recyclerviewActiveproperty.setItemAnimator(new DefaultItemAnimator());
//        binding.recyclerviewActiveproperty.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Intent intent = new Intent(DTHReportActivity.this, FragmentActivity.class);
            startActivity(intent);
            finish();
//            FragmentTransaction  transaction=getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.DTHReportActivity,new ReportFragment()).commit();
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