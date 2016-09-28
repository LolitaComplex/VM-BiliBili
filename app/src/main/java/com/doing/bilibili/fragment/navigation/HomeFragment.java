package com.doing.bilibili.fragment.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.MainActivityCallback;
import com.doing.bilibili.adapter.HomeFragmentPagerAdapter;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;
import com.doing.bilibili.baselib.utils.LogUtils;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.fragment.factory.HomeFragmentFactory;
import com.doing.bilibili.fragment.home.HomeRecyclerFragment;

import butterknife.BindView;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class HomeFragment extends BaseStaticFragment {

    @BindView(R.id.HomeFragment_viewpager)
    protected ViewPager mViewPager;
    private static HomeFragmentPagerAdapter  adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        adapter = new HomeFragmentPagerAdapter(getChildFragmentManager());
//
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = HomeFragmentFactory.createFragment(position);
                if (fragment instanceof BaseLoadingFragment) {
                    ((BaseLoadingFragment) fragment).show();
                }

                if (fragment instanceof HomeRecyclerFragment) {
                    ((HomeRecyclerFragment)fragment).operatorBanner(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        for(Fragment fragment : getChildFragmentManager ().getFragments()){
                            if (fragment instanceof HomeRecyclerFragment) {
                                ((HomeRecyclerFragment)fragment).operatorBanner(false);
                            }
                        }
                        break;
                }
            }
        });
        ((MainActivityCallback)mContext).initTabLayout(mViewPager);
    }

    public static BaseFragment newInstance() {
        return new HomeFragment();
    }

    public static void refresh() {
        adapter.notifyDataSetChanged();
    }
}
