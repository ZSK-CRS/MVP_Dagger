package com.mt.b.mvp_dagger.dagger.module;

import com.mt.b.mvp_dagger.ui.activity.MainActivity;
import com.mt.b.mvp_dagger.dagger.component.BaseActivityComponent;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Author : ZSK
 * Date : 2019/5/30
 * Description :
 */
@Module(subcomponents = BaseActivityComponent.class)
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivityInjector();

}
