package com.doing.bilibili.fragment.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;

import butterknife.BindView;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class DiscoverFragment extends BaseStaticFragment implements View.OnClickListener {

    @BindView(R.id.DiscoverFragment_tv_search)
    protected TextView mTvSearch;
    @BindView(R.id.DiscoverFragment_iv_zxing)
    protected ImageView mIvZxing;

    public static BaseFragment newInstance() {
        return new DiscoverFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_discover;
    }

    @Override
    protected void initView() {
        mTvSearch.setOnClickListener(this);
        mIvZxing.setOnClickListener(this);

        mTvSearch.measure(0, 0);
        int measuredHeight = mTvSearch.getMeasuredHeight();
        int paddingHeight = mTvSearch.getPaddingTop() * 2;
        mIvZxing.getLayoutParams().width =  mIvZxing.getLayoutParams().height
                = measuredHeight + paddingHeight;

        mIvZxing.setImageDrawable(UIUtils.tint(R.drawable.ic_scan,R.color.dark_gray));
        mTvSearch.setCompoundDrawablesWithIntrinsicBounds(
                UIUtils.tint(R.drawable.ic_hint_search, R.color.dark_gray), null, null, null);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.DiscoverFragment_tv_search:
                ToastUtil.show("搜索");
                break;

            case R.id.DiscoverFragment_iv_zxing:
                ToastUtil.show("二维码");
                break;
        }
    }
}
