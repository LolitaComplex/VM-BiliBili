package com.doing.bilibili.data.entity.bangumi;

import java.util.List;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public class HomeBangumi {


    private BangumiBannerBean ad;
    /**
     * list : [{"cover":"http://i0.hdslb.com/bfs/bangumi/7c1f3ca60da441ffbc2425409ee2a5c379264568.jpg","favourites":"2739175","is_finish":0,"last_time":1474218310,"newest_ep_index":"25","pub_time":1459699200,"season_id":3461,"season_status":2,"title":"Re：从零开始的异世界生活","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/14ba6643f22405e2777cca992002cc6411601334.jpg","favourites":"2131773","is_finish":1,"last_time":1467335102,"newest_ep_index":"12","pub_time":1460044800,"season_id":3450,"season_status":2,"title":"在下坂本，有何贵干？","watching_count":0},{"cover":"http://i0.hdslb.com/bfs/bangumi/6603936f61460f284c153b5fbdf2a8f6b2acb34c.jpg","favourites":"1224744","is_finish":1,"last_time":1467309602,"newest_ep_index":"12","pub_time":1460044800,"season_id":3494,"season_status":2,"title":"甲铁城的卡巴内瑞","watching_count":0}]
     * season : 2
     * year : 2016
     */

    private BangumiItemBean previous;
    /**
     * cover : http://i0.hdslb.com/bfs/bangumi/2cc5cd1644da95ca4aa5c39ef418d86461294772.jpg
     * favourites : 185869
     * is_finish : 0
     * last_time : 1474517002
     * newest_ep_index : 10
     * pub_time : 1469030400
     * season_id : 5352
     * season_status : 2
     * title : 画江湖之不良人 第二季
     * watching_count : 0
     */

    private List<BangumiListBean> china;

    private List<BangumiListBean> serializing;


    public BangumiBannerBean getAd() {
        return ad;
    }

    public void setAd(BangumiBannerBean ad) {
        this.ad = ad;
    }

    public BangumiItemBean getPrevious() {
        return previous;
    }

    public void setPrevious(BangumiItemBean previous) {
        this.previous = previous;
    }

    public List<BangumiListBean> getChina() {
        return china;
    }

    public void setChina(List<BangumiListBean> china) {
        this.china = china;
    }

    public List<BangumiListBean> getSerializing() {
        return serializing;
    }

    public void setSerializing(List<BangumiListBean> serializing) {
        this.serializing = serializing;
    }
}
