package com.doing.bilibili.fragment.home;

import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.entity.recommend.HomeRecommend;

import rx.Observable;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class DiscoverFragment extends BaseLoadingFragment {


    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void initViewWithData(Object data) {

    }

    @Override
    protected Observable<Response<HomeRecommend>> retrofitData() {
        return null;
    }

    public static BaseFragment newInstance() {
        return new DiscoverFragment();
    }
}
