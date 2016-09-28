package com.doing.bilibili.baselib.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doing on 2016/9/7.
 *
 */
public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<? extends Fragment> mFragments;

    private String[] mTitles;


    public BaseFragmentPagerAdapter(FragmentManager fm, List<? extends Fragment> fragments, String[] titles) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    public static class Holder{

        private final List<Fragment> fragments = new ArrayList<>();

        private FragmentManager manager;

        public Holder(FragmentManager manager) {
            this.manager = manager;
        }

        public Holder add(Fragment content) {
            fragments.add(content);
            return this;
        }

        public BaseFragmentPagerAdapter build(String[] titles) {
            return new BaseFragmentPagerAdapter(manager, fragments, titles);
        }
    }
}
