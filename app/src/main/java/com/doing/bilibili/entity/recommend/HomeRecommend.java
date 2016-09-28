package com.doing.bilibili.entity.recommend;

import java.util.List;

/**
 * Created by Doing on 2016/9/19.
 *
 */
public class HomeRecommend {

    private List<BannerRecommand> banners;

    private List<Recommend> recommends;

    public List<BannerRecommand> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerRecommand> banners) {
        this.banners = banners;
    }

    public List<Recommend> getRecommends() {
        return recommends;
    }

    public void setRecommends(List<Recommend> recommends) {
        this.recommends = recommends;
    }
}
