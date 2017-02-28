package com.doing.bilibili.data.cache;

import com.doing.bilibili.baselib.base.BaseApplication;
import com.doing.bilibili.baselib.entity.cache.DataCache;
import com.doing.bilibili.baselib.entity.cache.DataCacheDao;
import com.doing.bilibili.baselib.utils.NetUtils;
import com.doing.bilibili.baselib.utils.UIUtils;

import org.greenrobot.greendao.rx.RxDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Doing on 2016/11/14.
 *
 */
public class CacheManager {

    private static DataCacheDao mDataCacheDao;

    public static CacheManager getInstance() {
        mDataCacheDao = ((BaseApplication) UIUtils.getContext()).getDaoSession().getDataCacheDao();
        return new CacheManager();
    }

    private List<String> database = new ArrayList<>();

    public boolean haveCache(String url, Map<String, String> params) {
        List<DataCache> list = mDataCacheDao.queryBuilder()
                .where(DataCacheDao.Properties.Url.eq(url),
                        DataCacheDao.Properties.ArgumentsMd5.eq(NetUtils.md5(params.toString())))
                .build()
                .list();

        if (list.size() != 0) {
            return true;
        } else {
            return false;
        }

    }

    public String getCache(String url, Map<String, String> params) {
        return mDataCacheDao.queryBuilder()
                .where(DataCacheDao.Properties.Url.eq(url),
                        DataCacheDao.Properties.ArgumentsMd5.eq(NetUtils.md5(params.toString())))
                .build()
                .list()
                .get(0)
                .getContent();
    }

    public void saveCache(String url, Map<String, String> params, String content) {
        boolean insertOrUpdate = mDataCacheDao.queryBuilder()
                .where(DataCacheDao.Properties.Url.eq(url),
                        DataCacheDao.Properties.ArgumentsMd5.eq(NetUtils.md5(params.toString())))
                .build()
                .list()
                .size() != 0;
        DataCache cache = new DataCache(url, params, content);
        if (insertOrUpdate) {
            mDataCacheDao.update(cache);
        } else {
            mDataCacheDao.insert(cache);
        }
    }

    public static void deleteAll() {
        mDataCacheDao = ((BaseApplication) UIUtils.getContext()).getDaoSession().getDataCacheDao();
        mDataCacheDao.deleteAll();
    }
}
