package com.yul.mvvm;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BindingAdapter {
    @android.databinding.BindingAdapter("url")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
