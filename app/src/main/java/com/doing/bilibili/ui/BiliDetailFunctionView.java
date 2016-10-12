package com.doing.bilibili.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.IntegerRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doing.bilibili.R;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailFunctionView extends FrameLayout {


    private int mAmount;
    private int mResourceId;
    private String mTitle;
    private TextView mTvNumber;
    private ImageView mIvIcon;
    private TextView mTvTitle;
    private int mAmountColor;

    public BiliDetailFunctionView(Context context) {
        super(context);
        init();
    }

    public BiliDetailFunctionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BiliDetailFunctionView);
        mAmount = typedArray.getInt(R.styleable.BiliDetailFunctionView_amount, 0);
        mResourceId = typedArray.getResourceId(R.styleable.BiliDetailFunctionView_src, R.drawable.ic_coin);
        mTitle = typedArray.getString(R.styleable.BiliDetailFunctionView_titleText);
        mAmountColor = typedArray.getColor(R.styleable.BiliDetailFunctionView_amountColor, Color.BLUE);
        init();
    }

    public BiliDetailFunctionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //添加子View
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_bilidetail_functionview, this, true);

        mTvNumber = (TextView) inflate.findViewById(R.id.BiliDetailFunctionView_tv_number);
        mIvIcon = (ImageView) inflate.findViewById(R.id.BiliDetailFunctionView_iv_icon);
        mTvTitle = (TextView) inflate.findViewById(R.id.BiliDetailFunctionView_tv_title);

        mTvNumber.setTextColor(mAmountColor);

        setContent(mAmount, mResourceId, mTitle);
    }

    public void setContent(int amount ,int resourceId, String text) {
        if (amount == 0) {
            mTvNumber.setVisibility(View.INVISIBLE);
        } else {
            mTvNumber.setVisibility(View.VISIBLE);
            mTvNumber.setText(amount+"");
        }

        if (resourceId != -1) {
            mIvIcon.setImageResource(resourceId);
        }

        if (!TextUtils.isEmpty(text)) {
            mTvTitle.setText(text);
        }
    }

    public void setContent(String amount) {
        setContent(Integer.parseInt(amount), -1, null);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        this.setBackgroundResource(R.drawable.item_touch_have_bg);
        super.setOnClickListener(l);
    }
}
