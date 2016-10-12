package com.doing.bilibili.net;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;

import com.doing.bilibili.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImgLoader {

    private static final String HEX_STRING = "0123456789ABCDEF";

    public enum PicSize {
        F, XL, L, M, S;

        public String getUrl(String url) {
            url = url.replace("/F/", "/" + name() + "/");
            return url;
        }
    }

    private static final String TAG = "ImgLoader";

    private static boolean canChangeSize(String url) {
        return url.contains("/F/");
    }


    public static void load(final Context context, final ImageView img,
                            final String ourl) {
        if (!TextUtils.isEmpty(ourl)) {
            if (canChangeSize(ourl)) {
                int w = img.getWidth();
                int h = img.getHeight();
                if (w == 0 || h == 0) {
                    img.getViewTreeObserver().addOnPreDrawListener(
                            new OnPreDrawListener() {

                                @Override
                                public boolean onPreDraw() {
                                    int w = img.getMeasuredWidth();
                                    int h = img.getMeasuredHeight();
                                    if (w == 0 || h == 0) {
                                        Picasso.with(context).load(ourl)
                                                .into(img);
                                    } else {
                                        load(context, img, ourl, w, h);
                                    }
                                    img.getViewTreeObserver().removeOnPreDrawListener(this);
                                    return false;
                                }
                            });
                } else {
                    load(context, img, ourl, w, h);
                }
            } else {
                Picasso.with(context).load(ourl).into(img);
            }
        }
    }

    private static void load(Context context, ImageView img, final String url, int w,
                             int h) {
        final long start = SystemClock.currentThreadTimeMillis();
        PicSize picSize;
        int m = w * h;
        if (m < 320 * 320) {
            picSize = PicSize.S;
        } else if (m < 640 * 640) {
            picSize = PicSize.M;

        } else if (m < 1280 * 1280) {
            picSize = PicSize.L;

        } else if (m < 2560 * 2560) {
            picSize = PicSize.XL;

        } else {
            picSize = PicSize.L;
        }
        load(context, img, url, picSize, new Callback() {

            @Override
            public void onSuccess() {
                long end = SystemClock.currentThreadTimeMillis();
                getRuntime(end - start, url);
            }

            @Override
            public void onError() {

            }

            private void getRuntime(long time, String ourl) {
                String line = ourl + "——此url下载图片消耗的时间为：" + time + "ms";
                try {
                    BufferedWriter bufw = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), "ImgLog.log"), true));
                    bufw.write(line);
                    bufw.flush();
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public static void load(Context context, ImageView img, String url,
                            PicSize picSize, Callback callback) {
        if (!TextUtils.isEmpty(url)) {
            if (picSize != null)
                url = picSize.getUrl(url);
            Picasso.with(context).load(url).into(img, callback);
        } else {
            callback.onError();
        }
    }

    public static void load(Context context, ImageView img, String url,
                            PicSize picSize, int defaultImgRes) {
        if (!TextUtils.isEmpty(url)) {
            if (picSize != null)
                url = picSize.getUrl(url);
            Picasso.with(context).load(url).placeholder(defaultImgRes)
                    .error(defaultImgRes).into(img);
        }
    }

    /**
     * 已废弃
     * 把中文字符转换为带百分号的浏览器编码
     *
     * @param word
     * @return
     */
    @Deprecated
    public static String toBrowserCode(String word) {
        byte[] bytes = word.getBytes();

        //不包含中文，不做处理
        if (bytes.length == word.length())
            return word;

        StringBuilder browserUrl = new StringBuilder();
        String tempStr = "";

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            //不需要处理
            if ((int) currentChar <= 256) {

                if (tempStr.length() > 0) {
                    byte[] cBytes = tempStr.getBytes();

                    for (int j = 0; j < cBytes.length; j++) {
                        browserUrl.append('%');
                        browserUrl.append(HEX_STRING.charAt((cBytes[j] & 0xf0) >> 4));
                        browserUrl.append(HEX_STRING.charAt((cBytes[j] & 0x0f) >> 0));
                    }
                    tempStr = "";
                }

                browserUrl.append(currentChar);
            } else {
                //把要处理的字符，添加到队列中
                tempStr += currentChar;
            }
        }
        return browserUrl.toString();
    }
}
