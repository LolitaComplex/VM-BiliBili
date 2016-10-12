package com.doing.bilibili.fragment.detail;

import com.doing.bilibili.R;
import com.doing.bilibili.baselib.base.BaseLoadingFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.utils.LogUtils;
import com.doing.bilibili.entity.bilidetail.DetailComment;
import com.doing.bilibili.net.RetrofitHelper;

import java.util.LinkedHashMap;
import java.util.Map;

import rx.Observable;

import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Key;
import static com.doing.bilibili.net.BiliNetUtils.RequestParams.Value;


/**
 * Created by Doing on 2016/10/11.
 *
 */
public class BiliDetailCommentFragment extends BaseLoadingFragment<DetailComment> {

    public static BiliDetailCommentFragment newInstance() {
        return new BiliDetailCommentFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bilidetail_comment;
    }

    @Override
    public void initViewWithData(DetailComment data) {
        LogUtils.e(TAG, data.toString());
    }

    @Override
    protected Observable<Response<DetailComment>> retrofitData() {
        return RetrofitHelper.getBiliDetailCommentData().getCommentApi(initCommentParams(6561508));
    }

    private Map<String, String> initCommentParams(int id) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put(Key.DEVICE, Value.DEVICE);
        params.put(Key.HWID, Value.HWID);
        params.put(Key.ULV, Value.ULV);
        params.put(Key.BUILD, Value.BUILD);
        params.put(Key.MOBI_APP, Value.MOBI_APP);
        params.put("oid", id + "");
        params.put(Key.PN, "1");
        params.put(Key.PS, "20");
        params.put(Key.SORT, "0");
        params.put(Key.TYPE, "1");
        return params;
    }
}
