package com.doing.bilibili.base;

import com.doing.bilibili.activity.LoginActivity;
import com.doing.bilibili.baselib.base.BaseActivity;

import rx.functions.Action0;

/**
 * Created by Doing on 2016/9/27.
 *
 */
public abstract class AppBaseActivity extends BaseActivity {

    protected void action (Action0 action) {
        if (Altar.isLogin()) {
            action.call();
        } else {
            LoginActivity.newInstance(this);
        }
    }
}
