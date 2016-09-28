package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.HomeRecommendAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.baselib.utils.DensityUitls;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.recommend.Recommend;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Doing on 2016/9/21.
 *
 */
public class ActivityRecommendItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener {

    private final int windowWidth;

    public ActivityRecommendItem(Context context) {
        super(context);

        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        windowWidth = metrics.widthPixels;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_activity_recommand;
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
        holder.setOnClickListener(R.id.ActivityRecommend_header_more, this);

        RecyclerView recyclerView = holder.getView(R.id.ActivityRecommend_body_recycl);
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

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.CardViewItem_iv_title)
        ImageView CardViewItemIvTitle;
        @BindView(R.id.CardViewItem_tv_title)
        TextView CardViewItemTvTitle;

        Holder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ActivityRecommend_header_more:
                ToastUtil.show("活动更多");
                break;
        }
    }
}
