package com.water.cloudplatform.activity.statusbar_style;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tozzais.baselibrary.ui.BaseActivity;
import com.water.cloudplatform.R;


public class ColorStatusBarActivity extends BaseActivity {

//    ImageStatusBar
    public static void launch(Context context){
        Intent intent = new Intent(context, ColorStatusBarActivity.class);
        context.startActivity(intent);

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_statusbar;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setBackTitle("设置状态栏颜色");
    }


    @Override
    public void loadData() {
        new Handler().postDelayed(() -> showContent(), 2000);
    }

    @Override
    public void initListener() {

    }


    @Override
    protected void setStatusBar() {
        super.setStatusBar();
    }
}
