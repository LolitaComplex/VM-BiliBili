package com.doing.bilibili.net.api;

import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.entity.tag.Tag;

import java.util.List;

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
