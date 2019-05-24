/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: HandlePuzzle.java@author: jack@date: 5/21/19 2:10 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.example.lostincrowds.R;

/**
 * The type Super text show.
 */
public class SuperTextShow extends ConstraintLayout {
    /**
     * Instantiates a new Super text show.
     *
     * @param context the context
     */
    @SuppressLint("ResourceType")
    public SuperTextShow ( Context context ) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.supertextview , this);

    }

    /**
     * Instantiates a new Super text show.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public SuperTextShow ( Context context , AttributeSet attrs ) {
        super(context , attrs);

    }
}
