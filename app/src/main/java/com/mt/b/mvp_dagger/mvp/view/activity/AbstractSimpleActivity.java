package com.mt.b.mvp_dagger.mvp.view.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mt.b.mvp_dagger.mvp.view.ActivityCollector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Author : ZSK
 * Date : 2019/5/29
 * Description :  Activity抽象类、做基本的资源绑定、模版模式
 */
public abstract class AbstractSimpleActivity extends SupportActivity {

    private Unbinder unBinder;
    protected AbstractSimpleActivity mActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unBinder = ButterKnife.bind(this);
        mActivity = this;
        ActivityCollector.getInstance().addActivity(this);
        setContentView(getLayoutId());
        onViewCreate();
        initParams();
        initToolbar();
        initData();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
    }

    //获取当前的Activity的布局
    protected abstract int getLayoutId();

    //视图创建
    protected abstract void onViewCreate();

    //初始化参数
    protected abstract void initParams();

    //初始化Toobar
    protected abstract void initToolbar();

    //初始化数据
    protected abstract void initData();

    //初始化监听事件
    protected void initListener(){};




}
