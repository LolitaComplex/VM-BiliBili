package com.doing.bilibili.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.base.AppBaseActivity;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.uitls.TransitionHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Doing on 2016/9/30.
 *
 */
public class AppCacheActivity extends AppBaseActivity implements View.OnClickListener {

    @BindView(R.id.General_toolbar)
    protected Toolbar mToolbar;
    @BindView(R.id.AppCacheActivity_tv_spinner)
    protected TextView mTvSpinner;

    public static void newInstance(Activity context) {
        Pair[] pairs = TransitionHelper.createSafeTrianstionParticipants(context, true);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context, pairs);

        context.startActivity(new Intent(context, AppCacheActivity.class), activityOptionsCompat.toBundle());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_offline_cache;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView(Bundle savedInstanceState) {
        mTvSpinner.setOnClickListener(this);
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

    @Override
    protected void initWindowAnimations() {
        Explode explodeTransition = new Explode();
        explodeTransition.setDuration(500);
        getWindow().setEnterTransition(explodeTransition);

        Fade fadeTransition = new Fade();
        fadeTransition.setDuration(500);
        getWindow().setReturnTransition(fadeTransition);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appcache, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_appcache_search:
                ToastUtil.show("查找");
                break;

            case R.id.action_appcache_setting:
                ToastUtil.show("设置");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AppCacheActivity_tv_spinner:
                PopupMenu popupMenu = new PopupMenu(this, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_spinner,
                        popupMenu.getMenu());
                popupMenu.show();

                break;
        }
    }
}
