package com.doing.bilibili.net.api;

import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.entity.livestream.HomeLiveStream;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Doing on 2016/9/22.
 *
 */
public interface HomeLiveStreamApi {

    @GET("AppNewIndex/common?_device=android&platform=android&scale=xxhdpi")
    Observable<Response<HomeLiveStream>> getLiveStreamCommon();

    //hwid字段无法获取，此接口无法使用
    @GET("AppNewIndex/recommend?_device=android&_hwid=9ec238cf481b1087&appkey=1d8b6e7d45233436&build=426003&mobi_app=android&platform=android&scale=xxhdpi&sign=cb01cac6b427a7bbd4a96ba47a189e9f")
    Observable<Response<HomeLiveStream.LiveStream>> getLiveStreamRecommend();
}
