package com.doing.bilibili.biliplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.utils.UIUtils;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by Doing on 2016/10/18.
 *
 */
public class PlayView extends FrameLayout {

    private Context mContext;
    private View mRootView;


    public PlayView(Context context) {
        this(context, null);
    }

    public PlayView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View inflate = UIUtils.inflate(R.layout.layout_video_player, this);
        addView(inflate);

        this.mContext = context;

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
    }
}
