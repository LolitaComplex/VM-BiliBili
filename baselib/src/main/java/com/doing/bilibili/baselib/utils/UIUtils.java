package com.doing.bilibili.baselib.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Process;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.LayoutInflater;
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

    public static Drawable tint(int drawableId, int color) {
        Drawable wrapDrawable = DrawableCompat.wrap(getDrawable(drawableId).mutate());
        DrawableCompat.setTint(wrapDrawable, UIUtils.getColor(color));
        return wrapDrawable;
    }

    public static Drawable tintList(int drawableId, int clolorList) {
        Drawable wrapDrawable = DrawableCompat.wrap(getDrawable(drawableId).mutate());
        DrawableCompat.setTintList(wrapDrawable, ContextCompat.getColorStateList(getContext(),clolorList));
        return wrapDrawable;
    }

    public static class ColorText {
        Integer color;
        String text;

        public ColorText(Integer color, String text) {
            super();
            this.color = color;
            this.text = text;
        }

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


}
