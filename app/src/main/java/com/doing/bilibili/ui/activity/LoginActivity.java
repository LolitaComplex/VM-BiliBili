package com.doing.bilibili.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.ui.base.Altar;
import com.doing.bilibili.ui.base.AppBaseActivity;
import com.doing.bilibili.ui.base.RxBus;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.data.entity.global.User;
import com.doing.bilibili.uitls.TransitionHelper;

import butterknife.BindView;

/**
 * Created by Doing on 2016/9/26.
 *
 */
public class LoginActivity extends AppBaseActivity implements View.OnFocusChangeListener, View.OnClickListener, View.OnTouchListener, TextWatcher {

    @BindView(R.id.General_toolbar)
    protected Toolbar mToolbar;
    @BindView(R.id.LoginActivity_tv_username)
    protected AppCompatEditText mTvUserName;
    @BindView(R.id.LoginActivity_tv_password)
    protected AppCompatEditText mTvPassword;
    @BindView(R.id.LoginActivity_tv_logo)
    protected ImageView mIvLogo;
    @BindView(R.id.LoginActivity_btn_register)
    protected Button mBtnRegister;
    @BindView(R.id.LoginActivity_btn_login)
    protected Button mBtnLogin;

    public static void newInstance(Activity context) {
        Pair[] pairs = TransitionHelper.createSafeTrianstionParticipants(context, true);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context, pairs);

        context.startActivity(new Intent(context, LoginActivity.class), activityOptionsCompat.toBundle());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        mTvUserName.setOnFocusChangeListener(this);
        mTvPassword.setOnFocusChangeListener(this);

        mBtnRegister.setOnTouchListener(this);
        mBtnRegister.setOnFocusChangeListener(this);

        mBtnRegister.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);

        mTvUserName.addTextChangedListener(this);
        mTvPassword.addTextChangedListener(this);

        mBtnLogin.setClickable(false);

    }

    @Override
    protected void initActionBar() {
       super.initActionBar();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override
    protected void initWindowAnimations() {
        Explode explodeTransition = new Explode();
        explodeTransition.setDuration(500);
        getWindow().setEnterTransition(explodeTransition);

        Fade slideTransition = new Fade();
        slideTransition.setDuration(500);
        getWindow().setReturnTransition(slideTransition);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_forget:
                ToastUtil.show("忘记密码");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.LoginActivity_tv_username:
                mIvLogo.setBackgroundResource(R.drawable.layer_login_input_username);

                tintTextViewDrawable(mTvUserName, R.drawable.ic_login_username_default, mTvPassword, R.drawable.ic_login_password_default);
                break;

            case R.id.LoginActivity_tv_password:
                mIvLogo.setBackgroundResource(R.drawable.layer_login_input_password);

                tintTextViewDrawable(mTvPassword, R.drawable.ic_login_password_default, mTvUserName, R.drawable.ic_login_username_default);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LoginActivity_btn_register:
                ToastUtil.show("注册新用户");
                break;

            case R.id.LoginActivity_btn_login:
                User user = new User("布鲁马", "", "", "正式会员", 5, 666.6);
                Altar.login(user);
                RxBus.getDefault().post(user);
                finish();
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.LoginActivity_btn_register) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mBtnRegister.setTextColor(UIUtils.getColor(R.color.colorPrimary_dark));
                    break;

                case MotionEvent.ACTION_UP:
                    mBtnRegister.setTextColor(UIUtils.getColor(R.color.colorPrimary));
                    break;
            }
        }

        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (TextUtils.isEmpty(getTextViewText(mTvUserName)) ||
                TextUtils.isEmpty(getTextViewText(mTvPassword))) {
            mBtnLogin.setClickable(false);
            mBtnLogin.setAlpha(0.3f);
        } else {
            mBtnLogin.setClickable(true);
            mBtnLogin.setAlpha(1f);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private String getTextViewText(TextView textView) {
        return textView.getText().toString().trim();
    }

    private void tintTextViewDrawable(TextView tvTint, int tintDrawableId, TextView tvDefault, int defaultDrawableId) {
        tvTint.setCompoundDrawablesWithIntrinsicBounds(UIUtils.tint(tintDrawableId, R.color.colorPrimary), null, null, null);
        tvDefault.setCompoundDrawablesWithIntrinsicBounds(UIUtils.getDrawable(defaultDrawableId), null, null, null);
    }

}
