package com.water.cloudplatform.activity.statusbar_style;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.tozzais.baselibrary.ui.BaseActivity;
import com.water.cloudplatform.R;

import butterknife.OnClick;


public class StatusBarActivity extends BaseActivity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, StatusBarActivity.class);
        context.startActivity(intent);

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_statusbar;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setBackTitle("状态栏样式");


    }


    @Override
    public void loadData() {
        new Handler().postDelayed(() -> showContent(), 1000);
    }

    @Override
    public void initListener() {

    }


    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                break;
            case R.id.button2:
                ImageStatusBarActivity.launch(mContext);
                break;
            case R.id.button3:
                ImageStatusBarActivity.launch(mContext);
                break;
            case R.id.button4:
                MultiFragmentStatusBarActivity.launch(mContext);
                break;
        }
    }
}
