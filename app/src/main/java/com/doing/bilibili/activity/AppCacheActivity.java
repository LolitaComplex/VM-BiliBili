package com.doing.bilibili.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.doing.bilibili.R;
import com.doing.bilibili.base.AppBaseActivity;
import com.doing.bilibili.baselib.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Doing on 2016/9/30.
 *
 */
public class AppCacheActivity extends AppBaseActivity {

    @BindView(R.id.AppCacheActivity_spinner)
    protected Spinner mSpinner;
    @BindView(R.id.General_toolbar)
    protected Toolbar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_offline_cache;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView(Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.layout_spinner_item,
                UIUtils.getStringArray(R.array.array_offline_cache_spinner));
        mToolbar.measure(0, 0);
        mSpinner.measure(0, 0);
        int height = (mToolbar.getMeasuredHeight() - mSpinner.getMeasuredHeight())/4;
        mSpinner.setDropDownVerticalOffset(mToolbar.getMeasuredHeight() - height);
        mSpinner.setAdapter(adapter);
    }

    @Override
    protected void initActionBar() {
        setSupportActionBar(mToolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        params.topMargin = UIUtils.getStatusBarHeight();
        mToolbar.setLayoutParams(params);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    public static void newInstance(Context context) {
        context.startActivity(new Intent(context, AppCacheActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
