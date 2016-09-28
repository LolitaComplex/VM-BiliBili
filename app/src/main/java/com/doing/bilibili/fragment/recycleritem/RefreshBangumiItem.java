package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;
import android.view.View;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.ItemViewDelegate;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.entity.bangumi.BangumiItemBean;
import com.doing.bilibili.entity.bangumi.BangumiListBean;
import com.doing.bilibili.ui.GridViewFactoryView;

import java.util.List;

/**
 * Created by Doing on 2016/9/26.
 *
 */
public class RefreshBangumiItem extends ItemViewDelegateImp<BangumiItemBean> implements View.OnClickListener {

    public RefreshBangumiItem(Context context) {
        super(context);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_refresh_bangumi;
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
