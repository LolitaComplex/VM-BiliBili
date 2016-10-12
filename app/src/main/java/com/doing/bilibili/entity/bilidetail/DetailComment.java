package com.doing.bilibili.entity.bilidetail;

import java.util.List;

/**
 * Created by Doing on 2016/10/11.
 *
 */
public class DetailComment {

    private List<HotsBean> hots;
    /**
     * acount : 322
     * count : 203
     * num : 1
     * size : 20
     */
    private PageBean page;

    private List<RepliesBean> replies;


    public List<RepliesBean> getReplies() {
        return replies;
    }

    public void setReplies(List<RepliesBean> replies) {
        this.replies = replies;
    }

    public List<HotsBean> getHots() {
        return hots;
    }

    public void setHots(List<HotsBean> hots) {
        this.hots = hots;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class RepliesBean {

        /**
         * action : 0
         * content : {"device":"","members":[],"message":"用金木封面必须要有金木？真是可笑","plat":1}
         * count : 0
         * ctime : 1476080952
         * floor : 209
         * like : 0
         * member : {"DisplayRank":"10000","avatar":"http://i0.hdslb.com/bfs/face/db8e254dc62849037173c081fd369b927e6047bc.jpg","level_info":{"current_exp":1532,"current_level":3,"current_min":1500,"next_exp":4500},"mid":"15230342","nameplate":{"condition":"","image":"","image_small":"","level":"","name":"","nid":0},"official_verify":{"desc":"","type":-1},"pendant":{"expire":0,"image":"","name":"","pid":0},"rank":"10000","sex":"女","sign":"职业100小时宗师dj 有谁开黑吗","uname":"看我收藏全是精品福利","vip":{"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}}
         * mid : 15230342
         * oid : 6561508
         * parent : 0
         * parent_str : 0
         * rcount : 0
         * replies : []
         * root : 0
         * root_str : 0
         * rpid : 151980576
         * rpid_str : 151980576
         * state : 0
         * type : 1
         */

        private int action;
        /**
         * device :
         * members : []
         * message : 用金木封面必须要有金木？真是可笑
         * plat : 1
         */

        private ContentBean content;
        private int count;
        private int ctime;
        private int floor;
        private int like;
        /**
         * DisplayRank : 10000
         * avatar : http://i0.hdslb.com/bfs/face/db8e254dc62849037173c081fd369b927e6047bc.jpg
         * level_info : {"current_exp":1532,"current_level":3,"current_min":1500,"next_exp":4500}
         * mid : 15230342
         * nameplate : {"condition":"","image":"","image_small":"","level":"","name":"","nid":0}
         * official_verify : {"desc":"","type":-1}
         * pendant : {"expire":0,"image":"","name":"","pid":0}
         * rank : 10000
         * sex : 女
         * sign : 职业100小时宗师dj 有谁开黑吗
         * uname : 看我收藏全是精品福利
         * vip : {"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}
         */

        private MemberBean member;
        private int mid;
        private int oid;
        private int parent;
        private String parent_str;
        private int rcount;
        private int root;
        private String root_str;
        private int rpid;
        private String rpid_str;
        private int state;
        private int type;
        private List<?> replies;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getOid() {
            return oid;
        }

        public void setOid(int oid) {
            this.oid = oid;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public String getParent_str() {
            return parent_str;
        }

        public void setParent_str(String parent_str) {
            this.parent_str = parent_str;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public int getRoot() {
            return root;
        }

        public void setRoot(int root) {
            this.root = root;
        }

        public String getRoot_str() {
            return root_str;
        }

        public void setRoot_str(String root_str) {
            this.root_str = root_str;
        }

        public int getRpid() {
            return rpid;
        }

        public void setRpid(int rpid) {
            this.rpid = rpid;
        }

        public String getRpid_str() {
            return rpid_str;
        }

        public void setRpid_str(String rpid_str) {
            this.rpid_str = rpid_str;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<?> getReplies() {
            return replies;
        }

        public void setReplies(List<?> replies) {
            this.replies = replies;
        }

        public static class ContentBean {
            private String device;
            private String message;
            private int plat;
            private List<?> members;

            public String getDevice() {
                return device;
            }

            public void setDevice(String device) {
                this.device = device;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public int getPlat() {
                return plat;
            }

            public void setPlat(int plat) {
                this.plat = plat;
            }

            public List<?> getMembers() {
                return members;
            }

            public void setMembers(List<?> members) {
                this.members = members;
            }
        }

        public static class MemberBean {
            private String DisplayRank;
            private String avatar;
            /**
             * current_exp : 1532
             * current_level : 3
             * current_min : 1500
             * next_exp : 4500
             */

            private LevelInfoBean level_info;
            private String mid;
            /**
             * condition :
             * image :
             * image_small :
             * level :
             * name :
             * nid : 0
             */

            private NameplateBean nameplate;
            /**
             * desc :
             * type : -1
             */

            private OfficialVerifyBean official_verify;
            /**
             * expire : 0
             * image :
             * name :
             * pid : 0
             */

            private PendantBean pendant;
            private String rank;
            private String sex;
            private String sign;
            private String uname;
            /**
             * accessStatus : 1
             * dueRemark :
             * vipDueDate : 0
             * vipStatus : 0
             * vipStatusWarn :
             * vipType : 0
             */

            private VipBean vip;

            public String getDisplayRank() {
                return DisplayRank;
            }

            public void setDisplayRank(String DisplayRank) {
                this.DisplayRank = DisplayRank;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public LevelInfoBean getLevel_info() {
                return level_info;
            }

            public void setLevel_info(LevelInfoBean level_info) {
                this.level_info = level_info;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public NameplateBean getNameplate() {
                return nameplate;
            }

            public void setNameplate(NameplateBean nameplate) {
                this.nameplate = nameplate;
            }

            public OfficialVerifyBean getOfficial_verify() {
                return official_verify;
            }

            public void setOfficial_verify(OfficialVerifyBean official_verify) {
                this.official_verify = official_verify;
            }

            public PendantBean getPendant() {
                return pendant;
            }

            public void setPendant(PendantBean pendant) {
                this.pendant = pendant;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public VipBean getVip() {
                return vip;
            }

            public void setVip(VipBean vip) {
                this.vip = vip;
            }

            public static class LevelInfoBean {
                private int current_exp;
                private int current_level;
                private int current_min;
                private int next_exp;

                public int getCurrent_exp() {
                    return current_exp;
                }

                public void setCurrent_exp(int current_exp) {
                    this.current_exp = current_exp;
                }

                public int getCurrent_level() {
                    return current_level;
                }

                public void setCurrent_level(int current_level) {
                    this.current_level = current_level;
                }

                public int getCurrent_min() {
                    return current_min;
                }

                public void setCurrent_min(int current_min) {
                    this.current_min = current_min;
                }

                public int getNext_exp() {
                    return next_exp;
                }

                public void setNext_exp(int next_exp) {
                    this.next_exp = next_exp;
                }
            }

            public static class NameplateBean {
                private String condition;
                private String image;
                private String image_small;
                private String level;
                private String name;
                private int nid;

                public String getCondition() {
                    return condition;
                }

                public void setCondition(String condition) {
                    this.condition = condition;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getImage_small() {
                    return image_small;
                }

                public void setImage_small(String image_small) {
                    this.image_small = image_small;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getNid() {
                    return nid;
                }

                public void setNid(int nid) {
                    this.nid = nid;
                }
            }

            public static class OfficialVerifyBean {
                private String desc;
                private int type;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public static class PendantBean {
                private int expire;
                private String image;
                private String name;
                private int pid;

                public int getExpire() {
                    return expire;
                }

                public void setExpire(int expire) {
                    this.expire = expire;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }
            }

            public static class VipBean {
                private int accessStatus;
                private String dueRemark;
                private String vipDueDate;
                private int vipStatus;
                private String vipStatusWarn;
                private int vipType;

                public int getAccessStatus() {
                    return accessStatus;
                }

                public void setAccessStatus(int accessStatus) {
                    this.accessStatus = accessStatus;
                }

                public String getDueRemark() {
                    return dueRemark;
                }

                public void setDueRemark(String dueRemark) {
                    this.dueRemark = dueRemark;
                }

                public String getVipDueDate() {
                    return vipDueDate;
                }

                public void setVipDueDate(String vipDueDate) {
                    this.vipDueDate = vipDueDate;
                }

                public int getVipStatus() {
                    return vipStatus;
                }

                public void setVipStatus(int vipStatus) {
                    this.vipStatus = vipStatus;
                }

                public String getVipStatusWarn() {
                    return vipStatusWarn;
                }

                public void setVipStatusWarn(String vipStatusWarn) {
                    this.vipStatusWarn = vipStatusWarn;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }
            }
        }
    }

    public static class PageBean {
        private int acount;
        private int count;
        private int num;
        private int size;

        public int getAcount() {
            return acount;
        }

        public void setAcount(int acount) {
            this.acount = acount;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    static class HotsBean {

        /**
         * action : 0
         * content : {"device":"","members":[],"message":"aasd","plat":1}
         * count : 25
         * ctime : 1475727326
         * floor : 14
         * like : 110
         * member : {"DisplayRank":"10000","avatar":"http://i1.hdslb.com/bfs/face/b5cf5c9f4ab4a314d9897c6d78e6f134c29cd785.jpg","level_info":{"current_exp":55143,"current_level":6,"current_min":28800,"next_exp":"-"},"mid":"2263616","nameplate":{"condition":"所有自制视频总播放数>=100万","image":"http://i2.hdslb.com/bfs/face/27a952195555e64508310e366b3e38bd4cd143fc.png","image_small":"http://i2.hdslb.com/bfs/face/0497be49e08357bf05bca56e33a0637a273a7610.png","level":"稀有勋章","name":"知名偶像","nid":8},"official_verify":{"desc":"","type":-1},"pendant":{"expire":0,"image":"","name":"","pid":0},"rank":"10000","sex":"男","sign":"杂食型UP/用mad讲述不同的故事，用杂谈讲述生活。","uname":"Mr小丧","vip":{"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}}
         * mid : 2263616
         * oid : 6561508
         * parent : 0
         * parent_str : 0
         * rcount : 25
         * replies : []
         * root : 0
         * root_str : 0
         * rpid : 150419153
         * rpid_str : 150419153
         * state : 0
         * type : 1
         */

        private int action;
        /**
         * device :
         * members : []
         * message : aasd
         * plat : 1
         */

        private ContentBean content;
        private int count;
        private int ctime;
        private int floor;
        private int like;
        /**
         * DisplayRank : 10000
         * avatar : http://i1.hdslb.com/bfs/face/b5cf5c9f4ab4a314d9897c6d78e6f134c29cd785.jpg
         * level_info : {"current_exp":55143,"current_level":6,"current_min":28800,"next_exp":"-"}
         * mid : 2263616
         * nameplate : {"condition":"所有自制视频总播放数>=100万","image":"http://i2.hdslb.com/bfs/face/27a952195555e64508310e366b3e38bd4cd143fc.png","image_small":"http://i2.hdslb.com/bfs/face/0497be49e08357bf05bca56e33a0637a273a7610.png","level":"稀有勋章","name":"知名偶像","nid":8}
         * official_verify : {"desc":"","type":-1}
         * pendant : {"expire":0,"image":"","name":"","pid":0}
         * rank : 10000
         * sex : 男
         * sign : 杂食型UP/用mad讲述不同的故事，用杂谈讲述生活。
         * uname : Mr小丧
         * vip : {"accessStatus":1,"dueRemark":"","vipDueDate":0,"vipStatus":0,"vipStatusWarn":"","vipType":0}
         */

        private MemberBean member;
        private int mid;
        private int oid;
        private int parent;
        private String parent_str;
        private int rcount;
        private int root;
        private String root_str;
        private int rpid;
        private String rpid_str;
        private int state;
        private int type;
        private List<?> replies;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getOid() {
            return oid;
        }

        public void setOid(int oid) {
            this.oid = oid;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public String getParent_str() {
            return parent_str;
        }

        public void setParent_str(String parent_str) {
            this.parent_str = parent_str;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public int getRoot() {
            return root;
        }

        public void setRoot(int root) {
            this.root = root;
        }

        public String getRoot_str() {
            return root_str;
        }

        public void setRoot_str(String root_str) {
            this.root_str = root_str;
        }

        public int getRpid() {
            return rpid;
        }

        public void setRpid(int rpid) {
            this.rpid = rpid;
        }

        public String getRpid_str() {
            return rpid_str;
        }

        public void setRpid_str(String rpid_str) {
            this.rpid_str = rpid_str;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<?> getReplies() {
            return replies;
        }

        public void setReplies(List<?> replies) {
            this.replies = replies;
        }

        public static class ContentBean {
            private String device;
            private String message;
            private int plat;
            private List<?> members;

            public String getDevice() {
                return device;
            }

            public void setDevice(String device) {
                this.device = device;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public int getPlat() {
                return plat;
            }

            public void setPlat(int plat) {
                this.plat = plat;
            }

            public List<?> getMembers() {
                return members;
            }

            public void setMembers(List<?> members) {
                this.members = members;
            }
        }

        public static class MemberBean {
            private String DisplayRank;
            private String avatar;
            /**
             * current_exp : 55143
             * current_level : 6
             * current_min : 28800
             * next_exp : -
             */

            private LevelInfoBean level_info;
            private String mid;
            /**
             * condition : 所有自制视频总播放数>=100万
             * image : http://i2.hdslb.com/bfs/face/27a952195555e64508310e366b3e38bd4cd143fc.png
             * image_small : http://i2.hdslb.com/bfs/face/0497be49e08357bf05bca56e33a0637a273a7610.png
             * level : 稀有勋章
             * name : 知名偶像
             * nid : 8
             */

            private NameplateBean nameplate;
            /**
             * desc :
             * type : -1
             */

            private OfficialVerifyBean official_verify;
            /**
             * expire : 0
             * image :
             * name :
             * pid : 0
             */

            private PendantBean pendant;
            private String rank;
            private String sex;
            private String sign;
            private String uname;
            /**
             * accessStatus : 1
             * dueRemark :
             * vipDueDate : 0
             * vipStatus : 0
             * vipStatusWarn :
             * vipType : 0
             */

            private VipBean vip;

            public String getDisplayRank() {
                return DisplayRank;
            }

            public void setDisplayRank(String DisplayRank) {
                this.DisplayRank = DisplayRank;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public LevelInfoBean getLevel_info() {
                return level_info;
            }

            public void setLevel_info(LevelInfoBean level_info) {
                this.level_info = level_info;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public NameplateBean getNameplate() {
                return nameplate;
            }

            public void setNameplate(NameplateBean nameplate) {
                this.nameplate = nameplate;
            }

            public OfficialVerifyBean getOfficial_verify() {
                return official_verify;
            }

            public void setOfficial_verify(OfficialVerifyBean official_verify) {
                this.official_verify = official_verify;
            }

            public PendantBean getPendant() {
                return pendant;
            }

            public void setPendant(PendantBean pendant) {
                this.pendant = pendant;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public VipBean getVip() {
                return vip;
            }

            public void setVip(VipBean vip) {
                this.vip = vip;
            }

            public static class LevelInfoBean {
                private int current_exp;
                private int current_level;
                private int current_min;
                private String next_exp;

                public int getCurrent_exp() {
                    return current_exp;
                }

                public void setCurrent_exp(int current_exp) {
                    this.current_exp = current_exp;
                }

                public int getCurrent_level() {
                    return current_level;
                }

                public void setCurrent_level(int current_level) {
                    this.current_level = current_level;
                }

                public int getCurrent_min() {
                    return current_min;
                }

                public void setCurrent_min(int current_min) {
                    this.current_min = current_min;
                }

                public String getNext_exp() {
                    return next_exp;
                }

                public void setNext_exp(String next_exp) {
                    this.next_exp = next_exp;
                }
            }

            public static class NameplateBean {
                private String condition;
                private String image;
                private String image_small;
                private String level;
                private String name;
                private int nid;

                public String getCondition() {
                    return condition;
                }

                public void setCondition(String condition) {
                    this.condition = condition;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getImage_small() {
                    return image_small;
                }

                public void setImage_small(String image_small) {
                    this.image_small = image_small;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getNid() {
                    return nid;
                }

                public void setNid(int nid) {
                    this.nid = nid;
                }
            }

            public static class OfficialVerifyBean {
                private String desc;
                private int type;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public static class PendantBean {
                private int expire;
                private String image;
                private String name;
                private int pid;

                public int getExpire() {
                    return expire;
                }

                public void setExpire(int expire) {
                    this.expire = expire;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }
            }

            public static class VipBean {
                private int accessStatus;
                private String dueRemark;
                private String vipDueDate;
                private int vipStatus;
                private String vipStatusWarn;
                private int vipType;

                public int getAccessStatus() {
                    return accessStatus;
                }

                public void setAccessStatus(int accessStatus) {
                    this.accessStatus = accessStatus;
                }

                public String getDueRemark() {
                    return dueRemark;
                }

                public void setDueRemark(String dueRemark) {
                    this.dueRemark = dueRemark;
                }

                public String getVipDueDate() {
                    return vipDueDate;
                }

                public void setVipDueDate(String vipDueDate) {
                    this.vipDueDate = vipDueDate;
                }

                public int getVipStatus() {
                    return vipStatus;
                }

                public void setVipStatus(int vipStatus) {
                    this.vipStatus = vipStatus;
                }

                public String getVipStatusWarn() {
                    return vipStatusWarn;
                }

                public void setVipStatusWarn(String vipStatusWarn) {
                    this.vipStatusWarn = vipStatusWarn;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }
            }
        }
    }
}