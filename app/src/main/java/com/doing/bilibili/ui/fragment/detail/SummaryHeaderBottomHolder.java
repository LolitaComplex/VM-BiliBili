package com.doing.bilibili.ui.fragment.detail;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.data.entity.argument.DetailData;
import com.doing.bilibili.data.entity.bilidetail.DetailVideoInfo;
import com.doing.bilibili.data.net.ImageEnginePicasso;

import org.apmem.tools.layouts.FlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Doing on 2016/10/12 0012.
 *
 */

public class SummaryHeaderBottomHolder implements View.OnClickListener {

    @BindView(R.id.BiliDetailSummaryFragment_body_iv_cover)
    protected ImageView mBodyIvCover;
    @BindView(R.id.BiliDetailSummaryFragment_body_tv_author)
    protected TextView mBodyTvAuthor;
    @BindView(R.id.BiliDetailSummaryFragment_body_tv_time)
    protected TextView mBodyTvTime;
    @BindView(R.id.BiliDetailSummaryFragment_body_tv_attention)
    protected TextView mBodyTvAttention;
    @BindView(R.id.BiliDetailSummaryFragment_body_btn_charge)
    protected Button mBodyBtnCharge;
    @BindView(R.id.BiliDetailSummaryFragment_footer_flowlayout)
    protected FlowLayout mFooterFlowLayout;

    private DetailVideoInfo mVideoInfo;
    private DetailData mDetailData;

    public SummaryHeaderBottomHolder(View view, DetailVideoInfo videoInfo, DetailData detailData) {
        ButterKnife.bind(this, view);
        this.mVideoInfo = videoInfo;
        this.mDetailData = detailData;
    }

    public void covertView() {
        //Body部分
        getRoundBitmap();

        mBodyTvAuthor.setText(mVideoInfo.getAuthor());
        mBodyTvTime.setText(mVideoInfo.getCreated_at());

        mBodyTvAttention.setOnClickListener(this);
        mBodyBtnCharge.setOnClickListener(this);

        initFooterTag();


    }

    private void initFooterTag() {
        String[] tags = mVideoInfo.getTag().split(",");
        for (String tag : tags) {
            TextView inflate = (TextView) UIUtils.inflate(R.layout.item_flowlayout_discover, mFooterFlowLayout);
            inflate.setText(tag);
            inflate.setTag(tag);
            inflate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String tagClick = (String) v.getTag();
                    ToastUtil.show(tagClick);
                }
            });
            mFooterFlowLayout.addView(inflate);
        }
    }

    /**
     * 不想导入第三方控件，正好练习下脱离Retrofit的RxJava
     */
    private void getRoundBitmap() {
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Bitmap source = ImageEnginePicasso.getBitmap(mVideoInfo.getFace());
                RoundedBitmapDrawable roudedBitmapDrawable = UIUtils.getRoudedBitmapDrawable(source);
                subscriber.onNext(roudedBitmapDrawable);
                subscriber.onCompleted();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<Drawable>() {
                    @Override
                    public void call(Drawable drawable) {
                        mBodyIvCover.setImageDrawable(drawable);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BiliDetailSummaryFragment_body_tv_attention:
                ToastUtil.show("关注");
                break;

            case R.id.BiliDetailSummaryFragment_body_btn_charge:
                ToastUtil.show("充电");
                break;
        }
    }
}
