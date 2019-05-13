package com.example.lostincrowds.UI;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.DrawableRes;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lostincrowds.R;

public class BasicImgineView extends android.support.v7.widget.AppCompatImageView {
    private ImageView imageView;
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT ,
            LinearLayout.LayoutParams.WRAP_CONTENT);

    public BasicImgineView(Context context ) {
        super(context);
        setAdjustViewBounds(true);
        setLayoutParams(params);
        setMaxHeight(50);
        setMaxWidth(50);
    }
    private float x,y;

    public void setBasicImageView ( @DrawableRes int back , @DrawableRes int front,float x,float y) {
        Resources r = getResources();
        Bitmap backImage = ((BitmapDrawable) r.getDrawable(
                back)).getBitmap();
        Bitmap frontImage = ((BitmapDrawable) r.getDrawable(
                front)).getBitmap();
        ImageView imageView = new ImageView(this.getContext());

        Drawable[] layers = new Drawable[2];
        layers[0] = new BitmapDrawable(backImage);
        layers[1] = new BitmapDrawable(frontImage);
        LayerDrawable la = new LayerDrawable(layers);
        // 其中第一个参数为层的索引号，后面的四个参数分别为left、top、right和bottom
        /*
         * @param l number of pixels to add to the left bound
         * @param t number of pixels to add to the top bound
         * @param r number of pixels to subtract from the right bound
         * @param b number of pixels to subtract from the bottom bound
         */
//        la.setLayerInset(0 , 0 , 0 , 0 , 0);
//        la.setLayerInset(1 , 20 , 20 , 20 , 20);

        imageView.setImageDrawable(la);

        imageView.setY(y);
        imageView.setX(x);

        this.imageView = imageView;

    }

    public ImageView getImageView () {
        return imageView;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }
}
