package com.doing.bilibili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.utils.LogUtils;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.fragment.factory.HomeFragmentFactory;

/**
 * Created by Doing on 2016/9/7.
 *
 */
public class HomeFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private final String[] mTitles;

    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mTitles = UIUtils.getStringArray(R.array.array_home_pager_title);
    }

    @Override
    public BaseFragment getItem(int position) {
        return HomeFragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BaseFragment item = getItem(position);
        item.setContainerId(container.getId());
        return super.instantiateItem(container, position);
    }
}
