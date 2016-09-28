package com.doing.bilibili.net.api;

import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.entity.bangumi.BangumiListBean;
import com.doing.bilibili.entity.bangumi.HomeBangumi;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public interface HomeBangumiApi {

    @GET("api/app_index_page_v4_2")
    Observable<Response<HomeBangumi>> getHomeBangumi();

    @GET("api/bangumi_recommend")
    Observable<Response<List<BangumiListBean>>> getHomeBangumiRecommend(@QueryMap Map<String,String> questData);

}
