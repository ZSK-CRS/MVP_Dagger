package com.mt.b.mvp_dagger.mvp.model.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.mt.b.mvp_dagger.app.Constants;
import com.mt.b.mvp_dagger.app.MyApplication;
import com.mt.b.mvp_dagger.mvp.model.helper.PreferenceHelper;

import javax.inject.Inject;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description :
 */
public class PreferenceHelperImpl implements PreferenceHelper {

    private SharedPreferences mPreferences;

    @Inject
    PreferenceHelperImpl() {
        mPreferences = MyApplication.getInstance().getSharedPreferences(Constants.SHARE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferences.edit().putString(Constants.ACCOUNT, account).apply();
    }

    @Override
    public void setLoginPassword(String password) {
        mPreferences.edit().putString(Constants.PASSWORD, password).apply();
    }

    @Override
    public String getLoginAccount() {
        return mPreferences.getString(Constants.ACCOUNT, "");
    }

    @Override
    public String getLoginPassword() {
        return mPreferences.getString(Constants.PASSWORD, "");
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferences.edit().putBoolean(Constants.LOGIN_STATUS, isLogin).apply();
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferences.getBoolean(Constants.LOGIN_STATUS, false);
    }
}
