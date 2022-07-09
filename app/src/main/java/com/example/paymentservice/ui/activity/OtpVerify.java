package com.example.paymentservice.ui.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivityOtpVerifyBinding;


public class OtpVerify extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//          binding = ActivityOtpVerifyBinding.inflate(getLayoutInflater());
//          View view=binding.getRoot();
          setContentView(R.layout.activity_otp_verify);
//
        TextView view=(TextView) findViewById(R.id.tvpostpaid);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OtpVerify.this,FragmentActivity.class));
            }
        });
    }
}