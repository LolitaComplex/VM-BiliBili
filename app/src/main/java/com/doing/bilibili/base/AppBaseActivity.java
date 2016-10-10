package com.doing.bilibili.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.LoginActivity;
import com.doing.bilibili.baselib.base.BaseActivity;
import com.doing.bilibili.baselib.utils.LogUtils;
import com.doing.bilibili.baselib.utils.UIUtils;

import butterknife.BindView;
import rx.functions.Action0;

/**
 * Created by Doing on 2016/9/27.
 *
 */
public abstract class AppBaseActivity extends BaseActivity {


    @BindView(R.id.General_toolbar)
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initWindowAnimations();

    }
    protected void action (Action0 action) {
        if (Altar.isLogin()) {
            action.call();
        } else {
            LoginActivity.newInstance(this);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finishAfterTransition();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void initWindowAnimations() {

    }

    @Override
    protected void initActionBar() {
        setSupportActionBar(mToolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        params.topMargin = UIUtils.getStatusBarHeight();
        mToolbar.setLayoutParams(params);
    }
}
