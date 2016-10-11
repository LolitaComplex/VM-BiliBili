package com.doing.bilibili.fragment.detail;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.entity.Response;

import rx.Observable;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailSummaryFragment extends BaseLoadingFragment<Object> {

    public static BiliDetailSummaryFragment newInstance() {
        return new BiliDetailSummaryFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bilidetail_summary;
    }

    @Override
    public void initViewWithData(Object data) {

    }

    @Override
    protected Observable<Response<Object>> retrofitData() {
        return null;
    }
}
