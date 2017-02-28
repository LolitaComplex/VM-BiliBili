package com.doing.bilibili.ui.fragment.recycleritem;

import android.content.Context;
import android.view.View;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.data.entity.recommend.Recommend;
import com.doing.bilibili.ui.widget.GridViewFactoryView;

import static com.doing.bilibili.ui.adapter.HomeRecommendAdapter.TOPIC;

/**
 * Created by Doing on 2016/9/21.
 *
 */
public class RecommendTopicItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener {

    public RecommendTopicItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_recommend_topic;
    }

    @Override
    public boolean isForViewType(Recommend item, int position) {
        if (TOPIC.equals(item.getType())) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, Recommend recommend, int position) {
        holder.setOnClickListener(R.id.RecommendTopicItem_header_more, this);

        GridViewFactoryView cardViewFactory = holder.getView(R.id.RecommendTopicItem_body_cvf);
        cardViewFactory.setAdapter(new CommonAdapter<Recommend.BodyBean>(mContext, R.layout.layout_cardview_topic, recommend.getBody()) {
            @Override
            protected void convert(BaseViewHolder holder, Recommend.BodyBean bodyBean, int positon) {
                holder.setImageUrl(R.id.CardViewItem_iv_topic, bodyBean.getCover());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RecommendTopicItem_header_more:
                ToastUtil.show("话题更多");
                break;
        }
    }
}
