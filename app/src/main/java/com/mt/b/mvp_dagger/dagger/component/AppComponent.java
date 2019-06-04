package com.mt.b.mvp_dagger.dagger.component;

import com.mt.b.mvp_dagger.app.MyApplication;
import com.mt.b.mvp_dagger.dagger.module.AbstractAllActivityModule;
import com.mt.b.mvp_dagger.dagger.module.AbstractAllFragmentModule;
import com.mt.b.mvp_dagger.dagger.module.AppModule;
import com.mt.b.mvp_dagger.dagger.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Author : ZSK
 * Date : 2019/5/29
 * Description :   整个项目的Component,在同一个Component中module是相互依赖的
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllFragmentModule.class,
        AbstractAllActivityModule.class,
        AppModule.class,
        HttpModule.class})
public interface AppComponent {

    //注入MyApplication实例
    void inject(MyApplication application);

}
