package com.doing.bilibili.net.api;

import com.doing.bilibili.entity.bilidetail.DetailRecommandVideo;
import com.doing.bilibili.entity.bilidetail.DetailVideoInfo;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Doing on 2016/10/12.
 *
 */
public interface BiliDetailSummaryApi {

    @GET("recommend")
    Observable<DetailRecommandVideo> getRecommandVideo(@QueryMap Map<String,String> params);

    @GET("view")
    Observable<DetailVideoInfo> getVideoInfo(@QueryMap Map<String, String> params);
}

