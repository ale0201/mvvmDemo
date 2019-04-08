package com.yul.mvvm.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.yul.mvvm.api.BaseModel;
import com.yul.mvvm.model.Data;

public abstract class BaseViewModel<T> extends ViewModel {
    protected MutableLiveData<Data<T>> mutableLiveData;
    protected BaseModel baseModel;

    public BaseViewModel() {
        mutableLiveData = new MutableLiveData<>();
        baseModel = new BaseModel();
    }

    public MutableLiveData<Data<T>> getMutableLiveData() {
        return mutableLiveData;
    }

}
