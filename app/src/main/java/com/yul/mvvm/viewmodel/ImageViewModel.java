package com.yul.mvvm.viewmodel;

import com.yul.mvvm.api.BaseObserver;
import com.yul.mvvm.base.BaseViewModel;
import com.yul.mvvm.model.Data;
import com.yul.mvvm.model.ImageBean;

public class ImageViewModel extends BaseViewModel<ImageBean.ImagesBean> {
    private int idx;

    public ImageViewModel() {
        super();
        idx = 0;
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

