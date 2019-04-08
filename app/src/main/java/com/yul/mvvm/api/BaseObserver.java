package com.yul.mvvm.api;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    protected Disposable disposable;
    protected String errMsg = "";

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
//        if (!NetworkUtils.isConnected()) {
//            errMsg = "网络连接出错,";
//        } else if (e instanceof APIException) {
//            APIException exception = (APIException) e;
//            errMsg = exception.getMessage() + ", ";
//        } else if (e instanceof HttpException) {
//            errMsg = "网络请求出错,";
//        } else if (e instanceof IOException) {
//            errMsg = "网络出错,";
//        }
        onError(e.toString());
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void onComplete() {
        onFinish();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public abstract void onSuccess(T data);

    public abstract void onError(String error);

    public abstract void onFinish();
}
