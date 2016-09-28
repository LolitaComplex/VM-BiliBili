package com.doing.bilibili.base;

import com.doing.bilibili.entity.global.User;

/**
 * Created by Doing on 2016/9/27.
 *
 */
public class Altar {

    public static User user;

    public static void login(User biliUser) {
        user = biliUser;
    }

    public static boolean isLogin() {
        return user != null;
    }

    public static String getAccessKey() {
        return user.getAccseeKey();
    }
}
