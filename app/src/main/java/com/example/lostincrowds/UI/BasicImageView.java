/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: HandlePuzzle.java@author: jack@date: 5/21/19 2:10 PM@version: 1.0
 ******************************************************************************/

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

/**
 * The type Basic image view.
 */
public class BasicImageView extends android.support.v7.widget.AppCompatImageView {

    /**
     * The Params.
     */
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
    /**
     * The Layers.
     */
    Drawable[] layers = new Drawable[2];
    private float xpos, ypos;
    private @DrawableRes
    int back;
    private @DrawableRes
    int front;

    /**
     * Instantiates a new Basic image view.
     *
     * @param context the context
     * @param xpos    the xpos
     * @param ypos    the ypos
     */
    public BasicImageView(Context context, float xpos, float ypos) {
        super(context);
        setAdjustViewBounds(true);
        setLayoutParams(params);
        setMaxHeight(150);
        setMaxWidth(150);
        this.xpos = xpos;
        this.ypos = ypos;
        setY(ypos);
        setX(xpos);
    }

    /**
     * Instantiates a new Basic image view.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public BasicImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Gets back.
     *
     * @return the back
     */
    public int getBack() {
        return back;
    }

    /**
     * Gets front.
     *
     * @return the front
     */
    public int getFront() {
        return front;
    }

    /**
     * Sets basic image view.
     *
     * @param back  the back
     * @param front the front
     */
    public void setBasicImageView(@DrawableRes int back, @DrawableRes int front) {
        Resources r = getResources();
        Bitmap backImage = ((BitmapDrawable) r.getDrawable(
                back)).getBitmap();
        Bitmap frontImage = ((BitmapDrawable) r.getDrawable(
                front)).getBitmap();
        layers[0] = new BitmapDrawable(backImage);
        layers[1] = new BitmapDrawable(frontImage);
        LayerDrawable la = new LayerDrawable(layers);
        /*
         * @param l number of pixels to add to the left bound
         * @param t number of pixels to add to the top bound
         * @param r number of pixels to subtract from the right bound
         * @param b number of pixels to subtract from the bottom bound
         */
        la.setLayerInset(0, 0, 0, 0, 0);
        la.setLayerInset(1, 20, 20, 20, 20);
        setImageDrawable(la);
        setY(ypos);
        setX(xpos);
        this.back = back;
        this.front = front;
    }

    /**
     * Updatefront image view.
     *
     * @param front the front
     */
    public void updatefrontImageView(@DrawableRes int front) {
        Resources r = getResources();
        Bitmap backImage = ((BitmapDrawable) r.getDrawable(
                front)).getBitmap();
        layers[1] = new BitmapDrawable(backImage);
        LayerDrawable la = new LayerDrawable(layers);
        setImageDrawable(la);
        this.front = front;
        invalidate();
    }

    /**
     * Updateback image view.
     *
     * @param back the back
     */
    public void updatebackImageView(@DrawableRes int back) {
        Resources r = getResources();
        Bitmap backImage = ((BitmapDrawable) r.getDrawable(
                back)).getBitmap();
        layers[0] = new BitmapDrawable(backImage);
        LayerDrawable la = new LayerDrawable(layers);
        setImageDrawable(la);
        this.back = back;
        invalidate();
    }

}
