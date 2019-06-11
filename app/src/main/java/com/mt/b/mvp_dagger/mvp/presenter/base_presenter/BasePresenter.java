package com.mt.b.mvp_dagger.mvp.presenter.base_presenter;

import com.mt.b.mvp_dagger.mvp.model.DataManager;
import com.mt.b.mvp_dagger.mvp.view.AbstractView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author : ZSK
 * Date : 2019/5/29
 * Description :
 */
public class BasePresenter<T extends AbstractView> implements AbstractPresenter<T> {

    protected T mView;

    public WeakReference<T> mViewRef;

    private CompositeDisposable compositeDisposable;
    private DataManager mDataManager;

    public BasePresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        this.mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public boolean isAttach() {
        return mViewRef != null && mViewRef.get() != null;
    }

    @Override
    public T getView() {
        if (isAttach()) {
            return mViewRef.get();
        }
        return null;
    }

    @Override
    public void addRxBindingSubscribe(Disposable disposable) {
        addSubscribe(disposable);
    }

    @Override
    public void setLoginStatus(boolean loginStatus) {
        mDataManager.setLoginStatus(loginStatus);
    }

    @Override
    public boolean getLoginStatus() {
        return mDataManager.getLoginStatus();
    }

    @Override
    public String getLoginAccount() {
        return mDataManager.getLoginAccount();
    }

    @Override
    public void setLoginAccount(String account) {
        mDataManager.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mDataManager.setLoginPassword(password);
    }

    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
