package com.doing.bilibili.fragment.factory;

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

    private static Map<Integer, BaseFragment> factory = new HashMap<>();

    public static BaseFragment createFragment(int position) {

        BaseFragment fragment = factory.get(position);

        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = LiveStreamFragment.newInstance();
                    break;
                case 1:
                    fragment = RecommendFragment.newInstance();
                    break;
                case 2:
                    fragment = BangumiFragment.newInstance();
                    break;

                case 3:
                    fragment = PartitionFragment.newInstance();
                    break;
                case 4:
                    fragment = new LoginWrapperFragment(AttentionFragment.newInstance());
                    break;
                case 5:
                    fragment = DiscoverFragment.newInstance();
                    break;
                default:
                    break;
            }
        }

        if (fragment != null && !factory.containsValue(fragment)) {
            factory.put(position, fragment);
        }

        return fragment;
    }
}
