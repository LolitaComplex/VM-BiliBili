package com.doing.bilibili.ui.fragment.detail;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.doing.bilibili.R;
import com.doing.bilibili.ui.activity.BiliDetalActivity;
import com.doing.bilibili.ui.adapter.BiliDetailHomeFragmentPagerAdapter;
import com.doing.bilibili.baselib.base.BaseStaticFragment;
import com.doing.bilibili.data.entity.argument.DetailData;

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
