package com.doing.bilibili.entity.bus;

import com.doing.bilibili.entity.recommend.Recommend;

import java.util.List;

/**
 * Created by Doing on 2016/10/13.
 *
 */
public class BusRecommend {

    private List<Recommend.BodyBean> data;

    private int position;


    public BusRecommend(List<Recommend.BodyBean> data, int position) {
        this.data = data;
        this.position = position;
    }

    public List<Recommend.BodyBean> getData() {
        return data;
    }

    public void setData(List<Recommend.BodyBean> data) {
        this.data = data;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
