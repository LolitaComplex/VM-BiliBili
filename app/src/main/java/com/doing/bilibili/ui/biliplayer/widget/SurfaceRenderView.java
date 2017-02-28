package com.doing.bilibili.ui.biliplayer.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.doing.bilibili.baselib.utils.LogUtils;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;

/**
 * Created by Doing on 2016/10/18.
 *
 */
public class SurfaceRenderView extends SurfaceView implements IRenderView {

    private MeasureHelper mMeasureHelper;
    private SurfaceCallback mSurfaceCallback;

    public SurfaceRenderView(Context context) {
        this(context, null);
    }

    public SurfaceRenderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SurfaceRenderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView() {
        mMeasureHelper = new MeasureHelper(this);
        mSurfaceCallback = new SurfaceCallback(this);
        getHolder().addCallback(mSurfaceCallback);

        //此代码已经过时，源码提示当我们需要时这个值会自动改变
        //getHolder().setType(SurfaceHolder.SURFACE_TYPE_NORMAL);
    }


    @Override
    public View getView() {
        return this;
    }

    @Override
    public boolean isWaitForResize() {
        return true;
    }

    //--------------------
    // 布局与设置大小
    //--------------------
    @Override
    public void setVideoSize(int videoWidth, int videoHeight) {
        if (videoWidth > 0 && videoHeight > 0) {
            mMeasureHelper.setVideoSize(videoWidth, videoHeight);
            getHolder().setFixedSize(videoWidth, videoHeight);
            requestLayout();
        }
    }

    @Override
    public void setVideoSampleAspectRatio(int videoSarNum, int videoSarDen) {
        if (videoSarDen > 0 && videoSarDen > 0) {
            mMeasureHelper.setVideoSampleAspectRatio(videoSarNum, videoSarDen);
            requestLayout();
        }
    }

    @Override
    public void setAspectRatio(int aspectRatio) {
        mMeasureHelper.setAspectRatio(aspectRatio);
        requestLayout();
    }

    @Override
    public void setVideoRotation(int degree) {
        LogUtils.e("", "SurfaceView doesn't support rotation (" + degree +")!");
    }

    @Override
    public void addRenderCallback(@NonNull IRenderCallback callback) {
        mSurfaceCallback.addRenderCallback(callback);
    }

    @Override
    public void removeRenderCallback(@NonNull IRenderCallback callback) {
        mSurfaceCallback.removeRenderCallback(callback);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mMeasureHelper.getMeasuredWidth(), mMeasureHelper.getMeasuredHeight());
    }

    /**
     * 装饰者模式的逆向使用
     */
    private static final class SurfaceCallback implements SurfaceHolder.Callback {
        private SurfaceHolder mSurfaceHolder;
        private boolean mIsFormatChanged;
        private int mFormat;
        private int mHeight;
        private int mWidth;

        private WeakReference<SurfaceRenderView> mWeakSurfaceView;
        private Map<IRenderCallback, Object> mRenderCallbackMap = new ConcurrentHashMap<>();


        public SurfaceCallback(SurfaceRenderView surfaceView) {
            mWeakSurfaceView = new WeakReference<>(surfaceView);
        }

        public void addRenderCallback(@NonNull IRenderCallback callback) {
            mRenderCallbackMap.put(callback, callback);

            ISurfaceHolder holder = null;
            if (mSurfaceHolder != null) {
                holder = new InternalSurfaceHolder(mWeakSurfaceView.get(), mSurfaceHolder);
                callback.onSurfaceCreated(holder, mWidth, mHeight);
            }

            if (mIsFormatChanged) {
                if (holder == null) {
                    holder = new InternalSurfaceHolder(mWeakSurfaceView.get(), mSurfaceHolder);
                }
                callback.onSurfaceChanged(holder, mFormat, mWidth, mHeight);
            }
        }

        public void removeRenderCallback(@NonNull IRenderCallback callback) {
            mRenderCallbackMap.remove(callback);
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            mSurfaceHolder = holder;
            mIsFormatChanged = false;
            mFormat = 0;
            mWidth = 0;
            mHeight = 0;

            ISurfaceHolder surfaceHolder = new InternalSurfaceHolder(mWeakSurfaceView.get(), holder);
            for (IRenderCallback callback : mRenderCallbackMap.keySet()) {
                callback.onSurfaceCreated(surfaceHolder, mWidth, mHeight);
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            mSurfaceHolder = holder;
            mIsFormatChanged = true;
            mFormat = format;
            mWidth = width;
            mHeight = height;

            ISurfaceHolder surfaceHolder = new InternalSurfaceHolder(mWeakSurfaceView.get(), mSurfaceHolder);
            for (IRenderCallback callback : mRenderCallbackMap.keySet()) {
                callback.onSurfaceChanged(surfaceHolder, format, width, height);
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            mSurfaceHolder = null;
            mIsFormatChanged = false;
            mFormat = 0;
            mWidth = 0;
            mHeight = 0;

            ISurfaceHolder surfaceHolder = new InternalSurfaceHolder(mWeakSurfaceView.get(), mSurfaceHolder);
            for (IRenderCallback callback : mRenderCallbackMap.keySet()) {
                callback.onSurfaceDestroyed(surfaceHolder);
            }
        }
    }

    private static final class InternalSurfaceHolder implements ISurfaceHolder {

        private SurfaceRenderView mSurfaceView;
        private SurfaceHolder mSurfaceHolder;

        public InternalSurfaceHolder(@NonNull SurfaceRenderView sufaceView,
                                     @Nullable SurfaceHolder surfaceHolder) {
            this.mSurfaceHolder = surfaceHolder;
            this.mSurfaceView = sufaceView;
        }

        @Override
        public void bindToMediaPlayer(IMediaPlayer player) {
            if (player != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN &&
                        player instanceof ISurfaceTextureHolder) {
                    ISurfaceTextureHolder holder = (ISurfaceTextureHolder) player;
                    holder.setSurfaceTexture(null);
                }
                player.setDisplay(mSurfaceHolder);
            }
        }

        @Override
        public IRenderView getRenderView() {
            return mSurfaceView;
        }

        @Override
        public SurfaceHolder getSurfaceHolder() {
            return mSurfaceHolder;
        }

        @Override
        public Surface openSurface() {
            if (mSurfaceHolder == null) {
                return null;
            }
            return mSurfaceHolder.getSurface();
        }

        @Override
        public SurfaceTexture getSurfaceTexture() {
            return null;
        }
    }
}
