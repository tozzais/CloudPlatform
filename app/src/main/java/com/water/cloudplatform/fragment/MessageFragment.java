package com.water.cloudplatform.fragment;

import android.os.Bundle;
import android.os.Handler;

import com.tozzais.baselibrary.ui.BaseList1Fragment;
import com.tozzais.baselibrary.ui.BaseListFragment;
import com.tozzais.baselibrary.util.log.LogUtil;
import com.water.cloudplatform.adapter.recycleview.MessageAdapter;
import com.water.cloudplatform.util.DataUtil;


public class MessageFragment extends BaseList1Fragment<String> {




    public static MessageFragment newInstance(int type){
        MessageFragment cartFragment = new MessageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        cartFragment.setArguments(bundle);
        return cartFragment;

    }


    @Override
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mAdapter = new MessageAdapter();
        mRecyclerView.setAdapter(mAdapter);
        setEmptyView("暂无消息");

    }

    @Override
    public void loadData() {
        super.loadData();
        getData();
    }


    private int i = 0;

    private void getData(){
        LogUtil.e("page = "+page+","+"PageSize = "+PageSize);
        new Handler().postDelayed(()->{
            if (i % 3 ==  0){
                setData(DataUtil.getData(11));
            }else if (i % 3 ==  1 ){
                onErrorResult("出错了");
            }else if (i % 3 ==  2){
                setData(DataUtil.getData(8));
            }
            i++;
        },500);


    }

}
