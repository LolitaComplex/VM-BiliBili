package com.doing.bilibili.baselib.adapter.recyclerview;

import android.support.v4.util.SparseArrayCompat;

/**
 * Created by Doing on 2016/9/18.
 *
 */
public class ItemViewDelegateManager<T> {

    private SparseArrayCompat<ItemViewDelegate<T>> mDelegates = new SparseArrayCompat<>();


    public int getItemViewDelegateCount() {
        return mDelegates.size();
    }

    public ItemViewDelegateManager<T> addDelegate(ItemViewDelegate<T> delegate) {
        int viewType = mDelegates.size();
        if (delegate != null) {
            mDelegates.put(viewType, delegate);
        }

        return this;
    }

    public ItemViewDelegateManager<T> addDelegate(int viewType, ItemViewDelegate<T> delegate) {
        if (mDelegates.get(viewType) != null) {
            throw new IllegalArgumentException("An ItemViewDelegate is already registered for the viewType = "
                                    + viewType + ". It's" + mDelegates.get(viewType));
        }
        mDelegates.put(viewType, delegate);
        return this;
    }

    public ItemViewDelegateManager<T> removeDelegate(ItemViewDelegate<T> delegate) {
        if (delegate == null) {
            throw new NullPointerException("ItemViewDelegate is null");
        }

        int typePosition = mDelegates.indexOfValue(delegate);
        if (typePosition >= 0) {
            mDelegates.remove(typePosition);
        }
        return this;
    }

    public ItemViewDelegateManager<T> removeDelegate(int itemType) {
        int indexToRemove = mDelegates.indexOfKey(itemType);
        if (indexToRemove >= 0) {
            mDelegates.removeAt(indexToRemove);
        }
        return this;
    }

    public ItemViewDelegate<T> getItemViewDelegate(int viewType) {
        return mDelegates.get(viewType);
    }

    public int getItemViewType(ItemViewDelegate<T> delegate) {
        if (delegate == null) {
            throw new NullPointerException("ItemViewDelegate is null");
        }

        return mDelegates.indexOfValue(delegate);
    }

    public int getItemViewType(T item, int position) {
        int delegatesCount = mDelegates.size();

        for (int i = 0; i < delegatesCount; i++) {
            ItemViewDelegate<T> itemViewDelegate = mDelegates.valueAt(i);
            if (itemViewDelegate.isForViewType(item,position)) {
                return mDelegates.keyAt(i);
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position = "
                                 + position + "in data source");
    }


    public void convert(BaseViewHolder holder, T item, int position) {
        int delegatesCount = mDelegates.size();
        for (int i = 0; i < delegatesCount; i++) {
            ItemViewDelegate<T> itemViewDelegate = mDelegates.valueAt(i);
            if (itemViewDelegate.isForViewType(item,position)) {
                itemViewDelegate.convert(holder, item, position);
                return;
            }
        }

        throw new IllegalArgumentException(
                "No ItemViewDelegateManager added that matches position=" + position + " in data source");
    }

}
