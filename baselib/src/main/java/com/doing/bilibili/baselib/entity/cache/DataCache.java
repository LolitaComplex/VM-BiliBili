package com.doing.bilibili.baselib.entity.cache;

import com.doing.bilibili.baselib.utils.NetUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import java.util.Map;

/**
 * Created by Doing on 2016/11/21.
 *
 */
@Entity
public class DataCache {

    @Id
    private Long id;

    @NotNull
    private String url;
    private String argumentsMd5;
    private Date updateTiem;
    private String content;


    @Generated(hash = 1937961248)
    public DataCache(Long id, @NotNull String url, String argumentsMd5, Date updateTiem, String content) {
        this.id = id;
        this.url = url;
        this.argumentsMd5 = argumentsMd5;
        this.updateTiem = updateTiem;
        this.content = content;
    }

    @Generated(hash = 24611778)
    public DataCache() {
    }


    public DataCache(@NotNull String url, Map<String, String> params, String content) {
        this(null, url, NetUtils.md5(params.toString()), new Date(System.currentTimeMillis()), content);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArgumentsMd5() {
        return argumentsMd5;
    }

    public void setArgumentsMd5(String argumentsMd5) {
        this.argumentsMd5 = argumentsMd5;
    }

    public Date getUpdateTiem() {
        return updateTiem;
    }

    public void setUpdateTiem(Date updateTiem) {
        this.updateTiem = updateTiem;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFresh() {
        return System.currentTimeMillis() - updateTiem.getTime() <= 1000 * 60 * 3;
    }


}
