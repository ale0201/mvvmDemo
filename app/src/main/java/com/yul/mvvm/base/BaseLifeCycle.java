package com.yul.mvvm.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.Nullable;

public abstract class BaseLifeCycle<P extends BasePresenter> implements ILifeCycle {
    protected Context mContext;
    protected P mPresenter;

    public BaseLifeCycle(Context context) {
        this.mContext = context;
    }

    protected void addPresenter(P mPresenter) {
        if (mPresenter != null) {
            this.mPresenter = mPresenter;
        }
    }

    @Override
    public void onCreate(@Nullable LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(@Nullable LifecycleOwner owner) {

    }

    @Override
    public void onStart(@Nullable LifecycleOwner owner) {

    }

    @Override
    public void onResume(@Nullable LifecycleOwner owner) {

    }

    @Override
    public void onPause(@Nullable LifecycleOwner owner) {

    }

    @Override
    public void onStop(@Nullable LifecycleOwner owner) {

    }

    @Override
    public void onLifecycleChanged(@Nullable LifecycleOwner owner, @Nullable Lifecycle.Event event) {

    }
}
