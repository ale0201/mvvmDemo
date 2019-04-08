package com.yul.mvvm.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageRepertory {
    private static ImageRepertory repertory;
    private static Retrofit mRetrofit;

    public ImageRepertory() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://cn.bing.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static ImageRepertory getInstance() {
        if (repertory == null) {
            repertory = new ImageRepertory();
        }
        return repertory;
    }

    public Service getService() {
        return mRetrofit.create(Service.class);
    }
}
