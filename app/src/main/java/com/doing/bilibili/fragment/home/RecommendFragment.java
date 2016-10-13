package com.doing.bilibili.fragment.home;

import com.doing.bilibili.adapter.HomeRecommendAdapter;
import com.doing.bilibili.adapter.RotateAnimatorAdapter;
import com.doing.bilibili.base.RxBus;
import com.doing.bilibili.baselib.adapter.recyclerview.HeaderAndFooterWrapper;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.entity.bus.BusRecommend;
import com.doing.bilibili.entity.recommend.BannerRecommand;
import com.doing.bilibili.entity.recommend.HomeRecommend;
import com.doing.bilibili.entity.recommend.Recommend;
import com.doing.bilibili.net.RetrofitHelper;
import com.doing.bilibili.net.api.HomeRecommendApi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * Created by Doing on 2016/9/6.
 */
public class RecommendFragment extends HomeRecyclerFragment<HomeRecommend> {

    private List<Recommend> mRecommends;

    public static BaseFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    public void initViewWithData(HomeRecommend data) {
        mRecommends = data.getRecommends();
        HomeRecommendAdapter adapter = new HomeRecommendAdapter(getContext(), data.getRecommends());

        RotateAnimatorAdapter animatorAdapter = new RotateAnimatorAdapter(adapter);
        //添加头部Banner
        HeaderAndFooterWrapper wrapperAdapter = new HeaderAndFooterWrapper(animatorAdapter);
        List<String> imageUrlList = new ArrayList<>();
        for (BannerRecommand bannerRecommand : data.getBanners()) {
            imageUrlList.add(bannerRecommand.getImage());
        }

        wrapperAdapter.addHeaderView(initBanner(imageUrlList));
        //配置RecyclerView

        mRecyclerView.setAdapter(wrapperAdapter);

        super.initViewWithData(data);
    }

    @Override
    protected void subscirp() {
        //更新热门数据
        RxBus.getDefault()
                .toObservable(BusRecommend.class)
                .subscribe(new Action1<BusRecommend>() {
                    @Override
                    public void call(BusRecommend hotRecommend) {
                        int refreshPosition = hotRecommend.getPosition() + 1;
                        mRecommends.get(refreshPosition - 1).setBody(hotRecommend.getData());
                        mRecyclerView.getAdapter().notifyItemChanged(refreshPosition);
                    }
                });
    }

    @Override
    protected Observable<Response<HomeRecommend>> retrofitData() {
        Map<String, String> contentParams = new LinkedHashMap<>();
        Map<String, String> bannerParams = new LinkedHashMap<>();
        bannerParams.put("plat", "4");

        HomeRecommendApi homeRecommendData = RetrofitHelper.getHomeRecommendData();

        return Observable.zip(homeRecommendData.getRecommendedBaner(bannerParams),
                homeRecommendData.getRecommendedList(contentParams),
                new Func2<Response<List<BannerRecommand>>, Response<List<Recommend>>, Response<HomeRecommend>>() {
                    @Override
                    public Response<HomeRecommend> call(Response<List<BannerRecommand>> listBanner, Response<List<Recommend>> listRecommend) {
                        Response<HomeRecommend> responseResult = new Response<>();
                        responseResult.setCode(listRecommend.getCode());

                        HomeRecommend homeRecommend = new HomeRecommend();
                        homeRecommend.setBanners(listBanner.getData());
                        homeRecommend.setRecommends(listRecommend.getResult());
                        responseResult.setResult(homeRecommend);

                        return responseResult;
                    }
                });
    }

}
