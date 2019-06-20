package com.mt.b.mvp_dagger.mvp.view;

/**
 * Author : ZSK
 * Date : 2019/5/29
 * Description :  所有View的基类，用于定义公有的界面动作，如定义白天、黑夜模式等
 */
public interface AbstractView {

    void showErrorMessage(String errorMessage);     //显示错误信息
}
