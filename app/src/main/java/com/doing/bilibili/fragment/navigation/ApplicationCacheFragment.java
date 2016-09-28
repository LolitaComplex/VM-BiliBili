package com.doing.bilibili.fragment.navigation;

import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class ApplicationCacheFragment extends BaseStaticFragment {

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    public static BaseFragment newInstance() {
        return new ApplicationCacheFragment();
    }
}
