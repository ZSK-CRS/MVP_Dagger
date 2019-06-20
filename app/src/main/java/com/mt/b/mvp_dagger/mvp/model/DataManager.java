package com.mt.b.mvp_dagger.mvp.model;

import com.mt.b.mvp_dagger.db.UserMessage;
import com.mt.b.mvp_dagger.mvp.model.helper.DbHelper;
import com.mt.b.mvp_dagger.mvp.model.helper.HttpHelper;
import com.mt.b.mvp_dagger.mvp.model.helper.PreferenceHelper;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description : 数据层：包含网络、数据库、share文件
 */
public class DataManager implements HttpHelper, DbHelper, PreferenceHelper {

    private HttpHelper mHttpHelper;    //网络层
    private DbHelper mDbHelper;    //数据库层
    private PreferenceHelper mPreferenceHelper;   //本地文件层

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferenceHelper = preferencesHelper;
    }

    @Override
    public UserMessage getUserMessage() {
        return mDbHelper.getUserMessage();
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferenceHelper.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mPreferenceHelper.setLoginPassword(password);
    }

    @Override
    public String getLoginAccount() {
        return mPreferenceHelper.getLoginAccount();
    }

    @Override
    public String getLoginPassword() {
        return mPreferenceHelper.getLoginPassword();
    }

    @Override
    public void setLoginStatus(boolean isLogin) {
        mPreferenceHelper.setLoginStatus(isLogin);
    }

    @Override
    public boolean getLoginStatus() {
        return mPreferenceHelper.getLoginStatus();
    }

    @Override
    public Observable<ResponseBody> login(String userName, String password) {
        return mHttpHelper.login(userName,password);
    }

    @Override
    public Observable<ResponseBody> getBaseMessage(Map<String, String> params) {
        return mHttpHelper.getBaseMessage(params);
    }

    @Override
    public Observable<ResponseBody> getMyFragmentMessage(Map<String, String> params) {
        return mHttpHelper.getMyFragmentMessage(params);
    }


}
