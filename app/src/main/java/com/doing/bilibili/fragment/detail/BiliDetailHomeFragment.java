package com.doing.bilibili.fragment.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.BiliDetalActivity;
import com.doing.bilibili.adapter.BiliDetailHomeFragmentPagerAdapter;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;
import com.doing.bilibili.fragment.factory.BiliDetailFragmentFactory;
import com.doing.bilibili.fragment.navigation.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailHomeFragment extends BaseStaticFragment {


    @BindView(R.id.BiliDetailHomeFragment_viewpager)
    protected ViewPager mViewPager;

    public static BiliDetailHomeFragment newInstance() {
        return new BiliDetailHomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bilidetail_home;
    }

    @Override
    protected void initView() {
        FragmentStatePagerAdapter adapter =
                new BiliDetailHomeFragmentPagerAdapter(getChildFragmentManager());

        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BiliDetailFragmentFactory factory =
                        BiliDetailFragmentFactory.getInstance();
                BaseFragment fragment = factory.create(position);
                if (fragment instanceof BaseLoadingFragment) {
                    ((BaseLoadingFragment) fragment).show();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ((BiliDetalActivity) mContext).initTabLayout(mViewPager);
    }

}
