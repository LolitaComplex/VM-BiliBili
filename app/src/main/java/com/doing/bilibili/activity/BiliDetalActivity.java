package com.doing.bilibili.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.callback.TabLayoutCallback;
import com.doing.bilibili.base.AppBaseActivity;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.fragment.detail.BiliDetailHomeFragment;
import com.doing.bilibili.fragment.factory.BiliDetailFragmentFactory;
import com.doing.bilibili.ui.ImageTextView;

import butterknife.BindView;

/**
 * Created by Doing on 2016/10/10.
 *
 */
public class BiliDetalActivity extends AppBaseActivity implements TabLayoutCallback {

    @BindView(R.id.General_toobar_bg)
    protected ImageView mToobarImageView;
    @BindView(R.id.General_collapsingToolbar)
    protected CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.General_appBarLayout)
    protected AppBarLayout mAppBarLayout;
    @BindView(R.id.General_tv_title)
    protected ImageTextView mTvTitle;
    @BindView(R.id.General_floatactionbution)
    protected FloatingActionButton mFloatButton;
    @BindView(R.id.General_tablayout)
    protected TabLayout mTabLayout;
    private BiliDetailFragmentFactory mFactory;

    public static void newInstance(Activity context) {
        context.startActivity(new Intent(context, BiliDetalActivity.class));
    }

    @Override
    protected void initVariable() {
        mFactory = BiliDetailFragmentFactory.getInstance();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bilidetail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        addFragment(R.id.General_content,
                BiliDetailHomeFragment.newInstance(), false);

    }

    @Override
    protected void initActionBar() {
        setSupportActionBar(mToolbar);

        CollapsingToolbarLayout.LayoutParams params = (CollapsingToolbarLayout.LayoutParams) mToolbar.getLayoutParams();
        params.topMargin = UIUtils.getStatusBarHeight();
        mToolbar.setLayoutParams(params);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    mTvTitle.setText("av666666");
                    mTvTitle.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                    mTvTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    mFloatButton.show();
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    mTvTitle.setText("立即播放");
                    mTvTitle.setGravity(Gravity.CENTER_VERTICAL);
                    mTvTitle.setImageInView(ImageTextView.LEFT, R.drawable.ic_fab_play);
                    mFloatButton.hide();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bilidetail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.BiliDetailActivity_debug:
                ToastUtil.show("调试");
                break;

            case R.id.BiliDetailActivity_help:
                ToastUtil.show("帮助");
                break;

            case R.id.BiliDetailActivity_setting:
                ToastUtil.show("设置");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //================ 接口回调方法===================

    @Override
    public void initTabLayout(ViewPager viewPager) {
        mTabLayout.setupWithViewPager(viewPager);
    }
}
