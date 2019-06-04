package com.mt.b.mvp_dagger.mvp.model.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.mt.b.mvp_dagger.db.gen.DaoMaster;
import com.mt.b.mvp_dagger.db.gen.UserMessageDao;

import org.greenrobot.greendao.database.Database;

/**
 * Author : ZSK
 * Date : 2019/4/22
 * Description :
 */
public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 数据库升级
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //操作数据库的更新 有几个表升级都可以传入到下面
        MigrationHelper.getInstance().migrate(db,UserMessageDao.class);

    }
}