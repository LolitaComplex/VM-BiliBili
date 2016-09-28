package com.doing.bilibili.baselib.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class BaseUtil {

    public static void removeParent(View view) {

        ViewParent parent = view.getParent();

        if (parent instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) parent;
            group.removeView(view);
        }
    }
}
