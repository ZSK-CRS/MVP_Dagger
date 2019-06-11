package com.mt.b.mvp_dagger.mvp.model.impl;

import com.mt.b.mvp_dagger.mvp.model.helper.HttpHelper;
import com.mt.b.mvp_dagger.mvp.model.network.RetrofitService;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description :
 */
public class HttpHelperImpl implements HttpHelper {

    private RetrofitService mRetrofitService;

    @Inject
    HttpHelperImpl(RetrofitService retrofitService) {
        mRetrofitService = retrofitService;
    }

    @Override
    public Observable<ResponseBody> login(String userName, String password) {
        return mRetrofitService.login(userName,password);
    }

    @Override
    public Observable<ResponseBody> getBaseMessage(Map<String, String> params) {
        return mRetrofitService.getBaseMessage(params);
    }
}
