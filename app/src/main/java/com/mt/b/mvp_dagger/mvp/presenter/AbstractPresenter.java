package com.mt.b.mvp_dagger.mvp.presenter;

import com.mt.b.mvp_dagger.mvp.view.AbstractView;

import io.reactivex.disposables.Disposable;

/**
 * Author : ZSK
 * Date : 2019/5/29
 * Description :  Presenter 基类,这里可以定义公共的功能，比如说获取登录状态、白天黑夜模式等
 */
public interface AbstractPresenter<T extends AbstractView> {

    /**
     * 注入View
     *
     * @param view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();

    /**
     * Add rxBing subscribe manager
     *
     * @param disposable Disposable
     */
    void addRxBindingSubscribe(Disposable disposable);

    /**
     * 设置登录状态
     *
     * @param loginStatus login status
     */
    void setLoginStatus(boolean loginStatus);

    /**
     * 获取登录状态
     *
     * @return if is login status
     */
    boolean getLoginStatus();

    /**
     * 获取登录账号
     *
     * @return login account
     */
    String getLoginAccount();

    /**
     * 设置登录账号
     *
     * @param account account
     */
    void setLoginAccount(String account);

    /**
     * 设置登录密码
     *
     * @param password password
     */
    void setLoginPassword(String password);

}
