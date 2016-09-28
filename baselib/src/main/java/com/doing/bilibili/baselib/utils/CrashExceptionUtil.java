package com.doing.bilibili.baselib.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;

import com.doing.bilibili.baselib.base.BaseActivity;


/**
 * Created by 杜营 on 2016/4/14.
 * 异常全局捕获
 *
 */
public class CrashExceptionUtil implements Thread.UncaughtExceptionHandler {

    private static CrashExceptionUtil instance = new CrashExceptionUtil();

    private CrashExceptionUtil(){}

    private Context mContext;

    public void init(Context context){
        mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
        //Thread.currentThread().setUncaughtExceptionHandler(this);
    }

    public static CrashExceptionUtil getInstance(){
        return instance;
    }


    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        new Thread(){
            @Override
            public void run() {
                Looper.prepare();
                new AlertDialog.Builder(mContext).setTitle("崩溃提示").setCancelable(false).setMessage("应用崩溃了，~~~~(>_<)~~~~呜呜")
                        .setNeutralButton("我知道了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                BaseActivity activity = (BaseActivity)mContext;
                                activity.killAll();
                                Process.killProcess(Process.myPid());
                                System.exit(1);
                            }
                        }).create().show();
                Looper.loop();
            }
        }.start();
        ex.printStackTrace();
        SystemClock.sleep(1000);
    }
}
