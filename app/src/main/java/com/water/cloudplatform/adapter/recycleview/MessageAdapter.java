package com.water.cloudplatform.adapter.recycleview;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.water.cloudplatform.R;

import org.jetbrains.annotations.NotNull;


/**
 *
 */
public class MessageAdapter extends BaseQuickAdapter<String, BaseViewHolder> implements LoadMoreModule {

    public MessageAdapter() {
        super(R.layout.item_one, null);

    }


    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, @NotNull  String s) {
        int position = baseViewHolder.getLayoutPosition();
        baseViewHolder.setText(R.id.tv_title,position+"");
    }
}
