package com.doing.bilibili.data.entity.global;

/**
 * Created by Doing on 2016/9/27.
 *
 */
public class User {

    private String nickname;
    private String accseeKey;
    private String cover;
    private String type;
    private int level;
    private double coin;

    public User(String nickname, String accseeKey, String cover, String type, int level, double coin) {
        this.nickname = nickname;
        this.accseeKey = accseeKey;
        this.cover = cover;
        this.type = type;
        this.level = level;
        this.coin = coin;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccseeKey() {
        return accseeKey;
    }

    public void setAccseeKey(String accseeKey) {
        this.accseeKey = accseeKey;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCoin() {
        return coin;
    }

    public void setCoin(double coin) {
        this.coin = coin;
    }
}
