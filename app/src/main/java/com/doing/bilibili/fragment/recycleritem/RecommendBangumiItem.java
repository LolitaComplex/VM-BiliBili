package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;
import android.view.View;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.CardViewRecommandAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.entity.recommend.Recommend;
import com.doing.bilibili.ui.GridViewFactoryView;

import static com.doing.bilibili.adapter.HomeRecommendAdapter.BANGUMI;

/**
 * Created by Doing on 2016/9/21.
 *
 */
public class RecommendBangumiItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener {

    public RecommendBangumiItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_recommend_bangumi;
    }

    @Override
    public boolean isForViewType(Recommend item, int position) {
        if (BANGUMI.equals(item.getType())) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, Recommend recommend, int position) {
        holder.setOnClickListener(R.id.RecommendBangumiItem_header_more, this);
        holder.setOnClickListener(R.id.RecommendBangumiItem_footer_btn_timeline, this);
        holder.setOnClickListener(R.id.RecommendBangumiItem_footer_btn_index, this);

        GridViewFactoryView cardViewFactory = holder.getView(R.id.RecommendBangumiItem_body_cvf);
        cardViewFactory.setAdapter(new CardViewRecommandAdapter(mContext, R.layout.layout_cardview_bangumi, recommend.getBody()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RecommendBangumiItem_header_more:
                ToastUtil.show("番剧更多");
                break;
            case R.id.RecommendBangumiItem_footer_btn_timeline:
                ToastUtil.show("新番放送");
                break;
            case R.id.RecommendBangumiItem_footer_btn_index:
                ToastUtil.show("番剧索引");
                break;
        }
    }
}
