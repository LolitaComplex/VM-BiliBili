package com.doing.bilibili.baselib.base;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.functions.Action0;

/**
 * Createdy 杜营 on 2016/4/14.
 *
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    public static String TAG;
    private static List<BaseActivity> mStackActivitys = new LinkedList<>();
    private Unbinder mBind;

    protected BaseFragment mCurrentFragment;

    protected Subscription mSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //CrashExceptionUtil.getInstance().init(this);
        setContentView(getLayoutId());
        synchronized (mStackActivitys) {
            mStackActivitys.add(this);
        }

        if (getClass() != null) {
            String className = getClass().getName();
            TAG = className.substring(className.lastIndexOf(".") + 1);
        }

        //注册黄油刀
        mBind = ButterKnife.bind(this);

        initVariable();
        initView(savedInstanceState);
        initActionBar();

        subscirp();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    public void killAll() {
        List<BaseActivity> clone;

        synchronized (mStackActivitys) {
            clone = new ArrayList<>(mStackActivitys);
        }
        for (BaseActivity activity : clone) {
            activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }

        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }

        synchronized (mStackActivitys) {
            mStackActivitys.remove(this);
        }
    }

    protected void addFragment(int contentId, BaseFragment fragment, boolean backStackFlag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }
        if (!fragment.isAdded()) {
            transaction.add(contentId, fragment, fragment.getFragmentTag());
        }

        if (backStackFlag) {
            transaction.addToBackStack(fragment.getFragmentTag());
        }

        transaction.show(fragment);
        transaction.commit();

        mCurrentFragment = fragment;
    }


    /*===============================模板方法===================================*/
    protected void initVariable() {}

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initActionBar();

    protected void subscirp() {}

}
