package com.example.paymentservice.ui.base;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.paymentservice.R;

import java.util.List;

public class BaseFragment extends Fragment {
    private static final int REQUEST_LOCATION = 101;
    private BaseFragmentInterface interFace;

    protected int layoutId = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = null;
        init();
        ViewDataBinding viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        if (viewBinding != null) {
            view = viewBinding.getRoot();
            setUpUi(view, viewBinding);
        }
 
       
     
         

        return view;
    }


    protected void setUpUi(View view, ViewDataBinding viewBinding) {
    }

    protected void init() {

    }
    protected void setUpUi(Bundle savedInstanceState) {

    }

    public void showDialog(Activity activity, String msg, boolean isCancelBtnVisible, final boolean isClickable, final int Id){
        try {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.alert_dialog);

            TextView text = dialog.findViewById(R.id.text_dialog);
            text.setText(msg);

            Button dialogOKButton = dialog.findViewById(R.id.btn_ok);

            dialogOKButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    if (isClickable)
                        BaseFragment.this.okDialogClick(Id);
                }
            });

            Button dialogCancelButton = dialog.findViewById(R.id.btn_cancel);
            if (isCancelBtnVisible) {
                dialogCancelButton.setVisibility(View.VISIBLE);
            } else {
                dialogCancelButton.setVisibility(View.GONE);

            }
            dialogCancelButton.setOnClickListener(v -> {
                dialog.dismiss();
                if (isClickable)
                    BaseFragment.this.cancelDialogClick(Id);
            });


            dialog.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    private void cancelDialogClick(int id) {
    }

    private void okDialogClick(int id) {
    }


}



