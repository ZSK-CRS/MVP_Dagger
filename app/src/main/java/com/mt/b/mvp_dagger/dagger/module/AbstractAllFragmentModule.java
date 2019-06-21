package com.mt.b.mvp_dagger.dagger.module;

import com.mt.b.mvp_dagger.dagger.component.BaseFragmentComponent;
import com.mt.b.mvp_dagger.ui.fragment.HomeFragment;
import com.mt.b.mvp_dagger.ui.fragment.MainStoreFragment;
import com.mt.b.mvp_dagger.ui.fragment.MyFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Author : ZSK
 * Date : 2019/5/30
 * Description :
 */
@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AbstractAllFragmentModule {

    @ContributesAndroidInjector(modules = MyFragmentModule.class)
    abstract MyFragment contributesMyFragmentInject();

    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment contributesHomeFragmentInject();

    @ContributesAndroidInjector(modules = MainStoreFragmentModule.class)
    abstract MainStoreFragment contributesMainStoreFragmentInject();

}
