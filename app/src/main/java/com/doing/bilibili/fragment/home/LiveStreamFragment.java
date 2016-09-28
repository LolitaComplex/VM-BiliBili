package com.doing.bilibili.fragment.home;

import android.os.Bundle;
import android.view.View;

import com.doing.bilibili.adapter.HomeLiveStreamAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.HeaderAndFooterWrapper;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.entity.livestream.HomeLiveStream;
import com.doing.bilibili.net.RetrofitHelper;
import com.doing.bilibili.net.api.HomeLiveStreamApi;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func2;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class LiveStreamFragment extends HomeRecyclerFragment<HomeLiveStream> {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.show();
    }

    public static BaseFragment newInstance() {
        return new LiveStreamFragment();
    }

    @Override
    public void initViewWithData(HomeLiveStream data) {
        //设置该页面已经加载成功数据
        setDataIsShowing(true);

        HomeLiveStreamAdapter adapter = new HomeLiveStreamAdapter(mContext, data.getPartitions());

        HeaderAndFooterWrapper wrapperAdapter = new HeaderAndFooterWrapper(adapter);

        List<String> imageUrlList = new ArrayList<>();
        for (HomeLiveStream.BannerBean bannerBean : data.getBanner()) {
            imageUrlList.add(bannerBean.getImg());
        }
        wrapperAdapter.addHeaderView(initBanner(imageUrlList));
    }

    @Override
    protected Observable<Response<HomeLiveStream>> retrofitData() {
        HomeLiveStreamApi liveStreamData = RetrofitHelper.getHomeLiveStreamData();
        return Observable.zip(liveStreamData.getLiveStreamCommon(), liveStreamData.getLiveStreamRecommend(),
                new Func2<Response<HomeLiveStream>, Response<HomeLiveStream.LiveStream>, Response<HomeLiveStream>>() {
                    @Override
                    public Response<HomeLiveStream> call(Response<HomeLiveStream> commonResponse,
                                                         Response<HomeLiveStream.LiveStream> recommendResponse) {

                        List<HomeLiveStream.LiveStream> partitions = commonResponse.getData().getPartitions();

                        partitions.add(0, recommendResponse.getData());

                        return commonResponse;
                    }
                });
    }

}
