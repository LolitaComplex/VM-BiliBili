package com.doing.bilibili.ui.fragment.recycleritem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.R;
import com.doing.bilibili.ui.adapter.CardViewRecommandAdapter;
import static com.doing.bilibili.ui.adapter.HomeRecommendAdapter.LIVE;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.baselib.utils.UIUtils.ColorText;
import com.doing.bilibili.data.entity.recommend.Recommend;
import com.doing.bilibili.data.net.RetrofitHelper;
import com.doing.bilibili.ui.widget.GridViewFactoryView;
import com.doing.bilibili.uitls.AnimatorUtils;

import java.util.List;
import java.util.Random;

import rx.Observable;

/**
 * Created by Doing on 2016/9/20.
 *
 */
public class RecommendLivingItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener {

    private AnimatorUtils animatorUtils;


    public RecommendLivingItem(Context context) {
        super(context);
        animatorUtils = new AnimatorUtils();
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_general_living;
    }

    @Override
    public boolean isForViewType(Recommend item, int position) {
        if(LIVE.equals(item.getType())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void convert(BaseViewHolder holder, Recommend recommend, int position) {
        ImageView imageView = holder.getView(R.id.GeneralLivingItem_refresh_iv);
        UIUtils.tint(imageView, R.drawable.ic_item_refresh, R.color.colorPrimary);

        TextView textView = holder.getView(R.id.GeneralLivingItem_header_tv_current_live);
        int count = recommend.getHead().getCount();
        UIUtils.setTextWithColor(textView,
                ColorText.holder(UIUtils.getColor(R.color.text_black), UIUtils.getString(R.string.playing_live_current_start)),
                ColorText.holder(UIUtils.getColor(R.color.text_primary), count + ""),
                ColorText.holder(UIUtils.getColor(R.color.text_black),UIUtils.getString(R.string.playing_live_current_end)));

        holder.setText(R.id.GeneralLivingItem_footer_tv, new Random().nextInt(1000 - 1)
                + UIUtils.getString(R.string.playing_live_click_refresh));

        holder.getView(R.id.GeneralLivingItem_footer_ll).setTag(position);

        holder.setOnClickListener(R.id.GeneralLivingItem_header_tv_current_live, this);
        holder.setOnClickListener(R.id.GeneralLivingItem_footer_btn, this);
        holder.setOnClickListener(R.id.GeneralLivingItem_footer_ll, this);

        GridViewFactoryView cardViewFactory = holder.getView(R.id.GeneralLivingItem_body_cvf);
        cardViewFactory.setAdapter(new CardViewRecommandAdapter(mContext, R.layout.layout_cardview_living, recommend.getBody()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.GeneralLivingItem_header_tv_current_live:
                ToastUtil.show("正在直播");
            break;
            case R.id.GeneralLivingItem_footer_btn:
                ToastUtil.show("查看更多");
            break;
            case R.id.GeneralLivingItem_footer_ll:
                View imageView = ((ViewGroup) v).getChildAt(1);
                if(imageView instanceof ImageView){
                    animatorUtils.setRotateAnimatorCircle(imageView);
                    post((Integer) v.getTag());
                }
                break;
        }
    }

    @Override
    protected Observable<Response<List<Recommend.BodyBean>>> retrofitdata() {
        return RetrofitHelper.getHomeRecommendData().getRecommendedLiveData();
    }
}
