package com.mt.b.mvp_dagger.mvp.presenter.presenter_impl;

import com.mt.b.mvp_dagger.mvp.model.DataManager;
import com.mt.b.mvp_dagger.mvp.presenter.base_presenter.BasePresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.MainContract;
import com.mt.b.mvp_dagger.mvp.view.contract.MainStoreContract;

import java.util.Map;

import javax.inject.Inject;

public class MainStoreFragmentPresenter extends BasePresenter<MainStoreContract.View>
        implements MainStoreContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public MainStoreFragmentPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getBaseMessage(Map<String, String> params) {

    }

}
