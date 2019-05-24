/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: HandlePuzzle.java@author: jack@date: 5/21/19 2:10 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.UI;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * The type Auto image view.
 */
public class AutoImageView extends AppCompatImageView {

    /**
     * Instantiates a new Auto image view.
     *
     * @param context the context
     */
    public AutoImageView(Context context) {
        super(context);
    }

    /**
     * Instantiates a new Auto image view.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public AutoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int width = drawable.getMinimumWidth();
            int height = drawable.getMinimumHeight();
            float scale = (float) width / height;

            int heightMeasure = MeasureSpec.getSize(heightMeasureSpec);
            int widthMeasure = (int) (heightMeasure * scale);

            widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthMeasure, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
