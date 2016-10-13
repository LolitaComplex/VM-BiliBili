package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;
import android.view.View;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.CardViewRecommandAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.recommend.Recommend;
import com.doing.bilibili.ui.GridViewFactoryView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.doing.bilibili.adapter.HomeRecommendAdapter.REGION;

/**
 * Created by Doing on 2016/9/21.
 *
 */
public class RecommendCommonItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener {

    private Map<String, Integer> iconBox;


    public RecommendCommonItem(Context context) {
        super(context);
        iconBox = new HashMap<>();
        iconBox.put("动画区", R.mipmap.ic_category_t1);
        iconBox.put("音乐区", R.mipmap.ic_category_t3);
        iconBox.put("舞蹈区", R.mipmap.ic_category_t129);
        iconBox.put("游戏区", R.mipmap.ic_category_t4);
        iconBox.put("鬼畜区", R.mipmap.ic_category_t119);
        iconBox.put("科技区", R.mipmap.ic_category_t36);
        iconBox.put("生活区", R.mipmap.ic_category_t160);
        iconBox.put("时尚区", R.mipmap.ic_category_t155);
        iconBox.put("广告区", R.mipmap.ic_category_t165);
        iconBox.put("娱乐区", R.mipmap.ic_category_t5);
        iconBox.put("电视剧区", R.mipmap.ic_category_t11);
        iconBox.put("电影区", R.mipmap.ic_category_t23);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_recommend_common;
    }

    @Override
    public boolean isForViewType(Recommend item, int position) {
        if (REGION.equals(item.getType())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, Recommend recommend, int position) {
        setLogAndTitle(holder, recommend.getHead());


        holder.setOnClickListener(R.id.RecommendCommonItem_header_more, this);
        holder.setOnClickListener(R.id.RecommendCommonItem_footer_btn, this);
        holder.setOnClickListener(R.id.RecommendCommonItem_footer_ll, this);

        GridViewFactoryView cardViewFactory = holder.getView(R.id.RecommendCommonItem_body_cvf);
        cardViewFactory.setAdapter(new CardViewRecommandAdapter(mContext, R.layout.layout_cardview_hotrecommend, recommend.getBody()));
    }

    private void setLogAndTitle(BaseViewHolder holder, Recommend.HeadBean headBean) {
        String title = headBean.getTitle();
        holder.setText(R.id.RecommendCommonItem_header_tv_title, title)
                .setText(R.id.RecommendCommonItem_footer_tv, new Random().nextInt(1000 - 1)
                        + UIUtils.getString(R.string.playing_live_click_refresh));
        holder.setImageBitmapRes(R.id.RecommendCommonItem_header_iv_logo, iconBox.get(title));

        for (String key: iconBox.keySet()) {
            if (key.equals(title)) {
                holder.setText(R.id.RecommendCommonItem_footer_btn, UIUtils.getString(R.string.more) + key.substring(0, 2));
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RecommendCommonItem_header_more:
                ToastUtil.show("头部加载更多");
                break;
            case R.id.RecommendCommonItem_footer_btn:
                ToastUtil.show("尾部加载更多");
                break;
            case R.id.RecommendCommonItem_footer_ll:
                ToastUtil.show("动态");
                break;
        }
    }
}
