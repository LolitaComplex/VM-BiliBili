package com.doing.bilibili.data.entity.argument;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Doing on 2016/10/12.
 *
 */
public class DetailData implements Parcelable {

    private String titleCover;
    private String played;
    private String playing;

    private String av;

    public DetailData(String av, String titleCover, String played, String playing) {
        this.av = av;
        this.titleCover = titleCover;
        this.played = played;
        this.playing = playing;
    }

    public String getTitleCover() {
        return titleCover;
    }

    public void setTitleCover(String titleCover) {
        this.titleCover = titleCover;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public String getPlaying() {
        return playing;
    }

    public void setPlaying(String playing) {
        this.playing = playing;
    }

    public String getAv() {
        return av;
    }

    public void setAv(String av) {
        this.av = av;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titleCover);
        dest.writeString(this.played);
        dest.writeString(this.playing);
        dest.writeString(this.av);
    }

    protected DetailData(Parcel in) {
        this.titleCover = in.readString();
        this.played = in.readString();
        this.playing = in.readString();
        this.av = in.readString();
    }

    public static final Creator<DetailData> CREATOR = new Creator<DetailData>() {
        @Override
        public DetailData createFromParcel(Parcel source) {
            return new DetailData(source);
        }

        @Override
        public DetailData[] newArray(int size) {
            return new DetailData[size];
        }
    };
}
