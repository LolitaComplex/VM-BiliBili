package com.doing.bilibili.activity;

import android.os.Bundle;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 杜营 on 2016/9/1.
 *
 */
public class SplashActivity extends BaseActivity {

    private Timer mTimer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                MainActivity.newInstance(SplashActivity.this);
                finish();
            }
        }, 1500);
    }

    @Override
    protected void initActionBar() {

    }

    @Override
    protected void onDestroy() {
        if (mTimer != null) {
            mTimer.cancel();
        }
        super.onDestroy();
    }
}
