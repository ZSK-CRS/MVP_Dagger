package com.mt.b.mvp_dagger.mvp.model.helper;

import com.mt.b.mvp_dagger.db.UserMessage;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description :  数据库
 */
public interface DbHelper {

    //获取登录用户信息
    UserMessage getUserMessage();
}
