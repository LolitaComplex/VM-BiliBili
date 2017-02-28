package com.doing.bilibili.data.net.api;

import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.data.entity.livestream.HomeLiveStream;
import com.doing.bilibili.data.entity.livestream.LiveRecommendBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Doing on 2016/9/22.
 *
 */
public interface HomeLiveStreamApi {

    @GET("AppNewIndex/common?_device=android&platform=android&scale=xxhdpi")
    Observable<Response<HomeLiveStream>> getLiveStreamCommon();

    //hwid字段无法获取，此接口无法使用
    @GET("AppNewIndex/recommend")
    Observable<Response<LiveRecommendBean>> getLiveStreamRecommend(@QueryMap Map<String,String> params);
}
