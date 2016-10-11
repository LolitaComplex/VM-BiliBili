package com.doing.bilibili.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doing.bilibili.R;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailFunctionView extends LinearLayout {


    public BiliDetailFunctionView(Context context) {
        super(context);
        init();
    }

    public BiliDetailFunctionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BiliDetailFunctionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //初始化LinearLayout
        setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;

        //添加子View
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_bilidetail_functionview, null);
        addView(inflate, params);

        TextView tvNumber = (TextView) inflate.findViewById(R.id.BiliDetailFunctionView_tv_number);
        ImageView ivIcon = (ImageView) inflate.findViewById(R.id.BiliDetailFunctionView_iv_icon);
        TextView tvTitle = (TextView) inflate.findViewById(R.id.BiliDetailFunctionView_tv_title);
    }
}
