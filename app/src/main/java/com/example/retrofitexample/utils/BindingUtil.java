package com.example.retrofitexample.utils;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BindingUtil {
    @BindingAdapter({"imageUrl", "imageDefault"})
    public static void showAvartar(ImageView imageView, String imageUrl, Drawable imageDefault){
        Glide.with(imageView.getContext())
                    .load(imageUrl)
                    .error(imageDefault)
                    .circleCrop()
                    .into(imageView);
    }

}
