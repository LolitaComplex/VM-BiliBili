package com.doing.bilibili.fragment.general;

import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.LoginActivity;
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
                LoginActivity.newInstance(mContext);
            }
        });
    }


    public static BaseFragment newInstance() {
        return new LoginFragment();
    }

}
