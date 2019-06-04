package com.mt.b.mvp_dagger.mvp.model.impl;

import com.mt.b.mvp_dagger.app.Constants;
import com.mt.b.mvp_dagger.app.MyApplication;
import com.mt.b.mvp_dagger.db.UserMessage;
import com.mt.b.mvp_dagger.db.gen.DaoMaster;
import com.mt.b.mvp_dagger.db.gen.DaoSession;
import com.mt.b.mvp_dagger.mvp.model.helper.DbHelper;
import com.mt.b.mvp_dagger.mvp.model.helper.MyOpenHelper;

import org.greenrobot.greendao.identityscope.IdentityScopeType;

import java.util.List;

import javax.inject.Inject;

/**
 * Author : ZSK
 * Date : 2019/6/3
 * Description :
 */
public class DbHelperImpl implements DbHelper {

    private DaoSession daoSession;

    @Inject
    DbHelperImpl() {
        //创建数据库
        MyOpenHelper helper = new MyOpenHelper(MyApplication.getInstance(), Constants.SQLITE_NAME,null);
        //创建可读写数据库
        //  mDaoMaster = new DaoMaster(helper.getEncryptedWritableDb("7334453"));
        DaoMaster mDaoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = mDaoMaster.newSession(IdentityScopeType.None);
    }

    @Override
    public UserMessage getUserMessage() {
        List<UserMessage> userMessages = daoSession.getUserMessageDao().queryBuilder().list();
        if (userMessages != null && userMessages.size() != 0) {
            return userMessages.get(0);
        }
        return null;
    }
}
