/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: ImageButton.java@author: jack@date: 19-5-22 上午3:13@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lostincrowds.R;

/**
 * The type My image button.
 */
public class MyImageButton extends ConstraintLayout {
    private TextView textView;
    private ImageButton imageButton;
    private Typeface typeface;

    /**
     * Instantiates a new My image button.
     *
     * @param context the context
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MyImageButton(Context context) {
        super(context);
        init(context);
    }

    /**
     * Instantiates a new My image button.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MyImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void init(Context context) {
        setContextClickable(true);
        typeface = getResources().getFont(R.font.patrickhandregular);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.imagebutton, this);
        textView = findViewById(R.id.textViewbutton);
        imageButton = findViewById(R.id.imageButton2);
        textView.setId(View.NO_ID);
        imageButton.setId(View.NO_ID);
        textView.setTypeface(typeface);

    }

    /**
     * Sets typeface.
     *
     * @param typeface the typeface
     */
    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    /**
     * Sets button name.
     *
     * @param name the name
     */
    public void setButtonName(String name) {
        textView.setText(name);
        invalidate();
    }

    /**
     * Gets image button.
     *
     * @return the image button
     */
    public ImageButton getImageButton() {
        return imageButton;
    }

    /**
     * Sets image button.
     *
     * @param back the back
     */
    public void setImageButton(@DrawableRes int back) {
        imageButton.setBackgroundResource(back);
        invalidate();
    }

    /**
     * Gets text view.
     *
     * @return the text view
     */
    public TextView getTextView() {
        return textView;
    }

    /**
     * Sets position.
     *
     * @param xpos the xpos
     * @param ypos the ypos
     */
    public void setPosition(float xpos, float ypos) {
        setX(xpos);
        setY(ypos);
    }

}
