package com.doing.bilibili.fragment.home;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.HomeBangumiAdapter;
import com.doing.bilibili.adapter.RotateAnimatorAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.HeaderAndFooterWrapper;
import com.doing.bilibili.baselib.adapter.recyclerview.LoadMoreWrapper;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.bangumi.BangumiBannerBean;
import com.doing.bilibili.entity.bangumi.BangumiItemBean;
import com.doing.bilibili.entity.bangumi.BangumiListBean;
import com.doing.bilibili.entity.bangumi.HomeBangumi;
import com.doing.bilibili.entity.bangumi.HomeRealBangumi;
import com.doing.bilibili.net.BiliNetUtils;

import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Key;
import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Value;

import com.doing.bilibili.net.RetrofitHelper;
import com.doing.bilibili.net.api.HomeBangumiApi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class BangumiFragment extends HomeRecyclerFragment<HomeRealBangumi> implements View.OnClickListener {

    private LoadMoreWrapper mRecyclerAdapter;

    public static BaseFragment newInstance() {
        return new BangumiFragment();
    }

    @Override
    public void initViewWithData(final HomeRealBangumi data) {
        super.initViewWithData(data);

        HomeBangumiAdapter adapter = new HomeBangumiAdapter(mContext, data.getData());

        RotateAnimatorAdapter animatorAdapter = new RotateAnimatorAdapter(adapter);

        HeaderAndFooterWrapper adapterWrapper = new HeaderAndFooterWrapper(animatorAdapter);

        List<String> imageList = new ArrayList<>();
        for (BangumiBannerBean.HeadBean head : data.getAd().getHead()) {
            imageList.add(head.getImg());
        }
        adapterWrapper.addHeaderView(initBanner(imageList));
        adapterWrapper.addHeaderView(initHeaderView());

        mRecyclerAdapter = new LoadMoreWrapper(adapterWrapper);
        mRecyclerAdapter.setLoadMoreView(R.layout.default_loading);
        mRecyclerAdapter.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMoreData(data);
            }
        });

        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    private void loadMoreData(final HomeRealBangumi data) {
        List<BangumiListBean> sourceData = data.getData().get(data.getData().size() - 1).getList();
        String cursor = sourceData.get(sourceData.size() - 1).getCursor();
        RetrofitHelper.getHomeBangumiData()
                .getHomeBangumiRecommend(initRequestData(cursor))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Response<List<BangumiListBean>>>() {
                    @Override
                    public void call(Response<List<BangumiListBean>> response) {
                        List<BangumiListBean> list = response.getResult();
                        if(list.size() > 0) {
                            for (BangumiListBean bean : list) {
                                data.getData().add(new BangumiItemBean().setList(bean));
                            }

                        }else {
                            mRecyclerAdapter.setLoadMoreView(R.layout.loading_finish);
                        }
                        mRecyclerAdapter.notifyItemRangeChanged(list.size(), list.size());
                    }
                });
    }

    private Map<String, String> initRequestData(String cursor) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(Key.APP_KEY, Value.APP_KEY);
        map.put(Key.BUILD, Value.BUILD);
        map.put(Key.CURSOR, cursor);
        map.put(Key.MOBI_APP, Value.MOBI_APP);
        map.put(Key.PAGESIZE, 10 + "");
        map.put(Key.PLATFORM, Value.PLATFORM);
        map.put(Key.TS, System.currentTimeMillis() + "");

        String sign = BiliNetUtils.getSign(map);

        map.put(Key.SIGN, sign);
        return map;
    }


    @Override
    protected Observable<Response<HomeRealBangumi>> retrofitData() {
        HomeBangumiApi homeBangumiData = RetrofitHelper.getHomeBangumiData();

        return Observable.zip(homeBangumiData.getHomeBangumi(),
                homeBangumiData.getHomeBangumiRecommend(initRequestData("-1")),
                new Func2<Response<HomeBangumi>, Response<List<BangumiListBean>>, Response<HomeRealBangumi>>() {
                    @Override
                    public Response<HomeRealBangumi> call(Response<HomeBangumi> bangumi, Response<List<BangumiListBean>> bangumiRecommend) {
                        Response<HomeRealBangumi> response = new Response<>();
                        response.setCode(bangumi.getCode());
                        response.setMessage(bangumi.getMessage());

                        HomeBangumi result = bangumi.getResult();
                        HomeRealBangumi realBangumi = new HomeRealBangumi();
                        realBangumi.setAd(result.getAd());

                        List<BangumiItemBean> bangumiListItem = new ArrayList<>();
                        bangumiListItem.add(new BangumiItemBean()
                                .setList(result.getSerializing()));
                        bangumiListItem.add(new BangumiItemBean()
                                .setList(result.getChina()));
                        bangumiListItem.add(new BangumiItemBean()
                                .setSeason(result.getPrevious().getSeason())
                                .setYear(result.getPrevious().getYear())
                                .setList(result.getPrevious().getList()));
                        bangumiListItem.add(new BangumiItemBean()
                                .setList(bangumiRecommend.getResult()));

                        for (BangumiListBean item : bangumiRecommend.getResult()) {
                            bangumiListItem.add(new BangumiItemBean().setList(item));
                        }

                        realBangumi.setData(bangumiListItem);
                        response.setResult(realBangumi);
                        return response;
                    }
                });
    }

    public View initHeaderView() {
        View inflate = UIUtils.inflate(R.layout.item_bangumi_headerview);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);

        inflate.findViewById(R.id.HomeBangumi_btn_animate_after).setOnClickListener(this);
        inflate.findViewById(R.id.HomeBangumi_btn_play_table).setOnClickListener(this);
        inflate.findViewById(R.id.HomeBangumi_btn_index).setOnClickListener(this);

        inflate.setLayoutParams(layoutParams);
        return inflate;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.HomeBangumi_btn_animate_after:
                ToastUtil.show("追番");
                break;

            case R.id.HomeBangumi_btn_play_table:
                ToastUtil.show("放松表");
                break;

            case R.id.HomeBangumi_btn_index:
                ToastUtil.show("索引");
                break;
        }
    }
}
