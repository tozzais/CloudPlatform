package com.water.cloudplatform.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tozzais.baselibrary.ui.BaseActivity;
import com.water.cloudplatform.fragment.MessageFragment;


public class ListActivity extends BaseActivity {


    public static void launch(Context context) {
        Intent intent = new Intent(context, ListActivity.class);
        context.startActivity(intent);

    }

    @Override
    public int getLayoutId() {
        return com.tozzais.baselibrary.R.layout.base_content;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setBackTitle("列表");
//        setRightText("切换");
        getSupportFragmentManager()
                .beginTransaction()
                .add(com.tozzais.baselibrary.R.id.content_container, new MessageFragment()).commit();
    }


    @Override
    public void loadData() {




    }

    @Override
    public void initListener() {

    }


}
