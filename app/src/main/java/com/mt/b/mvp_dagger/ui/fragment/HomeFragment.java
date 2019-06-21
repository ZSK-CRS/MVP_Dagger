package com.mt.b.mvp_dagger.ui.fragment;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mt.b.mvp_dagger.R;
import com.mt.b.mvp_dagger.mvp.presenter.presenter_impl.HomeFragmentPresenter;
import com.mt.b.mvp_dagger.mvp.view.contract.HomeFragmentContract;
import com.mt.b.mvp_dagger.mvp.view.fragment.BaseFragment;

import static android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;

/**
 * @Author : ZSK
 * @Date : 2019/6/20
 * @Description :
 */
public class HomeFragment extends BaseFragment<HomeFragmentPresenter> implements HomeFragmentContract.View {

    @Override
    public void showRequestData(String data) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | FLAG_TRANSLUCENT_STATUS;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    /*    ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.hide();*/
    }
}
