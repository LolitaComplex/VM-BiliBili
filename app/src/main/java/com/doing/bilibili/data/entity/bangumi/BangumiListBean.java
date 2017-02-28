package com.doing.bilibili.data.entity.bangumi;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public class BangumiListBean {
    private String cover;
    private String favourites;
    private int is_finish;
    private int last_time;
    private String newest_ep_index;
    private int pub_time;
    private int season_id;
    private int season_status;
    private String title;
    private int watching_count;
    /**
     * is_started : 1
     */

    private int is_started;

    //====================================================================

    /**
     * "cover": "http://i0.hdslb.com/bfs/bangumi/f65f1d4ac0479cf438de674897ec5566c5c6ed24.jpg",
     * "cursor": 1474538400753,
     * "desc": "以绝望收尾的希望物语
     * Bad End？本来就没有什么Happy End
     * 如果绝望从世上消失 那也是一种绝望吧",
     * "id": 1758,
     * "is_new": 1,
     * "link": "http://bangumi.bilibili.com/anime/5057",
     * "title": "弹丸论破3 -绝望篇- 11"
     */

    private String cursor;
    private String desc;
    private long id;
    private String is_new;
    private String link;


    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    //====================================================================


    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getFavourites() {
        return favourites;
    }

    public void setFavourites(String favourites) {
        this.favourites = favourites;
    }

    public int getIs_finish() {
        return is_finish;
    }

    public void setIs_finish(int is_finish) {
        this.is_finish = is_finish;
    }

    public int getLast_time() {
        return last_time;
    }

    public void setLast_time(int last_time) {
        this.last_time = last_time;
    }

    public String getNewest_ep_index() {
        return newest_ep_index;
    }

    public void setNewest_ep_index(String newest_ep_index) {
        this.newest_ep_index = newest_ep_index;
    }

    public int getPub_time() {
        return pub_time;
    }

    public void setPub_time(int pub_time) {
        this.pub_time = pub_time;
    }

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public int getSeason_status() {
        return season_status;
    }

    public void setSeason_status(int season_status) {
        this.season_status = season_status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWatching_count() {
        return watching_count;
    }

    public void setWatching_count(int watching_count) {
        this.watching_count = watching_count;
    }

    public int getIs_started() {
        return is_started;
    }

    public void setIs_started(int is_started) {
        this.is_started = is_started;
    }
}
