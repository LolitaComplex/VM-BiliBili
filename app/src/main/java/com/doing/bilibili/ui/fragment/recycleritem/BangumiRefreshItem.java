package com.doing.bilibili.ui.fragment.recycleritem;

import android.content.Context;
import android.view.View;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.data.entity.bangumi.BangumiItemBean;
import com.doing.bilibili.data.entity.bangumi.BangumiListBean;

/**
 * Created by Doing on 2016/9/26.
 *
 */
public class BangumiRefreshItem extends ItemViewDelegateImp<BangumiItemBean> implements View.OnClickListener {

    public BangumiRefreshItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_bangumi_refresh;
    }

    @Override
    public boolean isForViewType(BangumiItemBean item, int position) {
        if (position >= 4) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, BangumiItemBean bangumiItemBean, int position) {
        BangumiListBean data = bangumiItemBean.getList().get(0);

        holder.setOnClickListener(R.id.CardViewItem_cv_root, this);
        holder.setText(R.id.CardViewItem_tv_title, data.getTitle());
        holder.setText(R.id.CardViewItem_tv_content, data.getDesc());
        holder.setImageUrl(R.id.CardViewItem_iv_title, data.getCover());

    }

    @Override
    public void onClick(View v) {
        ToastUtil.show("点击了大CardView");
    }
}
