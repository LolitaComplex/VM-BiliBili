package com.doing.bilibili.ui.fragment.detail;

import android.view.View;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.data.entity.argument.DetailData;
import com.doing.bilibili.data.entity.bilidetail.DetailVideoInfo;
import com.doing.bilibili.ui.widget.BiliDetailFunctionView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Doing on 2016/10/12 0012.
 *
 */

public class SummaryHeaderTopHolder implements View.OnClickListener {

    @BindView(R.id.BiliDetailSummaryFragment_header_tv_title)
    protected TextView mHeaderTvTitle;
    @BindView(R.id.BiliDetailSummaryFragment_header_tv_played)
    protected TextView mHeaderTvPlayed;
    @BindView(R.id.BiliDetailSummaryFragment_header_tv_playing)
    protected TextView mHeaderTvPlaying;
    @BindView(R.id.BiliDetailSummaryFragment_header_tv_instruction)
    protected TextView mHeaderTvInstruction;
    @BindView(R.id.BiliDetailSummaryFragment_header_ll_share)
    protected BiliDetailFunctionView mHeaderShare;
    @BindView(R.id.BiliDetailSummaryFragment_header_ll_coin)
    protected BiliDetailFunctionView mHeaderCoin;
    @BindView(R.id.BiliDetailSummaryFragment_header_ll_collection)
    protected BiliDetailFunctionView mHeaderCollect;
    @BindView(R.id.BiliDetailSummaryFragment_header_ll_download)
    protected BiliDetailFunctionView mHeaderDownload;

    private DetailVideoInfo mVideoInfo;
    private DetailData mDetailData;

    public SummaryHeaderTopHolder(View view, DetailVideoInfo videoInfo, DetailData detailData) {
        ButterKnife.bind(this, view);
        this.mVideoInfo = videoInfo;
        this.mDetailData = detailData;
    }

    public void covertView() {
        //Header部分
        mHeaderTvTitle.setText(mVideoInfo.getTitle().trim());
        mHeaderTvInstruction.setText(mVideoInfo.getDescription());
        if (mDetailData != null) {
            mHeaderTvPlayed.setText(mDetailData.getPlayed());
            mHeaderTvPlaying.setText(mDetailData.getPlaying());
        }

        mHeaderCoin.setContent(mVideoInfo.getCoins());
        mHeaderCollect.setContent(mVideoInfo.getFavorites());

        mHeaderCoin.setOnClickListener(this);
        mHeaderCollect.setOnClickListener(this);
        mHeaderShare.setOnClickListener(this);
        mHeaderDownload.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BiliDetailSummaryFragment_header_ll_share:
                ToastUtil.show("分享");
                break;

            case R.id.BiliDetailSummaryFragment_header_ll_coin:
                ToastUtil.show("投硬币");
                break;

            case R.id.BiliDetailSummaryFragment_header_ll_collection:
                ToastUtil.show("收藏");
                break;

            case R.id.BiliDetailSummaryFragment_header_ll_download:
                ToastUtil.show("下载");
                break;
        }
    }
}
