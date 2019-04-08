package com.yul.mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.yul.mvvm.api.BaseModel;
import com.yul.mvvm.api.BaseObserver;
import com.yul.mvvm.model.Data;
import com.yul.mvvm.model.ImageBean;

public class ImageViewModel extends ViewModel {
    protected MutableLiveData<Data<ImageBean.ImagesBean>> mutableLiveData;
    protected BaseModel baseModel;
    private int idx;

    public ImageViewModel() {
        mutableLiveData = new MutableLiveData<>();
        baseModel = new BaseModel();
    }

    public MutableLiveData<Data<ImageBean.ImagesBean>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void loadImage() {
        baseModel.getImage("js", idx, 1, new BaseObserver<ImageBean>() {
            @Override
            public void onSuccess(ImageBean data) {
                mutableLiveData.setValue(new Data(
                        data.getImages().get(0), null
                ));
            }

            @Override
            public void onError(String error) {
                mutableLiveData.setValue(new Data<ImageBean.ImagesBean>(
                        null, error
                ));
            }

            @Override
            public void onFinish() {

            }
        });
    }

    public void nextImage() {
        baseModel.getImage("js", ++idx, 1, new BaseObserver<ImageBean>() {
            @Override
            public void onSuccess(ImageBean data) {
                mutableLiveData.setValue(new Data<ImageBean.ImagesBean>(
                        data.getImages().get(0), null
                ));
            }

            @Override
            public void onError(String error) {
                mutableLiveData.setValue(new Data<ImageBean.ImagesBean>(
                        null, error
                ));
                idx--;
            }

            @Override
            public void onFinish() {

            }
        });
    }

    public void previousImage() {
        if (idx <= 0) {
            mutableLiveData.setValue(new Data<ImageBean.ImagesBean>(
                    null, "已经是第一个了"
            ));
            return;
        }
        baseModel.getImage("js", --idx, 1, new BaseObserver<ImageBean>() {
            @Override
            public void onSuccess(ImageBean data) {
                mutableLiveData.setValue(new Data<ImageBean.ImagesBean>(
                        data.getImages().get(0), null
                ));
            }

            @Override
            public void onError(String error) {
                mutableLiveData.setValue(new Data<ImageBean.ImagesBean>(
                        null, error
                ));
                idx++;
            }

            @Override
            public void onFinish() {

            }
        });
    }

}

