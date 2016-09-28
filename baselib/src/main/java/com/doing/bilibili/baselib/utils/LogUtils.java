package com.doing.bilibili.baselib.utils;

import com.orhanobut.logger.Logger;


/**
 * Created by 杜营 on 2016/4/18.
 *
 */
public class LogUtils {

    private static final boolean LOGFLAG = true;

    public static void d(String tag, String mes){
        if(LOGFLAG)
           Logger.t(tag).d(mes);
    }

    public static void e(String tag, String mes){
        if(LOGFLAG)
           Logger.t(tag).e(mes);
    }

    public static void w(String tag, String mes){
        if(LOGFLAG)
            Logger.t(tag).w(mes);
    }

    public static void v(String tag, String mes){
        if(LOGFLAG)
            Logger.t(tag).v(mes);
    }

    public static void wtf(String tag, String mes){
        if (LOGFLAG)
            Logger.t(tag).wtf(mes);
    }

    public static void json(String tag, String mes){
        if (LOGFLAG)
            Logger.t(tag).json(mes);
    }

    public static void xml(String tag, String mes){
        if (LOGFLAG)
            Logger.t(tag).xml(mes);
    }

    /**
     * 打印异常的工具方法
     * @param tag
     * @param throwable 异常对象
     * @param mes
     * @param args 引起的异常描述
     */
    public static void e(String tag,Throwable throwable,String mes,Object... args){
        if (LOGFLAG)
            Logger.t(tag).e(throwable,mes,args);
    }
}
