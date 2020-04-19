package com.verma.android.verma_ui.widget.ui.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.verma.android.verma_ui.R;

import androidx.annotation.Nullable;


public class ImageSupport {
    private final String TAG = this.getClass().getSimpleName();
    public static final String USER_AGENT = "Android Application";
    public static final String APP_AGENT = "Planet Money";
    private GlideUrl getGlideUrl(String pURL) {
        if(pURL == null){

            return null;
        }
        // String authString = USER_ID + ":" + PASSWORD;
        //String base64Auth = Base64.encodeToString(authString.getBytes(), Base64.DEFAULT);
        LazyHeaders authHeaders =
                new LazyHeaders.Builder()
                        //.setHeader("Authorization", "Basic " + base64Auth)
                        // .setHeader("Accept", "application/json")
                        // .setHeader("Content-Type", "application/json")
                        .setHeader("User-Agent", USER_AGENT)
                        .setHeader("APP-Agent", APP_AGENT)

                        .build();
        GlideUrl glideURL = new GlideUrl(pURL, authHeaders);
        Log.d(TAG, glideURL.toStringUrl());

        return glideURL;
    }
    public void setImageWithGlide(Context context, final String pURL, final ImageView pImageView) {
        GlideUrl glideURL = getGlideUrl(pURL);
        Glide.with(context)
                .load(glideURL)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.e("TAG", "Error loading image");
                        pImageView.setImageResource(R.drawable.ic_default_icon);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })


                .thumbnail(0.5f)
                .into(pImageView);
    }
}
