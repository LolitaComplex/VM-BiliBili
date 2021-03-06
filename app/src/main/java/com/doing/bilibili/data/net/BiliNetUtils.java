package com.doing.bilibili.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.doing.bilibili.baselib.utils.NetUtils;
import com.doing.bilibili.baselib.utils.UIUtils;

import java.util.Map;

/**
 * Created by Doing on 2016/9/19.
 *
 */
public class BiliNetUtils {

    public static final String APP_BASE_LIVE_URL = "http://live.bilibili.com";

    public static final String APP_BASE_BANGUMI_URL = "http://bangumi.bilibili.com";

    public static final String APP_BASE_DISCOVER_URL = "http://s.search.bilibili.com";

    public static final String APP_BASE_URL = "http://app.bilibili.com";

    public static final String APP_BILI_DETAIL_URL = "http://api.bilibili.cn";

    //RequestParams
    public static class RequestParams{

        public static class Key{
            public static final String APP_KEY = "appkey";
            public static final String ACCESS_KEY = "access_key";
            public static final String BUILD = "build";
            public static final String CHANNEL = "channel";
            public static final String MOBI_APP = "mobi_app";
            public static final String PLATFORM = "platform";
            public static final String SCREEN = "screen";
            public static final String TS = "ts";
            public static final String SIGN = "sign";
            public static final String CURSOR = "cursor";
            public static final String PAGE = "page";
            public static final String PAGESIZE = "pagesize";
            public static final String ORDER = "order";

            public static final String DEVICE = "_device";
            public static final String HWID = "_hwid";
            public static final String SCALE = "scale";

            public static final String ULV = "_ulv";
            public static final String PN = "pn";
            public static final String PS = "ps";
            public static final String SORT = "sort";
            public static final String TYPE = "type";
        }

        public static class Value{
            public static final String APP_KEY = "c1b107428d337928";
//            public static final String APP_KEY = "85eb6835b0a1034e";
            public static final String APP_SECRET_KEY = "ea85624dfcf12d7cc7b2b3a94fac1f2c";
//            public static final String APP_SECRET_KEY = "2ad42749773c441109bdc0191257a664";
            public static final String BUILD = "426003";
            public static final String CHANNEL = "wandoujia";
            public static final String MOBI_APP = "android";
            public static final String PLATFORM = "android";
            public static final String DEVICE = "android";
            public static final String SCREEN = "xxhdpi";

            public static final String HWID = "9ec238cf481b1087";

            public static final String ULV = "10000";

        }
    }

    public static String getSign(Map<String,String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue()+"&");
        }
        return NetUtils.md5(sb.substring(0, sb.length() - 1) + RequestParams.Value.APP_SECRET_KEY);
    }

    public static boolean statusOfNetwork() {
        Context context = UIUtils.getContext();
        ConnectivityManager service = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = service.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
        //TODO 确实确认本地是否存在缓存的判断，后期记得补上
    }
}
