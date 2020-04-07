package com.water.cloudplatform.activity;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tozzais.baselibrary.ui.CheckPermissionActivity;
import com.tozzais.baselibrary.util.log.LogUtil;
import com.water.cloudplatform.R;

import butterknife.OnClick;


public class PermissionActivity extends CheckPermissionActivity {




    public static String[] needPermissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public static String[] needPermissions1 = {
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public static void launch(Context context) {
        Intent intent = new Intent(context, PermissionActivity.class);
        context.startActivity(intent);

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_permission;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setBackTitle("权限申请");


    }


    @Override
    public void loadData() {
    }

    @Override
    public void initListener() {

    }


    @OnClick({R.id.button, R.id.button1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                checkPermissions(needPermissions);
                break;
            case R.id.button1:
                checkPermissions(needPermissions1);
                break;
        }
    }

    @Override
    public void permissionGranted() {
        LogUtil.e("permissionGranted ");
    }
}
