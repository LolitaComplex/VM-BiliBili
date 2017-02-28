package com.doing.bilibili.ui.fragment.recycleritem;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.doing.bilibili.R;
import com.doing.bilibili.data.cache.CacheHelper;
import com.doing.bilibili.data.entry.CacheDataEntry;
import com.doing.bilibili.ui.activity.BiliDetalActivity;
import com.doing.bilibili.ui.adapter.CardViewRecommandAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.data.entity.argument.DetailData;
import com.doing.bilibili.data.entity.recommend.Recommend;
import com.doing.bilibili.data.net.RetrofitHelper;
import com.doing.bilibili.ui.widget.GridViewFactoryView;
import com.doing.bilibili.uitls.AnimatorUtils;

import java.util.List;

import rx.Observable;

import static com.doing.bilibili.ui.adapter.HomeRecommendAdapter.HOT_RECOMMEND;

/**
 * Created by Doing on 2016/9/19.
 *
 */
public class RecommendHotItem extends ItemViewDelegateImp<Recommend> implements View.OnClickListener{

    private AnimatorUtils animatorUtils;


    public RecommendHotItem(Context context) {
        super(context);
        animatorUtils = new AnimatorUtils();
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_recommend_hot;
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
    public void convert(BaseViewHolder holder, final Recommend recommend, final int position) {
        ImageView imageView = holder.getView(R.id.RecommendHotItem_footer_iv_refresh);
        UIUtils.tint(imageView, R.drawable.ic_item_refresh, R.color.colorPrimary);

        holder.setText(R.id.RecommendHotItem_header_tv_title, "热门推荐");

        holder.setOnClickListener(R.id.RecommendHotItem_footer, this);
        holder.setOnClickListener(R.id.RecommendHotItem_header_ll_rank, this);

        holder.getView(R.id.RecommendHotItem_footer).setTag(position);

        GridViewFactoryView cardViewFactory = holder.getView(R.id.RecommendHotItem_body_cvf);
        final CardViewRecommandAdapter cardViewAdapter = new CardViewRecommandAdapter(
                mContext, R.layout.layout_cardview_hotrecommend, recommend.getBody());
        cardViewFactory.setAdapter(cardViewAdapter);
        cardViewFactory.setOnItemClickListener(new GridViewFactoryView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postionInner) {
                Recommend.BodyBean bodyBean = recommend.getBody().get(postionInner);
                DetailData detailData = new DetailData(bodyBean.getParam()
                        , bodyBean.getCover(), bodyBean.getPlay(), bodyBean.getDanmaku());
                View imageview = ((ViewGroup) (((ViewGroup) view).getChildAt(0))).getChildAt(0);
                BiliDetalActivity.newInstance((Activity) mContext, detailData, imageview);
            }

            @Override
            public void onItemLongClick(View view, int postion) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RecommendHotItem_header_ll_rank:
                CacheDataEntry.getInstance().removeAllData();
                ToastUtil.show("Rank被点击了");
                break;
            case R.id.RecommendHotItem_footer:
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
        return RetrofitHelper.getHomeRecommendData().getRecommendedHotData();
    }
}
