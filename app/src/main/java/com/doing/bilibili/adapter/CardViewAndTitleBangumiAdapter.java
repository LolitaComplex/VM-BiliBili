package com.doing.bilibili.adapter;

import android.content.Context;
import android.view.View;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.bangumi.BangumiListBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public class CardViewAndTitleBangumiAdapter extends CommonAdapter<BangumiListBean> {

    private int mCurrentItem;

    public CardViewAndTitleBangumiAdapter(Context context, int layoutId, List<BangumiListBean> data,int position) {
        super(context, layoutId, data);
        this.mCurrentItem = position;
    }

    @Override
    protected void convert(BaseViewHolder holder, BangumiListBean data, int positon) {
        String whiteText = null;

        if (mCurrentItem == 0) {
            whiteText = data.getWatching_count() + UIUtils.getString(R.string.seeing);
        }else if(mCurrentItem == 1) {
            SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
            sdf.format(new Date(data.getLast_time()));
            Calendar calendar = sdf.getCalendar();
            int hour = calendar.get(Calendar.HOUR);
            //TODO
            String ApOrPm = "上午";
            if (hour > 11) {
                ApOrPm = "下午";
            }
            int minuti = calendar.get(Calendar.MINUTE)+1;
            whiteText = ApOrPm + (hour+1) + ":" + minuti ;
        } else if(mCurrentItem == 2){
            String favourites = data.getFavourites();
            double value = Integer.valueOf(Integer.parseInt(favourites) / 1000).doubleValue() / 10;
            whiteText = value + "万人追番";
        }

        holder.setImageUrl(R.id.CardViewItem_iv_title, data.getCover());
        holder.setText(R.id.CardViewItem_tv_current_person,whiteText);
        holder.setText(R.id.CardViewItem_tv_title, data.getTitle());

        if (mCurrentItem == 0) {
            holder.setText(R.id.CardViewItem_tv_regfresh, UIUtils.getString(R.string.refresh_to)
                    + data.getNewest_ep_index() + UIUtils.getString(R.string.episode));
        }else {
            holder.getView(R.id.CardViewItem_tv_regfresh).setVisibility(View.GONE);
        }

        List<String> list = new ArrayList<>();
        list.add("1111");


    }

}
