package com.doing.bilibili.data.entity.bangumi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public class BangumiItemBean {
    private int season;
    private int year;
    /**
     * cover : http://i0.hdslb.com/bfs/bangumi/7c1f3ca60da441ffbc2425409ee2a5c379264568.jpg
     * favourites : 2739175
     * is_finish : 0
     * last_time : 1474218310
     * newest_ep_index : 25
     * pub_time : 1459699200
     * season_id : 3461
     * season_status : 2
     * title : Re：从零开始的异世界生活
     * watching_count : 0
     */

    private List<BangumiListBean> list;

    public int getSeason() {
        return season;
    }

    public BangumiItemBean setSeason(int season) {
        this.season = season;
        return this;
    }

    public int getYear() {
        return year;
    }

    public BangumiItemBean setYear(int year) {
        this.year = year;
        return this;
    }

    public List<BangumiListBean> getList() {
        return list;
    }

    public BangumiItemBean setList(List<BangumiListBean> list) {
        this.list = list;
        return this;
    }

    public BangumiItemBean setList(BangumiListBean itemBean) {
        list = new ArrayList<>();
        list.add(itemBean);
        return this;
    }
}
