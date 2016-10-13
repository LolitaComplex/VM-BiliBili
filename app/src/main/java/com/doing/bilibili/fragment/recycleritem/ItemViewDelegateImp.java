package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;

import com.doing.bilibili.base.RxBus;
import com.doing.bilibili.baselib.adapter.recyclerview.ItemViewDelegate;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.entity.bus.BusRecommend;
import com.doing.bilibili.entity.recommend.Recommend;
import com.doing.bilibili.net.RetrofitHelper;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public abstract class ItemViewDelegateImp<T> implements ItemViewDelegate<T> {

    protected Context mContext;

    public ItemViewDelegateImp(Context context) {
        this.mContext = context;
    }

    @Override
    public boolean isEnable() {
        return false;
    }

    protected void subscrib(final int position) {
        retrofitdata()
                .map(new Func1<Response<List<Recommend.BodyBean>>, List<Recommend.BodyBean>>() {
                    @Override
                    public List<Recommend.BodyBean> call(Response<List<Recommend.BodyBean>> listResponse) {
                        return listResponse.getResult() != null ? listResponse.getResult() : listResponse.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Recommend.BodyBean>>() {
                    @Override
                    public void call(List<Recommend.BodyBean> bodyBean) {
                        BusRecommend hotRecommend = new BusRecommend(bodyBean, position);
                        RxBus.getDefault().post(hotRecommend);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.show("更新数据失败");
                    }
                });
    }

    protected Observable<Response<List<Recommend.BodyBean>>> retrofitdata() {
        return null;
    }
}
