package com.doing.bilibili.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.utils.LogUtils;

/**
 * Created by Doing on 2016/9/20.
 *
 */
public class GridViewFactoryView extends GridLayout {

    private int mCardViewCount = 1;
    private SparseArrayCompat<ViewGroup> mCardViewFractory;

    private RecyclerView.Adapter<BaseViewHolder> mAdapter;

    private OnItemClickListener mOnItemClickListener;
    private LayoutInflater mInflater;
    private DisplayMetrics mWindowmetrics;

    //Item是否是CardView
    private boolean mIsItemCardView;

    public GridViewFactoryView(Context context) {
        super(context);
        init();
    }

    public GridViewFactoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GridViewFactoryView);
        mIsItemCardView = typedArray.getBoolean(R.styleable.GridViewFactoryView_isItemCardVIew, true);
        mCardViewCount = typedArray.getInteger(R.styleable.GridViewFactoryView_gridSize, 0);
        setContentViewRes();

        typedArray.recycle();
    }

    public GridViewFactoryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    private void init() {
        mInflater = LayoutInflater.from(getContext());

        WindowManager manager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        mWindowmetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(mWindowmetrics);
    }

    public void setContentViewRes() {
        if (getRowCount() == 0) {
            setRowCount(1, false);
        }

        if (getColumnCount() == 0) {
            setColumnCount(1, false);
        }

        if (mCardViewCount == 0) {
            mCardViewCount = getRowCount() * getColumnCount();
        }

        for (int i = 0; i < this.getChildCount(); i++) {
            this.removeViewAt(i);
        }

        mCardViewFractory = new SparseArrayCompat<>();

        for (int i = 0; i < mCardViewCount; i++) {
            Spec rowSpec = GridLayout.spec(i / getColumnCount());
            int start = i % getColumnCount();
            int size = (i != 0 && i == mCardViewCount - 1 && mCardViewCount % getColumnCount() != 0) ? 2 : 1;
            Spec columnSpec = GridLayout.spec(start, size);
            LayoutParams params = new LayoutParams(rowSpec, columnSpec);
            ViewGroup contentView;

            if (mIsItemCardView) {
                contentView = new CardView(getContext());

                int[] attrs = new int[]{android.R.attr.selectableItemBackground};
                TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs);
                Drawable drawable = a.getDrawable(0);
                ((CardView) contentView).setForeground(drawable);
            } else {
                contentView = new FrameLayout(getContext());
            }

            int marginPx = dip2px(6);
            params.setMargins(marginPx, marginPx, marginPx, marginPx);
            int contentViewWidth = mWindowmetrics.widthPixels - dip2px(44);
            params.width = size == 1 && mCardViewCount != 1 ? contentViewWidth / getColumnCount() : ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;

            mCardViewFractory.put(i, contentView);
            this.addView(contentView, params);

            setListener(contentView, i);

            requestLayout();
        }
    }

    public void setAdapter(RecyclerView.Adapter<BaseViewHolder> adapter) {
        mAdapter = adapter;

        initItem();
    }

    private void initItem() {
        if (mAdapter != null) {
            for (int i = 0; i < mCardViewCount; i++) {
                ViewGroup contentView = mCardViewFractory.get(i);

                int childCount = contentView.getChildCount();
                BaseViewHolder holder;
                if(childCount == 0){
                    holder = mAdapter.createViewHolder(contentView, mAdapter.getItemViewType(i));
                    contentView.addView(holder.getContentView(), holder.getContentView().getLayoutParams());
                    contentView.setTag(holder);
                }else{
                    holder = (BaseViewHolder) contentView.getTag();
                }
                mAdapter.onBindViewHolder(holder, i);
            }
        }
    }

    private void setListener(View contentView, final int position) {
        contentView.setClickable(true);
        contentView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            }
        });

        contentView.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemLongClick(v, position);
                }
                return false;
            }
        });
    }

    @Override
    public void setRowCount(int rowCount) {
        setRowCount(rowCount, false);
    }

    @Override
    public void setColumnCount(int columnCount) {
        setColumnCount(columnCount, false);
    }

    public void setRowCount(int rowCount,boolean flag) {
        super.setRowCount(rowCount);
        if(flag)
            setContentViewRes();
    }

    public void setColumnCount(int columnCount,boolean flag) {
        super.setColumnCount(columnCount);
        if(flag)
            setContentViewRes();
    }

    public void setItemMargin(int left, int top, int right, int bottom) {
        for (int i = 0; i < mCardViewFractory.size(); i++) {
            ViewGroup itemView = mCardViewFractory.valueAt(i);
            ViewGroup.MarginLayoutParams layoutParams = (MarginLayoutParams)itemView.getLayoutParams();
            layoutParams.setMargins(left, top, right, bottom);
        }
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int postion);

        void onItemLongClick(View view, int postion);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    private int px2dip(float pxValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
