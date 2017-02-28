package com.doing.bilibili.ui.fragment.general;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.doing.bilibili.R;
import com.doing.bilibili.ui.activity.LoginActivity;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;

import butterknife.BindView;

/**
 * Created by Doing on 2016/9/27.
 *
 */
public class LoginFragment extends BaseStaticFragment {

    @BindView(R.id.LoginFragment_btn)
    protected Button mBtnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.newInstance((Activity) mContext);
            }
        });
    }


    public static BaseFragment newInstance() {
        return new LoginFragment();
    }

}
