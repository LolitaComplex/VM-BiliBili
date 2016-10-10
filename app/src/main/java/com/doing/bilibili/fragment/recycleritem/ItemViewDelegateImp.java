package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;

import com.doing.bilibili.baselib.adapter.recyclerview.ItemViewDelegate;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public abstract class ItemViewDelegateImp<T> implements ItemViewDelegate<T> {

    protected Context mContext;

    public ItemViewDelegateImp(Context context) {
        this.mContext = context;
    }

    @Override
    public boolean isEnable() {
        return false;
    }
}
