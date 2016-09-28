package com.doing.bilibili.fragment.recycleritem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.CardViewAndTitleBangumiAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.bangumi.BangumiItemBean;
import com.doing.bilibili.ui.GridViewFactoryView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public class CommonBangumiItem extends ItemViewDelegateImp<BangumiItemBean> implements View.OnClickListener {

    private int[] iconBox;
    private int[] seasonIconBox;
    private String[] titleBox;
    private String[] titleMoreBox;

    public CommonBangumiItem(Context context) {
        super(context);
        iconBox = new int[]{R.mipmap.ic_category_t33,
               R.mipmap.ic_category_t153, 0,
               R.mipmap.ic_category_t22};

        seasonIconBox = new int[]{R.drawable.bangumi_home_ic_season_1,
                R.drawable.bangumi_home_ic_season_2,
                R.drawable.bangumi_home_ic_season_3,
                R.drawable.bangumi_home_ic_season_4};

        titleBox = UIUtils.getStringArray(R.array.array_home_bangumi_title);
        titleMoreBox = UIUtils.getStringArray(R.array.array_home_bangumi_title_more);
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_common_bangumi;
    }

    @Override
    public boolean isForViewType(BangumiItemBean item, int position) {
        if (position < 4 ) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, BangumiItemBean data, int position) {
        initTitleAndLogo(holder, data, position);

        holder.setOnClickListener(R.id.CommonBangumi_header_tv_more, this);
        holder.getView(R.id.CommonBangumi_header_tv_more).setTag(position);

        GridViewFactoryView gridViewFratory = holder.getView(R.id.CommonBangumi_body_cvf);

        if(position == 0) {
            gridViewFratory.setRowCount(2, true);
        }

        if(position == 3){
            gridViewFratory.setVisibility(View.GONE);
            holder.getView(R.id.CommonBangumi_header_tv_more).setVisibility(View.GONE);
        }else{
            gridViewFratory.setAdapter(new CardViewAndTitleBangumiAdapter(mContext,
                    R.layout.layout_cardview_and_title, data.getList(), position));
        }
    }

    private void initTitleAndLogo(BaseViewHolder holder, BangumiItemBean data, int position) {
        String title;
        int iconId;

        if (position == 2) {
            title = 1 + (data.getSeason()-1)*3 + titleBox[position];
            iconId = seasonIconBox[data.getSeason()-1];
        } else {
            title = titleBox[position];
            iconId = iconBox[position];
        }

        holder.setText(R.id.CommonBangumi_header_tv_title, title);
        holder.setImageBitmapRes(R.id.CommonBangumi_header_iv_logo, iconId);

        if (position < 3) {
            holder.setText(R.id.CommonBangumi_header_tv_more, titleMoreBox[position]);
        }
    }

    @Override
    public void onClick(View v) {
        int currentPostion = (int) v.getTag();

        switch (v.getId()) {
            case R.id.CommonBangumi_header_tv_more:
                ToastUtil.show(titleMoreBox[currentPostion]);
                break;
        }
    }
}
