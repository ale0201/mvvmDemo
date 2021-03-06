package com.yul.mvvm.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<L extends BaseLifeCycle, V extends ViewDataBinding, P extends BasePresenter>
        extends AppCompatActivity{
    protected Context mContext;
    protected L mLifeCycle;
    protected V dataBinding;
    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        dataBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        initView();
        getLifecycle().addObserver(mLifeCycle);
        mLifeCycle.addPresenter(mPresenter);
        startListenerData();
    }

    protected abstract void startListenerData();

    protected abstract void initView();

    protected abstract int getLayoutRes();
}
