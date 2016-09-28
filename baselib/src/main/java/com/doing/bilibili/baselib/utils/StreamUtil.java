package com.doing.bilibili.baselib.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by 杜营 on 2016/6/27.
 *
 */
public class StreamUtil {

    public static void closeStream(Closeable stream){
        if(stream!=null)
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
