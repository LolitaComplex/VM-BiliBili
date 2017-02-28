package com.doing.bilibili.data.net;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.doing.bilibili.baselib.utils.LogUtils;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;

import rx.functions.Action1;
import rx.functions.Action2;

/**
 * Created by Doing on 2016/10/12.
 *
 * Piccso，初步封装，后续补充完毕
 */
public class ImageEnginePicasso {

    private static String url;
    private static Action1<Bitmap> action2;

    public enum ImageSize {
        is600x360(600,360),
        is80x80(80, 80),;

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
                .resize(resizeWidth, resizeHeight)
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

    public static void handleBitmap(final ImageView imageView, final String url, final Action2<ImageView, Bitmap> action2) {

        ImageSize size = ImageSize.is80x80;

        Picasso.with(UIUtils.getContext())
                .load(url)
                .resize(size.getResizeWidth(), size.getResizeHeight())
                .centerCrop()
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        LogUtils.e("Doing", "asda");
                        action2.call(imageView, bitmap);
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        LogUtils.e("ImageLoader", "读片读取错误");
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
    }
}
