package com.doing.bilibili.baselib.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.Unbinder;
import rx.Subscription;

/**
 * Created by Doing on 2016/9/2.
 *
 */
public class BaseFragment extends RxFragment {

    protected Unbinder mBind;

    protected Context mContext;

    protected String TAG;

    protected int mContainerId;

    protected Subscription mSubscription;

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.e("FragmentStyle", "onAttachFragment");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("FragmentStyle", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();

        Log.e("FragmentStyle", "onCreateView");

        if (getClass() != null) {
            String name = this.getClass().getName();
            TAG =  name.substring(name.lastIndexOf(".") + 1);
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        subscirp();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        RecyclerView recyclerView = new RecyclerView(mContext);
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        manager.findViewByPosition(1);
        recyclerView.findViewById(0);
        recyclerView.findViewHolderForLayoutPosition(0);
    }

    //================= 模板方法 ==============
    protected void subscirp() {
    }

}
