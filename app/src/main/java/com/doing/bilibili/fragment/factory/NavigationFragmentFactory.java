package com.doing.bilibili.fragment.factory;

import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.fragment.navigation.CollectionFragment;
import com.doing.bilibili.fragment.navigation.FollowPeopleFragment;
import com.doing.bilibili.fragment.navigation.HistoryFragment;
import com.doing.bilibili.fragment.navigation.HomeFragment;
import com.doing.bilibili.fragment.navigation.ThemeSelectFragment;
import com.doing.bilibili.fragment.navigation.WalletFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class NavigationFragmentFactory {

    public static final int HOME = 0;
    public static final int COLLECTION = 1;
    public static final int HISTORY = 2;
    public static final int FOLLOW_PEOPLE = 3;
    public static final int WALLET = 4;
    public static final int THEME_SELECT = 5;

    private static Map<Integer, BaseFragment> factory = new HashMap<>();

    public static BaseFragment createFragment(int position) {
        BaseFragment fragment = factory.get(position);
        if (fragment == null) {
            switch (position) {
                case HOME:
                    fragment = HomeFragment.newInstance();
                    break;
                case COLLECTION:
                    fragment = CollectionFragment.newInstance();
                    break;
                case HISTORY:
                    fragment = HistoryFragment.newInstance();
                    break;
                case FOLLOW_PEOPLE:
                    fragment = FollowPeopleFragment.newInstance();
                    break;
                case WALLET:
                    fragment = WalletFragment.newInstance();
                    break;
                case THEME_SELECT:
                    fragment = ThemeSelectFragment.newInstance();
                    break;
            }
        }

        if (fragment != null && !factory.containsValue(fragment)) {
            factory.put(position, fragment);
        }
        return fragment;
    }
}
