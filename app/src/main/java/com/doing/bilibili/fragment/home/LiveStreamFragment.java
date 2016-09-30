package com.doing.bilibili.fragment.home;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

import com.doing.bilibili.R;
import com.doing.bilibili.adapter.HomeLiveStreamAdapter;
import com.doing.bilibili.baselib.adapter.recyclerview.HeaderAndFooterWrapper;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.entity.Response;
import com.doing.bilibili.baselib.utils.DensityUitls;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.livestream.HomeLiveStream;
import com.doing.bilibili.entity.livestream.LiveRecommendBean;
import com.doing.bilibili.net.BiliNetUtils;
import com.doing.bilibili.net.RetrofitHelper;
import com.doing.bilibili.net.api.HomeLiveStreamApi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func2;

import static com.doing.bilibili.net.BiliNetUtils.RequestParams.*;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public class LiveStreamFragment extends HomeRecyclerFragment<HomeLiveStream> implements View.OnClickListener {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.show();
    }

    public static BaseFragment newInstance() {
        return new LiveStreamFragment();
    }

    @Override
    public void initViewWithData(HomeLiveStream data) {
        //设置该页面已经加载成功数据
        setDataIsShowing(true);

        HomeLiveStreamAdapter adapter = new HomeLiveStreamAdapter(mContext, data.getPartitions());

        HeaderAndFooterWrapper wrapperAdapter = new HeaderAndFooterWrapper(adapter);

        List<String> imageUrlList = new ArrayList<>();
        for (HomeLiveStream.BannerBean bannerBean : data.getBanner()) {
            imageUrlList.add(bannerBean.getImg());
        }
        wrapperAdapter.addHeaderView(initBanner(imageUrlList));
        wrapperAdapter.addHeaderView(initHeaderView());
        wrapperAdapter.addFooterView(initFootView());

        mRecyclerView.setAdapter(wrapperAdapter);

        super.initViewWithData(data);
    }

    @Override
    protected Observable<Response<HomeLiveStream>> retrofitData() {
        HomeLiveStreamApi liveStreamData = RetrofitHelper.getHomeLiveStreamData();
        return Observable.zip(liveStreamData.getLiveStreamCommon(), liveStreamData.getLiveStreamRecommend(initRequestData()),
                new Func2<Response<HomeLiveStream>, Response<LiveRecommendBean>, Response<HomeLiveStream>>() {
                    @Override
                    public Response<HomeLiveStream> call(Response<HomeLiveStream> commonResponse,
                                                         Response<LiveRecommendBean> recommendResponse) {

                        List<HomeLiveStream.LiveStream> partitions = commonResponse.getData().getPartitions();

                        partitions.add(0, recommendResponse.getData().getRecommend_data());

                        return commonResponse;
                    }
                });
    }

    private Map<String, String> initRequestData() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(Key.DEVICE, Value.DEVICE);
        map.put(Key.HWID, Value.HWID);
        map.put(Key.APP_KEY, Value.APP_KEY);
        map.put(Key.MOBI_APP, Value.MOBI_APP);
        map.put(Key.PLATFORM, Value.PLATFORM);
        map.put(Key.SCALE, Value.SCREEN);

        String sign = BiliNetUtils.getSign(map);

        map.put(Key.SIGN, sign);
        return map;
    }

    //?_device=android&_hwid=9ec238cf481b1087&appkey=1d8b6e7d45233436&build=426003&
    // mobi_app=android&platform=android&scale=xxhdpi&sign=cb01cac6b427a7bbd4a96ba47a189e9f

    private View initHeaderView() {
        View inflate = UIUtils.inflate(R.layout.item_living_headeriew);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);

        inflate.findViewById(R.id.HomeLiving_attention).setOnClickListener(this);
        inflate.findViewById(R.id.HomeLiving_center).setOnClickListener(this);
        inflate.findViewById(R.id.HomeLiving_search).setOnClickListener(this);
        inflate.findViewById(R.id.HomeLiving_all_partion).setOnClickListener(this);

        inflate.setLayoutParams(layoutParams);

        return inflate;
    }

    private View initFootView() {
        Button button = new Button(mContext);
        ViewGroup.MarginLayoutParams  layoutParams = new ViewGroup.MarginLayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        int density = DensityUitls.dip2px(10);
        layoutParams.bottomMargin = density;
        layoutParams.leftMargin = density;
        layoutParams.rightMargin = density;

        button.setText("更多直播");
        button.setTextColor(UIUtils.getColor(R.color.gray));
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(layoutParams);
        button.setBackgroundResource(R.drawable.item_touch_bg);
        return button;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.HomeLiving_attention:
                ToastUtil.show(getString(R.string.attention_anchor));
                break;

            case R.id.HomeLiving_center:
                ToastUtil.show(getString(R.string.living_center));

                break;

            case R.id.HomeLiving_search:
                ToastUtil.show(getString(R.string.living_search));

                break;

            case R.id.HomeLiving_all_partion:
                ToastUtil.show(getString(R.string.all_partion));
                break;
        }
    }
}
