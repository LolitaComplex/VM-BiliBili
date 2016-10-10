package com.doing.bilibili.baselib.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.doing.bilibili.baselib.R;
import com.doing.bilibili.baselib.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doing on 2016/9/18.
 *
 */
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected Context mContext;
    protected List<T> mDatas;

    protected ItemViewDelegateManager<T> mDelegateManager;
    protected OnItemClickLisenter mOnItemClickLisenter;

    public MultiItemTypeAdapter(Context context, List<T> data) {
        super();
        this.mContext = context;
        this.mDatas = data;
        mDelegateManager = new ItemViewDelegateManager<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (!isUseItemViewDelegateManager()) {
            return super.getItemViewType(position);
        }
        return mDelegateManager.getItemViewType(mDatas.get(position), position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewDelegate<T> itemViewDelegate = mDelegateManager.getItemViewDelegate(viewType);
        int layoutId = itemViewDelegate.getItemViewLayoutId();

        BaseViewHolder holder = BaseViewHolder.createViewHolder(mContext, parent, layoutId);

        onViewHolderCreate();

//        holder.getContentView().setBackgroundResource(R.drawable.item_touch_bg);
        setListener(parent, holder, viewType);
        return holder;
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, mDatas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    protected void convert(BaseViewHolder holder, T t,int position) {
        mDelegateManager.convert(holder, t, position);
    }

    public void addItems(List<T> datas) {
        addItems(datas, mDatas.size());
    }

    public void addItems(List<T> datas, int position) {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        mDatas.addAll(datas);
        notifyItemRangeInserted(position, datas.size());
        if (position != datas.size()) {
            //这段更新逻辑待考证
            notifyItemRangeChanged(position + datas.size(), getItemCount() - datas.size());
        }
    }

    public void setItems(List<T> datas) {
        mDatas.clear();
        addItems(datas);
    }


    public List<T> getData() {
        return mDatas;
    }

    public MultiItemTypeAdapter<T> addItemViewDelegate(ItemViewDelegate<T> itemViewDelegate) {
        mDelegateManager.addDelegate(itemViewDelegate);
        return this;
    }

    public MultiItemTypeAdapter<T> addItemViewDelegate(int viewType, ItemViewDelegate<T> itemViewDelegate) {
        mDelegateManager.addDelegate(viewType, itemViewDelegate);
        return this;
    }

    protected boolean isUseItemViewDelegateManager() {
        return mDelegateManager.getItemViewDelegateCount() > 0;
    }

    protected void onViewHolderCreate() {

    }

    protected void setListener(ViewGroup parent, final BaseViewHolder holder, int viewType) {
        if (!isEnable(viewType)) {
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickLisenter != null) {
                    int position = holder.getAdapterPosition();
                    mOnItemClickLisenter.onItemClick(v, holder, position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickLisenter != null) {
                    int position = holder.getAdapterPosition();
                    mOnItemClickLisenter.onItemLongClick(v, holder, position);
                }
                return false;
            }
        });
    }

    public void setOnItemClickListener(OnItemClickLisenter onItemClickLisenter) {
        this.mOnItemClickLisenter = onItemClickLisenter;
    }

    /**
     * 自条目是否可被点击
     * @param viewType
     * @return
     */
    protected boolean isEnable(int viewType) {
        ItemViewDelegate<T> itemViewDelegate = mDelegateManager.getItemViewDelegate(viewType);
        return itemViewDelegate.isEnable();
//        return true;
    }

    public interface OnItemClickLisenter {
        void onItemClick(View view, RecyclerView.ViewHolder holder, int position);

        void onItemLongClick(View view, RecyclerView.ViewHolder holder, int position);
    }

}
