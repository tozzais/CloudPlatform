package com.water.cloudplatform.activity.statusbar_style;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tozzais.baselibrary.ui.BaseActivity;
import com.tozzais.baselibrary.util.StatusBarUtil;
import com.water.cloudplatform.R;

import butterknife.OnClick;


/**
 * 半透明 全透明activity
 */
public class ImageStatusBarActivity extends BaseActivity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, ImageStatusBarActivity.class);
        context.startActivity(intent);

    }


    @Override
    public int getBaseLayout() {
        return R.layout.activity_image;
    }

    @Override
    public int getLayoutId() {
        return -1;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
    }


    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

    }


    @Override
    protected void setStatusBar() {
        //全透明 全屏 黑体字体状态栏
        StatusBarUtil.setTransparent(this);
        StatusBarUtil.setLightMode(this);

        //半透明 全屏 白色字体状态栏
//        StatusBarUtil.setTranslucent(this, 0);
//        StatusBarUtil.setDarkMode(this);
    }

    private boolean isChange = true;
    @OnClick(R.id.button5)
    public void onClick() {
        if (isChange){
            StatusBarUtil.setTranslucent(this, 0);
            StatusBarUtil.setDarkMode(this);
        }else {
            StatusBarUtil.setTransparent(this);
            StatusBarUtil.setLightMode(this);
        }
        isChange = !isChange;
    }
}
