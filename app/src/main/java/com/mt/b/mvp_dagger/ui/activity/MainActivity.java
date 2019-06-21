package com.mt.b.mvp_dagger.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mt.b.mvp_dagger.R;
import com.mt.b.mvp_dagger.mvp.presenter.presenter_impl.MainPresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.MainContract;
import com.mt.b.mvp_dagger.mvp.view.activity.BaseActivity;
import com.mt.b.mvp_dagger.ui.fragment.HomeFragment;
import com.mt.b.mvp_dagger.ui.fragment.MainStoreFragment;
import com.mt.b.mvp_dagger.ui.fragment.MyFragment;
import com.mt.b.mvp_dagger.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.fragment)
    FrameLayout fragment;
    @BindView(R.id.main_tab_imgbt_first)
    ImageButton mainTabImgbtFirst;
    @BindView(R.id.main_tab_tv_first)
    TextView mainTabTvFirst;
    @BindView(R.id.main_tab_ll_first)
    LinearLayout mainTabLlFirst;
    @BindView(R.id.main_tab_imgbt_store)
    ImageButton mainTabImgbtStore;
    @BindView(R.id.main_tab_tv_store)
    TextView mainTabTvStore;
    @BindView(R.id.main_tab_ll_store)
    LinearLayout mainTabLlStore;
    @BindView(R.id.main_tab_imgbt_my)
    ImageButton mainTabImgbtMy;
    @BindView(R.id.main_tab_tv_my)
    TextView mainTabTvMy;
    @BindView(R.id.main_tab_ll_my)
    LinearLayout mainTabLlMy;
    private FragmentManager mFragmentManager;

    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    //对外提供跳转
    public static void actionTo(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initParams() {
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initData() {
        replacteFragment(0);
    }

    @OnClick({R.id.main_tab_imgbt_first, R.id.main_tab_tv_first, R.id.main_tab_ll_first,
            R.id.main_tab_imgbt_store, R.id.main_tab_tv_store, R.id.main_tab_ll_store,
            R.id.main_tab_imgbt_my, R.id.main_tab_tv_my, R.id.main_tab_ll_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_tab_imgbt_first:     //首页
            case R.id.main_tab_tv_first:
            case R.id.main_tab_ll_first:
                replacteFragment(0);
                break;
            case R.id.main_tab_imgbt_store:     //仓库管理
            case R.id.main_tab_tv_store:
            case R.id.main_tab_ll_store:
                replacteFragment(1);
                break;
            case R.id.main_tab_imgbt_my:      //我的
            case R.id.main_tab_tv_my:
            case R.id.main_tab_ll_my:
                replacteFragment(2);
                break;
        }
    }


    private void replacteFragment(int position) {
        FragmentTransaction mTransactionm = mFragmentManager.beginTransaction();
        Fragment fragment = null;
        resertSelectState();
        if (position == 0) {
            fragment = new HomeFragment();
            mainTabTvFirst.setSelected(true);
            mainTabImgbtFirst.setSelected(true);
        }
        if (position == 1) {
            fragment = new MainStoreFragment();
            mainTabImgbtStore.setSelected(true);
            mainTabTvStore.setSelected(true);
        }
        if (position == 2) {
            fragment = new MyFragment();
            mainTabImgbtMy.setSelected(true);
            mainTabTvMy.setSelected(true);
        }
        mTransactionm.replace(R.id.fragment,fragment);
        mTransactionm.commit();
    }

    private void resertSelectState() {
        mainTabTvFirst.setSelected(false);
        mainTabImgbtFirst.setSelected(false);
        mainTabImgbtStore.setSelected(false);
        mainTabTvStore.setSelected(false);
        mainTabImgbtMy.setSelected(false);
        mainTabTvMy.setSelected(false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 500);
        } else {
            finish();
            System.exit(0);
        }
    }

    //############################################  View ##############################################################
    @Override
    public void showRequestData(String data) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }


}
