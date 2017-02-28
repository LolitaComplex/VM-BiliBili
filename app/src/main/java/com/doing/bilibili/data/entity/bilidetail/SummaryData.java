package com.doing.bilibili.data.entity.bilidetail;

/**
 * Created by Doing on 2016/10/12.
 *
 */
public class SummaryData {

    private DetailVideoInfo info;

    private DetailRecommandVideo recommandVideo;

    public SummaryData(DetailVideoInfo info, DetailRecommandVideo recommandVideo) {
        this.info = info;
        this.recommandVideo = recommandVideo;
    }

    public DetailVideoInfo getInfo() {
        return info;
    }

    public void setInfo(DetailVideoInfo info) {
        this.info = info;
    }

    public DetailRecommandVideo getRecommandVideo() {
        return recommandVideo;
    }

    public void setRecommandVideo(DetailRecommandVideo recommandVideo) {
        this.recommandVideo = recommandVideo;
    }
}
