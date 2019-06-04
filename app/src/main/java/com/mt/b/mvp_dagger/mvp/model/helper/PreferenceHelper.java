package com.mt.b.mvp_dagger.mvp.model.helper;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description :
 */
public interface PreferenceHelper {

    //设置登录账号
    void setLoginAccount(String account);

    //设置登录密码
    void setLoginPassword(String password);

    //获取登录账号
    String getLoginAccount();

    //获取登录密码
    String getLoginPassword();

    //设置登录状态
    void setLoginStatus(boolean isLogin);

    //获取登录状态
    boolean getLoginStatus();

}
