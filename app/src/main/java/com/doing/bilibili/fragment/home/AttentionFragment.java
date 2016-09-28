package com.doing.bilibili.fragment.home;

import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.entity.Response;

import rx.Observable;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class AttentionFragment extends BaseLoadingFragment {



    public static BaseFragment newInstance() {
        return new AttentionFragment();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void initViewWithData(Object data) {

    }

    @Override
    protected Observable<Response> retrofitData() {
        return null;
    }
}
