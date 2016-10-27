package com.doing.bilibili.fragment.detail;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.doing.bilibili.R;
import com.doing.bilibili.activity.BiliDetalActivity;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.DividerItemDecoration;
import com.doing.bilibili.baselib.adapter.recyclerview.HeaderAndFooterWrapper;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.utils.LogUtils;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.argument.DetailData;
import com.doing.bilibili.entity.bilidetail.CommentItemData;
import com.doing.bilibili.entity.bilidetail.DetailComment;
import com.doing.bilibili.net.ImageEnginePicasso;
import com.doing.bilibili.net.RetrofitHelper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import rx.Observable;
import rx.functions.Action2;

import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Key;
import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Value;


/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailCommentFragment extends BaseLoadingFragment<DetailComment> implements View.OnClickListener {

    @BindView(R.id.BiliDetailFragment_recycler)
    protected RecyclerView mRecyclerView;


    private DetailData mDetailData;

    public static BaseFragment newInstance(DetailData mDetailData) {
        BaseFragment fragment = new BiliDetailCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(BiliDetalActivity.DETAIL_DATA, mDetailData);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initVariable() {
        mDetailData = getArguments().getParcelable(
                BiliDetalActivity.DETAIL_DATA);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bilidetail;
    }

    @Override
    public void initViewWithData(DetailComment data) {

        CommonAdapter<DetailComment.RepliesBean> adapter =
                new CommonAdapter<DetailComment.RepliesBean>(
                        mContext, R.layout.item_recycler_comment, data.getReplies()) {
                    @Override
                    protected void convert(BaseViewHolder holder, DetailComment.RepliesBean repliesBean, int positon) {
                        CommentItemData itemData = new CommentItemData(
                                repliesBean.getMember().getUname(),
                                repliesBean.getFloor(),
                                repliesBean.getCtime(),
                                repliesBean.getContent().getMessage(),
                                repliesBean.getLike(),
                                repliesBean.getMember().getLevel_info().getCurrent_level(),
                                repliesBean.getMember().getAvatar());

                        initCommentItemViewData(holder, itemData);
                    }
                };
        HeaderAndFooterWrapper wrapperAdapter = new HeaderAndFooterWrapper(adapter);
        wrapperAdapter.addHeaderView(initMoreCommentHeaderView(data));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setItemAnimator(new FadeInAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                getContext(),DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(wrapperAdapter);
        LogUtils.e(TAG, data.toString());

    }

    private View initMoreCommentHeaderView(DetailComment data) {
        LinearLayout inflate = (LinearLayout) UIUtils.inflate(R.layout.item_comment_more_headerview);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        inflate.setLayoutParams(params);
        inflate.setOrientation(LinearLayout.VERTICAL);

        LinearLayoutCompat view = (LinearLayoutCompat) inflate.findViewById(R.id.RecyclerHeader_ll_hot_comment);
        initCommentHaderView(view, data);

        inflate.findViewById(R.id.RecyclerHeader_ll_more_comment).setOnClickListener(this);
        return inflate;
    }

    /**
     * 这里实体类应该去编辑JsonFormat自动生成的那个实体类为一个才对，可是太麻烦就自定义了一个实体类
     * @param holder
     */
    private void initCommentItemViewData(BaseViewHolder holder,CommentItemData itemData) {
        holder.setText(R.id.RecyclerCommentItem_tv_nickname, itemData.getNickName())
                .setText(R.id.RecyclerCommentItem_tv_stiar, "#" + itemData.getFloor())
                .setText(R.id.RecyclerCommentItem_tv_time, "" + itemData.getCreatDate())
                .setText(R.id.RecyclerCommentItem_tv_content, itemData.getContent())
                .setText(R.id.RecyclerCommentItem_tv_support, "" + itemData.getSupport())
                .setImageBitmapRes(R.id.RecyclerCommentItem_iv_level, UIUtils.getIdentifier("ic_lv" +
                        itemData.getLevel(), "drawable"));

        holder.setOnClickListener(R.id.RecyclerCommentItem_tv_comment, BiliDetailCommentFragment.this)
                .setOnClickListener(R.id.RecyclerCommentItem_ib_more, BiliDetailCommentFragment.this)
                .setOnClickListener(R.id.RecyclerCommentItem_rl_parent, BiliDetailCommentFragment.this)
                .setOnClickListener(R.id.RecyclerCommentItem_tv_support, BiliDetailCommentFragment.this);

        ImageView ivCover = holder.getView(R.id.RecyclerCommentItem_iv_cover);
        String currentUrl = itemData.getCoverUrl();
        ivCover.setImageResource(R.drawable.ic_default_avatar);

        ImageEnginePicasso.handleBitmap(ivCover, currentUrl, new Action2<ImageView, Bitmap>() {

            @Override
            public void call(ImageView imageView, Bitmap bitmap) {
                RoundedBitmapDrawable roudedBitmapDrawable = UIUtils.getRoudedBitmapDrawable(bitmap);
                imageView.setImageDrawable(roudedBitmapDrawable);
            }
        });
    }

    private void initCommentHaderView(LinearLayoutCompat linearLayoutCompat ,DetailComment data) {
        List<DetailComment.HotsBean> hots = data.getHots();
        for (int x = 0; x < hots.size(); x++) {
            View itemView = UIUtils.inflate(R.layout.item_recycler_comment, linearLayoutCompat);
            BaseViewHolder viewHolder = BaseViewHolder.createViewHolder(mContext, itemView);
            DetailComment.HotsBean hotsBean = hots.get(x);
            CommentItemData itemData = new CommentItemData(
                    hotsBean.getMember().getUname(),
                    hotsBean.getFloor(),
                    hotsBean.getCtime(),
                    hotsBean.getContent().getMessage(),
                    hotsBean.getLike(),
                    hotsBean.getMember().getLevel_info().getCurrent_level(),
                    hotsBean.getMember().getAvatar());
            initCommentItemViewData(viewHolder, itemData);
            linearLayoutCompat.addView(itemView, itemView.getLayoutParams());

            itemView.setOnClickListener(this);
        }
    }

    @Override
    protected Observable<Response<DetailComment>> retrofitData() {
        return RetrofitHelper.getBiliDetailCommentData().getCommentApi(initCommentParams(mDetailData.getAv()));
    }

    private Map<String, String> initCommentParams(String id) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(Key.DEVICE, Value.DEVICE);
        params.put(Key.HWID, Value.HWID);
        params.put(Key.ULV, Value.ULV);
        params.put(Key.BUILD, Value.BUILD);
        params.put(Key.MOBI_APP, Value.MOBI_APP);
        params.put("oid", id);
        params.put(Key.PN, "1");
        params.put(Key.PS, "20");
        params.put(Key.SORT, "0");
        params.put(Key.TYPE, "1");
        return params;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RecyclerCommentItem_tv_comment:
                ToastUtil.show("更多评论");
                break;

            case R.id.RecyclerCommentItem_ib_more:
                ToastUtil.show("更多功能");
                break;

            case R.id.RecyclerHeader_ll_more_comment:
                ToastUtil.show("更多热门评论");
                break;

            case R.id.RecyclerCommentItem_rl_parent:
                ToastUtil.show("父布局");
                break;

            case R.id.RecyclerCommentItem_tv_support:
                ToastUtil.show("支持");
                break;

        }
    }
}
