package com.mt.b.mvp_dagger.mvp.presenter;

import com.mt.b.mvp_dagger.mvp.view.AbstractView;

import io.reactivex.disposables.Disposable;

/**
 * Author : ZSK
 * Date : 2019/5/29
 * Description :
 */
public class BasePresenter <T extends AbstractView> implements AbstractPresenter<T>{
    @Override
    public void attachView(T view) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void addRxBindingSubscribe(Disposable disposable) {

    }

    @Override
    public void setLoginStatus(boolean loginStatus) {

    }

    @Override
    public boolean getLoginStatus() {
        return false;
    }

    @Override
    public String getLoginAccount() {
        return null;
    }

    @Override
    public void setLoginAccount(String account) {

    }

    @Override
    public void setLoginPassword(String password) {

    }
}
