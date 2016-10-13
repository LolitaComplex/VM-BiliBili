package com.doing.bilibili.entity.recommend;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Doing on 2016/9/9.
 *
 */
public class Recommend implements Parcelable{

    @Override
    public String toString() {
        return "Recommend{" +
                "head=" + head +
                ", type='" + type + '\'' +
                ", body=" + body +
                '}';
    }

    /**
     * count : 1930
     * goto : live
     * param :
     * style : gm_av
     * title : 热门直播
     */

    private HeadBean head;
    /**
     * body : [{"area":"手机直播","area_id":11,"cover":"http://i0.hdslb.com/bfs/live/d919bee96250aba5347d235bbc8612cf846bba68.jpg","goto":"live","height":364,"online":1368,"param":"91761","style":"gm_live","title":"温柔御姐音陪聊+深夜放毒","up":"抹茶味の影喵","up_face":"http://i0.hdslb.com/bfs/face/4020644bd617910bb230596e02eb0199d3c67aa3.jpg","width":580},{"area":"单机联机","area_id":1,"cover":"http://i0.hdslb.com/bfs/live/a889f6d7c9dbe00207d43532905f3ffaa0bc2586.jpg","goto":"live","height":364,"online":1807,"param":"101526","style":"gm_live","title":"【枫叔】黎明烧鸡","up":"狼枫子","up_face":"http://i0.hdslb.com/bfs/face/10fb15e2efe7ae272779db76a72d9e2bec663637.jpg","width":580},{"area":"绘画专区","area_id":9,"cover":"http://i0.hdslb.com/bfs/live/8b6552325bf6c557d4d35f10f7ac898aec130461.jpg","goto":"live","height":364,"online":441,"param":"146809","style":"gm_live","title":"一身正气不怕污~起来做早操","up":"zhufun","up_face":"http://i1.hdslb.com/bfs/face/6afd4dd866677ffc50782dd4335e8a5995dff64f.jpg","width":580},{"area":"单机联机","area_id":1,"cover":"http://i0.hdslb.com/bfs/live/78afcaa6aec4bea153af71f47d2dd7eeb1095d14.jpg","goto":"live","height":364,"online":738,"param":"74723","style":"gm_live","title":"萌新幼女被鬼举高高实况 污所畏惧 污忘初心","up":"万四屋","up_face":"http://i0.hdslb.com/bfs/face/331a25a98cfad31bfa1c325f43e92a140cb04814.jpg","width":580}]
     * head : {"count":1930,"goto":"live","param":"","style":"gm_av","title":"热门直播"}
     * type : live
     */

    private String type;
    /**
     * area : 手机直播
     * area_id : 11
     * cover : http://i0.hdslb.com/bfs/live/d919bee96250aba5347d235bbc8612cf846bba68.jpg
     * goto : live
     * height : 364
     * online : 1368
     * param : 91761
     * style : gm_live
     * title : 温柔御姐音陪聊+深夜放毒
     * up : 抹茶味の影喵
     * up_face : http://i0.hdslb.com/bfs/face/4020644bd617910bb230596e02eb0199d3c67aa3.jpg
     * width : 580
     */

    private List<BodyBean> body;

    protected Recommend(Parcel in) {
        type = in.readString();
    }

    public static final Creator<Recommend> CREATOR = new Creator<Recommend>() {
        @Override
        public Recommend createFromParcel(Parcel in) {
            return new Recommend(in);
        }

        @Override
        public Recommend[] newArray(int size) {
            return new Recommend[size];
        }
    };

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
    }


    public static class HeadBean {

        @Override
        public String toString() {
            return "HeadBean{" +
                    "count=" + count +
                    ", gotoX='" + gotoX + '\'' +
                    ", param='" + param + '\'' +
                    ", style='" + style + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        private int count;
        @SerializedName("goto")
        private String gotoX;
        private String param;
        private String style;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class BodyBean {
        @Override
        public String toString() {
            return "BodyBean{" +
                    "area='" + area + '\'' +
                    ", area_id=" + area_id +
                    ", cover='" + cover + '\'' +
                    ", gotoX='" + gotoX + '\'' +
                    ", height=" + height +
                    ", online=" + online +
                    ", param='" + param + '\'' +
                    ", style='" + style + '\'' +
                    ", title='" + title + '\'' +
                    ", up='" + up + '\'' +
                    ", up_face='" + up_face + '\'' +
                    ", width=" + width +
                    ", danmaku='" + danmaku + '\'' +
                    ", play='" + play + '\'' +
                    ", desc1='" + desc1 + '\'' +
                    ", status=" + status +
                    '}';
        }

        private String area;
        private int area_id;
        private String cover;
        @SerializedName("goto")
        private String gotoX;
        private int height;
        private int online;
        private String param;
        private String style;
        private String title;
        private String up;
        private String up_face;
        private int width;
        /**
         * danmaku : 422
         * play : 3.5万
         */

        private String danmaku;
        private String play;
        /**
         * desc1 : 更新到第12话
         * status : 2
         */

        private String desc1;
        private int status;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getUp_face() {
            return up_face;
        }

        public void setUp_face(String up_face) {
            this.up_face = up_face;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(String danmaku) {
            this.danmaku = danmaku;
        }

        public String getPlay() {
            return play;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public String getDesc1() {
            return desc1;
        }

        public void setDesc1(String desc1) {
            this.desc1 = desc1;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
