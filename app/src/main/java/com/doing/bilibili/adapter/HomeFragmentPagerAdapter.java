package com.doing.bilibili.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.fragment.factory.HomeFragmentFactory;

/**
 * Created by Doing on 2016/9/7.
 *
 */
public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {

    private final String[] mTitles;
    private final HomeFragmentFactory mFactory;

    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mTitles = UIUtils.getStringArray(R.array.array_home_pager_title);
        mFactory = HomeFragmentFactory.getInstance();
    }

    @Override
    public BaseFragment getItem(int position) {
        return mFactory.createFragment(position);
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

    @Override
    public long getItemId(int position) {
        return position;
    }
}
