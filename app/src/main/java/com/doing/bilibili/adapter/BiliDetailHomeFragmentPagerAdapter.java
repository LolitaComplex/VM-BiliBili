package com.doing.bilibili.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.argument.DetailData;
import com.doing.bilibili.fragment.factory.BiliDetailFragmentFactory;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailHomeFragmentPagerAdapter extends FragmentStatePagerAdapter {


    private final String[] titles;
    private final BiliDetailFragmentFactory factory;
    private DetailData data;

    public BiliDetailHomeFragmentPagerAdapter(FragmentManager fm, DetailData detailData) {
        super(fm);
        titles = UIUtils.getStringArray(R.array.array_bili_detail_pager_title);
        factory = BiliDetailFragmentFactory.getInstance();
        this.data = detailData;
    }

    @Override
    public Fragment getItem(int position) {
        return factory.create(position,data);
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
