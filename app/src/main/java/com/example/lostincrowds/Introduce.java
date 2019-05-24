/******************************************************************************
 * Copyright (c) 2019. Xiaorong Ma From Australian National University CECS  All Rights Reserved. FileName: Introduce.java@author: jack@date: 23/05/19 11:57 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import me.grantland.widget.AutofitTextView;

public class Introduce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        AutofitTextView mFileContentView = (AutofitTextView) findViewById(R.id.autofitTextView2);
        mFileContentView.setMovementMethod(ScrollingMovementMethod.getInstance());
        AutofitTextView mFileContentView2 = (AutofitTextView) findViewById(R.id.autofitTextView);
        mFileContentView2.setMovementMethod(ScrollingMovementMethod.getInstance());
        Glide.with(this).load(R.drawable.cutdraw).into((ImageView) findViewById(R.id.drawlinegif));
    }
}
