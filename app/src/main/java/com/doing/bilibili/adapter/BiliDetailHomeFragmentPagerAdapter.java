package com.doing.bilibili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.fragment.factory.BiliDetailFragmentFactory;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailHomeFragmentPagerAdapter extends FragmentStatePagerAdapter {


    private final String[] titles;
    private final BiliDetailFragmentFactory factory;

    public BiliDetailHomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        titles = UIUtils.getStringArray(R.array.array_bili_detail_pager_title);
        factory = BiliDetailFragmentFactory.getInstance();
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
}
