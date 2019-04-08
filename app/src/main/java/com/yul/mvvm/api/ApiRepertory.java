package com.yul.mvvm.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRepertory {
    private static ApiRepertory repertory;
    private static Retrofit mRetrofit;

    public ApiRepertory() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://cn.bing.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static ApiRepertory getInstance() {
        if (repertory == null) {
            repertory = new ApiRepertory();
        }
        return repertory;
    }

    public Service getService() {
        return mRetrofit.create(Service.class);
    }
}
