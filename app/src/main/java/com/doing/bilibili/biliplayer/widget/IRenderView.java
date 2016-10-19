package com.doing.bilibili.biliplayer.widget;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * Created by Doing on 2016/10/18.
 *
 */
public interface IRenderView {

    int AR_ASPECT_FIT_PARENT = 0; // without clip
    int AR_ASPECT_FILL_PARENT = 1; // may clip
    int AR_ASPECT_WRAP_CONTENT = 2;
    int AR_MATCH_PARENT = 3;
    int AR_16_9_FIT_PARENT = 4;
    int AR_4_3_FIT_PARENT = 5;

    /**
     * 获取Instance
     */
    View getView();

    /**
     * 是否需要等待设置大小
     * TODO 这个方法做什么的...最大化时用吗？
     */
    boolean isWaitForResize();


    /**
     * 设置视频的大小
     */
    void setVideoSize(int videoWidth, int videoHeight);


    /**
     * 设置视频的裁剪方式
     * TODO
     */
    void setVideoSampleAspectRatio(int videoSarNum, int videoSarDen);


    /**
     * 设置视频的裁剪方式
     */
    void setAspectRatio(int aspectRatio);

    /**
     * 设置视频的选装角度
     */
    void setVideoRotation(int degree);

    /**
     * 添加视频渲染的回调
     */
    void addRenderCallback(@NonNull IRenderCallback callback);

    void removeRenderCallback(@NonNull IRenderCallback callback);

    interface ISurfaceHolder {
        /**
         * surface界面绑定到mediaplayer上
         */
        void bindToMediaPlayer(IMediaPlayer player);

        /**
         * 获得渲染的View
         */
        IRenderView getRenderView();

        /**
         * 获取具体使用的SurfaceView
         */
        SurfaceHolder getSurfaceHolder();

        /**
         * 打开surface界面
         * TODO Surface对象是什么东西
         */
        Surface openSurface();

        /**
         * 获取渲染使用的具体TextureView
         */
        SurfaceTexture getSurfaceTexture();

    }


    interface IRenderCallback {

        /**
         * 创建Surface页面的大小
         */
        void onSurfaceCreated(@NonNull ISurfaceHolder holder, int width, int height);

        /**
         * surface页面大小改变的监听
         */
        void onSurfaceChanged(@NonNull ISurfaceHolder holder, int format, int width, int height);

        /**
         * surfave页面回收
         */
        void onSurfaceDestroyed(@NonNull ISurfaceHolder holder);
    }
}
