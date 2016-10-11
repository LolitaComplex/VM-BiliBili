package com.doing.bilibili.fragment.factory;

import android.support.v4.util.SparseArrayCompat;
import android.widget.ScrollView;

import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.fragment.general.LoginWrapperFragment;
import com.doing.bilibili.fragment.home.AttentionFragment;
import com.doing.bilibili.fragment.home.BangumiFragment;
import com.doing.bilibili.fragment.home.DiscoverFragment;
import com.doing.bilibili.fragment.home.LiveStreamFragment;
import com.doing.bilibili.fragment.home.PartitionFragment;
import com.doing.bilibili.fragment.home.RecommendFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Doing on 2016/9/7.
 *
 */
public class HomeFragmentFactory {

    public static final int LIVE = 0;
    public static final int RECOMMEND = 1;
    public static final int BANGUMI = 2;
    public static final int PARTITION = 3;
    public static final int ATTENTION = 4;
    public static final int DISCOVER = 5;

    private static HomeFragmentFactory instance = new HomeFragmentFactory();

    private HomeFragmentFactory(){}

    public static HomeFragmentFactory getInstance() {
        return instance;
    }

    private SparseArrayCompat<BaseFragment> factory = new SparseArrayCompat<>();

    public BaseFragment createFragment(int position) {
        BaseFragment fragment = null;
        if (factory != null) {
            fragment = factory.get(position);
        }

        if (fragment == null) {
            switch (position) {
                case LIVE:
                    fragment = LiveStreamFragment.newInstance();
                    break;
                case RECOMMEND:
                    fragment = RecommendFragment.newInstance();
                    break;
                case BANGUMI:
                    fragment = BangumiFragment.newInstance();
                    break;

                case PARTITION:
                    fragment = PartitionFragment.newInstance();
                    break;
                case ATTENTION:
                    fragment = new LoginWrapperFragment(AttentionFragment.newInstance());
                    break;
                case DISCOVER:
                    fragment = DiscoverFragment.newInstance();
                    break;
                default:
                    break;
            }
        }

        if (fragment != null && factory.indexOfValue(fragment) == -1) {
            factory.put(position, fragment);
        }

        return fragment;
    }
}
