package com.doing.bilibili.fragment.recycleritem;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.BiliDetalActivity;
import com.doing.bilibili.adapter.CardViewRecommandAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.MultiItemTypeAdapter;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.recommend.Recommend;
import com.doing.bilibili.ui.GridViewFactoryView;

import static com.doing.bilibili.adapter.HomeRecommendAdapter.HOT_RECOMMEND;

/**
 * Created by Doing on 2016/9/19.
 *
 */
public class RecommendHotItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener, MultiItemTypeAdapter.OnItemClickLisenter {

    public RecommendHotItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_recommend_hot;
    }

    @Override
    public boolean isForViewType(Recommend item, int position) {
        if(HOT_RECOMMEND.equals(item.getType())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, Recommend recommend, int position) {
        ImageView imageView = holder.getView(R.id.RecommendHotItem_footer_iv_refresh);
        UIUtils.tint(imageView, R.drawable.ic_item_refresh, R.color.colorPrimary);

        holder.setOnClickListener(R.id.RecommendHotItem_footer, this);
        holder.setOnClickListener(R.id.RecommendHotItem_header_ll_rank, this);

        GridViewFactoryView cardViewFactory = holder.getView(R.id.RecommendHotItem_body_cvf);
        CardViewRecommandAdapter cardViewAdapter = new CardViewRecommandAdapter(mContext, R.layout.layout_cardview_hotrecommend, recommend.getBody());
        cardViewAdapter.setEnable(true);
        cardViewFactory.setAdapter(cardViewAdapter);
        cardViewAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RecommendHotItem_header_ll_rank:
                ToastUtil.show("Rank被点击了");
                break;
            case R.id.RecommendHotItem_footer:
                View imageView = ((ViewGroup) v).getChildAt(1);
                if(imageView instanceof ImageView){
                    imageView.animate().rotation(360f).setDuration(1000).start();
                }

                ToastUtil.show("Refresh被点击了");
                break;
        }
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        BiliDetalActivity.newInstance((Activity) mContext);
    }

    @Override
    public void onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {

    }
}
