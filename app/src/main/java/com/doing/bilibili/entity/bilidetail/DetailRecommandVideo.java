package com.doing.bilibili.entity.bilidetail;

import java.util.List;

/**
 * Created by Doing 2016/10/11.
 *
 */
public class DetailRecommandVideo {

    private int code;
    private int pages;
    private int num;
    /**
     * aid : 449146
     * typeid : 24
     * typename : MAD·AMV
     * title : 阴阳相隔情犹在 魂返红尘与君别 // Sincerity
     * subtitle : 冰菓 - Sincerity
     * play : 599176
     * review : 4743
     * video_review : 6324
     * favorites : 36498
     * mid : 528476
     * author : Umika
     * description : 原创 ~AKROSS Con 2012: Best Video / Viewers' Choice / Best Romance / Best Technical Work / Best Visual Effects Design / Best Presentation on AKROSS Con 2012 Music: Halou - Today http://akross.ru/index.cgi?act=video;id=3414
     * create : 2013-01-23 23:52
     * pic : http://i0.hdslb.com/u_f/c0f4f5af8fa9cc9c4ce8666288f6fc87.jpg
     * credit : 11245
     * coins : 14192
     * duration : 2:59
     * last_recommend : [{"mid":8615,"time":1359013131,"msg":"迷の制作","uname":"Tsanie.Fix","face":"http://i2.hdslb.com/bfs/face/ea8fa5ea52a7997c9492cddd778957f8a5741684.jpg"}]
     */

    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private int aid;
        private int typeid;
        private String typename;
        private String title;
        private String subtitle;
        private String play;
        private int review;
        private int video_review;
        private int favorites;
        private int mid;
        private String author;
        private String description;
        private String create;
        private String pic;
        private int credit;
        private int coins;
        private String duration;
        /**
         * mid : 8615
         * time : 1359013131
         * msg : 迷の制作
         * uname : Tsanie.Fix
         * face : http://i2.hdslb.com/bfs/face/ea8fa5ea52a7997c9492cddd778957f8a5741684.jpg
         */

        private List<LastRecommendBean> last_recommend;

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public int getTypeid() {
            return typeid;
        }

        public void setTypeid(int typeid) {
            this.typeid = typeid;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getPlay() {
            return play;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public int getReview() {
            return review;
        }

        public void setReview(int review) {
            this.review = review;
        }

        public int getVideo_review() {
            return video_review;
        }

        public void setVideo_review(int video_review) {
            this.video_review = video_review;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCreate() {
            return create;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public int getCoins() {
            return coins;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public List<LastRecommendBean> getLast_recommend() {
            return last_recommend;
        }

        public void setLast_recommend(List<LastRecommendBean> last_recommend) {
            this.last_recommend = last_recommend;
        }

        public static class LastRecommendBean {
            private int mid;
            private int time;
            private String msg;
            private String uname;
            private String face;

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }
        }
    }
}
