package com.doing.bilibili.adapter;

import android.content.Context;

import com.doing.bilibili.baselib.adapter.recyclerview.MultiItemTypeAdapter;
import com.doing.bilibili.entity.recommend.Recommend;
import com.doing.bilibili.fragment.recycleritem.ActivityRecommendItem;
import com.doing.bilibili.fragment.recycleritem.BangumiRecommendItem;
import com.doing.bilibili.fragment.recycleritem.CommonRecommendItem;
import com.doing.bilibili.fragment.recycleritem.HotRecommendItem;
import com.doing.bilibili.fragment.recycleritem.LivingItem;
import com.doing.bilibili.fragment.recycleritem.TopicRecommendItem;

import java.util.List;

/**
 * Created by Doing on 2016/9/19.
 *
 */
public class HomeRecommendAdapter extends MultiItemTypeAdapter<Recommend> {

    public static final String HOT_RECOMMEND = "recommend";
    public static final String LIVE = "live";
    public static final String BANGUMI = "bangumi_2";
    public static final String REGION = "region";
    public static final String TOPIC = "weblink";
    public static final String ACTIVITY = "activity";


    public HomeRecommendAdapter(Context context, List<Recommend> data) {
        super(context, data);

        addItemViewDelegate(new HotRecommendItem(context));
        addItemViewDelegate(new LivingItem(context));
        addItemViewDelegate(new BangumiRecommendItem(context));
        addItemViewDelegate(new CommonRecommendItem(context));
        addItemViewDelegate(new TopicRecommendItem(context));
        addItemViewDelegate(new ActivityRecommendItem(context));
    }
}
