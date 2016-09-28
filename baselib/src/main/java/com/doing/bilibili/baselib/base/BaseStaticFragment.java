package com.doing.bilibili.baselib.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public abstract class BaseStaticFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View inflate = inflater.inflate(getLayoutId(), container, false);

        initVariable();

        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBind = ButterKnife.bind(this, view);
        initView();
    }

    //============== 模板方法 ==================

    protected void initVariable() {}

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initView();
}
