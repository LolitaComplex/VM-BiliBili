package com.doing.bilibili.baselib.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;

/**
 * Created by Doing on 2016/9/18.
 *
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {

    protected int mLayoutId;
    protected LayoutInflater mInflater;

    public CommonAdapter(final Context context, final int layoutId, List<T> data) {
        super(context, data);
        this.mLayoutId = layoutId;
        this.mInflater = LayoutInflater.from(context);

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(BaseViewHolder holder, T t, int position) {
                CommonAdapter.this.convert(holder, t, position);
            }
        });

    }


    protected abstract void convert(BaseViewHolder holder, T t, int positon);
}
