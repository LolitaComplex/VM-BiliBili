package com.doing.bilibili.baselib.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import com.doing.bilibili.baselib.entity.cache.DaoMaster;
import com.doing.bilibili.baselib.entity.cache.DaoSession;


/**
 * Created by 杜营 on 2016/4/14.
 *
 */
public class BaseApplication extends Application{

    private static BaseApplication application;
    private DaoSession mDaoSession;

    //主线程Id
    private static int mainProcessId;

    //主线程Handler
    private static Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mainProcessId = Process.myTid();
        handler = new Handler(getMainLooper());

        DaoMaster.DevOpenHelper heler = new DaoMaster.DevOpenHelper(this, "cache-db", null);
        DaoMaster master = new DaoMaster(heler.getWritableDatabase());
        mDaoSession = master.newSession();
    }

    public static int getMainId(){
        return mainProcessId;
    }

    public static Handler getHandler(){
        return handler;
    }

    public static Context getApplication(){
        return application;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
