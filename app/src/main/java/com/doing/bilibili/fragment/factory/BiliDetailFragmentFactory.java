package com.doing.bilibili.fragment.factory;

import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;

import com.doing.bilibili.activity.BiliDetalActivity;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.entity.argument.DetailData;
import com.doing.bilibili.fragment.detail.BiliDetailCommentFragment;
import com.doing.bilibili.fragment.detail.BiliDetailSummaryFragment;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailFragmentFactory {

    public final static int SUMMARY = 0;
    public final static int COMMENT = 1;

    private BiliDetailFragmentFactory(){}

    public static BiliDetailFragmentFactory getInstance() {
        return new BiliDetailFragmentFactory();
    }

    private SparseArrayCompat<BaseFragment> factory = new SparseArrayCompat<>();

    public BaseFragment create(int position) {
        BaseFragment fragment = null;

        if (factory != null) {
            fragment = factory.get(position);
        }

        if (fragment == null) {
            switch (position) {
                case SUMMARY:
                    fragment = BiliDetailSummaryFragment.newInstance();
                    break;

                case COMMENT:
                    fragment = BiliDetailCommentFragment.newInstance();
                    break;
            }
        }

        if (factory != null && factory.indexOfValue(fragment) == -1) {
            factory.put(position, fragment);
        }
        return fragment;
    }

    public BaseFragment create(int position, DetailData data) {
        BaseFragment fragment = null;

        if (factory != null) {
            fragment = factory.get(position);
        }

        if (fragment == null) {
            switch (position) {
                case SUMMARY:
                    fragment = BiliDetailSummaryFragment.newInstance();
                    break;

                case COMMENT:
                    fragment = BiliDetailCommentFragment.newInstance();
                    break;
            }
        }

        if (factory != null && factory.indexOfValue(fragment) == -1) {
            factory.put(position, fragment);
        }

        if (fragment instanceof BiliDetailSummaryFragment) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(BiliDetalActivity.DETAIL_DATA, data);
            fragment.setArguments(bundle);
        }
        return fragment;
    }
}
