package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;

import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.ItemViewDelegate;
import com.doing.bilibili.entity.bangumi.BangumiItemBean;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public class RecommendBangumiItem extends ItemViewDelegateImp<BangumiItemBean> {

    public RecommendBangumiItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return 0;
    }

    @Override
    public boolean isForViewType(BangumiItemBean item, int position) {
        return false;
    }

    @Override
    public void convert(BaseViewHolder holder, BangumiItemBean bangumiItemBean, int position) {

    }
}
