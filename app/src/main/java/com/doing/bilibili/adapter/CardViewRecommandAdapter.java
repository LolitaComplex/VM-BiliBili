package com.doing.bilibili.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.entity.recommend.Recommend;

import java.util.List;

/**
 * Created by Doing on 2016/9/20.
 *
 */
public class CardViewRecommandAdapter extends CommonAdapter<Recommend.BodyBean> {


    public CardViewRecommandAdapter(Context context, int layoutId, List<Recommend.BodyBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Recommend.BodyBean bodyBean, int positon) {
        String footerText1 = getNotNullText(bodyBean.getPlay(), bodyBean.getUp(), bodyBean.getDesc1());
        String footerText2 = getNotNullText(bodyBean.getDanmaku(), bodyBean.getOnline() + "");

        //这个时间哪里获取的呢？接口中没有的XD
        if (!TextUtils.isEmpty(bodyBean.getDesc1())) {
            footerText2 = "凌晨1:00";
            footerText1 = footerText1.substring(3);
        }

        holder.setText(R.id.CardViewItem_tv_title, bodyBean.getTitle())
                .setImageUrl(R.id.CardViewItem_iv_title, bodyBean.getCover(), 660, 360)
                .setText(R.id.CardViewItem_tv_playing, footerText1)
                .setText(R.id.CardViewItem_tv_leave_mes, footerText2);
    }

    private String getNotNullText(String... text) {
        for (String target : text) {
            if (!TextUtils.isEmpty(target)) {
                return target;
            }
        }
        return "";
    }

}
