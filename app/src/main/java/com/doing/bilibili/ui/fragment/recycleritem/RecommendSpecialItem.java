package com.doing.bilibili.ui.fragment.recycleritem;

import android.content.Context;
import android.text.TextUtils;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.data.entity.recommend.Recommend;

/**
 * Created by Doing on 2016/10/13 0013.
 *
 */
public class RecommendSpecialItem extends ItemViewDelegateImp<Recommend> {

    public RecommendSpecialItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_recommand_special;
    }

    @Override
    public boolean isForViewType(Recommend item, int position) {
        return TextUtils.isEmpty(item.getType());
    }

    @Override
    public void convert(BaseViewHolder holder, Recommend recommend, int position) {
        holder.setImageUrl(R.id.RecommendSpecialItem_iv, recommend.getBody().get(0).getCover());
    }

    @Override
    public boolean isEnable() {
        return false;
    }
}
