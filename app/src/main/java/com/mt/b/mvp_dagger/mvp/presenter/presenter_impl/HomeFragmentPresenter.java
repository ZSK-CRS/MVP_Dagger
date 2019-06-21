package com.mt.b.mvp_dagger.mvp.presenter.presenter_impl;

import com.mt.b.mvp_dagger.mvp.model.DataManager;
import com.mt.b.mvp_dagger.mvp.presenter.base_presenter.BasePresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.HomeFragmentContract;

import java.util.Map;

import javax.inject.Inject;

/**
 * @Author : ZSK
 * @Date : 2019/6/20
 * @Description :
 */
public class HomeFragmentPresenter extends BasePresenter<HomeFragmentContract.View> implements HomeFragmentContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public HomeFragmentPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getBaseMessage(Map<String, String> params) {

    }
}
