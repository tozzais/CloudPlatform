package com.water.cloudplatform;


import android.os.Bundle;

import com.tozzais.baselibrary.ui.BaseActivity;

public class MainActivity extends BaseActivity {



    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void initView(Bundle savedInstanceState) {
        setBackTitle("首页");
        setRightText("设置");
    }

    @Override
    public void loadData() {

    }


    @Override
    public void initListener() {


    }
}
