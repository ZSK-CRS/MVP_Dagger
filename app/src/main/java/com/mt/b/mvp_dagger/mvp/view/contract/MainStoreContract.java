package com.mt.b.mvp_dagger.mvp.view.contract;

import com.mt.b.mvp_dagger.mvp.presenter.base_presenter.AbstractPresenter;
import com.mt.b.mvp_dagger.mvp.view.AbstractView;

import java.util.Map;

/**
 * Author : ZSK
 * Date : 2019/6/5
 * Description :
 */
public interface MainStoreContract {

    interface View extends AbstractView {
        void showRequestData(String data);
    }

    interface Presenter extends AbstractPresenter<MainStoreContract.View> {

        void getBaseMessage(Map<String, String> params);
    }
}
