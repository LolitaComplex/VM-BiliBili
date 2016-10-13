package com.doing.bilibili.baselib.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Process;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.doing.bilibili.baselib.R;
import com.doing.bilibili.baselib.base.BaseApplication;


/**
 * Created by Doing on 2016/4/14.
 *
 */
public class UIUtils {

    public static Context getContext() {
        return BaseApplication.getApplication();
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static String getString(int id) {
        return getResources().getString(id);
    }

    public static String[] getStringArray(int id) {
        return getResources().getStringArray(id);
    }

    public static String getResString(int id) {
        return getResources().getString(id);
    }

    public static int getColor(int id) {
        return ContextCompat.getColor(getContext(), id);
    }

    public static ColorStateList getColorList(int listId) {
        return ContextCompat.getColorStateList(getContext(), listId);
    }

    public static Drawable getDrawable(int drawableId) {
        return ContextCompat.getDrawable(getContext(), drawableId);
    }


    public static int getIdentifier(String idName, String defType) {
        return getResources().getIdentifier(idName, defType, getContext().getPackageName());
    }

    public static View inflate(int layoutId) {
        return LayoutInflater.from(getContext()).inflate(layoutId, null);
    }

    public static View inflate(int layoutId, ViewGroup parentLyaout) {
        return LayoutInflater.from(getContext()).inflate(layoutId, parentLyaout, false);
    }

    public static View inflate(int layoutId, ViewGroup parentLyaout,boolean attachToRoot) {
        return LayoutInflater.from(getContext()).inflate(layoutId, parentLyaout, attachToRoot);
    }

    public static void runOnUiThread(Runnable runnable) {
        int processId = Process.myTid();
        if (processId == BaseApplication.getMainId()) {
            runnable.run();
        } else {
            Handler handler = BaseApplication.getHandler();
            handler.post(runnable);
        }
    }

    public static Rect getWindowSize() {
        WindowManager manager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        Rect rect = new Rect();
        defaultDisplay.getRectSize(rect);
        return rect;
    }

    public static void tint(ImageView imageView, int drawableId, int color) {
        Drawable drawable = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), drawableId).mutate());
        DrawableCompat.setTint(drawable, UIUtils.getColor(color));
        imageView.setImageDrawable(drawable);
    }

    public static Drawable tint(@DrawableRes int drawableId,@ColorRes int color) {
        Drawable wrapDrawable = DrawableCompat.wrap(getDrawable(drawableId).mutate());
        DrawableCompat.setTint(wrapDrawable, UIUtils.getColor(color));
        return wrapDrawable;
    }

    public static Drawable tintList(@DrawableRes int drawableId,@ColorRes int clolorList) {
        Drawable wrapDrawable = DrawableCompat.wrap(getDrawable(drawableId).mutate());
        DrawableCompat.setTintList(wrapDrawable, ContextCompat.getColorStateList(getContext(),clolorList));
        return wrapDrawable;
    }

    public static class ColorText {
        Integer color;
        String text;

        private ColorText(Integer color, String text) {
            super();
            this.color = color;
            this.text = text;
        }

        public static ColorText holder(Integer color, String text) {
            return new ColorText(color, text);
        }
    }

    public static void setTouchListener(View view,final boolean scrollSwitch) {
        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return scrollSwitch;
            }
        });
    }

    /***
     * 同一个textview 设置不同的文字颜色
     *
     * @param tv
     * @param colorTexts
     */
    public static void setTextWithColor(TextView tv, ColorText... colorTexts) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        int start = 0;
        int end = 0;
        for (ColorText ct : colorTexts) {
            if (TextUtils.isEmpty(ct.text)) {
                continue;
            }
            builder.append(ct.text);
            end += ct.text.length();
            if (ct.color != null) {
                builder.setSpan(new ForegroundColorSpan(ct.color), start, end,
                        SpannableStringBuilder.SPAN_INCLUSIVE_EXCLUSIVE);
            }
            start += ct.text.length();
        }
        tv.setText(builder);
    }

    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 生成带边线的原型图片
     * @param source
     * @return
     */
    public static RoundedBitmapDrawable getRoudedBitmapDrawable(Bitmap source) {
        //原图宽度
        int bitmapWidth = source.getWidth();
        //原图高度
        int bitmapHeight = source.getHeight();
        //边框宽度 pixel
        int borderWidthHalf = 10;

        //转换为正方形后的宽高
        int bitmapSquareWidth = Math.min(bitmapWidth,bitmapHeight);

        //最终图像的宽高
        int newBitmapSquareWidth = bitmapSquareWidth+borderWidthHalf;

        Bitmap roundedBitmap = Bitmap.createBitmap(newBitmapSquareWidth,newBitmapSquareWidth,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roundedBitmap);
        int x = borderWidthHalf + bitmapSquareWidth - bitmapWidth;
        int y = borderWidthHalf + bitmapSquareWidth - bitmapHeight;

        //裁剪后图像,注意X,Y要除以2 来进行一个中心裁剪
        canvas.drawBitmap(source, x/2, y/2, null);
        Paint borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(borderWidthHalf);
        borderPaint.setColor(Color.WHITE);
        borderPaint.setAntiAlias(true);

        //添加边框
        canvas.drawCircle(canvas.getWidth()/2, canvas.getWidth()/2, newBitmapSquareWidth/2, borderPaint);

        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),roundedBitmap);
        roundedBitmapDrawable.setGravity(Gravity.CENTER);
        roundedBitmapDrawable.setAntiAlias(true);
        roundedBitmapDrawable.setCircular(true);

        return roundedBitmapDrawable;
    }


}
