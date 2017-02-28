package com.doing.bilibili.ui.fragment.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.doing.bilibili.R;
import com.doing.bilibili.ui.activity.callback.TabLayoutCallback;
import com.doing.bilibili.ui.adapter.HomeFragmentPagerAdapter;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;
import com.doing.bilibili.ui.fragment.factory.HomeFragmentFactory;
import com.doing.bilibili.ui.fragment.home.HomeRecyclerFragment;

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
                HomeFragmentFactory factory = HomeFragmentFactory.getInstance();
                BaseFragment fragment = factory.createFragment(position);
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
        ((TabLayoutCallback)mContext).initTabLayout(mViewPager);
    }

    public static BaseFragment newInstance() {
        return new HomeFragment();
    }

    public static void refresh() {
        adapter.notifyDataSetChanged();
    }
}
