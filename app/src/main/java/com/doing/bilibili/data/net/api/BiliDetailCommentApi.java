package com.doing.bilibili.data.net.api;

import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.data.entity.bilidetail.DetailComment;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Doing on 2016/10/12.
 *
 */
public interface BiliDetailCommentApi {

    @GET("x/v2/reply")
    Observable<Response<DetailComment>> getCommentApi(@QueryMap Map<String, String> params);
}
