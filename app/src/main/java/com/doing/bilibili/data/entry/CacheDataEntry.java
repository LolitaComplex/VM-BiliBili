package com.doing.bilibili.data.entry;

import android.content.Context;

import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.data.cache.CacheHelper;
import com.doing.bilibili.data.cache.CacheManager;
import com.doing.bilibili.data.entity.recommend.BannerRecommand;
import com.doing.bilibili.data.entity.recommend.Recommend;
import com.doing.bilibili.data.net.BiliNetUtils;
import com.doing.bilibili.data.net.RetrofitHelper;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Cache;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Doing on 2016/11/14.
 *
 */
public class CacheDataEntry {

    private static CacheDataEntry mDataEntiry = new CacheDataEntry();

    private CacheDataEntry(){}

    public static CacheDataEntry getInstance() {
        return mDataEntiry;
    }

    public Observable<Response<List<BannerRecommand>>> getRecommendedBanner(Map<String, String> params) {
        return new CacheHelper.DataBuilder()
                .baseUrl(BiliNetUtils.APP_BASE_URL + "x/banner")
                .addParams(params)
                .addType(new TypeToken<Response<List<BannerRecommand>>>(){}.getType())
                .addRetrofit(new Func1<Map<String, String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(Map<String, String> params) {
                        return RetrofitHelper.getHomeRecommendData().getRecommendedBannerString(params);
                    }
                })
                .build();
    }

    public Observable<Response<List<Recommend>>> getRecommendedList(Map<String, String> params) {
        return new CacheHelper.DataBuilder()
                .baseUrl(BiliNetUtils.APP_BASE_URL + "x/show/old")
                .addParams(params)
                .addType(new TypeToken<Response<List<Recommend>>>(){}.getType())
                .addRetrofit(new Func1<Map<String, String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(Map<String, String> params) {
                        return RetrofitHelper.getHomeRecommendData().getRecommendedListString(params);
                    }
                })
                .build();
    }

    public void removeAllData() {
        CacheManager.deleteAll();
    }
}
