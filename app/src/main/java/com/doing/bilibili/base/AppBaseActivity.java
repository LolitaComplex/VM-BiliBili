package com.doing.bilibili.base;

import android.os.Bundle;
import android.view.MenuItem;

import com.doing.bilibili.activity.LoginActivity;
import com.doing.bilibili.baselib.base.BaseActivity;

import rx.functions.Action0;

/**
 * Created by Doing on 2016/9/27.
 *
 */
public abstract class AppBaseActivity extends BaseActivity {

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
}
