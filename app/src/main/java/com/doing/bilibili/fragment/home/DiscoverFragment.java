package com.doing.bilibili.fragment.home;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.utils.DensityUitls;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.tag.Tag;
import com.doing.bilibili.net.BiliNetUtils;
import com.doing.bilibili.net.RetrofitHelper;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Doing on 2016/9/6.
 */
public class DiscoverFragment extends BaseStaticFragment implements View.OnClickListener {

    @BindView(R.id.DiscoverFragment_tv_search)
    protected TextView mTvSearch;
    @BindView(R.id.DiscoverFragment_iv_zxing)
    protected ImageView mIvZxing;
    @BindView(R.id.DiscoverFragment_flow)
    protected TagFlowLayout mFlowLayout;
    @BindView(R.id.DiscoverFragment_sv_flow)
    protected NestedScrollView mFlowSrollView;
    @BindView(R.id.DiscoverFragment_iv_arrow)
    protected ImageView mIvArrow;
    @BindView(R.id.DiscoverFragment_fl_control)
    protected LinearLayout mFlFlowControl;
    @BindView(R.id.General_flowlayouy_foldable)
    protected ViewGroup layout;
    @BindView(R.id.DiscoverFragment_tv_control)
    protected TextView mTvControl;
    @BindView(R.id.DiscoverFragment_view_line1)
    protected View mLine1;
    @BindView(R.id.DiscoverFragment_view_line2)
    protected View mLine2;

    public static BaseFragment newInstance() {

        return new DiscoverFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_discover;
    }

    @Override
    protected void initView() {

        initHeader();

        initBodyFlow();

        initFooter();
    }

    private void initHeader() {
        mTvSearch.setOnClickListener(this);
        mIvZxing.setOnClickListener(this);

        mTvSearch.measure(0, 0);
        int measuredHeight = mTvSearch.getMeasuredHeight();
        int paddingHeight = mTvSearch.getPaddingTop() * 2;
        mIvZxing.getLayoutParams().width = mIvZxing.getLayoutParams().height
                = measuredHeight + paddingHeight;

        mIvZxing.setImageDrawable(UIUtils.tint(R.drawable.ic_scan, R.color.dark_gray));
        mTvSearch.setCompoundDrawablesWithIntrinsicBounds(
                UIUtils.tint(R.drawable.ic_hint_search, R.color.dark_gray), null, null, null);
    }

    private void initBodyFlow() {
        if (BiliNetUtils.statusOfNetwork()) {
            layout.setVisibility(View.VISIBLE);
            RetrofitHelper.getHomeDiscoverData().getHomeDiscoverTagData()
                    .map(new Func1<Response<Tag>, List<Tag>>() {
                        @Override
                        public List<Tag> call(Response<Tag> tagResponse) {
                            return tagResponse.getList();
                        }
                    })
                    .compose(this.<List<Tag>>bindToLifecycle())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<List<Tag>>() {
                        @Override
                        public void call(List<Tag> tags) {
                            initFlowLayout(tags);
                        }
                    });

            initFlowButtonLayout();
        } else {
            layout.setVisibility(View.GONE);
        }
    }

    private void initFlowLayout(final List<Tag> tags) {
        mFlowLayout.setAdapter(new TagAdapter<Tag>(tags) {
            @Override
            public View getView(FlowLayout parent, int position, Tag tag) {
                TextView textView = (TextView) UIUtils.inflate(
                        R.layout.item_flowlayout_discover, parent);
                textView.setBackgroundResource(R.drawable.selector_tag_white);
                textView.setText(tag.getKeyword());
                return textView;
            }
        });

        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                ToastUtil.show(tags.get(position).getKeyword());
                return false;
            }
        });

    }

    private void initFlowButtonLayout() {
        Rect windowSize = UIUtils.getWindowSize();

        mIvArrow.measure(0, 0);
        mTvControl.measure(0, 0);
        int width = windowSize.width()- (mIvArrow.getMeasuredWidth() + mTvControl.getMeasuredWidth() + DensityUitls.dip2px(113.0f));
        mLine1.getLayoutParams().width = width / 2 - 1;
        mLine2.getLayoutParams().width = width / 2;
    }

    private void initFooter() {

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
