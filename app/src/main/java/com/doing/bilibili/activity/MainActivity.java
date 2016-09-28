package com.doing.bilibili.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.doing.bilibili.R;
import com.doing.bilibili.base.Altar;
import com.doing.bilibili.base.AppBaseActivity;
import com.doing.bilibili.base.RxBus;
import com.doing.bilibili.baselib.adapter.recyclerview.BaseViewHolder;
import com.doing.bilibili.baselib.base.BaseFragment;
import com.doing.bilibili.baselib.utils.ToastUtil;
import com.doing.bilibili.baselib.utils.UIUtils;
import com.doing.bilibili.entity.global.User;
import com.doing.bilibili.fragment.factory.NavigationFragmentFactory;
import static com.doing.bilibili.fragment.factory.NavigationFragmentFactory.createFragment;

import butterknife.BindView;
import rx.functions.Action0;
import rx.functions.Action1;

public class MainActivity extends AppBaseActivity implements MainActivityCallback, View.OnClickListener, View.OnTouchListener {

    @BindView(R.id.General_toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.MainActivity_drawer)
    protected DrawerLayout mDrawerLayout;

    @BindView(R.id.MainActivity_navigation)
    protected NavigationView mNavigationView;

    @BindView(R.id.General_tablayout)
    protected TabLayout mTabLayout;

    private BaseViewHolder mNvHeaderHolder;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        addFragment(R.id.General_content, createFragment(NavigationFragmentFactory.HOME), false);


        initNavigationHeaderView();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (handleNavigationItemSelected(item)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
                return false;
            }
        });
    }

    private void initNavigationHeaderView() {
        View headerView = mNavigationView.getHeaderView(0);

        mNvHeaderHolder = BaseViewHolder.createViewHolder(this, headerView);

        mNvHeaderHolder.setOnClickListener(R.id.NavigationHeader_ll_user, this);
        mNvHeaderHolder.setOnTouchListener(R.id.NavigationHeader_iv_bg, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.NavigationHeader_ll_user:
                action(new Action0() {
                    @Override
                    public void call() {

                    }
                });
                break;

            case R.id.NavigationHeader_iv_message:
                ToastUtil.show("登录后，信息可以查看了");

                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.NavigationHeader_iv_bg) {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_UP:
                    ((ImageView)v).setImageResource(R.drawable.ic_drawerbg_not_logined);
                    break;

                case MotionEvent.ACTION_DOWN:
                    ((ImageView)v).setImageResource(R.drawable.ic_drawerbg_logined);
                    break;
            }
        }

        return false;
    }

    private boolean handleNavigationItemSelected(MenuItem item) {
        final BaseFragment[] showFragment = new BaseFragment[1];
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.NavigationMenu_home:
                showFragment[0] = createFragment(NavigationFragmentFactory.HOME);
                ToastUtil.show("主页");
                break;
            case R.id.NavigationMenu_download:
                showFragment[0] = createFragment(NavigationFragmentFactory.APPLICATION_CACHE);
                ToastUtil.show("离线缓存");
                break;
            case R.id.NavigationMenu_collectoin:
                action(new Action0() {
                    @Override
                    public void call() {
                        showFragment[0] = createFragment(NavigationFragmentFactory.COLLECTION);
                    }
                });
                ToastUtil.show("我的收藏");
                break;
            case R.id.NavigationMenu_history:
                showFragment[0] = createFragment(NavigationFragmentFactory.HISTORY);
                ToastUtil.show("历史记录");
                break;
            case R.id.NavigationMenu_follow:
                action(new Action0() {
                    @Override
                    public void call() {
                        showFragment[0] = createFragment(NavigationFragmentFactory.FOLLOW_PEOPLE);
                    }
                });
                ToastUtil.show("关注的人");
                break;
            case R.id.NavigationMenu_wallet:
                action(new Action0() {
                    @Override
                    public void call() {
                        showFragment[0] = createFragment(NavigationFragmentFactory.WALLET);
                    }
                });
                ToastUtil.show("我的钱包");
                break;
            case R.id.NavigationMenu_style:
                showFragment[0] = createFragment(NavigationFragmentFactory.THEME_SELECT);
                ToastUtil.show("主题选择");
                break;
            case R.id.NavigationMenu_shop:
                ToastUtil.show("应用推荐");
                break;
            case R.id.NavigationMenu_setting:
                ToastUtil.show("设置与帮助");
                break;

            default:
                return false;
        }
        mNavigationView.setCheckedItem(itemId);

        if (showFragment[0] != null) {
            addFragment(R.id.General_content, showFragment[0], false);
        }
        return true;
    }

    @Override
    protected void initActionBar() {
        setSupportActionBar(mToolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        params.topMargin = UIUtils.getStatusBarHeight();
        mToolbar.setLayoutParams(params);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    public static void newInstance(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_game:
                ToastUtil.show("游戏");
                break;
            case R.id.action_download:
                ToastUtil.show("下载");
                break;
            case R.id.action_search:
                ToastUtil.show("搜索");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void subscirp() {
        mSubscription = RxBus.getDefault().toObservable(User.class)
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        mNvHeaderHolder.setVisible(
                                R.id.NavigationHeader_tv_notlogin, false);

                        mNvHeaderHolder.setVisible(
                                R.id.NavigationHeader_ll_user_info, true);

                        mNvHeaderHolder.setText(
                                R.id.NavigationHeader_tv_username, user.getNickname());

                        mNvHeaderHolder.setText(
                                R.id.NavigationHeader_tv_level, "LV" + user.getLevel());

                        mNvHeaderHolder.setText(
                                R.id.NavigationHeader_tv_type, user.getType());

                        mNvHeaderHolder.setText(
                                R.id.NavigationHeader_tv_coin, getString(R.string.default_uesr_coin)
                                        + user.getCoin());

                        mNvHeaderHolder.setVisible(R.id.NavigationHeader_iv_message, true);

                        mNvHeaderHolder.setOnClickListener(R.id.NavigationHeader_iv_message,
                                MainActivity.this);
                    }
                });
    }

    //================= 接口回调的方法 =======================
    @Override
    public void initTabLayout(ViewPager viewPager) {
        mTabLayout.setupWithViewPager(viewPager);
    }

}
