package com.doing.bilibili.baselib.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.Unbinder;

/**
 * Created by Doing on 2016/9/2.
 *
 */
public class BaseFragment extends RxFragment {

    protected Unbinder mBind;

    protected Context mContext;

    protected String TAG;

    protected int mContainerId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();

        if (getClass() != null) {
            String name = this.getClass().getName();
            TAG =  name.substring(name.lastIndexOf(".") + 1);
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public String getFragmentTag(){
        return TAG;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }

    public void setContainerId(int resId) {
        mContainerId = resId;
    }
}
