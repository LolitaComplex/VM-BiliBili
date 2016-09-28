package com.doing.bilibili.fragment.general;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;

import com.doing.bilibili.R;
import com.doing.bilibili.base.Altar;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;

/**
 * Created by Doing on 2016/9/27.
 *
 */
public class LoginWrapperFragment extends BaseStaticFragment {

    private BaseFragment mContentFragment;

    public LoginWrapperFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public LoginWrapperFragment(BaseFragment contentFragment) {
        this();
        mContentFragment = contentFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_wrapper;
    }

    @Override
    protected void initView() {
        if (Altar.isLogin()) {
            addFragment(mContentFragment);
        }else{
            addFragment(LoginFragment.newInstance());
        }
    }

    private void addFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.LoginWrapperFragment_root, fragment).commit();
    }
}
