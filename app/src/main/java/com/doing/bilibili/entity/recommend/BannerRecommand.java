package com.doing.bilibili.entity.recommend;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/9/19.
 *
 */
public class BannerRecommand implements Parcelable {

    private String title;
    private String value;
    private String image;
    private int type;
    private int weight;
    private String remark;
    private String hash;

    protected BannerRecommand(Parcel in) {
        title = in.readString();
        value = in.readString();
        image = in.readString();
        type = in.readInt();
        weight = in.readInt();
        remark = in.readString();
        hash = in.readString();
    }

    public static final Creator<BannerRecommand> CREATOR = new Creator<BannerRecommand>() {
        @Override
        public BannerRecommand createFromParcel(Parcel in) {
            return new BannerRecommand(in);
        }

        @Override
        public BannerRecommand[] newArray(int size) {
            return new BannerRecommand[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(title);
        dest.writeString(value);
        dest.writeString(image);
        dest.writeInt(type);
        dest.writeInt(weight);
        dest.writeString(remark);
        dest.writeString(hash);
    }

}
