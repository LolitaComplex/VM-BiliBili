package com.doing.bilibili.net;

/**
 * Created by Doing on 2016/10/12.
 *
 */
public enum ZoneConstant {
    综合排名(0),
    动画(1),
    AMD_AMV(24),
    MMD_3D(25);

    private int zone;

    ZoneConstant(int zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return zone+"";
    }

    /*
    *
    * zone：分区
        综合排名：0
        动画：1
        AMD·AMV：24
        MMD·3D：25
        原创·配音：47
        原创：48
        中配：49
        二次元鬼畜：26
        综合：27
        手书：50
        咨询：51
        杂谈：52
        其他：53
        音乐/舞蹈：3
        音乐视频：28
        OP/ED：54
        其他：55
        Vocaloid相关：30
        Vocaloid：56
        UTAU相关：57
        中文曲：58
        翻唱：31
        舞蹈：20
        演奏：59
        三次元音乐：29
        游戏：4
        游戏视频：17
        预告·演示：61
        其他：63
        游戏攻略·解说：18
        单机游戏：64
        网络游戏：65
        家用·掌机：66
        其他：67
        Mugen：19
        电子竞技：60
        赛事：68
        解说：69
        其它：70
        科学技术:36
        全球科技：39
        数码科技：95
        军事科技：96
        手机测评：97
        其它：98
        科普·人文：37
        BBC纪录片：99
        探索频道：100
        国家地理：101
        NHK：102
        TED演讲：103
        名校公开课：104
        教程·演示：105
        其它：107
        野生技术协会：40
        趣味短片·其它：108
        娱乐：5
        生活娱乐：21
        三次元鬼畜：22
        动物圈：75
        喵星人：77
        汪星人：78
        其它：79
        美食：76
        美食视频：80
        制作教程：81
        综艺：71
        影视：11
        连载剧集：15
        国产：110
        日剧：111
        美剧：112
        其它：113
        完结剧集：34
        国产：87
        日剧：88
        美剧：89
        其它：90
        电影：23
        预告·花絮：82
        电影：83
        微电影：85
        特摄·布袋：86
        特摄：91
        布袋戏：92
        动漫剧番：13
        连载动画：33
        完结动画：32
        剧场·OVA：94

        完整分区（感谢tiansh提供）：

        tid	name	link	parent
        1	动画	http://www.bilibili.com/video/douga.html	null
        3	音乐	http://www.bilibili.com/video/music.html	null
        4	游戏	http://www.bilibili.com/video/game.html	null
        5	娱乐	http://www.bilibili.com/video/ent.html	null
        9	意见留言簿	http://www.bilibili.complus/guestbook.php	null
        11	电视剧	http://www.bilibili.com/video/teleplay.html	null
        12	公告	http://www.bilibili.com/list.php?tid=	null
        13	番剧	http://www.bilibili.com/video/bangumi.html	null
        15	连载剧集	http://www.bilibili.com/video/soap-three-1.html	11
        16	flash游戏	http://www.bilibili.com/video/game-flash-1.html	116
        17	单机联机	http://www.bilibili.com/video/game-video-1.html	116
        18	游戏攻略·解说	http://www.bilibili.com/video/game-ctary-1.html	116
        19	Mugen	http://www.bilibili.com/video/game-mugen-1.html	116
        20	ACG相关舞蹈	http://www.bilibili.com/video/dance-1.html	129
        21	生活	http://www.bilibili.com/video/ent-life-1.html	5
        22	三次元鬼畜	http://www.bilibili.com/video/ent-Kichiku-1.html	119
        23	电影	http://www.bilibili.com/video/movie.html	null
        24	MAD·AMV	http://www.bilibili.com/video/douga-mad-1.html	1
        25	MMD·3D	http://www.bilibili.com/video/douga-mmd-1.html	1
        26	二次元鬼畜	http://www.bilibili.com/video/douga-kichiku-1.html	119
        27	综合	http://www.bilibili.com/video/douga-else-1.html	1
        28	同人音乐	http://www.bilibili.com/video/music-video-1.html	117
        29	三次元音乐	http://www.bilibili.com/video/music-coordinate-1.html	117
        30	VOCALOID·UTAU	http://www.bilibili.com/video/music-vocaloid-1.html	117
        31	翻唱	http://www.bilibili.com/video/music-Cover-1.html	117
        32	完结动画	http://www.bilibili.com/video/part-twoelement-1.html	13
        33	连载动画	http://www.bilibili.com/video/bangumi-two-1.html	13
        34	完结剧集	http://www.bilibili.com/video/tv-drama-1.html	11
        36	科技	http://www.bilibili.com/video/technology.html	null
        37	纪录片	http://www.bilibili.com/video/tech-popular-science-1.html	36
        39	演讲•公开课	http://www.bilibili.com/video/speech-course-1.html	36
        40	技术宅	http://www.bilibili.com/video/tech-otaku-1.html	122
        41	暂置区	http://www.bilibili.comvideo/index.html	12
        43	舞蹈MMD	http://www.bilibili.com/video/mmd-dance-1.html	25
        44	剧情MMD	http://www.bilibili.com/video/mmd-story-1.html	25
        45	原创模型	http://www.bilibili.com/video/mmd-original-1.html	25
        46	其他	http://www.bilibili.com/video/index.html	25
        47	动画短片	http://www.bilibili.com/video/douga-voice-1.html	1
        48	原创动画	http://www.bilibili.com/video/douga-voice-original-1.html	47
        49	ACG配音	http://www.bilibili.com/video/douga-voice-translate-1.html	27
        50	手书	http://www.bilibili.com/video/douga-else-handwriting-1.html	27
        51	资讯	http://www.bilibili.com/video/douga-else-information-1.html	13
        52	动漫杂谈	http://www.bilibili.com/video/douga-else-tattle-1.html	27
        53	其他	http://www.bilibili.com/video/douga-else-other-1.html	27
        54	OP/ED/OST	http://www.bilibili.com/video/music-oped-1.html	117
        55	其他	http://www.bilibili.com/video/music-video-other-1.html	28
        56	VOCALOID	http://www.bilibili.com/video/music-vocaloid-vocaloid-1.html	30
        57	UTAU	http://www.bilibili.com/video/music-vocaloid-utau-1.html	30
        58	VOCALOID中文曲	http://www.bilibili.com/video/music-vocaloid-chinese-1.html	30
        59	演奏	http://www.bilibili.com/video/music-perform-1.html	117
        60	电子竞技	http://www.bilibili.com/video/game-fight-1.html	116
        61	预告资讯	http://www.bilibili.com/video/game-presentation-1.html	17
        63	实况解说	http://www.bilibili.com/video/game-video-other-1.html	17
        64	游戏杂谈	http://www.bilibili.com/video/game-ctary-standalone-1.html	17
        65	网络游戏	http://www.bilibili.com/video/game-ctary-network-1.html	116
        66	游戏集锦	http://www.bilibili.com/video/game-ctary-handheld-1.html	17
        67	其他	http://www.bilibili.com/video/game-ctary-other-1.html	17
        68	电竞赛事	http://www.bilibili.com/video/game-fight-matches-1.html	60
        69	实况解说	http://www.bilibili.com/video/game-fight-explain-1.html	60
        70	游戏集锦	http://www.bilibili.com/video/game-fight-other-1.html	60
        71	综艺	http://www.bilibili.com/video/ent-variety-1.html	5
        72	运动	http://www.bilibili.com/video/ent-sports-1.html	21
        73	影视剪影	http://www.bilibili.com/video/ent-silhouette-1.html	128
        74	日常	http://www.bilibili.com/video/ent-life-other-1.html	21
        75	动物圈	http://www.bilibili.com/video/ent-animal-1.html	5
        76	美食圈	http://www.bilibili.com/video/ent-food-1.html	5
        77	喵星人	http://www.bilibili.com/video/ent-animal-cat-1.html	75
        78	汪星人	http://www.bilibili.com/video/ent-animal-dog-1.html	75
        79	其他	http://www.bilibili.com/video/ent-animal-other-1.html	75
        80	美食视频	http://www.bilibili.com/video/ent-food-video-1.html	76
        81	料理制作	http://www.bilibili.com/video/ent-food-course-1.html	76
        82	电影相关	http://www.bilibili.com/video/movie-presentation-1.html	23
        83	其他国家	http://www.bilibili.com/video/movie-movie-1.html	23
        85	短片	http://www.bilibili.com/video/tv-micromovie-1.html	23
        86	特摄·布袋	http://www.bilibili.com/video/tv-sfx-1.html	11
        87	国产	http://www.bilibili.com/video/tv-drama-cn-1.html	34
        88	日剧	http://www.bilibili.com/video/tv-drama-jp-1.html	34
        89	美剧	http://www.bilibili.com/video/tv-drama-us-1.html	34
        90	其他	http://www.bilibili.com/video/tv-drama-other-1.html	34
        91	特摄	http://www.bilibili.com/video/tv-sfx-sfx-1.html	86
        92	布袋戏	http://www.bilibili.com/video/tv-sfx-pili-1.html	86
        94	剧场版	http://www.bilibili.com/video/bangumi-ova-1.html	32
        95	数码	http://www.bilibili.com/video/tech-future-digital-1.html	36
        96	军事	http://www.bilibili.com/video/tech-future-military-1.html	36
        97	手机评测	http://www.bilibili.com/video/tech-future-mobile-1.html	95
        98	机械	http://www.bilibili.com/video/tech-future-other-1.html	36
        99	BBC纪录片	http://www.bilibili.com/video/tech-geo-bbc-1.html	37
        100	探索频道	http://www.bilibili.com/video/tech-geo-discovery-1.html	37
        101	国家地理	http://www.bilibili.com/video/tech-geo-national-1.html	37
        102	NHK	http://www.bilibili.com/video/tech-geo-nhk-1.html	37
        103	演讲	http://www.bilibili.com/video/speech-1.html	39
        104	公开课	http://www.bilibili.com/video/course-1.html	39
        105	演示	http://www.bilibili.com/video/tech-geo-course-1.html	122
        107	科技人文	http://www.bilibili.com/video/tech-humanity-1.html	124
        108	趣味短片	http://www.bilibili.com/video/tech-funvideo-1.html	124
        110	国产	http://www.bilibili.com/video/soap-three-cn-1.html	15
        111	日剧	http://www.bilibili.com/video/soap-three-jp-1.html	15
        112	美剧	http://www.bilibili.com/video/soap-three-us-1.html	15
        113	其他	http://www.bilibili.com/video/soap-three-oth-1.html	15
        114	国内综艺	http://www.bilibili.com/video/index.html	71
        115	国外综艺	http://www.bilibili.com/video/index.html	71
        116	游戏	http://www.bilibili.comvideo/index.html	12
        117	音乐	http://www.bilibili.comvideo/index.html	12
        118	其他	http://www.bilibili.comvideo/index.html	12
        119	鬼畜	http://www.bilibili.com/video/kichiku.html	null
        120	剧场版	http://www.bilibili.com/video/newbangumi-ova-1.html	33
        121	GMV	http://www.bilibili.com/video/gmv-1.html	116
        122	野生技术协会	http://www.bilibili.com/video/tech-wild-1.html	36
        123	手办模型	http://www.bilibili.com/video/figure-1.html	122
        124	趣味科普人文	http://www.bilibili.com/video/tech-fun-1.html	36
        125	其他	http://www.bilibili.com/video/tech-geo-other-1.html	37
        126	人力VOCALOID	http://www.bilibili.com/video/kichiku-manual_vocaloid-1.html	119
        127	教程演示	http://www.bilibili.com/video/kichiku-course-1.html	119
        128	电视剧相关	http://www.bilibili.com/video/tv-presentation-1.html	11
        129	舞蹈	http://www.bilibili.com/video/dance.html	null
        130	音乐选集	http://www.bilibili.com/video/music-collection-1.html	117
        131	Korea相关	http://www.bilibili.com/video/ent-korea-1.html	5
        132	Korea音乐舞蹈	http://www.bilibili.com/video/ent-korea-music-dance-1.html	131
        133	Korea综艺	http://www.bilibili.com/video/ent-korea-variety-1.html	131
        134	其他	http://www.bilibili.com/video/ent-korea-other-1.html	131
        135	活动	http://www.bilibili.com/video/video/activities.html	null
        136	音游	http://www.bilibili.com/video/music-game-1.html	116
        137	娱乐圈	http://www.bilibili.com/video/ent-circle-1.html	5
        138	搞笑	http://www.bilibili.com/video/ent_funny_1.html	5
        139	实况解说	http://www.bilibili.com/video/list__1.html	65
        140	游戏杂谈	http://www.bilibili.com/video/list__1.html	65
        141	游戏集锦	http://www.bilibili.com/video/list__1.html	65
        142	漫展	http://www.bilibili.com/video/list__1.html	21
        143	COSPLAY	http://www.bilibili.com/video/list__1.html	21
        144	综艺剪辑	http://www.bilibili.com/video/list__1.html	71
        145	欧美电影	http://www.bilibili.com/video/movie_west_1.html	23
        146	日本电影	http://www.bilibili.com/video/movie_japan_1.html	23
        147	国产电影	http://www.bilibili.com/video/movie_chinese_1.html	23
        148	TV动画	http://www.bilibili.com/video/list__1.html	33
        149	OVA·OAD	http://www.bilibili.com/video/list__1.html	33
        150	TV动画	http://www.bilibili.com/video/list__1.html	32
        151	OVA·OAD	http://www.bilibili.com/video/list__1.html	32
        152	官方延伸	http://www.bilibili.com/video/bagumi_offical_1.html	13
        153	国产动画	http://www.bilibili.com/video/bangumi_chinese_1.html	13
        154	三次元舞蹈	http://www.bilibili.com/video/three-dimension-dance-1.html
    * */
}