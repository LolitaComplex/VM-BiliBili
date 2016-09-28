package com.doing.bilibili.entity.livestream;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Doing on 2016/9/22.
 *
 */
public class HomeLiveStream {


    /**
     * img : http://i0.hdslb.com/bfs/live/52db661c9bbb558f4b806d9858ea1754cdef4ebb.jpg
     * link : http://live.bilibili.com/AppBanner/index?id=271
     * remark : 红叶祭上线
     * title : 红叶祭隆重上线！
     */

    private List<BannerBean> banner;
    /**
     * entrance_icon : {"height":"132","src":"http://static.hdslb.com/live-static/images/mobile/android/big/xxhdpi/11_big.png?2016092201","width":"132"}
     * id : 11
     * name : 手机直播
     */

    private List<EntranceIconsBean> entranceIcons;
    /**
     * lives : [{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/f9ff96370365221bcf70d908c9711ff7991399d0.jpg","width":320},"is_tv":0,"online":383,"owner":{"face":"http://i0.hdslb.com/bfs/face/9c39b75a9dcf79fe3135934e9ad049a47edb03cf.jpg","mid":16159326,"name":"后雨大叔"},"playurl":"http://live-play.acgvideo.com/live/392/live_16159326_5264177.flv?wsSecret=b4692e0e6d300c4e1f191c6e90d2312a&wsTime=57bbe0c1","room_id":55755,"title":"耽美条漫中【】"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/4821d0e847a1338a1c2be95e351923dc78313920.jpg","width":320},"is_tv":0,"online":961,"owner":{"face":"http://i2.hdslb.com/bfs/face/6f8df12624dd2114ac2f1e600f76f24ae91322c7.jpg","mid":25256202,"name":"柚子巫"},"playurl":"http://live-play.acgvideo.com/live/454/live_25256202_5460444.flv?wsSecret=e44985c982570a4c19b422b493ec49a8&wsTime=57bbe0c1","room_id":79933,"title":"全彩本本，啊呸，我在练人体！！！"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/8171c64ad432de100c7adb59cf79cbb37b87fce8.jpg","width":320},"is_tv":0,"online":2692,"owner":{"face":"http://i2.hdslb.com/bfs/face/2f04bb7b5acdb79238c69806e5536384d4556a56.jpg","mid":7924398,"name":"偏执的-Rin"},"playurl":"http://live-play.acgvideo.com/live/641/live_7924398_7544856.flv?wsSecret=e4c8793c6b7f1eccc38690668376f55a&wsTime=57bbe0c1","room_id":91072,"title":"每日稳定0颜料"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/08d315cce66dcd76a97ac7ea83bd9a61393c0f1b.jpg","width":320},"is_tv":0,"online":16,"owner":{"face":"http://i1.hdslb.com/bfs/face/7b6f74b9a602c701ff1198689cc2ef07cbea4f91.jpg","mid":2034937,"name":"素手可卿"},"playurl":"http://live-play.acgvideo.com/live/220/live_2034937_7622380.flv?wsSecret=61a2b53c4b9baaf6976c346f1f6cb993&wsTime=57bbe0c1","room_id":130006,"title":"【废卿】金木（录播）等我下课！"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/f87c4cce29e805bb4bd3af969365550b33cae496.jpg","width":320},"is_tv":0,"online":22,"owner":{"face":"http://i1.hdslb.com/bfs/face/61c02b51d97b386bdc86da7b98e2d626db2329e1.jpg","mid":3059987,"name":"末代代"},"playurl":"http://live-play.acgvideo.com/live/364/live_3059987_5624627.flv?wsSecret=92c2bd22d022d893cf73dd0d59630e09&wsTime=57bbe0c1","room_id":541825,"title":"鼠绘个阴阳师小蝴蝶"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/546286876711f3294be4e35976b2e622259e0809.jpg","width":320},"is_tv":0,"online":42,"owner":{"face":"http://i0.hdslb.com/bfs/face/6ea7861deb566895e2e15427633bc6f8aa7bebf5.gif","mid":32435588,"name":"漫画佬"},"playurl":"http://live-play.acgvideo.com/live/954/live_32435588_6457114.flv?wsSecret=d0ae530f55cb3dcb20d3fd48112358a8&wsTime=57bbe0c1","room_id":281759,"title":"画速写之类的直播"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/deb4ab91d1cda7d6d429347bbb489ea9fda81e62.jpg","width":320},"is_tv":0,"online":61,"owner":{"face":"http://i0.hdslb.com/bfs/face/605a8053956dd478f544ca8323ee4fa2854bc5cc.jpg","mid":31678446,"name":"大角虫漫画"},"playurl":"http://live-play.acgvideo.com/live/439/live_31678446_8654583.flv?wsSecret=1326ea8139a71834a6c6c40ca385f60a&wsTime=57bbe0c1","room_id":306289,"title":"《星星不是发光体》漫画赶稿现场"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/9a374d17174163473e952fac7fdc4dbc232efdfc.jpg","width":320},"is_tv":0,"online":1544,"owner":{"face":"http://i1.hdslb.com/bfs/face/624ad2b0cbabda6ce8b76bda36070aa8da94320c.jpg","mid":1734000,"name":"雷七郎"},"playurl":"http://live-play.acgvideo.com/live/743/live_1734000_6030375.flv?wsSecret=345d875ab893d8082be1205fdd98c966&wsTime=57bbe0c1","room_id":76650,"title":"( ´_ゝ｀)=3"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/ff3c33bbbfe4a1c905519c300112138c1468bcf0.jpg","width":320},"is_tv":0,"online":201,"owner":{"face":"http://i1.hdslb.com/bfs/face/6ee91036fcb7943769450de81d62caeae5248b71.jpg","mid":31034263,"name":"穆逢春"},"playurl":"http://live-play.acgvideo.com/live/829/live_31034263_8416467.flv?wsSecret=397dc82a82d7b6c1fbc332bd10284e02&wsTime=57bbe0c1","room_id":258940,"title":"斗罗大陆167画线稿绘制"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/92e5a8a2424474ab8753cabe0d8ea871656a1b47.jpg","width":320},"is_tv":0,"online":476,"owner":{"face":"http://i2.hdslb.com/bfs/face/04a10eb6a518a427e26f6a9dcf4032cad4d2ce52.jpg","mid":32042621,"name":"H努力赶稿中"},"playurl":"http://live-play.acgvideo.com/live/328/live_32042621_4809257.flv?wsSecret=80fe369d3475a8e1cbc1300706c26771&wsTime=57bbe0c1","room_id":300701,"title":"能多睡绝不少睡能少画绝不多画！"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/8c6ec4447f44f61fb3ed022810fd9ef7151e87d1.jpg","width":320},"is_tv":0,"online":12,"owner":{"face":"http://i2.hdslb.com/bfs/face/95ac61348425d9dbdaa21d0488632444d50d6716.jpg","mid":6130142,"name":"-戊子"},"playurl":"http://live-play.acgvideo.com/live/567/live_6130142_5126999.flv?wsSecret=8be8e27414de03b6694d4f99ca25f7e4&wsTime=57bbe0c1","room_id":30670,"title":"仗露进行中"},{"accept_quality":"4","area":"绘画专区","area_id":9,"broadcast_type":0,"check_version":0,"cover":{"height":180,"src":"http://i0.hdslb.com/bfs/live/1910b99416ca635fdbfa21ec5fa858ff1e279e2f.jpg","width":320},"is_tv":0,"online":29,"owner":{"face":"http://i1.hdslb.com/bfs/face/098f22ba83aa1def26d6dd2ffe5f493b83e7f103.jpg","mid":2106554,"name":"LQK凊佳"},"playurl":"http://live-play.acgvideo.com/live/860/live_2106554_5373450.flv?wsSecret=72081349380e0d20ae72af5449291b08&wsTime=57bbe0c1","room_id":32253,"title":"画一只洛天依~"}]
     * partition : {"area":"draw","count":61,"id":9,"name":"绘画专区","sub_icon":{"height":"63","src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?2016092201","width":"63"}}
     */

    private List<LiveStream> partitions;

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<EntranceIconsBean> getEntranceIcons() {
        return entranceIcons;
    }

    public void setEntranceIcons(List<EntranceIconsBean> entranceIcons) {
        this.entranceIcons = entranceIcons;
    }

    public List<LiveStream> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<LiveStream> partitions) {
        this.partitions = partitions;
    }

    public static class BannerBean implements Parcelable {
        private String img;
        private String link;
        private String remark;
        private String title;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.img);
            dest.writeString(this.link);
            dest.writeString(this.remark);
            dest.writeString(this.title);
        }

        public BannerBean() {
        }

        protected BannerBean(Parcel in) {
            this.img = in.readString();
            this.link = in.readString();
            this.remark = in.readString();
            this.title = in.readString();
        }

        public static final Parcelable.Creator<BannerBean> CREATOR = new Parcelable.Creator<BannerBean>() {
            @Override
            public BannerBean createFromParcel(Parcel source) {
                return new BannerBean(source);
            }

            @Override
            public BannerBean[] newArray(int size) {
                return new BannerBean[size];
            }
        };
    }

    public static class EntranceIconsBean implements Parcelable {
        /**
         * height : 132
         * src : http://static.hdslb.com/live-static/images/mobile/android/big/xxhdpi/11_big.png?2016092201
         * width : 132
         */

        private EntranceIconBean entrance_icon;
        private int id;
        private String name;

        public EntranceIconBean getEntrance_icon() {
            return entrance_icon;
        }

        public void setEntrance_icon(EntranceIconBean entrance_icon) {
            this.entrance_icon = entrance_icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static class EntranceIconBean implements Parcelable {
            private String height;
            private String src;
            private String width;

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.height);
                dest.writeString(this.src);
                dest.writeString(this.width);
            }

            public EntranceIconBean() {
            }

            protected EntranceIconBean(Parcel in) {
                this.height = in.readString();
                this.src = in.readString();
                this.width = in.readString();
            }

            public static final Parcelable.Creator<EntranceIconBean> CREATOR = new Parcelable.Creator<EntranceIconBean>() {
                @Override
                public EntranceIconBean createFromParcel(Parcel source) {
                    return new EntranceIconBean(source);
                }

                @Override
                public EntranceIconBean[] newArray(int size) {
                    return new EntranceIconBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.entrance_icon, flags);
            dest.writeInt(this.id);
            dest.writeString(this.name);
        }

        public EntranceIconsBean() {
        }

        protected EntranceIconsBean(Parcel in) {
            this.entrance_icon = in.readParcelable(EntranceIconBean.class.getClassLoader());
            this.id = in.readInt();
            this.name = in.readString();
        }

        public static final Parcelable.Creator<EntranceIconsBean> CREATOR = new Parcelable.Creator<EntranceIconsBean>() {
            @Override
            public EntranceIconsBean createFromParcel(Parcel source) {
                return new EntranceIconsBean(source);
            }

            @Override
            public EntranceIconsBean[] newArray(int size) {
                return new EntranceIconsBean[size];
            }
        };
    }

    public static class LiveStream {
        /**
         * area : draw
         * count : 61
         * id : 9
         * name : 绘画专区
         * sub_icon : {"height":"63","src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?2016092201","width":"63"}
         */

        private PartitionBean partition;
        /**
         * accept_quality : 4
         * area : 绘画专区
         * area_id : 9
         * broadcast_type : 0
         * check_version : 0
         * cover : {"height":180,"src":"http://i0.hdslb.com/bfs/live/f9ff96370365221bcf70d908c9711ff7991399d0.jpg","width":320}
         * is_tv : 0
         * online : 383
         * owner : {"face":"http://i0.hdslb.com/bfs/face/9c39b75a9dcf79fe3135934e9ad049a47edb03cf.jpg","mid":16159326,"name":"后雨大叔"}
         * playurl : http://live-play.acgvideo.com/live/392/live_16159326_5264177.flv?wsSecret=b4692e0e6d300c4e1f191c6e90d2312a&wsTime=57bbe0c1
         * room_id : 55755
         * title : 耽美条漫中【】
         */

        private List<LivesBean> lives;
        /**
         * accept_quality : 4
         * area : 放映厅
         * area_id : 7
         * broadcast_type : 0
         * check_version : 0
         * cover : {"height":180,"src":"http://i0.hdslb.com/bfs/live/98c268f907705241a3e3face25ae365e3120406b.png","width":320}
         * is_tv : 0
         * online : 18061
         * owner : {"face":"http://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","mid":11153765,"name":"哔哩哔哩音乐台"}
         * playurl : http://yf.live-play.acgvideo.com/live-yf/494940/live_11153765_9369560.flv?wsSecret=602867055c2648b19a17a949f3f0b48e&wsTime=1474520901
         * room_id : 23058
         * title : 【官方】哔哩哔哩官方音乐台
         */

        private List<BannerDataBean> banner_data;


        public PartitionBean getPartition() {
            return partition;
        }

        public void setPartition(PartitionBean partition) {
            this.partition = partition;
        }

        public List<LivesBean> getLives() {
            return lives;
        }

        public void setLives(List<LivesBean> lives) {
            this.lives = lives;
        }

        public List<BannerDataBean> getBanner_data() {
            return banner_data;
        }

        public void setBanner_data(List<BannerDataBean> banner_data) {
            this.banner_data = banner_data;
        }

        public static class PartitionBean implements Parcelable {
            private String area;
            private int count;
            private int id;
            private String name;
            /**
             * height : 63
             * src : http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/9.png?2016092201
             * width : 63
             */

            private SubIconBean sub_icon;

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public SubIconBean getSub_icon() {
                return sub_icon;
            }

            public void setSub_icon(SubIconBean sub_icon) {
                this.sub_icon = sub_icon;
            }

            public static class SubIconBean implements Parcelable {
                private String height;
                private String src;
                private String width;

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.height);
                    dest.writeString(this.src);
                    dest.writeString(this.width);
                }

                public SubIconBean() {
                }

                protected SubIconBean(Parcel in) {
                    this.height = in.readString();
                    this.src = in.readString();
                    this.width = in.readString();
                }

                public static final Parcelable.Creator<SubIconBean> CREATOR = new Parcelable.Creator<SubIconBean>() {
                    @Override
                    public SubIconBean createFromParcel(Parcel source) {
                        return new SubIconBean(source);
                    }

                    @Override
                    public SubIconBean[] newArray(int size) {
                        return new SubIconBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.area);
                dest.writeInt(this.count);
                dest.writeInt(this.id);
                dest.writeString(this.name);
                dest.writeParcelable(this.sub_icon, flags);
            }

            public PartitionBean() {
            }

            protected PartitionBean(Parcel in) {
                this.area = in.readString();
                this.count = in.readInt();
                this.id = in.readInt();
                this.name = in.readString();
                this.sub_icon = in.readParcelable(SubIconBean.class.getClassLoader());
            }

            public static final Parcelable.Creator<PartitionBean> CREATOR = new Parcelable.Creator<PartitionBean>() {
                @Override
                public PartitionBean createFromParcel(Parcel source) {
                    return new PartitionBean(source);
                }

                @Override
                public PartitionBean[] newArray(int size) {
                    return new PartitionBean[size];
                }
            };
        }

        public static class LivesBean implements Parcelable {
            private String accept_quality;
            private String area;
            private int area_id;
            private int broadcast_type;
            private int check_version;
            /**
             * height : 180
             * src : http://i0.hdslb.com/bfs/live/f9ff96370365221bcf70d908c9711ff7991399d0.jpg
             * width : 320
             */

            private CoverBean cover;
            private int is_tv;
            private int online;
            /**
             * face : http://i0.hdslb.com/bfs/face/9c39b75a9dcf79fe3135934e9ad049a47edb03cf.jpg
             * mid : 16159326
             * name : 后雨大叔
             */

            private OwnerBean owner;
            private String playurl;
            private int room_id;
            private String title;

            public String getAccept_quality() {
                return accept_quality;
            }

            public void setAccept_quality(String accept_quality) {
                this.accept_quality = accept_quality;
            }

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

            public int getBroadcast_type() {
                return broadcast_type;
            }

            public void setBroadcast_type(int broadcast_type) {
                this.broadcast_type = broadcast_type;
            }

            public int getCheck_version() {
                return check_version;
            }

            public void setCheck_version(int check_version) {
                this.check_version = check_version;
            }

            public CoverBean getCover() {
                return cover;
            }

            public void setCover(CoverBean cover) {
                this.cover = cover;
            }

            public int getIs_tv() {
                return is_tv;
            }

            public void setIs_tv(int is_tv) {
                this.is_tv = is_tv;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public OwnerBean getOwner() {
                return owner;
            }

            public void setOwner(OwnerBean owner) {
                this.owner = owner;
            }

            public String getPlayurl() {
                return playurl;
            }

            public void setPlayurl(String playurl) {
                this.playurl = playurl;
            }

            public int getRoom_id() {
                return room_id;
            }

            public void setRoom_id(int room_id) {
                this.room_id = room_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public static class CoverBean implements Parcelable {
                private int height;
                private String src;
                private int width;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.height);
                    dest.writeString(this.src);
                    dest.writeInt(this.width);
                }

                public CoverBean() {
                }

                protected CoverBean(Parcel in) {
                    this.height = in.readInt();
                    this.src = in.readString();
                    this.width = in.readInt();
                }

                public static final Parcelable.Creator<CoverBean> CREATOR = new Parcelable.Creator<CoverBean>() {
                    @Override
                    public CoverBean createFromParcel(Parcel source) {
                        return new CoverBean(source);
                    }

                    @Override
                    public CoverBean[] newArray(int size) {
                        return new CoverBean[size];
                    }
                };
            }

            public static class OwnerBean implements Parcelable {
                private String face;
                private int mid;
                private String name;

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }

                public int getMid() {
                    return mid;
                }

                public void setMid(int mid) {
                    this.mid = mid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.face);
                    dest.writeInt(this.mid);
                    dest.writeString(this.name);
                }

                public OwnerBean() {
                }

                protected OwnerBean(Parcel in) {
                    this.face = in.readString();
                    this.mid = in.readInt();
                    this.name = in.readString();
                }

                public static final Parcelable.Creator<OwnerBean> CREATOR = new Parcelable.Creator<OwnerBean>() {
                    @Override
                    public OwnerBean createFromParcel(Parcel source) {
                        return new OwnerBean(source);
                    }

                    @Override
                    public OwnerBean[] newArray(int size) {
                        return new OwnerBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.accept_quality);
                dest.writeString(this.area);
                dest.writeInt(this.area_id);
                dest.writeInt(this.broadcast_type);
                dest.writeInt(this.check_version);
                dest.writeParcelable(this.cover, flags);
                dest.writeInt(this.is_tv);
                dest.writeInt(this.online);
                dest.writeParcelable(this.owner, flags);
                dest.writeString(this.playurl);
                dest.writeInt(this.room_id);
                dest.writeString(this.title);
            }

            public LivesBean() {
            }

            protected LivesBean(Parcel in) {
                this.accept_quality = in.readString();
                this.area = in.readString();
                this.area_id = in.readInt();
                this.broadcast_type = in.readInt();
                this.check_version = in.readInt();
                this.cover = in.readParcelable(CoverBean.class.getClassLoader());
                this.is_tv = in.readInt();
                this.online = in.readInt();
                this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
                this.playurl = in.readString();
                this.room_id = in.readInt();
                this.title = in.readString();
            }

            public static final Parcelable.Creator<LivesBean> CREATOR = new Parcelable.Creator<LivesBean>() {
                @Override
                public LivesBean createFromParcel(Parcel source) {
                    return new LivesBean(source);
                }

                @Override
                public LivesBean[] newArray(int size) {
                    return new LivesBean[size];
                }
            };
        }

        public static class BannerDataBean implements Parcelable {
            private String accept_quality;
            private String area;
            private int area_id;
            private int broadcast_type;
            private int check_version;
            /**
             * height : 180
             * src : http://i0.hdslb.com/bfs/live/98c268f907705241a3e3face25ae365e3120406b.png
             * width : 320
             */

            private CoverBean cover;
            private int is_tv;
            private int online;
            /**
             * face : http://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg
             * mid : 11153765
             * name : 哔哩哔哩音乐台
             */

            private OwnerBean owner;
            private String playurl;
            private int room_id;
            private String title;

            public String getAccept_quality() {
                return accept_quality;
            }

            public void setAccept_quality(String accept_quality) {
                this.accept_quality = accept_quality;
            }

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

            public int getBroadcast_type() {
                return broadcast_type;
            }

            public void setBroadcast_type(int broadcast_type) {
                this.broadcast_type = broadcast_type;
            }

            public int getCheck_version() {
                return check_version;
            }

            public void setCheck_version(int check_version) {
                this.check_version = check_version;
            }

            public CoverBean getCover() {
                return cover;
            }

            public void setCover(CoverBean cover) {
                this.cover = cover;
            }

            public int getIs_tv() {
                return is_tv;
            }

            public void setIs_tv(int is_tv) {
                this.is_tv = is_tv;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public OwnerBean getOwner() {
                return owner;
            }

            public void setOwner(OwnerBean owner) {
                this.owner = owner;
            }

            public String getPlayurl() {
                return playurl;
            }

            public void setPlayurl(String playurl) {
                this.playurl = playurl;
            }

            public int getRoom_id() {
                return room_id;
            }

            public void setRoom_id(int room_id) {
                this.room_id = room_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public static class CoverBean implements Parcelable {
                private int height;
                private String src;
                private int width;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.height);
                    dest.writeString(this.src);
                    dest.writeInt(this.width);
                }

                public CoverBean() {
                }

                protected CoverBean(Parcel in) {
                    this.height = in.readInt();
                    this.src = in.readString();
                    this.width = in.readInt();
                }

                public static final Parcelable.Creator<CoverBean> CREATOR = new Parcelable.Creator<CoverBean>() {
                    @Override
                    public CoverBean createFromParcel(Parcel source) {
                        return new CoverBean(source);
                    }

                    @Override
                    public CoverBean[] newArray(int size) {
                        return new CoverBean[size];
                    }
                };
            }

            public static class OwnerBean implements Parcelable {
                private String face;
                private int mid;
                private String name;

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }

                public int getMid() {
                    return mid;
                }

                public void setMid(int mid) {
                    this.mid = mid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.face);
                    dest.writeInt(this.mid);
                    dest.writeString(this.name);
                }

                public OwnerBean() {
                }

                protected OwnerBean(Parcel in) {
                    this.face = in.readString();
                    this.mid = in.readInt();
                    this.name = in.readString();
                }

                public static final Parcelable.Creator<OwnerBean> CREATOR = new Parcelable.Creator<OwnerBean>() {
                    @Override
                    public OwnerBean createFromParcel(Parcel source) {
                        return new OwnerBean(source);
                    }

                    @Override
                    public OwnerBean[] newArray(int size) {
                        return new OwnerBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.accept_quality);
                dest.writeString(this.area);
                dest.writeInt(this.area_id);
                dest.writeInt(this.broadcast_type);
                dest.writeInt(this.check_version);
                dest.writeParcelable(this.cover, flags);
                dest.writeInt(this.is_tv);
                dest.writeInt(this.online);
                dest.writeParcelable(this.owner, flags);
                dest.writeString(this.playurl);
                dest.writeInt(this.room_id);
                dest.writeString(this.title);
            }

            public BannerDataBean() {
            }

            protected BannerDataBean(Parcel in) {
                this.accept_quality = in.readString();
                this.area = in.readString();
                this.area_id = in.readInt();
                this.broadcast_type = in.readInt();
                this.check_version = in.readInt();
                this.cover = in.readParcelable(CoverBean.class.getClassLoader());
                this.is_tv = in.readInt();
                this.online = in.readInt();
                this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
                this.playurl = in.readString();
                this.room_id = in.readInt();
                this.title = in.readString();
            }

            public static final Parcelable.Creator<BannerDataBean> CREATOR = new Parcelable.Creator<BannerDataBean>() {
                @Override
                public BannerDataBean createFromParcel(Parcel source) {
                    return new BannerDataBean(source);
                }

                @Override
                public BannerDataBean[] newArray(int size) {
                    return new BannerDataBean[size];
                }
            };
        }
    }
}
