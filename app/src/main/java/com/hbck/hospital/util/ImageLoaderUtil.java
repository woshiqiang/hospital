package com.hbck.hospital.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hbck.hospital.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.File;

public class ImageLoaderUtil {

    public static void display(Context context, String path, ImageView imageView) {
        if (imageView instanceof RoundedImageView) {
            RoundedImageView riv = (RoundedImageView) imageView;
            Glide.with(context)
                    .load(path)
                    .apply(RequestOptions.centerCropTransform())
                    .apply(RequestOptions.placeholderOf(R.mipmap.icon_default))
                    .apply(RequestOptions.errorOf(R.mipmap.icon_default))
                    .into(riv);
        } else {
            Glide.with(context)
                    .load(path)
                    .apply(RequestOptions.centerCropTransform())
                    .apply(RequestOptions.placeholderOf(R.mipmap.icon_default))
                    .apply(RequestOptions.errorOf(R.mipmap.icon_default))
                    .into(imageView);
        }

    }


    public static void display(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .apply(RequestOptions.centerCropTransform())
                .apply(RequestOptions.placeholderOf(R.mipmap.icon_default))
                .apply(RequestOptions.errorOf(R.mipmap.icon_default))
                .into(imageView);
    }

    public static void display(Context context, int resourceId, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(resourceId)
                .apply(RequestOptions.centerCropTransform())
                .apply(RequestOptions.placeholderOf(R.mipmap.icon_default))
                .apply(RequestOptions.errorOf(R.mipmap.icon_default))
                .into(imageView);
    }

    public static void display(Context context, String path, ImageView imageView,RequestOptions options) {
        Glide.with(imageView.getContext())
                .load(path)
                .apply(options)
                .into(imageView);
    }


}