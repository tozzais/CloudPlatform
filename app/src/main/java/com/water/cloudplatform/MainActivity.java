package com.water.cloudplatform;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tozzais.baselibrary.http.RxHttp;
import com.tozzais.baselibrary.ui.BaseActivity;
import com.tozzais.baselibrary.util.sign.SignUtil;
import com.water.cloudplatform.activity.ListActivity;
import com.water.cloudplatform.activity.PermissionActivity;
import com.water.cloudplatform.activity.statusbar_style.StatusBarActivity;
import com.water.cloudplatform.http.ApiManager;
import com.water.cloudplatform.http.BaseResult;
import com.water.cloudplatform.http.Response;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

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
//        button.setText("hello world");
    }


    @Override
    public void initListener() {


    }

    @OnClick({R.id.button, R.id.button1, R.id.button2, R.id.button3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                StatusBarActivity.launch(mActivity);
                break;
            case R.id.button1:
                PermissionActivity.launch(mActivity);
                break;
            case R.id.button2:
                ListActivity.launch(mActivity);
                break;
            case R.id.button3:
                login();
                break;
        }
    }

    private void login(){
        TreeMap<String, String> hashMap = new TreeMap<>();
        hashMap.put("phone", "13166015579");
        hashMap.put("password", "123456");
        hashMap.put("sign", SignUtil.getMd5(hashMap));
        new RxHttp<BaseResult>().send(ApiManager.getService().getlogin(hashMap),
                new Response<BaseResult>(mActivity) {
                    @Override
                    public void onSuccess(BaseResult result) {

                    }
                });
    }


}
