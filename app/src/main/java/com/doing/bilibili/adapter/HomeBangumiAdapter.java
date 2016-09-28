package com.doing.bilibili.adapter;

import android.content.Context;

import com.doing.bilibili.baselib.adapter.recyclerview.MultiItemTypeAdapter;
import com.doing.bilibili.entity.bangumi.BangumiItemBean;
import com.doing.bilibili.fragment.recycleritem.CommonBangumiItem;
import com.doing.bilibili.fragment.recycleritem.RefreshBangumiItem;

import java.util.List;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public class HomeBangumiAdapter extends MultiItemTypeAdapter<BangumiItemBean> {

    public HomeBangumiAdapter(Context context, List<BangumiItemBean> data) {
        super(context, data);

        addItemViewDelegate(new CommonBangumiItem(context));
        addItemViewDelegate(new RefreshBangumiItem(context));
    }
}
