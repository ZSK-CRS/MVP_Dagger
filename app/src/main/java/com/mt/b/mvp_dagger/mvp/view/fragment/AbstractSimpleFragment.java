package com.mt.b.mvp_dagger.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mt.b.mvp_dagger.R;
import com.mt.b.mvp_dagger.app.Constants;
import com.mt.b.mvp_dagger.utils.CommonUtils;
import com.mt.b.mvp_dagger.utils.ViewColor;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Author : ZSK
 * Date : 2019/5/30
 * Description :
 */
public abstract class AbstractSimpleFragment extends SupportFragment {

    private Unbinder unBinder;
    private long clickTime;
    public boolean isInnerFragment;
    private View mStatusBarView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, view);
        initView();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initData();
    }

    /**
     * 处理回退事件
     */
    @Override
    public boolean onBackPressedSupport() {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
        } else {
            if (isInnerFragment) {
                _mActivity.finish();
                return true;
            }
            long currentTime = System.currentTimeMillis();
            if ((currentTime - clickTime) > Constants.DOUBLE_INTERVAL_TIME) {
                CommonUtils.showSnackMessage(_mActivity, getString(R.string.double_click_exit_tint));
                clickTime = System.currentTimeMillis();
            } else {
                _mActivity.finish();
            }
        }
        return true;
    }


    protected void initView() {

    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
