package com.doing.bilibili.entity.bangumi;


import java.util.List;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public class HomeRealBangumi {

    private BangumiBannerBean ad;

    private List<BangumiItemBean> data;

    public BangumiBannerBean getAd() {
        return ad;
    }

    public void setAd(BangumiBannerBean ad) {
        this.ad = ad;
    }

    public List<BangumiItemBean> getData() {
        return data;
    }

    public void setData(List<BangumiItemBean> data) {
        this.data = data;
    }
}
