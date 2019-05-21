/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: ImageButton.java@author: jack@date: 19-5-22 上午3:13@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.example.lostincrowds.R;

public class ImageButton extends ConstraintLayout {
    private TextView textView;
    private ImageView imageView;
    private  Typeface typeface;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ImageButton(Context context) {
        super(context);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void init(Context context){
        typeface = getResources().getFont(R.font.patrickhandregular);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.imagebutton , this);
        textView = findViewById(R.id.textViewbutton);
        imageView = findViewById(R.id.imageView2);
        textView.setId(View.NO_ID);
        imageView.setId(View.NO_ID);
        textView.setTypeface(typeface);

    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }
    public void setButtonName(String name){
        textView.setText(name);
        invalidate();
    }
    public void setImageView(@DrawableRes int back){
        Resources r = getResources();
        Bitmap backImage = ((BitmapDrawable) r.getDrawable(
                back)).getBitmap();
        imageView.setImageBitmap(backImage);
        invalidate();
    }
    public TextView getTextView() {
        return textView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void  setPosition(float xpos, float ypos){
        setX(xpos);
        setY(ypos);
    }

}
