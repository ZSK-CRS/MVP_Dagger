package com.mt.b.mvp_dagger.ui.fragment;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mt.b.mvp_dagger.R;
import com.mt.b.mvp_dagger.mvp.presenter.presenter_impl.MyFragmentPresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.MyFragmentContract;
import com.mt.b.mvp_dagger.mvp.view.fragment.BaseFragment;

import butterknife.BindView;

/**
 * Author : ZSK
 * Date : 2019/5/30
 * Description :
 */
public class MyFragment extends BaseFragment<MyFragmentPresenter> implements MyFragmentContract.View{

    @BindView(R.id.fake_status_bar)
    View mFakeStatusBar;

    @Override
    public void showRequestData(String data) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}
