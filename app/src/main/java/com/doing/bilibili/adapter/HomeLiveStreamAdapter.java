package com.doing.bilibili.adapter;

import android.content.Context;

import com.doing.bilibili.baselib.adapter.recyclerview.MultiItemTypeAdapter;
import com.doing.bilibili.entity.livestream.HomeLiveStream;

import java.util.List;

/**
 * Created by Doing on 2016/9/22.
 *
 */
public class HomeLiveStreamAdapter extends MultiItemTypeAdapter<HomeLiveStream.LiveStream>{

    public HomeLiveStreamAdapter(Context context, List<HomeLiveStream.LiveStream> data) {
        super(context, data);
    }
}
