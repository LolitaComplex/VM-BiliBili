package com.doing.bilibili.net;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.doing.bilibili.baselib.utils.LogUtils;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Created by Doing on 2016/10/12.
 *
 * Piccso，初步封装，后续补充完毕
 */
public class ImageEnginePicasso {

    public enum ImageSize {
        is600x360(600,360);

        private int resizeWidth;
        private int resizeHeight;

        ImageSize(int resizeWidth, int resizeHeight) {
            this.resizeHeight = resizeHeight;
            this.resizeWidth = resizeWidth;
        }

        public int getResizeWidth() {
            return resizeWidth;
        }

        public int getResizeHeight() {
            return resizeHeight;
        }
    }


    public static void load(ImageView iv, String url) {
        Picasso.with(UIUtils.getContext())
                .load(url)
                .centerCrop()
                .into(iv);
    }

    public static void load(ImageView iv, String url, int resizeWidth, int resizeHeight) {
        Picasso.with(UIUtils.getContext())
                .load(url)
                .resize(resizeWidth,resizeHeight)
                .centerCrop()
                .into(iv);
    }

    public static void load(ImageView iv, String url, ImageSize imageSize) {
        Picasso.with(UIUtils.getContext())
                .load(url)
                .resize(imageSize.getResizeWidth(), imageSize.getResizeHeight())
                .centerCrop()
                .into(iv);
    }

    //同步请求
    public static Bitmap getBitmap(String url) {
        try {
            return Picasso.with(UIUtils.getContext())
                    .load(url)
                    .get();
        } catch (IOException e) {
            LogUtils.e("ImageEnginePicasso","Url有误");
        }
        return null;
    }
}
