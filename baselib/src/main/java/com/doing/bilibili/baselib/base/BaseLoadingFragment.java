package com.doing.bilibili.baselib.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.ui.LoadingPage;
import com.doing.bilibili.baselib.ui.LoadingPage.LoadRusult;
import com.doing.bilibili.baselib.utils.BaseUtil;
import com.doing.bilibili.baselib.utils.UIUtils;

import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public abstract class BaseLoadingFragment<T> extends BaseFragment {

    private LoadingPage<T> mLoadingPage;

    private boolean mDataIsShowing = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (mLoadingPage == null) {
            mLoadingPage = new LoadingPage<T>(mContext) {
                @Override
                protected View createSuccessView() {
                    BaseLoadingFragment.this.initVariable();

                    View inflate = UIUtils.inflate(getLayoutId());
                    ButterKnife.bind(BaseLoadingFragment.this, inflate);
                    BaseLoadingFragment.this.initView();
                    return inflate;
                }

                @Override
                protected LoadRusult load(T t) {
                    return BaseLoadingFragment.this.checkData(t);
                }

                @Override
                protected Observable<Response<T>> retrofitData() {
                    return BaseLoadingFragment.this.retrofitData();
                }

                @Override
                protected void initViewWithData(T t) {
                    BaseLoadingFragment.this.initViewWithData(t);
                }

                @Override
                protected Observable.Transformer<T, T> bindToLifecycle() {
                    return BaseLoadingFragment.this.bindToLifecycle();
                }
            };
        } else {
            BaseUtil.removeParent(mLoadingPage);
        }

        return mLoadingPage;
    }

    public void show() {
        if (mLoadingPage != null && !mDataIsShowing) {
            mLoadingPage.show();
        }
    }

    public void showImmediate(){
        if (mLoadingPage != null) {
            mLoadingPage.show();
        }
    }

    protected void setDataIsShowing(boolean isShowing) {
        this.mDataIsShowing = isShowing;
    }


    //============== 模板方法 ==================

    protected void initVariable(){}

    @LayoutRes
    protected abstract int getLayoutId();

    protected void initView(){}

    public abstract void initViewWithData(T data);

    protected LoadRusult checkData(T datas) {
        return LoadRusult.success;
    }

    protected abstract Observable<Response<T>> retrofitData();

}
