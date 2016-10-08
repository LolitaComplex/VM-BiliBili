package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.CardViewLivingAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.baselib.utils.UIUtils.ColorText;
import com.doing.bilibili.entity.livestream.HomeLiveStream;
import com.doing.bilibili.entity.livestream.HomeLiveStream.LiveStream.BannerDataBean;
import com.doing.bilibili.entity.livestream.HomeLiveStream.LiveStream.LivesBean;
import com.doing.bilibili.ui.GridViewFactoryView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Doing on 2016/9/30.
 *
 */
public class LivingRecommendItem extends ItemViewDelegateImp<HomeLiveStream.LiveStream> implements View.OnClickListener {

    public LivingRecommendItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_living_recommand;
    }

    @Override
    public boolean isForViewType(HomeLiveStream.LiveStream item, int position) {
        if (position == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, HomeLiveStream.LiveStream data, int position) {
        ImageView imageView = holder.getView(R.id.LivingRecommendItem_refresh_iv);
        UIUtils.tint(imageView, R.drawable.ic_item_refresh, R.color.colorPrimary);

        int count = data.getPartition().getCount();
        UIUtils.setTextWithColor(holder.<TextView>getView(R.id.LivingRecommendItem_header_tv_current_live),
                ColorText.holder(UIUtils.getColor(R.color.text_black), UIUtils.getString(R.string.playing_live_current_start)),
                ColorText.holder(UIUtils.getColor(R.color.text_primary), count + ""),
                ColorText.holder(UIUtils.getColor(R.color.text_black), UIUtils.getString(R.string.playing_live_current_end))
        );

        GridViewFactoryView gridViewFactoryUp = holder.getView(R.id.LivingRecommendItem_body1_cvf);
        GridViewFactoryView gridViewFactoryDown = holder.getView(R.id.LivingRecommendItem_body2_cvf);


        List<LivesBean> listUp = new ArrayList<>(data.getLives());
        BannerDataBean dataItem = data.getBanner_data().get(0);
        listUp.add(6, new LivesBean(dataItem));


        List<LivesBean> listDown = data.getLives().subList(5, data.getLives().size());
        gridViewFactoryUp.setAdapter(new CardViewLivingAdapter(mContext, R.layout.layout_cardview_living, listUp, true));
        gridViewFactoryDown.setAdapter(new CardViewLivingAdapter(mContext, R.layout.layout_cardview_living, listDown, true));

        holder.setOnClickListener(R.id.LivingRecommendItem_footer_btn, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.GeneralLivingItem_footer_btn:
                ToastUtil.show("查看更多");
                break;
        }
    }
}
