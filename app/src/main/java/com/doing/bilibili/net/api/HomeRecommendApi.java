package com.doing.bilibili.net.api;

import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.entity.recommend.BannerRecommand;
import com.doing.bilibili.entity.recommend.Recommend;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Doing on 2016/9/9.
 *
 */
public interface HomeRecommendApi {

    @GET("x/show/old")
    Observable<Response<List<Recommend>>> getRecommendedList(@QueryMap Map<String, String> params);

/*
        Map<String, String> contentParams = new LinkedHashMap<>();
        if (!TextUtils.isEmpty("")) {
            contentParams.put(Key.ACCESS_KEY, "");
        }
        contentParams.put(Key.APP_KEY, Value.APP_KEY);
        contentParams.put(Key.BUILD, Value.BUILD);
        contentParams.put(Key.CHANNEL, Value.CHANNEL);
        contentParams.put(Key.MOBI_APP, Value.MOBI_APP);
        contentParams.put(Key.PLATFORM, Value.PLATFORM);
        contentParams.put(Key.SCREEN, Value.SCREEN);
        contentParams.put(Key.TS, System.currentTimeMillis() + "");
        contentParams.put(Key.SIGN, BiliNetUtils.getSign(contentParams));
*/

    @GET("x/banner")
    Observable<Response<List<BannerRecommand>>> getRecommendedBaner(@QueryMap Map<String, String> params);

/*
        Map<String, String> bannerParams = new LinkedHashMap<>();
        bannerParams.put("plat", "4");
        bannerParams.put(Key.BUILD, Value.BUILD);
        bannerParams.put(Key.CHANNEL, Value.CHANNEL);
*/

    @GET("x/show/hot/old")
    Observable<Response<List<Recommend.BodyBean>>> getRecommendedHotData();
}
