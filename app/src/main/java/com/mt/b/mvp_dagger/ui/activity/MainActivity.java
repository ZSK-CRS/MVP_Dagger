package com.mt.b.mvp_dagger.ui.activity;

import com.mt.b.mvp_dagger.R;
import com.mt.b.mvp_dagger.mvp.presenter.presenter_impl.MainPresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.MainContract;
import com.mt.b.mvp_dagger.mvp.view.activity.BaseActivity;
import com.mt.b.mvp_dagger.utils.ToastUtil;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initParams() {
        if (mPresenter == null) {
            ToastUtil.showToastShort("为空");
        } else {
            ToastUtil.showToastShort("不为空!");
        }
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void showRequestData(String data) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }
}
