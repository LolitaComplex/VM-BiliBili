package com.doing.bilibili.ui.biliplayer.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;

/**
 * Created by Doing on 2016/10/19.
 *
 */
public class TextureRenderView extends TextureView implements IRenderView {


    private MeasureHelper mMeasureHelper;
    private TextureViewCallback mTextureViewCallback;

    public TextureRenderView(Context context) {
        this(context, null);
    }

    public TextureRenderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextureRenderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mMeasureHelper = new MeasureHelper(this);
        mTextureViewCallback = new TextureViewCallback(this);

        setSurfaceTextureListener(mTextureViewCallback);
    }


    @Override
    public View getView() {
        return this;
    }

    @Override
    public boolean isWaitForResize() {
        return false;
    }

    public ISurfaceHolder getSurfaceHolder() {
        return new InternalSurfaceHolder(this, mTextureViewCallback.mSurfaceTexture);
    }

    //-----------------
    // 布局与设置大小
    //-----------------
    @Override
    public void setVideoSize(int videoWidth, int videoHeight) {
        if (videoWidth > 0 && videoHeight > 0) {
            mMeasureHelper.setVideoSize(videoWidth, videoHeight);
            requestLayout();
        }
    }

    @Override
    public void setVideoSampleAspectRatio(int videoSarNum, int videoSarDen) {
        if (videoSarDen > 0 && videoSarNum > 0) {
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
        mMeasureHelper.setVideoRotation(degree);
        requestLayout();
    }

    @Override
    public void addRenderCallback(@NonNull IRenderCallback callback) {
        mTextureViewCallback.addRenderCallback(callback);
    }

    @Override
    public void removeRenderCallback(@NonNull IRenderCallback callback) {
        mTextureViewCallback.removeRenderCallback(callback);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mMeasureHelper.doMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mMeasureHelper.getMeasuredWidth(), mMeasureHelper.getMeasuredHeight());
    }

    private static final class TextureViewCallback implements SurfaceTextureListener {
        private SurfaceTexture mSurfaceTexture;
        private boolean mOwnSurfaceTecture;

        private int mWidth;
        private int mHeight;
        private boolean mIsFormatChanage;


        private final WeakReference<TextureRenderView> mWeakReaderView;
        private Map<IRenderCallback, Object> mReaderCallbackMap = new ConcurrentHashMap<>();

        public TextureViewCallback(@NonNull TextureRenderView readerView) {
            mWeakReaderView = new WeakReference<>(readerView);
        }

        public void setOwnSurfaceTecture(boolean ownSurfaceTecture) {
            mOwnSurfaceTecture = ownSurfaceTecture;
        }

        public void addRenderCallback(@NonNull IRenderCallback callback) {
            mReaderCallbackMap.put(callback, callback);

            ISurfaceHolder surfaceHolder = null;
            if (mSurfaceTexture != null) {
                surfaceHolder = new InternalSurfaceHolder(mWeakReaderView.get(), mSurfaceTexture);
                callback.onSurfaceCreated(surfaceHolder, mWidth, mHeight);
            }

            if (mIsFormatChanage) {
                if (surfaceHolder != null) {
                    surfaceHolder = new InternalSurfaceHolder(mWeakReaderView.get(), mSurfaceTexture);
                }
                callback.onSurfaceChanged(surfaceHolder, 0, mWidth, mHeight);
            }
        }

        public void removeRenderCallback(@NonNull IRenderCallback callback) {
            mReaderCallbackMap.remove(callback);
        }

        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            mSurfaceTexture = surface;
            mIsFormatChanage = false;
            mWidth = 0;
            mHeight = 0;

            ISurfaceHolder surfaceHolder = new InternalSurfaceHolder(mWeakReaderView.get(), mSurfaceTexture);
            for (IRenderCallback callback : mReaderCallbackMap.keySet()) {
                callback.onSurfaceCreated(surfaceHolder, width, height);
            }
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            mSurfaceTexture = surface;
            mIsFormatChanage = true;
            mWidth = width;
            mHeight = height;

            ISurfaceHolder surfaceHolder = new InternalSurfaceHolder(mWeakReaderView.get(), mSurfaceTexture);
            for (IRenderCallback callback : mReaderCallbackMap.keySet()) {
                callback.onSurfaceChanged(surfaceHolder, 0, width, height);
            }
        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            mSurfaceTexture = surface;
            mIsFormatChanage = false;
            mWidth = 0;
            mHeight = 0;

            ISurfaceHolder holder = new InternalSurfaceHolder(mWeakReaderView.get(), mSurfaceTexture);
            for (IRenderCallback callback : mReaderCallbackMap.keySet()) {
                callback.onSurfaceDestroyed(holder);
            }

            return mOwnSurfaceTecture;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    }

    private static final class InternalSurfaceHolder implements ISurfaceHolder {

        private SurfaceTexture mSurfaceTexture;
        private TextureRenderView mTextureReaderView;

        public InternalSurfaceHolder(@NonNull TextureRenderView textureRenderView,
                                     @Nullable SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.mTextureReaderView = textureRenderView;
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void bindToMediaPlayer(IMediaPlayer player) {
            if (player == null) {
                return;
            }

            if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) &&
                    player instanceof ISurfaceTextureHolder) {
                ISurfaceTextureHolder holder = (ISurfaceTextureHolder) player;
                mTextureReaderView.mTextureViewCallback.setOwnSurfaceTecture(false);

                SurfaceTexture surfaceTexture = holder.getSurfaceTexture();
                if (surfaceTexture != null) {
                    mTextureReaderView.setSurfaceTexture(surfaceTexture);
                } else {
                    holder.setSurfaceTexture(mSurfaceTexture);
                }
            } else {
                player.setSurface(openSurface());
            }
        }

        @Override
        public IRenderView getRenderView() {
            return mTextureReaderView;
        }

        @Override
        public SurfaceHolder getSurfaceHolder() {
            return null;
        }

        @Override
        public Surface openSurface() {
            if (mSurfaceTexture == null) {
                return null;
            }
            return new Surface(mSurfaceTexture);
        }

        @Override
        public SurfaceTexture getSurfaceTexture() {
            return mSurfaceTexture;
        }
    }
}
