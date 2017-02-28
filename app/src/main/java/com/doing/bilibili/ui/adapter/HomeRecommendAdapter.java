package com.doing.bilibili.ui.adapter;

import android.content.Context;

import com.doing.bilibili.baselib.adapter.recyclerview.MultiItemTypeAdapter;
import com.doing.bilibili.data.entity.recommend.Recommend;
import com.doing.bilibili.ui.fragment.recycleritem.RecommendActivityItem;
import com.doing.bilibili.ui.fragment.recycleritem.RecommendBangumiItem;
import com.doing.bilibili.ui.fragment.recycleritem.RecommendCommonItem;
import com.doing.bilibili.ui.fragment.recycleritem.RecommendHotItem;
import com.doing.bilibili.ui.fragment.recycleritem.RecommendLivingItem;
import com.doing.bilibili.ui.fragment.recycleritem.RecommendSpecialItem;
import com.doing.bilibili.ui.fragment.recycleritem.RecommendTopicItem;

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

        addItemViewDelegate(new RecommendHotItem(context));
        addItemViewDelegate(new RecommendLivingItem(context));
        addItemViewDelegate(new RecommendBangumiItem(context));
        addItemViewDelegate(new RecommendSpecialItem(context));
        addItemViewDelegate(new RecommendCommonItem(context));
        addItemViewDelegate(new RecommendTopicItem(context));
        addItemViewDelegate(new RecommendActivityItem(context));
    }
}
