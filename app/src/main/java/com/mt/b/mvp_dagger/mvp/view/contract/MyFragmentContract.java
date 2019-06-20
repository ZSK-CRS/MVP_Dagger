package com.mt.b.mvp_dagger.mvp.view.contract;

import com.mt.b.mvp_dagger.mvp.presenter.base_presenter.AbstractPresenter;
import com.mt.b.mvp_dagger.mvp.view.AbstractView;

import java.util.Map;

public interface MyFragmentContract {

    interface View extends AbstractView {
        void showRequestData(String data);
    }

    interface Presenter extends AbstractPresenter<View> {
        void getBaseMessage(Map<String, String> params);
    }
}
