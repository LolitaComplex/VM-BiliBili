package com.doing.bilibili.baselib.utils;

import android.widget.Toast;

/**
 * Created by 杜营 on 2016/4/18.
 *
 */
public class ToastUtil {

    private static Toast toast;

    public static void show(String mes){
        if(toast == null){
            toast = Toast.makeText(UIUtils.getContext(),"",Toast.LENGTH_SHORT);
        }
        toast.setText(mes);
        toast.show();
    }
}
