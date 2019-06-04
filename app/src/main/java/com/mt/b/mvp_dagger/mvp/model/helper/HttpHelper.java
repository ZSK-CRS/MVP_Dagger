package com.mt.b.mvp_dagger.mvp.model.helper;


import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description :  网络请求
 */
public interface HttpHelper {

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    Observable<ResponseBody> login(String userName,String password);
}