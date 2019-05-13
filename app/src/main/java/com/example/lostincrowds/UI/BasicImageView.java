package com.example.lostincrowds.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class BasicImageView extends android.support.v7.widget.AppCompatImageView {
    private int width = 150;
    private int id = 0;
    private int height = 150;

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width ,
            height);

    private float xpos;
    private float ypos;


    @SuppressLint("ResourceType")
    public BasicImageView ( Context context , @DrawableRes int back , @DrawableRes int front , float xpos , float ypos , int id ) {
        super(context);
        this.xpos = xpos;
        this.ypos = ypos;
        setLayoutParams(params);
        this.id = id;
        setBasicImageView(back , front);
    }

    public BasicImageView ( Context context , int back , int front , float xpos , float ypos ) {
        super(context);
        this.xpos = xpos;
        this.ypos = ypos;
        setLayoutParams(params);
        setBasicImageView(back , front);
    }

    public BasicImageView ( Context context , int back , int front ) {
        super(context);
        setLayoutParams(params);
        setBasicImageView(back , front);
    }

    public BasicImageView ( Context context , AttributeSet attrs ) {
        super(context , attrs);
        setLayoutParams(params);
    }


    public BasicImageView setBasicImageView ( @DrawableRes int back , @DrawableRes int front ) {
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
        setX(xpos);
        setY(ypos);
        setId(id);

        return this;

    }


    private void setWidth ( int width ) {
        this.width = width;
    }

    private void setHeight ( int height ) {
        this.height = height;
    }

    private void setXpos ( float xpos ) {
        this.xpos = xpos;
    }

    private void setYpos ( float ypos ) {
        this.ypos = ypos;
    }

    public float getXpos () {
        return xpos;
    }

    public float getYpos () {
        return ypos;
    }

    public float getXcentre () {
        return (float) (xpos + width / 2.0);
    }

    public float getYcentre () {
        return (float) (ypos + height / 2.0);
    }
}
