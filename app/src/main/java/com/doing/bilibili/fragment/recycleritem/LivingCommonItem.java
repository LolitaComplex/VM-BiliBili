package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.CardViewLivingAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.ItemViewDelegate;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.livestream.HomeLiveStream;
import com.doing.bilibili.ui.GridViewFactoryView;

import java.util.List;

/**
 * Created by Doing on 2016/9/30.
 *
 */
public class LivingCommonItem extends ItemViewDelegateImp<HomeLiveStream.LiveStream> implements View.OnClickListener {

    public LivingCommonItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_general_living;
    }

    @Override
    public boolean isForViewType(HomeLiveStream.LiveStream item, int position) {
        if (position != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, HomeLiveStream.LiveStream data, int position) {
        holder.setText(R.id.GeneralLivingItem_header_tv, data.getPartition().getName())
                .setImageUrl(R.id.GeneralLivingItem_iv_logo, data.getPartition().getSub_icon().getSrc());

        ImageView imageView = holder.getView(R.id.GeneralLivingItem_refresh_iv);
        UIUtils.tint(imageView, R.drawable.ic_item_refresh, R.color.colorPrimary);

        int count = data.getPartition().getCount();
        UIUtils.setTextWithColor(holder.<TextView>getView(R.id.GeneralLivingItem_header_tv_current_live),
                UIUtils.ColorText.holder(UIUtils.getColor(R.color.text_black), UIUtils.getString(R.string.playing_live_current_start)),
                UIUtils.ColorText.holder(UIUtils.getColor(R.color.text_primary), count + ""),
                UIUtils.ColorText.holder(UIUtils.getColor(R.color.text_black), UIUtils.getString(R.string.playing_live_current_end))
        );

        GridViewFactoryView gridViewFactoryUp = holder.getView(R.id.GeneralLivingItem_body_cvf);
        gridViewFactoryUp.setAdapter(new CardViewLivingAdapter(mContext, R.layout.layout_cardview_living, data.getLives(), false));

        holder.setOnClickListener(R.id.GeneralLivingItem_footer_btn, this);
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
