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

public class MyImageButton extends ConstraintLayout {
    private TextView textView;
    private ImageButton imageButton;
    private  Typeface typeface;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public MyImageButton(Context context) {
        super(context);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public MyImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void init(Context context){
        setContextClickable(true);
        typeface = getResources().getFont(R.font.patrickhandregular);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.imagebutton , this);
        textView = findViewById(R.id.textViewbutton);
        imageButton = findViewById(R.id.imageButton2);
        textView.setId(View.NO_ID);
        imageButton.setId(View.NO_ID);
        textView.setTypeface(typeface);

    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }
    public void setButtonName(String name){
        textView.setText(name);
        invalidate();
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setImageButton(@DrawableRes int back) {
        imageButton.setBackgroundResource(back);
        invalidate();
    }

    public void  setPosition(float xpos, float ypos){
        setX(xpos);
        setY(ypos);
    }

}
