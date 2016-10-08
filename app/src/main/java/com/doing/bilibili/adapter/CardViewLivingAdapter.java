package com.doing.bilibili.adapter;

import android.content.Context;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.baselib.utils.UIUtils.ColorText;
import com.doing.bilibili.entity.livestream.HomeLiveStream.LiveStream.LivesBean;

import java.util.List;

/**
 * Created by Doing on 2016/9/20.
 */
public class CardViewLivingAdapter extends CommonAdapter<LivesBean> {

    private boolean mTintText;

    public CardViewLivingAdapter(Context context, int layoutId, List<LivesBean> data, boolean tintText) {
        super(context, layoutId, data);
        this.mTintText = tintText;
    }

    @Override
    protected void convert(BaseViewHolder holder, LivesBean data, int positon) {
        if (mTintText) {
            UIUtils.setTextWithColor(holder.<TextView>getView(R.id.CardViewItem_tv_title),
                    ColorText.holder(UIUtils.getColor(R.color.colorPrimary), "#" + data.getArea() + "#"),
                    ColorText.holder(UIUtils.getColor(R.color.text_black), data.getTitle())
            );
        } else {
            holder.setText(R.id.CardViewItem_tv_title, data.getTitle());
        }

        holder.setText(R.id.CardViewItem_tv_playing, data.getOwner().getName())
                .setText(R.id.CardViewItem_tv_leave_mes, data.getOnline() + "");

        if (positon == 6) {
            holder.setImageUrl(R.id.CardViewItem_iv_title, data.getCover().getSrc());
        } else {
            holder.setImageUrl(R.id.CardViewItem_iv_title, data.getCover().getSrc(), 660, 360);
        }
    }

}
