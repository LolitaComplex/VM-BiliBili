package com.doing.bilibili.entity.bus;

import com.doing.bilibili.entity.recommend.Recommend;

import java.util.List;

/**
 * Created by Doing on 2016/10/13.
 *
 */
public class HotRecommend {

    private List<Recommend.BodyBean> data;

    public HotRecommend(List<Recommend.BodyBean> data) {
        this.data = data;
    }

    public List<Recommend.BodyBean> getData() {
        return data;
    }

    public void setData(List<Recommend.BodyBean> data) {
        this.data = data;
    }
}
