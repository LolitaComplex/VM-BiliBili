package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.CardViewRecommandAdapter;
import static com.doing.bilibili.adapter.HomeRecommendAdapter.LIVE;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.baselib.utils.UIUtils.ColorText;
import com.doing.bilibili.entity.recommend.Recommend;
import com.doing.bilibili.ui.GridViewFactoryView;

/**
 * Created by Doing on 2016/9/20.
 *
 */
public class RecommendLivingItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener {

    public RecommendLivingItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_general_living;
    }

    @Override
    public boolean isForViewType(Recommend item, int position) {
        if(LIVE.equals(item.getType())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, Recommend recommend, int position) {
        ImageView imageView = holder.getView(R.id.GeneralLivingItem_refresh_iv);
        UIUtils.tint(imageView, R.drawable.ic_item_refresh, R.color.colorPrimary);

        TextView textView = holder.getView(R.id.GeneralLivingItem_header_tv_current_live);
        int count = recommend.getHead().getCount();
        UIUtils.setTextWithColor(textView,
                ColorText.holder(UIUtils.getColor(R.color.text_black), UIUtils.getString(R.string.playing_live_current_start)),
                ColorText.holder(UIUtils.getColor(R.color.text_primary), count + ""),
                ColorText.holder(UIUtils.getColor(R.color.text_black),UIUtils.getString(R.string.playing_live_current_end)));

        holder.setOnClickListener(R.id.GeneralLivingItem_header_tv_current_live, this);
        holder.setOnClickListener(R.id.GeneralLivingItem_footer_btn, this);
        holder.setOnClickListener(R.id.GeneralLivingItem_footer_ll, this);

        GridViewFactoryView cardViewFactory = holder.getView(R.id.GeneralLivingItem_body_cvf);
        cardViewFactory.setAdapter(new CardViewRecommandAdapter(mContext, R.layout.layout_cardview_living, recommend.getBody()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.GeneralLivingItem_header_tv_current_live:
                ToastUtil.show("正在直播");
            break;
            case R.id.GeneralLivingItem_footer_btn:
                ToastUtil.show("查看更多");
            break;
            case R.id.GeneralLivingItem_footer_ll:
                ToastUtil.show("数据更新");
                break;
        }
    }
}
