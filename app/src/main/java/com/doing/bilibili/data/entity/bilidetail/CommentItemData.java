package com.doing.bilibili.data.entity.bilidetail;

/**
 * Created by Doing on 2016/10/13.
 *
 */
public class CommentItemData {

    private String nickName;
    private int floor;
    private int creatDate;
    private String content;
    private int support;
    private int level;

    private String coverUrl;

    public CommentItemData(String nickName, int floor, int creatDate, String content, int support, int level, String coverUrl) {
        this.nickName = nickName;
        this.floor = floor;
        this.creatDate = creatDate;
        this.content = content;
        this.support = support;
        this.level = level;
        this.coverUrl = coverUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(int creatDate) {
        this.creatDate = creatDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
