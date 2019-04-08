package com.yul.mvvm;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.yul.mvvm.base.BaseActivity;
import com.yul.mvvm.databinding.ActivityMainBinding;
import com.yul.mvvm.lifecycler.MainLifeCycle;
import com.yul.mvvm.model.Data;
import com.yul.mvvm.model.ImageBean;
import com.yul.mvvm.presenter.ImagePresenter;
import com.yul.mvvm.viewmodel.ImageViewModel;

public class MainActivity extends BaseActivity<MainLifeCycle, ActivityMainBinding, ImagePresenter> {
    private ProgressDialog mProgressDialog;
    private ImageViewModel baseViewModel;

    @Override
    protected void initView() {
        mLifeCycle = new MainLifeCycle(this);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("加载中");
        baseViewModel = new ViewModelProvider(
                this, new ViewModelProvider.AndroidViewModelFactory(getApplication())
        ).get(ImageViewModel.class);
        dataBinding.setPresenter(new ClickHandler());
        //将presener绑定生命周期
        mPresenter = new ImagePresenter(baseViewModel);
        mProgressDialog.show();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void startListenerData() {
        baseViewModel.getMutableLiveData().observe(this, new Observer<Data<ImageBean.ImagesBean>>() {
            @Override
            public void onChanged(@Nullable Data<ImageBean.ImagesBean> imagesBeanData) {
                if (imagesBeanData.getErrorMsg() != null) {
                    Toast.makeText(MainActivity.this, imagesBeanData.getErrorMsg(), Toast.LENGTH_SHORT).show();
                    mProgressDialog.dismiss();
                    return;
                }
                dataBinding.setImageBean(imagesBeanData.getData());
                setTitle(imagesBeanData.getData().getCopyright());
                mProgressDialog.dismiss();
            }
        });
    }

    public class ClickHandler {

        public void onClick(View view) {
            mProgressDialog.show();
            switch (view.getId()) {
                case R.id.btn_load:
                    baseViewModel.loadImage();
                    break;
                case R.id.btn_previous:
                    baseViewModel.previousImage();
                    break;
                case R.id.btn_next:
                    baseViewModel.nextImage();
                    break;
                default:
                    break;
            }
        }

    }
}
