package com.mt.b.mvp_dagger.dagger.module;

import com.mt.b.mvp_dagger.app.MyApplication;
import com.mt.b.mvp_dagger.mvp.model.DataManager;
import com.mt.b.mvp_dagger.mvp.model.helper.DbHelper;
import com.mt.b.mvp_dagger.mvp.model.helper.HttpHelper;
import com.mt.b.mvp_dagger.mvp.model.helper.PreferenceHelper;
import com.mt.b.mvp_dagger.mvp.model.impl.DbHelperImpl;
import com.mt.b.mvp_dagger.mvp.model.impl.HttpHelperImpl;
import com.mt.b.mvp_dagger.mvp.model.impl.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Author : ZSK
 * Date : 2019/5/30
 * Description :  提供全局变量、MVP中的M层、
 */
@Module
public class AppModule {

    private MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        //之所以这种类型的不用new,是因为HttpHelperImpl的构造方法中使用了@Inject
        return httpHelperImpl;
    }

    @Provides
    @Singleton
    DbHelper provideDbHeler(DbHelperImpl realmHelper){
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(PreferenceHelperImpl preferenceHelper) {
        return preferenceHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferenceHelper) {
        //需要在如上提供这三者
        return new DataManager(httpHelper,dbHelper,preferenceHelper);
    }

}
