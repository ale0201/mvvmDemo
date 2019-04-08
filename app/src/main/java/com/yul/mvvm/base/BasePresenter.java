package com.yul.mvvm.base;

import android.arch.lifecycle.ViewModel;

public abstract class BasePresenter<M extends ViewModel> {
    protected M mViewModel;

    public BasePresenter(M viewModel) {
        if (viewModel != null) {
            this.mViewModel = viewModel;
        }
    };
}
