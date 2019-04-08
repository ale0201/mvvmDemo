package com.yul.mvvm;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.yul.mvvm.databinding.ActivityMainBinding;
import com.yul.mvvm.model.Data;
import com.yul.mvvm.model.ImageBean;
import com.yul.mvvm.viewmodel.ImageViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private ImageViewModel mViewModel;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new ViewModelProvider(
                this, new ViewModelProvider.AndroidViewModelFactory(getApplication())
        ).get(ImageViewModel.class);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("加载中");

        mViewModel.getImage().observe(this, new Observer<Data<ImageBean.ImagesBean>>() {
            @Override
            public void onChanged(@Nullable Data<ImageBean.ImagesBean> imagesBeanData) {
                if (imagesBeanData.getErrorMsg() != null) {
                    Toast.makeText(MainActivity.this, imagesBeanData.getErrorMsg(), Toast.LENGTH_SHORT).show();
                    mProgressDialog.dismiss();
                    return;
                }
                mBinding.setImageBean(imagesBeanData.getData());
                setTitle(imagesBeanData.getData().getCopyright());
                mProgressDialog.dismiss();
            }
        });

        mBinding.setPresenter(new Presenter());

        mProgressDialog.show();
        mViewModel.loadImage();
    }

    public class Presenter {

        public void onClick(View view) {
            mProgressDialog.show();
            switch (view.getId()) {
                case R.id.btn_load:
                    mViewModel.loadImage();
                    break;
                case R.id.btn_previous:
                    mViewModel.previousImage();
                    break;
                case R.id.btn_next:
                    mViewModel.nextImage();
                    break;
                default:
                    break;
            }
        }

    }
}
