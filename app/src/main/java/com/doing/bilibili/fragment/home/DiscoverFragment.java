package com.doing.bilibili.fragment.home;

import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.transition.TransitionManager;
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
import com.doing.bilibili.uitls.AnimatorUtils;

import org.apmem.tools.layouts.FlowLayout;

import java.util.List;

import butterknife.BindView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class DiscoverFragment extends BaseStaticFragment implements View.OnClickListener {

    @BindView(R.id.DiscoverFragment_tv_search)
    protected TextView mTvSearch;
    @BindView(R.id.DiscoverFragment_iv_zxing)
    protected ImageView mIvZxing;
    @BindView(R.id.DiscoverFragment_flow)
    protected FlowLayout mFlowLayout;
    @BindView(R.id.DiscoverFragment_sv_flow)
    protected NestedScrollView mFlowSrollView;
    @BindView(R.id.DiscoverFragment_iv_arrow)
    protected ImageView mIvArrow;
    @BindView(R.id.DiscoverFragment_ll_control)
    protected LinearLayout mFlFlowControl;
    @BindView(R.id.General_flowlayouy_foldable)
    protected ViewGroup layout;
    @BindView(R.id.DiscoverFragment_tv_control)
    protected TextView mTvControl;
    @BindView(R.id.DiscoverFragment_view_line1)
    protected View mLine1;
    @BindView(R.id.DiscoverFragment_view_line2)
    protected View mLine2;
    @BindView(R.id.DiscoverFragment_tv_intreasting)
    protected TextView mTvIntreasing;
    @BindView(R.id.DiscoverFragment_tv_topic_center)
    protected TextView mTvTopicCenter;
    @BindView(R.id.DiscoverFragment_tv_activity_center)
    protected TextView mTvActivityCenter;
    @BindView(R.id.DiscoverFragment_tv_original_rank)
    protected TextView mTvOriRank;
    @BindView(R.id.DiscoverFragment_tv_all_rank)
    protected TextView mTvAllRank;
    @BindView(R.id.DiscoverFragment_tv_game_center)
    protected TextView mTvGameCenter;
    @BindView(R.id.DiscoverFragment_root)
    protected ViewGroup rootView;


    private boolean mFlowLayoutSwitch = false;
    private AnimatorUtils mAnimationUtils;

    public static BaseFragment newInstance() {

        return new DiscoverFragment();
    }

    @Override
    protected void initVariable() {
        mAnimationUtils = new AnimatorUtils();
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
        UIUtils.setTouchListener(mFlowSrollView, true);
        if (BiliNetUtils.statusOfNetwork()) {
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
        mFlFlowControl.setOnClickListener(this);
        for (int i = 0; i < tags.size(); i++) {
            TextView inflate = (TextView) UIUtils.inflate(R.layout.item_flowlayout_discover, mFlowLayout);
            inflate.setText(tags.get(i).getKeyword());
            inflate.setTag(i);
            inflate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = (Integer) v.getTag();
                    ToastUtil.show(tags.get(index).getKeyword());
                }
            });
            mFlowLayout.addView(inflate);
        }
        layout.setVisibility(View.VISIBLE);
        //鸿洋FlowLayout
        /*mFlowLayout.setAdapter(new TagAdapter<Tag>(tags) {
            @Override
            public View getView(FlowLayout parent, final int position, Tag tag) {
                TextView textView = (TextView) UIUtils.inflate(
                        R.layout.item_flowlayout_discover, parent);
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
        });*/

    }

    private void initFlowButtonLayout() {
        Rect windowSize = UIUtils.getWindowSize();

        mIvArrow.measure(0, 0);
        mTvControl.measure(0, 0);
        int width = windowSize.width() - (mIvArrow.getMeasuredWidth() + mTvControl.getMeasuredWidth() + DensityUitls.dip2px(123.0f));
        mLine1.getLayoutParams().width = width / 2 - 1;
        mLine2.getLayoutParams().width = width / 2;
    }

    private void initFooter() {

        mTvIntreasing.setOnClickListener(this);
        mTvTopicCenter.setOnClickListener(this);
        mTvActivityCenter.setOnClickListener(this);
        mTvOriRank.setOnClickListener(this);
        mTvAllRank.setOnClickListener(this);
        mTvGameCenter.setOnClickListener(this);
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

            case R.id.DiscoverFragment_ll_control:
                int closeHeight = DensityUitls.dip2px(75);
                int openHeight = DensityUitls.dip2px(200);
                if (mFlowLayoutSwitch) {
                    UIUtils.setTouchListener(mFlowSrollView, true);
                    mTvControl.setText(getString(R.string.see_more));
                    mFlowSrollView.smoothScrollTo(0, 0);
                    switchFlowLayout();
//                    mAnimationUtils.setCloseAnimator(mFlowSrollView, 500, closeHeight, openHeight);
                    mAnimationUtils.setRotateAnimator(mIvArrow, 500, 180, 360);
                } else {
                    UIUtils.setTouchListener(mFlowSrollView, false);
                    mTvControl.setText(getString(R.string.close_flow_tag));
//                    mAnimationUtils.setOpenAnimator(mFlowSrollView, 500, closeHeight, openHeight);
                    mAnimationUtils.setRotateAnimator(mIvArrow, 500, 0, 180);
                    switchFlowLayout();
                }

                break;

        }
    }

    private boolean flowLayoutSizeChangeed;

    private void switchFlowLayout() {
        TransitionManager.beginDelayedTransition(rootView);

        ViewGroup.LayoutParams layoutParams = mFlowSrollView.getLayoutParams();
        if (mFlowLayoutSwitch) {
            int closeHeight = DensityUitls.dip2px(75);
            layoutParams.height = closeHeight;
        } else {
            int openHeight = DensityUitls.dip2px(200);
            layoutParams.height = openHeight;
        }

        mFlowLayoutSwitch = !mFlowLayoutSwitch;

        mFlowSrollView.setLayoutParams(layoutParams);
    }

//    private boolean arrowRotateChangeed;


//    private void switchArrow() {
//        TransitionManager.beginDelayedTransition(rootView);
//
//        if (arrowRotateChangeed) {
//            mIvArrow.setRotation(360);
//        } else {
//            mIvArrow.setRotation(180);
//        }
//
//        arrowRotateChangeed = !arrowRotateChangeed;
//    }
}
