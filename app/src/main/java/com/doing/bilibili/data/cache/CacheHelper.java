package com.doing.bilibili.data.cache;

import android.os.SystemClock;

import com.doing.bilibili.baselib.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Doing on 2016/11/14.
 *
 */
public class CacheHelper {

    private CacheManager mCacheManager;
    private Gson mGson;

    private CacheHelper() {
        mCacheManager = CacheManager.getInstance();
        mGson = new Gson();
    }

    private static CacheHelper mCacheHelper = new CacheHelper();

    private static CacheHelper getInstance() {
        return mCacheHelper;
    }

    public static class DataBuilder {

        /**
         * 存在多线程同步问题，使用请斟酌(这里当时自己的想法完全是错的，静态内部类不是如果外部类不是静态的，同样会创建多个对象)
         */
        private String url;
        private Map<String, String> params = new LinkedHashMap<>();
        private Func1<Map<String, String>, Observable<String>> func;
        private Type type = new TypeToken<Object>() {}.getType();

        /**
         * 缓存数据的地址值
         *
         * @param url 地址值
         */
        public DataBuilder baseUrl(String url) {
            this.url = url;
            return this;
        }

        /**
         * 缓存数据的参数
         *
         * @param params 参数
         */
        public DataBuilder addParams(Map<String, String> params) {
            this.params.clear();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                this.params.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        /**
         * 缓存数据转换的对象类型
         *
         * @param type new TypeToken<对象类型>(){}.getType()
         */
        public DataBuilder addType(Type type) {
            this.type = type;
            return this;
        }

        /**
         * 缓存数据获取的逻辑
         */
        public DataBuilder addRetrofit(Func1<Map<String, String>, Observable<String>> func) {
            this.func = func;
            return this;
        }


        /**
         * 构建缓存
         */
        public <T> Observable<T> build() {
//            LogUtils.e("CacheHelper", "Budilder地址值" + this.hashCode() + "全称:" + this.toString());
            return getInstance().getData(url, params, type, func);
        }
    }

    /**
     * 获取数据，并且会判断是否缓存。
     *
     * @param url    请求地址
     * @param params 请求参数
     * @param func   Retrofit请求的逻辑
     * @return 包裹了数据的Observable
     */
    private <T> Observable<T> getData(final String url, final Map<String, String> params,
                                      final Type type, final Func1<Map<String, String>, Observable<String>> func) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                try {
                    boolean hanveCache = mCacheManager.haveCache(url, params);
                    subscriber.onNext(hanveCache);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).flatMap(new Func1<Boolean, Observable<T>>() {
            @Override
            public Observable<T> call(Boolean flag) {
                if (flag) {
                    return getCache(url, params, type);
                } else {
                    return func.call(params)
                            .doOnNext(new Action1<String>() {
                                @Override
                                public void call(final String s) {
                                    //不会阻塞UI线程
                                    Schedulers.io()
                                            .createWorker()
                                            .schedule(new Action0() {
                                                @Override
                                                public void call() {
                                                    mCacheManager.saveCache(url, params, s);
                                                }
                                            });
                                }
                            })
                            .map(new Func1<String, T>() {
                                @Override
                                public T call(String json) {
                                    return mGson.fromJson(json, type);
                                }
                            });
                }

            }
        });
    }

    private <T> Observable<T> getCache(final String url, final Map<String, String> params, final Type type) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    String json = mCacheManager.getCache(url, params);
                    T t = mGson.fromJson(json, type);
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
