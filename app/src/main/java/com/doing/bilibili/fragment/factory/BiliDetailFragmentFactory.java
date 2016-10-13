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

    private DetailData mDetailData;

    private BiliDetailFragmentFactory(DetailData detailData) {
        this.mDetailData = detailData;
    }

    public static BiliDetailFragmentFactory getInstance(DetailData detailData) {
        return new BiliDetailFragmentFactory(detailData);
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
                    fragment = BiliDetailSummaryFragment.newInstance(mDetailData);
                    break;

                case COMMENT:
                    fragment = BiliDetailCommentFragment.newInstance(mDetailData);
                    break;
            }
        }

        if (factory != null && factory.indexOfValue(fragment) == -1) {
            factory.put(position, fragment);
        }
        return fragment;
    }
}
