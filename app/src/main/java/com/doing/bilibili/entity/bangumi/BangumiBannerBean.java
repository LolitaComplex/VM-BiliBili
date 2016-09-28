package com.doing.bilibili.entity.bangumi;

import java.util.List;

/**
 * Created by Doing on 2016/9/23.
 *
 */
public class BangumiBannerBean {

    private List<?> body;
    /**
     * id : 0
     * img : http://i0.hdslb.com/bfs/bangumi/a89f145cb1108fafaf5aa2e7e3dc6e2249c247a5.jpg
     * is_ad : 0
     * link : http://bangumi.bilibili.com/anime/1882
     * title : 遥远时空中
     */

    private List<HeadBean> head;

    public List<?> getBody() {
        return body;
    }

    public void setBody(List<?> body) {
        this.body = body;
    }

    public List<HeadBean> getHead() {
        return head;
    }

    public void setHead(List<HeadBean> head) {
        this.head = head;
    }

    public static class HeadBean {
        private int id;
        private String img;
        private int is_ad;
        private String link;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getIs_ad() {
            return is_ad;
        }

        public void setIs_ad(int is_ad) {
            this.is_ad = is_ad;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
