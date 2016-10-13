package com.doing.bilibili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.argument.DetailData;
import com.doing.bilibili.fragment.factory.BiliDetailFragmentFactory;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailHomeFragmentPagerAdapter extends FragmentStatePagerAdapter implements ViewPager.OnPageChangeListener {


    private final String[] titles;
    private final BiliDetailFragmentFactory factory;
    private DetailData data;

    public BiliDetailHomeFragmentPagerAdapter(FragmentManager fm, DetailData detailData) {
        super(fm);
        titles = UIUtils.getStringArray(R.array.array_bili_detail_pager_title);
        factory = BiliDetailFragmentFactory.getInstance(detailData);
        this.data = detailData;
    }

    @Override
    public Fragment getItem(int position) {
        return factory.create(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        BaseFragment fragment = factory.create(position);
        if (fragment instanceof BaseLoadingFragment) {
            ((BaseLoadingFragment) fragment).show();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
