package com.doing.bilibili.biliplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by Doing on 2016/10/18.
 *
 */
public class PlayView extends FrameLayout {

    @BindView(R.id.VideoPlayer_ijk_videoview)
    protected IjkVideoView mIjkVideoView;
    @BindView(R.id.VideoPlayer_btn_play)
    protected ToggleButton mBtnPlay;
    @BindView(R.id.VideoPlayer_tv_currenttime)
    protected TextView mTvCurrentTime;
    @BindView(R.id.VideoPlayer_seekbar)
    protected SeekBar mSbProgress;
    @BindView(R.id.VideoPlayer_tv_length)
    protected TextView mTvLength;
    @BindView(R.id.VideoPlayer_iv_fullscreen)
    protected ImageView mIvFullScreent;
    @BindView(R.id.VideoPlayer_little_bottom_bar)
    protected LinearLayout mLlLittleBottomBar;
    private View mRootView;

    public PlayView(Context context) {
        this(context, null);
    }

    public PlayView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mRootView = UIUtils.inflate(R.layout.layout_video_player, this);
        ButterKnife.bind(this, mRootView);
        addView(mRootView);

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        mSbProgress.setMax(100);
        mSbProgress.setOnSeekBarChangeListener(mPlaySeekBarListener);

        mBtnPlay.setOnClickListener(mOnClickListener);
        mIvFullScreent.setOnClickListener(mOnClickListener);
    }

    private final OnSeekBarChangeListener mPlaySeekBarListener =  new OnSeekBarChangeListener(){

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            ToastUtil.show("当前进度"+progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private final OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.VideoPlayer_btn_play:
                    ToastUtil.show("开始播放或者暂停");
                    break;

                case R.id.VideoPlayer_iv_fullscreen:
                    ToastUtil.show("全屏播放");
                    break;
            }
        }
    };
}
