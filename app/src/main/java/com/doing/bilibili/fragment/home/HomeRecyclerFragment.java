package com.doing.bilibili.fragment.home;

import android.animation.TimeInterpolator;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.utils.DensityUitls;
import com.doing.bilibili.baselib.utils.LogUtils;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.List;

import butterknife.BindView;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;

/**
 * Created by Doing on 2016/9/22.
 *
 */
public abstract class HomeRecyclerFragment<T> extends BaseLoadingFragment<T> {

    @BindView(R.id.RefreshFragment_recycler)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.RefreshFragment_refreshlayout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.RefreshFragment_root)
    protected ViewGroup rootView;

    protected Banner mBanner;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_common;
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                HomeRecyclerFragment.this.showImmediate();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        mRecyclerView.setItemAnimator(new FadeInAnimator());

        initTransition();
    }

    protected void initTransition() {
        rootView.post(new Runnable() {
            @Override
            public void run() {
                AutoTransition transition = new AutoTransition();
                transition.setDuration(300);
                transition.setInterpolator(new DecelerateInterpolator());
                TransitionManager.beginDelayedTransition(rootView, transition);

                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mSwipeRefreshLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                mSwipeRefreshLayout.setLayoutParams(layoutParams);
            }
        });

    }

    protected Banner initBanner(List<String> imageUrlList) {
        Banner banner = (Banner) UIUtils.inflate(R.layout.item_banner);
        banner.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUitls.dip2px(110)));
        if (imageUrlList != null && imageUrlList.size() > 1) {
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            banner.setIndicatorGravity(BannerConfig.RIGHT);
        }
        banner.setImages(imageUrlList);

        mBanner = banner;
        return banner;
    }

    @Override
    public void initViewWithData(T data) {
        //设置该页面已经首次加载成功数据
        setDataIsShowing(true);
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mBanner != null) {
            mBanner.isAutoPlay(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mBanner != null) {
            mBanner.isAutoPlay(false);
        }
    }

    public void operatorBanner(boolean boo) {
        if (mBanner == null) {
            return;
        }

        if (boo) {
            mBanner.isAutoPlay(true);
        }else {
            mBanner.isAutoPlay(false);
        }
    }

}
