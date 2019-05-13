package com.example.lostincrowds.UI;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;

class BasicImageView extends android.support.v7.widget.AppCompatImageView {

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT ,
            LinearLayout.LayoutParams.WRAP_CONTENT);
    private float xpos, ypos;
    private int back;

    private int front;

    public BasicImageView ( Context context , float xpos , float ypos ) {
        super(context);
        setAdjustViewBounds(true);
        setLayoutParams(params);
        setMaxHeight(150);
        setMaxWidth(150);
        this.xpos = xpos;
        this.ypos = ypos;
    }


    public BasicImageView ( Context context , AttributeSet attrs ) {
        super(context , attrs);
    }

    public void setBasicImageView ( @DrawableRes int back , @DrawableRes int front ) {
        Resources r = getResources();
        Bitmap backImage = ((BitmapDrawable) r.getDrawable(
                back)).getBitmap();
        Bitmap frontImage = ((BitmapDrawable) r.getDrawable(
                front)).getBitmap();

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
        la.setLayerInset(0 , 0 , 0 , 0 , 0);
        la.setLayerInset(1 , 20 , 20 , 20 , 20);
        setImageDrawable(la);
        setY(ypos);
        setX(xpos);
    }



}
