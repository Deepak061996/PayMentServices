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
import com.example.paymentservice.databinding.ActivityWalletSummaryBinding;
import com.example.paymentservice.ui.adapter.WalletSunnaryAdapter;
import java.util.ArrayList;

public class WalletSummaryActivity extends AppCompatActivity {
    ActivityWalletSummaryBinding binding;
    private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWalletSummaryBinding.inflate(getLayoutInflater());
        View  view=binding.getRoot();
        setContentView(view);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(R.string.Walletsummary);
        ColorDrawable drawable=new ColorDrawable(Color.parseColor("#300D83"));
        getSupportActionBar().setBackgroundDrawable(drawable);
        WalletSunnaryAdapter adapter=new WalletSunnaryAdapter(data,getApplicationContext());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        binding.recyclerviewActiveproperty.setLayoutManager(layoutManager);
        binding.recyclerviewActiveproperty.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerviewActiveproperty.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Intent intent = new Intent(WalletSummaryActivity.this, FragmentActivity.class);
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