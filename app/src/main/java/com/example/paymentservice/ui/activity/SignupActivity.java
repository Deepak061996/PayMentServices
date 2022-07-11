package com.example.paymentservice.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivitySingupBinding;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    ActivitySingupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySingupBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.tvlogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tvlogin:
                startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                break;
        }
    }
}