package com.example.paymentservice.ui.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivityLoginBinding;
import com.example.paymentservice.databinding.ActivityOtpVerifyBinding;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View   view=binding.getRoot();
        setContentView(view);
//
//        TextView view=(TextView) findViewById(R.id.tvpostpaid);

        binding.btnNext.setOnClickListener(this);
        binding.tvcreate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_next:
                startActivity(new Intent(LoginActivity.this,FragmentActivity.class));
                break;
            case R.id.tvcreate:
                startActivity(new Intent(LoginActivity.this,SingupActivity.class));
                break;
        }
    }
}