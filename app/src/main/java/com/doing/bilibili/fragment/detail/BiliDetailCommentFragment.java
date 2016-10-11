package com.doing.bilibili.fragment.detail;

import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.entity.Response;

import rx.Observable;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailCommentFragment extends BaseLoadingFragment<Object> {

    public static BiliDetailCommentFragment newInstance() {
        return new BiliDetailCommentFragment();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void initViewWithData(Object data) {

    }

    @Override
    protected Observable<Response<Object>> retrofitData() {
        return null;
    }
}
