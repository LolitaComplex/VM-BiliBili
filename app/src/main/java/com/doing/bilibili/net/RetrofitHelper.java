package com.doing.bilibili.net;

import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.net.api.BiliDetailCommentApi;
import com.doing.bilibili.net.api.BiliDetailSummaryApi;
import com.doing.bilibili.net.api.HomeBangumiApi;
import com.doing.bilibili.net.api.HomeDiscoverApi;
import com.doing.bilibili.net.api.HomeLiveStreamApi;
import com.doing.bilibili.net.api.HomeRecommendApi;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Doing on 2016/9/9.
 *
 */
public class RetrofitHelper {

    private static OkHttpClient mOkHttpClient;

    public static final String APP_BASE_LIVE_URL = "http://live.bilibili.com";

    public static final String APP_BASE_BANGUMI_URL = "http://bangumi.bilibili.com";

    public static final String APP_BASE_DISCOVER_URL = "http://s.search.bilibili.com";

    public static final String APP_BASE_URL = "http://app.bilibili.com";

    public static final String APP_BILI_DETAIL_URL = "http://api.bilibili.cn";

    static {
        initOkHttpClient();
    }

    //TODO OKhttp这部分完全是抄的，不理解，日后依然要来学习一下。Google调试让我删了
    /**
     * 初始化OKHttpClient
     * 设置缓存
     * 设置超时时间
     * 设置打印日志
     * 设置UA拦截器
     */
    private static void initOkHttpClient()
    {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null)
        {
            synchronized (RetrofitHelper.class)
            {
                if (mOkHttpClient == null)
                {
                    //设置Http缓存
                    Cache cache = new Cache(new File(UIUtils.getContext()
                            .getCacheDir(), "HttpCache"), 1024 * 1024 * 100);

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .addInterceptor(new UserAgentInterceptor())
                            .build();
                }
            }
        }
    }

    public static final String COMMON_UA_STR = "Doing Android Client/2.1 (1024587616@qq.com)";

    /**
     * 添加UA拦截器
     * B站请求API文档需要加上UA
     */
    static class UserAgentInterceptor implements Interceptor
    {

        @Override
        public Response intercept(Chain chain) throws IOException
        {

            Request originalRequest = chain.request();
            Request requestWithUserAgent = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", COMMON_UA_STR)
                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }


    public static HomeRecommendApi getHomeRecommendData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(HomeRecommendApi.class);
    }

    public static HomeLiveStreamApi getHomeLiveStreamData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_LIVE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(HomeLiveStreamApi.class);
    }

    public static HomeBangumiApi getHomeBangumiData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_BANGUMI_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(HomeBangumiApi.class);
    }

    public static HomeDiscoverApi getHomeDiscoverData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BASE_DISCOVER_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(HomeDiscoverApi.class);
    }

    public static BiliDetailSummaryApi getBiliDetailSummaryData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BILI_DETAIL_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(BiliDetailSummaryApi.class);
    }

    public static BiliDetailCommentApi getBiliDetailCommentData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_BILI_DETAIL_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(BiliDetailCommentApi.class);
    }
}
