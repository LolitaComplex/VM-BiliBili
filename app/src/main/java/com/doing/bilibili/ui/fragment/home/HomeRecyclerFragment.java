package com.doing.bilibili.ui.fragment.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.utils.DensityUitls;
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

        /*
        据说是常用API 记一下咯 >_<!!!...
        mRecyclerView.scrollTo(100,0);
        mRecyclerView.scrollToPosition(1);
        mRecyclerView.smoothScrollToPosition(1);
        mRecyclerView.smoothScrollBy(100, 0);
        mRecyclerView.findViewHolderForPosition(1);
        mRecyclerView.findViewHolderForAdapterPosition(0);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        */
    }

    protected void initTransition() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
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
        } else {
            mBanner.isAutoPlay(false);
        }
    }

}
