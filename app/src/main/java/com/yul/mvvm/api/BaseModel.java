package com.yul.mvvm.api;

import com.yul.mvvm.model.ImageBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BaseModel {
    public BaseModel() {}

    public void getImage(String format, int idx, int n, BaseObserver<ImageBean> observer) {
        ImageRepertory.getInstance().getService().getImage(format, idx, n)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
