package com.yul.mvvm.presenter;

import com.yul.mvvm.base.BasePresenter;
import com.yul.mvvm.viewmodel.ImageViewModel;

public class ImagePresenter extends BasePresenter<ImageViewModel> {

    public ImagePresenter(ImageViewModel viewModel) {
        super(viewModel);
    }

    public void loadImage() {
        mViewModel.loadImage();
    }

}
