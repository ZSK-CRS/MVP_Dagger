package com.mt.b.mvp_dagger.mvp.presenter.presenter_impl;

import com.mt.b.mvp_dagger.mvp.model.DataManager;
import com.mt.b.mvp_dagger.mvp.presenter.base_presenter.BasePresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.MyFragmentContract;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MyFragmentPresenter extends BasePresenter<MyFragmentContract.View> implements  MyFragmentContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public MyFragmentPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getBaseMessage(Map<String, String> params) {
        addSubscribe(mDataManager.getMyFragmentMessage(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        getView().showRequestData(responseBody.string());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showErrorMessage(throwable.getMessage());
                    }
                }));
    }
}
