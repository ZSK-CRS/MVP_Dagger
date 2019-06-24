package com.mt.b.mvp_dagger.ui.fragment;
import com.mt.b.mvp_dagger.R;
import com.mt.b.mvp_dagger.mvp.presenter.presenter_impl.MainStoreFragmentPresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.MainStoreContract;
import com.mt.b.mvp_dagger.mvp.view.fragment.BaseFragment;

public class MainStoreFragment extends BaseFragment<MainStoreFragmentPresenter> implements MainStoreContract.View {
    @Override
    public void showRequestData(String data) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_store;
    }

    @Override
    protected void initData() {

    }
}
