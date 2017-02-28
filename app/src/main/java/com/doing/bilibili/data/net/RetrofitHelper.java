package com.doing.bilibili.data.net;

import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.data.net.api.BiliDetailCommentApi;
import com.doing.bilibili.data.net.api.BiliDetailSummaryApi;
import com.doing.bilibili.data.net.api.HomeBangumiApi;
import com.doing.bilibili.data.net.api.HomeDiscoverApi;
import com.doing.bilibili.data.net.api.HomeLiveStreamApi;
import com.doing.bilibili.data.net.api.HomeRecommendApi;

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
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.doing.bilibili.data.net.BiliNetUtils.APP_BASE_URL;
import static com.doing.bilibili.data.net.BiliNetUtils.APP_BASE_LIVE_URL;
import static com.doing.bilibili.data.net.BiliNetUtils.APP_BASE_BANGUMI_URL;
import static com.doing.bilibili.data.net.BiliNetUtils.APP_BASE_DISCOVER_URL;
import static com.doing.bilibili.data.net.BiliNetUtils.APP_BILI_DETAIL_URL;

/**
 * Created by Doing on 2016/9/9.
 *
 */
public class RetrofitHelper {

    private static OkHttpClient mOkHttpClient;

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
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(15, TimeUnit.SECONDS)
                            .readTimeout(15, TimeUnit.SECONDS)
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
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request requestWithUserAgent = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", COMMON_UA_STR)
                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }


    public static HomeRecommendApi getHomeRecommendData() {
        return getRetrofitApi(APP_BASE_URL, HomeRecommendApi.class);
    }

    public static HomeLiveStreamApi getHomeLiveStreamData() {
        return getRetrofitApi(APP_BASE_LIVE_URL, HomeLiveStreamApi.class);
    }

    public static HomeBangumiApi getHomeBangumiData() {
        return getRetrofitApi(APP_BASE_BANGUMI_URL, HomeBangumiApi.class);
    }

    public static HomeDiscoverApi getHomeDiscoverData() {
        return getRetrofitApi(APP_BASE_DISCOVER_URL, HomeDiscoverApi.class);
    }

    public static BiliDetailSummaryApi getBiliDetailSummaryData() {
        return getRetrofitApi(APP_BILI_DETAIL_URL, BiliDetailSummaryApi.class);
    }

    public static BiliDetailCommentApi getBiliDetailCommentData() {
        return getRetrofitApi(APP_BILI_DETAIL_URL, BiliDetailCommentApi.class);
    }


    private static <T> T getRetrofitApi(String url, Class<T> clazz) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(mOkHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(clazz);
    }
}
