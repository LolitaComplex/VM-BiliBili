package com.doing.bilibili.ui.fragment.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.adapter.recyclerview.CommonAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.MultiItemTypeAdapter;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.base.BaseStaticFragment;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;

import java.util.Arrays;

import butterknife.BindView;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class PartitionFragment extends BaseStaticFragment {


    @BindView(R.id.PartitionFragment_recycler)
    RecyclerView mRecyclerView;

    private int[] iconBox;

    private String[] titleBox;

    public static BaseFragment newInstance() {
        return new PartitionFragment();
    }

    @Override
    protected void initVariable() {
        iconBox = new int[]{
                R.mipmap.ic_category_live, R.mipmap.ic_category_t13, R.mipmap.ic_category_t1,
                R.mipmap.ic_category_t3, R.mipmap.ic_category_t129, R.mipmap.ic_category_t4,
                R.mipmap.ic_category_t36, R.mipmap.ic_category_t160, R.mipmap.ic_category_t119,
                R.mipmap.ic_category_t155, R.mipmap.ic_category_t165, R.mipmap.ic_category_t5,
                R.mipmap.ic_category_t23, R.mipmap.ic_category_t11, R.mipmap.ic_category_game_center};

        titleBox = UIUtils.getStringArray(R.array.array_home_partition_title);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_partition;
    }

    @Override
    protected void initView() {
        CommonAdapter adapter = new CommonAdapter<String>(mContext,R.layout.item_partition,
                Arrays.asList(titleBox)) {
            @Override
            protected void convert(BaseViewHolder holder, String text, int positon) {
                holder.getContentView().setBackgroundResource(R.drawable.item_touch_have_bg);
                holder.setText(R.id.PartitionItem_tv_title, text);
                holder.setImageBitmapRes(R.id.PartitionItem_iv_title, iconBox[positon]);
            }

            @Override
            protected boolean isEnable(int viewType) {
                return true;
            }
        };

        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickLisenter() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                ToastUtil.show(titleBox[position]);

            }

            @Override
            public void onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {

            }
        });
    }
}
