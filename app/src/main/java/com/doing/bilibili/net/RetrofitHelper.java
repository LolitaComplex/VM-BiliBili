package com.doing.bilibili.net;

import com.doing.bilibili.net.api.HomeBangumiApi;
import com.doing.bilibili.net.api.HomeLiveStreamApi;
import com.doing.bilibili.net.api.HomeRecommendApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Doing on 2016/9/9.
 *
 */
public class RetrofitHelper {


    public static final String APP_BASE_LIVE_URL = "http://live.bilibili.com";

    public static final String APP_BASE_BANGUMI_URL = "http://bangumi.bilibili.com";

    public static final String APP_BASE_URL = "http://app.bilibili.com";


    public static HomeRecommendApi getHomeRecommendData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(HomeRecommendApi.class);
    }

    public static HomeLiveStreamApi getHomeLiveStreamData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_LIVE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(HomeLiveStreamApi.class);
    }

    public static HomeBangumiApi getHomeBangumiData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_BANGUMI_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(HomeBangumiApi.class);
    }

}
