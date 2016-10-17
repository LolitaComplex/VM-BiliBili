package com.doing.bilibili.fragment.detail;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.BiliDetalActivity;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.HeaderAndFooterWrapper;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.argument.DetailData;
import com.doing.bilibili.entity.bilidetail.DetailRecommandVideo;
import com.doing.bilibili.entity.bilidetail.DetailVideoInfo;
import com.doing.bilibili.net.BiliNetUtils;
import com.doing.bilibili.net.RetrofitHelper;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import rx.Observable;
import rx.functions.Func1;

import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Key;
import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Value;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailSummaryFragment extends BaseLoadingFragment<DetailRecommandVideo> {


    @BindView(R.id.BiliDetailFragment_recycler)
    protected RecyclerView mRecyclerView;

    private DetailVideoInfo mVideoInfo;
    private DetailData mDetailData;

    public static BaseFragment newInstance(DetailData detailData) {
        BaseFragment fragment = new BiliDetailSummaryFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(BiliDetalActivity.DETAIL_DATA, detailData);
        fragment.setArguments(bundle);
        return fragment;
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
        return R.layout.fragment_bilidetail;
    }

    @Override
    public void initViewWithData(DetailRecommandVideo data) {
        setDataIsShowing(true);

        CommonAdapter<DetailRecommandVideo.ListBean> adapter =
                new CommonAdapter<DetailRecommandVideo.ListBean>(
                        mContext, R.layout.item_recycler_common, data.getList()) {
                    @Override
                    protected void convert(BaseViewHolder holder,
                                           DetailRecommandVideo.ListBean listBean, int positon) {
                        holder.getContentView().setBackgroundResource(R.drawable.item_touch_bg_transparent);

                        holder.setText(R.id.RecyclerCommonItem_tv_title, listBean.getTitle())
                                .setText(R.id.RecyclerCommonItem_tv_up, listBean.getAuthor())
                                .setText(R.id.RecyclerCommonItem_tv_playing, listBean.getPlay())
                                .setText(R.id.RecyclerCommonItem_tv_leave_mes, listBean.getReview()+"")
                                .setImageUrl(R.id.RecyclerCommonItem_iv_cover, listBean.getPic());
                    }

                };

        adapter.setEnable(true);
        HeaderAndFooterWrapper wrapperAdapter = new HeaderAndFooterWrapper(adapter);

        //拆成两部分是因为HeaderView过长时显示不完整
        //后来找到的显示不完整的原因是我设置match_parent导致的。可是都改成这个样子了，懒得在改回去了
        wrapperAdapter.addHeaderView(initHeaderView(R.layout.item_summary_recycler_header_top));
        wrapperAdapter.addHeaderView(initHeaderView(R.layout.item_summary_recycler_header_bottom));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setItemAnimator(new FadeInAnimator());
        mRecyclerView.setAdapter(wrapperAdapter);
    }

    private View initHeaderView(@LayoutRes int headerId) {
        LinearLayout inflate = (LinearLayout) UIUtils.inflate(headerId);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        inflate.setLayoutParams(params);
        inflate.setOrientation(LinearLayout.VERTICAL);

        if (headerId == R.layout.item_summary_recycler_header_top) {
            SummaryHeaderTopHolder holer = new SummaryHeaderTopHolder(inflate, mVideoInfo, mDetailData);
            holer.covertView();
        } else {
            SummaryHeaderBottomHolder holer = new SummaryHeaderBottomHolder(inflate, mVideoInfo, mDetailData);
            holer.covertView();
        }

        return inflate;
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
