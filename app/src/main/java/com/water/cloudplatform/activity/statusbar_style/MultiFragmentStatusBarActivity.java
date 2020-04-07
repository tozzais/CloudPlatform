package com.water.cloudplatform.activity.statusbar_style;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.tozzais.baselibrary.ui.BaseActivity;
import com.tozzais.baselibrary.util.StatusBarUtil;
import com.water.cloudplatform.R;

import butterknife.BindView;
import butterknife.OnClick;


public class MultiFragmentStatusBarActivity extends BaseActivity {

    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.iv_category)
    ImageView ivCategory;
    @BindView(R.id.tv_category)
    TextView tvCategory;


    private int mPosition;//当前选中的底部菜单
    private FragmentManager fragmentManager;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;


    public static final int HOME = 0;
    public static final int CATEGORY = 1;

    private static final String TAG_HOME = "tag_home";

    private static final String TAG_CATEGROY = "tag_categroy";

    public static void launch(Context context){
        Intent intent = new Intent(context, MultiFragmentStatusBarActivity.class);
        context.startActivity(intent);
    }


    @Override
    public int getBaseLayout() {
        return R.layout.activity_main_tab;
    }

    @Override
    public int getLayoutId() {
        return -1;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //必须添加判断。否则重叠还会出现 因为取不出对应的fragment
        if (fragmentManager == null)
        fragmentManager = getSupportFragmentManager();
        selectFragment(HOME);
    }


    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

    }


    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTransparentForImageViewInFragment(this, null);
        StatusBarUtil.setLightMode(this);
    }



    public void selectFragment(int position) {
        switch (position) {
            case HOME:
                mPosition = HOME;
                StatusBarUtil.setDarkMode(this);
                setTabChecked(mPosition);
                setTabSelection(mPosition);
                break;
            case CATEGORY:
                StatusBarUtil.setLightMode(this);
                mPosition = CATEGORY;
                setTabChecked(mPosition);
                setTabSelection(mPosition);
                break;
        }


    }

    /**
     * 设置底部菜单被选中后字体、图片的颜色
     *
     * @param pos
     */
    private void setTabChecked(int pos) {
        ivHome.setImageResource(pos == HOME ? R.mipmap.home_selete : R.mipmap.home);
        tvHome.setTextColor(pos == HOME ? getResources().getColor(R.color.baseColor) : getResources().getColor(R.color.main_tab_gray_text_color));
        ivCategory.setImageResource(pos == CATEGORY ? R.mipmap.category_selete : R.mipmap.category);
        tvCategory.setTextColor(pos == CATEGORY ? getResources().getColor(R.color.baseColor) : getResources().getColor(R.color.main_tab_gray_text_color));

    }

    private void setTabSelection(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();//开启Fragment事务
        hideFragments(transaction);//隐藏所有页面（）
        switch (position) {
            case HOME:
                if (oneFragment == null) {
                    oneFragment = new OneFragment();
                    transaction.add(R.id.fl_container, oneFragment, TAG_HOME);
                } else {
                    transaction.show(oneFragment);
                }
                break;

            case CATEGORY:
                if (twoFragment == null) {
                    twoFragment = new TwoFragment();
                    transaction.add(R.id.fl_container, twoFragment, TAG_CATEGROY);
                } else {
                    transaction.show(twoFragment);
                }
                break;

        }
        // 提交
        transaction.commit();
    }

    /**
     * 隐藏所有的页面
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (oneFragment != null) {
            transaction.hide(oneFragment);
        }
        if (twoFragment != null) {
            transaction.hide(twoFragment);
        }

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            fragmentManager = getSupportFragmentManager();
            oneFragment = (OneFragment) fragmentManager.findFragmentByTag(TAG_HOME);
            twoFragment = (TwoFragment) fragmentManager.findFragmentByTag(TAG_CATEGROY);
        }
        mPosition = savedInstanceState.getInt("mPosition");
        selectFragment(mPosition);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mPosition", mPosition);
    }

    @OnClick({R.id.ll_home, R.id.ll_category, R.id.ll_community, R.id.ll_cart, R.id.ll_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                selectFragment(HOME);
                break;
            case R.id.ll_category:
                selectFragment(CATEGORY);
                break;
        }
    }
}
