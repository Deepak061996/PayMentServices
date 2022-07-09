package com.example.paymentservice.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.paymentservice.R;
import com.example.paymentservice.databinding.ActivityFragmentBinding;
import com.example.paymentservice.databinding.ActivityLoginBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener
{

    private AppBarLayout appBarLayout;
    NavController navController;
    ActivityFragmentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_fragment);
//        setContentView(R.layout.activity_fragment);
        navController= Navigation.findNavController(this,R.id.fragmentContainerView);
        setSupportActionBar(binding.toolbar);

        AppBarConfiguration appBarConfiguration=new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(binding.toolbar,navController,appBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this,navController,binding.drawerLayout);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                getSupportActionBar().setDisplayShowHomeEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.allServicesActivity);

            }
        });
        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        navController.navigate(R.id.dashboardFragment);
                        break;
                    case R.id.Other:
                        navController.navigate(R.id.otherFragment);
                        break;
                    case R.id.Report:
                        navController.navigate(R.id.roportFragment);
                        break;
                    case R.id.Profile:
                        navController.navigate(R.id.profileFragment);
                        break;
                }
                return false;
            }
        });
    }

//    public boolean onOptionItemSelected(MenuItem item) {
//
//        switch (item.getItemId())
//        {
//            case android.R.id.home:
//                item.getActionView().setVisibility(View.GONE);
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View view) {

    }
}