package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.CardViewRecommandAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.recommend.Recommend;
import com.doing.bilibili.ui.GridViewFactoryView;

import static com.doing.bilibili.adapter.HomeRecommendAdapter.HOT_RECOMMEND;

/**
 * Created by Doing on 2016/9/19.
 *
 */
public class HotRecommendItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener {

    public HotRecommendItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_hot_recommend;
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
        ImageView imageView = holder.getView(R.id.HotRecommendItem_footer_iv_refresh);
        UIUtils.tint(imageView, R.drawable.ic_item_refresh, R.color.colorPrimary);

        holder.setOnClickListener(R.id.HotRecommendItem_footer, this);
        holder.setOnClickListener(R.id.HotRecommendItem_header_ll_rank, this);

        GridViewFactoryView cardViewFactory = holder.getView(R.id.HotRecommendItem_body_cvf);
        cardViewFactory.setAdapter(new CardViewRecommandAdapter(mContext, R.layout.layout_cardview_hotrecommend, recommend.getBody()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.HotRecommendItem_header_ll_rank:
                ToastUtil.show("Rank被点击了");
                break;
            case R.id.HotRecommendItem_footer:
                View imageView = ((ViewGroup) v).getChildAt(1);
                if(imageView instanceof ImageView){
                    imageView.animate().rotation(360f).setDuration(1000).start();
                }

                ToastUtil.show("Refresh被点击了");
                break;
        }
    }
}
