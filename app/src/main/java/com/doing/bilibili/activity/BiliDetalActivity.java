package com.doing.bilibili.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.widget.ImageView;

import com.doing.bilibili.R;
import com.doing.bilibili.base.AppBaseActivity;
import com.doing.bilibili.baselib.utils.UIUtils;

import butterknife.BindView;

/**
 * Created by Doing on 2016/10/10.
 *
 */
public class BiliDetalActivity extends AppBaseActivity {

    @BindView(R.id.General_toobar_bg)
    protected ImageView mToobarImageView;

    public static void newInstance(Activity context) {
        context.startActivity(new Intent(context, BiliDetalActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bilidetail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

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
        }
    }

}
