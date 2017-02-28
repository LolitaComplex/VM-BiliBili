package com.doing.bilibili.ui.adapter;

import android.content.Context;

import com.doing.bilibili.baselib.adapter.recyclerview.MultiItemTypeAdapter;
import com.doing.bilibili.data.entity.livestream.HomeLiveStream;
import com.doing.bilibili.ui.fragment.recycleritem.LivingCommonItem;
import com.doing.bilibili.ui.fragment.recycleritem.LivingRecommendItem;

import java.util.List;

/**
 * Created by Doing on 2016/9/22.
 *
 */
public class HomeLiveStreamAdapter extends MultiItemTypeAdapter<HomeLiveStream.LiveStream>{

    public HomeLiveStreamAdapter(Context context, List<HomeLiveStream.LiveStream> data) {
        super(context, data);

        addItemViewDelegate(new LivingRecommendItem(context));
        addItemViewDelegate(new LivingCommonItem(context));
    }
}
