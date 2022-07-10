package com.example.paymentservice.ui.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.FragmentAllServicesBinding;

public class AllServicesActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentAllServicesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=FragmentAllServicesBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.All_Services);
        ColorDrawable drawable=new ColorDrawable(Color.parseColor("#300D83"));
        getSupportActionBar().setBackgroundDrawable(drawable);
        binding.cardprepad.setOnClickListener(this);
        binding.cardpospaid.setOnClickListener(this);
        binding.carddth.setOnClickListener(this);
        binding.cardlandline.setOnClickListener(this);
        binding.cardelectric.setOnClickListener(this);
        binding.cardGas.setOnClickListener(this);
        binding.cardinsurance.setOnClickListener(this);
        binding.cardbroadband.setOnClickListener(this);
        binding.cardplaystore.setOnClickListener(this);
        binding.cardfasttag.setOnClickListener(this);
        binding.carduilities.setOnClickListener(this);
        binding.cardgift.setOnClickListener(this);
        binding.cardbus.setOnClickListener(this);
        binding.cardflights.setOnClickListener(this);
        binding.cardrailway.setOnClickListener(this);
        binding.cardhotel.setOnClickListener(this);
        binding.cardwater.setOnClickListener(this);
        binding.cardloan.setOnClickListener(this);
        binding.cardcredit.setOnClickListener(this);
        binding.carddthconnection.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Intent intent = new Intent(AllServicesActivity.this, FragmentActivity.class);
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

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.cardprepad:
                startActivity(new Intent(AllServicesActivity.this,PrepaidActivity.class));
                break;
            case R.id.cardpospaid:
                startActivity(new Intent(AllServicesActivity.this,PostpaidActivity.class));
                break;
            case R.id.carddth:
                startActivity(new Intent(AllServicesActivity.this,DTHRechargeActivity.class));
                break;
            case R.id.cardinsurance:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardbroadband:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardelectric:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardGas:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardplaystore:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardfasttag:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardflights:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.carduilities:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardgift:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardbus:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardhotel:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardwater:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardloan:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardcredit:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.carddthconnection:
                Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}