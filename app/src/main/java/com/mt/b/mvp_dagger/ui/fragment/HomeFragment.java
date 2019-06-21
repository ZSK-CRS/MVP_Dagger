package com.mt.b.mvp_dagger.ui.fragment;

import com.mt.b.mvp_dagger.R;
import com.mt.b.mvp_dagger.mvp.presenter.presenter_impl.HomeFragmentPresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.HomeFragmentContract;
import com.mt.b.mvp_dagger.mvp.view.fragment.BaseFragment;

/**
 * @Author : ZSK
 * @Date : 2019/6/20
 * @Description :
 */
public class HomeFragment extends BaseFragment<HomeFragmentPresenter> implements HomeFragmentContract.View {

    @Override
    public void showRequestData(String data) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

    }
}
