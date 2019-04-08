package com.yul.mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.yul.mvvm.api.BaseModel;
import com.yul.mvvm.api.BaseObserver;
import com.yul.mvvm.model.Data;
import com.yul.mvvm.model.ImageBean;

public class ImageViewModel extends ViewModel {
    private MutableLiveData<Data<ImageBean.ImagesBean>> mImage;
    private int idx;
    private BaseModel baseModel;

    public ImageViewModel() {
        mImage = new MutableLiveData<>();
        baseModel = new BaseModel();
        idx = 0;
    }

    public MutableLiveData<Data<ImageBean.ImagesBean>> getImage() {
        return mImage;
    }

    public void loadImage() {
        baseModel.getImage("js", idx, 1, new BaseObserver<ImageBean>() {
            @Override
            public void onSuccess(ImageBean data) {
                mImage.setValue(new Data(
                        data.getImages().get(0), null
                ));
            }

            @Override
            public void onError(String error) {
                mImage.setValue(new Data<ImageBean.ImagesBean>(
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
                mImage.setValue(new Data<ImageBean.ImagesBean>(
                        data.getImages().get(0), null
                ));
            }

            @Override
            public void onError(String error) {
                mImage.setValue(new Data<ImageBean.ImagesBean>(
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
            mImage.setValue(new Data<ImageBean.ImagesBean>(
                    null, "已经是第一个了"
            ));
            return;
        }
        baseModel.getImage("js", --idx, 1, new BaseObserver<ImageBean>() {
            @Override
            public void onSuccess(ImageBean data) {
                mImage.setValue(new Data<ImageBean.ImagesBean>(
                        data.getImages().get(0), null
                ));
            }

            @Override
            public void onError(String error) {
                mImage.setValue(new Data<ImageBean.ImagesBean>(
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

