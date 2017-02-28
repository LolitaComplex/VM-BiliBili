package com.doing.bilibili.ui.fragment.recycleritem;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.doing.bilibili.R;
import com.doing.bilibili.ui.adapter.HomeRecommendAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.data.entity.recommend.Recommend;

/**
 * Created by Doing on 2016/9/21.
 *
 */
public class RecommendActivityItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener {

    private final int windowWidth;

    public RecommendActivityItem(Context context) {
        super(context);

        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        windowWidth = metrics.widthPixels;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_recommand_activity;
    }

    @Override
    public boolean isForViewType(Recommend item, int position) {
        if (HomeRecommendAdapter.ACTIVITY.equals(item.getType())) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, final Recommend recommend, final int position) {
        holder.setOnClickListener(R.id.RecommendActivityItem_header_more, this);

        RecyclerView recyclerView = holder.getView(R.id.RecommendActivityItem_body_recycl);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new CommonAdapter<Recommend.BodyBean>(mContext, R.layout.cardview_one_title, recommend.getBody()) {

            @Override
            protected void convert(BaseViewHolder holder, Recommend.BodyBean bodyBean, int positon) {
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.getContentView().getLayoutParams();
                layoutParams.width = windowWidth / 2;
                holder.getContentView().setLayoutParams(layoutParams);

                holder.getContentView().setVisibility(View.VISIBLE);

                holder.setImageUrl(R.id.CardViewItem_iv_title, bodyBean.getCover());
                holder.setText(R.id.CardViewItem_tv_title, bodyBean.getTitle());
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RecommendActivityItem_header_more:
                ToastUtil.show("活动更多");
                break;
        }
    }
}
