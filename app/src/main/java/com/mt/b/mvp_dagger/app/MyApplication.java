package com.mt.b.mvp_dagger.app;

import android.app.Activity;
import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.mt.b.mvp_dagger.dagger.component.DaggerAppComponent;
import com.mt.b.mvp_dagger.dagger.module.AppModule;
import com.mt.b.mvp_dagger.dagger.module.HttpModule;
import com.mt.b.mvp_dagger.db.gen.DaoMaster;
import com.mt.b.mvp_dagger.db.gen.DaoSession;
import com.mt.b.mvp_dagger.utils.ToastUtil;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Author : ZSK
 * Date : 2019/5/29
 * Description :
 */
public class MyApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    private static MyApplication instance;


    public static synchronized MyApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .httpModule(new HttpModule())
                .build()
                .inject(this);
        ToastUtil.init(this);
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }
}
