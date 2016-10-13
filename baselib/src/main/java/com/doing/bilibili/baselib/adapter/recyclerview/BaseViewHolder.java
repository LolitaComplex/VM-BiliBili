package com.doing.bilibili.baselib.adapter.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.baselib.utils.UIUtils;
import com.squareup.picasso.Picasso;

/**
 * Created by Doing on 2016/9/18.
 *
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;

    private View mContentView;

    private SparseArrayCompat<View> mViews;


    private BaseViewHolder(Context context,View itemView) {
        super(itemView);
        this.mContext = context;
        this.mContentView = itemView;
        mViews = new SparseArrayCompat<>();
    }

    public static BaseViewHolder createViewHolder(Context context, View itemView) {
        return new BaseViewHolder(context, itemView);
    }

    public static BaseViewHolder createViewHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new BaseViewHolder(context, itemView);
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mContentView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getContentView() {
        return mContentView;
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public BaseViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    public BaseViewHolder setTextColor(int viewId, int color) {
        TextView textView = getView(viewId);
        textView.setTextColor(color);
        return this;
    }

    public BaseViewHolder setTextColorRes(int viewId, int res) {
        TextView textView = getView(viewId);
        textView.setTextColor(ContextCompat.getColor(mContext, res));
        return this;
    }

    public BaseViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageBitmapRes(int viewId,int bitmapRes) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(bitmapRes);
        return this;
    }

    public BaseViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView imageView = getView(viewId);
        imageView.setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setImageUrl(int viewId, String url) {
        ImageView imageView = getView(viewId);
        Picasso.with(mContext).load(url).into(imageView);
        //TODO
        return this;
    }

    public BaseViewHolder setImageUrl(int viewId, String url, int resizeWidth, int resizeHeight) {
        if (TextUtils.isEmpty(url)) {
            return this;
        }
        ImageView imageView = getView(viewId);
        Picasso.with(mContext).load(url).resize(resizeWidth, resizeHeight).centerCrop().into(imageView);
        //TODO
        return this;
    }

    public BaseViewHolder setVisible(int viewId, boolean boo) {
        View view = getView(viewId);
        if (boo) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
        return this;
    }

    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener clickListener) {
        View view = getView(viewId);
        view.setOnClickListener(clickListener);
        return this;
    }

    public BaseViewHolder setOnTouchListener(int viewId, View.OnTouchListener touchListener) {
        View view = getView(viewId);
        view.setClickable(true);
        view.setOnTouchListener(touchListener);
        return this;
    }

    public BaseViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener longClickListener) {
        View view = getView(viewId);
        view.setOnLongClickListener(longClickListener);
        return this;
    }


}
