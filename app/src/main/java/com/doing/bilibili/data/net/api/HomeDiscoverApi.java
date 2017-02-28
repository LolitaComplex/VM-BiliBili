package com.doing.bilibili.data.net.api;

import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.data.entity.tag.Tag;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Doing on 2016/9/28 0028.
 *
 */

public interface HomeDiscoverApi {

    @GET("main/hotword")
    Observable<Response<Tag>> getHomeDiscoverTagData();
}
