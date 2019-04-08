package com.yul.mvvm.lifecycler;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.yul.mvvm.base.BaseLifeCycle;
import com.yul.mvvm.presenter.ImagePresenter;


public class MainLifeCycle extends BaseLifeCycle<ImagePresenter> {
    public MainLifeCycle(Context context) {
        super(context);
    }

    @Override
    public void onStart(@Nullable LifecycleOwner owner) {
        Log.e("MainActivity", "onCreate");
        mPresenter.loadImage();
    }
}
