package com.mt.b.mvp_dagger.mvp.view.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mt.b.mvp_dagger.mvp.presenter.base_presenter.AbstractPresenter;
import com.mt.b.mvp_dagger.mvp.view.AbstractView;

import java.lang.reflect.Field;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Author : ZSK
 * Date : 2019/5/29
 * Description :  作视图的关联，销毁、Dagger的注入
 */
public abstract class BaseActivity<T extends AbstractPresenter> extends AbstractSimpleActivity implements
        HasSupportFragmentInjector,
        AbstractView {

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        addStatueView();
    }

    protected void addStatueView() {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            //填充重叠的部分
            addMoreView();
        }
        addMoreView();
    }


    @Override
    protected void onViewCreate() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    /**
     * 添加一个和状态栏一样高度的view将toolbar顶下去
     */
    private void addMoreView() {
        //获取windowphone下的decorView
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        int count = decorView.getChildCount();
        //判断是否已经添加了statusBarView
        if (count > 0 && decorView.getChildAt(count - 1) instanceof TextView) {
            decorView.getChildAt(count - 1).setBackgroundColor(Color.parseColor("#8B1C21"));
        } else {
            //新建一个和状态栏高宽的view
            View statusView = createStatusBarView();
            decorView.addView(statusView);
        }
        ViewGroup rootView = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        //rootview不会为状态栏留出状态栏空间
        ViewCompat.setFitsSystemWindows(rootView, true);
        rootView.setClipToPadding(true);

    }

    /**
     * 创建一个与状态看一样高度的view
     *
     * @return 返回view
     */
    private View createStatusBarView() {
        // 绘制一个和状态栏一样高的矩形
        TextView statusBarView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight());
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(Color.parseColor("#8B1C21"));
        return statusBarView;
    }

    /**
     * 拿到状态栏的高度
     *
     * @return 返回高度
     */
    private int getStatusBarHeight() {
        Class c;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
