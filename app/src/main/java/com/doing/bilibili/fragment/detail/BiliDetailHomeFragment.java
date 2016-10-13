package com.doing.bilibili.fragment.detail;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.BiliDetalActivity;
import com.doing.bilibili.adapter.BiliDetailHomeFragmentPagerAdapter;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;
import com.doing.bilibili.entity.argument.DetailData;
import com.doing.bilibili.fragment.factory.BiliDetailFragmentFactory;

import butterknife.BindView;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailHomeFragment extends BaseStaticFragment {


    @BindView(R.id.BiliDetailHomeFragment_viewpager)
    protected ViewPager mViewPager;

    public static BiliDetailHomeFragment newInstance(DetailData detailData) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(BiliDetalActivity.DETAIL_DATA, detailData);

        BiliDetailHomeFragment fragment = new BiliDetailHomeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bilidetail_home;
    }

    @Override
    protected void initView() {
        DetailData detailData = getArguments().getParcelable(BiliDetalActivity.DETAIL_DATA);

        BiliDetailHomeFragmentPagerAdapter adapter =
                new BiliDetailHomeFragmentPagerAdapter(getChildFragmentManager(),detailData);

        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(adapter);

        ((BiliDetalActivity) mContext).initTabLayout(mViewPager);
    }

}
