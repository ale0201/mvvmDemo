package com.yul.mvvm.lifecycler;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.yul.mvvm.base.BaseLifeCycle;


public class MainLifeCycle extends BaseLifeCycle {
    public MainLifeCycle(Context context) {
        super(context);
    }
    @Override
    public void onCreate(@Nullable LifecycleOwner owner) {
        Log.e("MainActivity", "onCreate");
    }
}
