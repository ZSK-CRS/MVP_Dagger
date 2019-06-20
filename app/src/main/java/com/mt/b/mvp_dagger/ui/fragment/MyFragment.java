package com.mt.b.mvp_dagger.ui.fragment;

import android.support.v4.app.Fragment;

import com.mt.b.mvp_dagger.R;
import com.mt.b.mvp_dagger.mvp.presenter.presenter_impl.MyFragmentPresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.MyFragmentContract;
import com.mt.b.mvp_dagger.mvp.view.fragment.BaseFragment;

/**
 * Author : ZSK
 * Date : 2019/5/30
 * Description :
 */
public class MyFragment extends BaseFragment<MyFragmentPresenter> implements MyFragmentContract.View{

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
}
