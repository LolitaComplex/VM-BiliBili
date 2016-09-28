package com.doing.bilibili.baselib.adapter.recyclerview;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Wrapper;

/**
 * Created by Doing on 2016/9/19.
 *
 */
public class HeaderAndFooterWrapper<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int BASE_ITEM_TYPE_HEADER = 100000;
    private static final int BASE_ITEM_TYPE_FOOTER = 200000;

    private SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat<>();
    private SparseArrayCompat<View> mFooterViews = new SparseArrayCompat<>();

    private RecyclerView.Adapter mInterAdapter;

    public HeaderAndFooterWrapper(RecyclerView.Adapter adapter) {
        this.mInterAdapter = adapter;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderViewPosition(position)) {
            return mHeaderViews.keyAt(position);
        }else if (isFooterViewPosition(position)) {
            return mFooterViews.keyAt(position);
        }

        return mInterAdapter.getItemViewType(position - getHeaderCount());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderViews.get(viewType) != null) {
            return BaseViewHolder.createViewHolder(parent.getContext(), mHeaderViews.get(viewType));
        }

        if (mFooterViews.get(viewType) != null) {
            return BaseViewHolder.createViewHolder(parent.getContext(), mFooterViews.get(viewType));
        }
        return mInterAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isHeaderViewPosition(position)) {
            return;
        }
        if (isFooterViewPosition(position)) {
            return;
        }

        mInterAdapter.onBindViewHolder(holder, position - getHeaderCount());
    }

    @Override
    public int getItemCount() {
        return getHeaderCount() + getRealItemCount() + getFooterCount();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        WrapperUtils.onAttachedToRecyclerView(mInterAdapter, recyclerView, new WrapperUtils.SpanSizeCallback() {
            @Override
            public int getSpanSize(GridLayoutManager layoutManager, GridLayoutManager.SpanSizeLookup oldLookUp, int position) {
                int viewType = getItemViewType(position);
                if (mHeaderViews.get(viewType) != null) {
                    return layoutManager.getSpanCount();
                } else if (mFooterViews.get(viewType) != null) {
                    return layoutManager.getSpanCount();
                }

                if (oldLookUp != null) {
                    return oldLookUp.getSpanSize(position);
                }
                return 1;
            }
        });
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        mInterAdapter.onViewAttachedToWindow(holder);

        int position = holder.getLayoutPosition();
        if (isHeaderViewPosition(position) || isFooterViewPosition(position)) {
            WrapperUtils.setFullSpan(holder);
        }

    }

    private boolean isHeaderViewPosition(int position) {
        return position < getHeaderCount();
    }

    private boolean isFooterViewPosition(int position) {
        return position > getRealItemCount() + getHeaderCount();
    }


    public int getHeaderCount() {
        return mHeaderViews.size();
    }

    private int getRealItemCount() {
        return mInterAdapter.getItemCount();
    }

    public int getFooterCount() {
        return mFooterViews.size();
    }

    public void addHeaderView(View view) {
        mHeaderViews.put(mHeaderViews.size() + BASE_ITEM_TYPE_HEADER, view);
    }

    public void addFooterView(View view) {
        mFooterViews.put(mFooterViews.size() + BASE_ITEM_TYPE_FOOTER, view);
    }
}
