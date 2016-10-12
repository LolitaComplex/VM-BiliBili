package com.doing.bilibili.fragment.detail;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.BiliDetalActivity;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.entity.argument.DetailData;
import com.doing.bilibili.entity.bilidetail.DetailRecommandVideo;
import com.doing.bilibili.entity.bilidetail.DetailVideoInfo;
import com.doing.bilibili.entity.bilidetail.SummaryData;
import com.doing.bilibili.net.BiliNetUtils;
import com.doing.bilibili.net.RetrofitHelper;
import com.doing.bilibili.ui.BiliDetailFunctionView;
import com.squareup.picasso.Picasso;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.functions.Func1;

import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Key;
import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Value;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailSummaryFragment extends BaseLoadingFragment<DetailRecommandVideo> {

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
    @BindView(R.id.BiliDetailSummaryFragment_body_iv_cover)
    protected ImageView mBodyIvCover;
    @BindView(R.id.BiliDetailSummaryFragment_body_tv_author)
    protected TextView mBodyTvAuthor;
    @BindView(R.id.BiliDetailSummaryFragment_body_tv_time)
    protected TextView mBodyTvTime;
    @BindView(R.id.BiliDetailSummaryFragment_body_tv_attention)
    protected TextView mBodyTvAttention;

    private DetailVideoInfo mVideoInfo;
    private DetailData mDetailData;

    public static BiliDetailSummaryFragment newInstance() {
        return new BiliDetailSummaryFragment();
    }

    @Override
    protected void initVariable() {
        mDetailData = getArguments().getParcelable(
                BiliDetalActivity.DETAIL_DATA);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bilidetail_summary;
    }

    @Override
    public void initViewWithData(DetailRecommandVideo data) {
        SummaryData sData = new SummaryData(mVideoInfo, data);

        mHeaderTvTitle.setText(mVideoInfo.getTitle().trim());
        mHeaderTvInstruction.setText(mVideoInfo.getDescription());
        if (mDetailData != null) {
            mHeaderTvPlayed.setText(mDetailData.getPlayed());
            mHeaderTvPlaying.setText(mDetailData.getPlaying());
        }

        mHeaderCoin.setContent(mVideoInfo.getCoins());
        mHeaderCollect.setContent(mVideoInfo.getFavorites());

//        Picasso.with(mContext).load(mVideoInfo.getFace()).get();
//
//        RoundedBitmapDrawableFactory.
//        mBodyIvCover.getDrawable().get
    }

    @Override
    protected Observable<Response<DetailRecommandVideo>> retrofitData() {
        String av = null;
        if (mDetailData != null) {
            av = mDetailData.getAv();
        }

        return RetrofitHelper.getBiliDetailSummaryData().getVideoInfo(initVideoInfoData(av))
                .flatMap(new Func1<DetailVideoInfo, Observable<DetailRecommandVideo>>() {
                    @Override
                    public Observable<DetailRecommandVideo> call(DetailVideoInfo detailVideoInfo) {
                        mVideoInfo = detailVideoInfo;
                        int tid = detailVideoInfo.getTid();
                        return RetrofitHelper.getBiliDetailSummaryData().getRecommandVideo(initRecmmandVideoData(tid));
                    }
                }).map(new Func1<DetailRecommandVideo, Response<DetailRecommandVideo>>() {
                    @Override
                    public Response<DetailRecommandVideo> call(DetailRecommandVideo recommandVideo) {
                        Response<DetailRecommandVideo> response = new Response<>();
                        response.setCode(0);
                        response.setData(recommandVideo);
                        return response;
                    }
                });
        /*
        //此合并方法为合并静态数据与Oberserable
        .zipWith(videoInfo, new Func2<DetailRecommandVideo, DetailVideoInfo, Response<SummaryData>>() {
                    @Override
                    public Response<SummaryData> call(DetailRecommandVideo detailRecommandVideo, DetailVideoInfo detailVideoInfo) {
                        Response<SummaryData> response = new Response<>();
                        response.setCode(0);
                        response.setData(new SummaryData(detailVideoInfo, detailRecommandVideo));
                        return response;
                    }
                }
        */
    }

    private Map<String, String> initRecmmandVideoData(int tid) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(Key.ORDER, "hot");
        map.put(Key.PAGE, "1");
        map.put(Key.PAGESIZE, "20");
        map.put("tid", tid + "");
        return map;
    }

    private Map<String, String> initVideoInfoData(String id) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(Key.DEVICE, Value.DEVICE);
        map.put(Key.HWID, Value.HWID);
        map.put(Key.APP_KEY, Value.APP_KEY);
        map.put(Key.BUILD, Value.BUILD);
        map.put("id", id);
        map.put(Key.MOBI_APP, Value.MOBI_APP);
        map.put(Key.PAGE, 1 + "");
        map.put(Key.PLATFORM, Value.PLATFORM);

        String sign = BiliNetUtils.getSign(map);

        map.put(Key.SIGN, sign);
        return map;
    }

}
