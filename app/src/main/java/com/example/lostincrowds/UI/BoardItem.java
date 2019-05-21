/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Board.java@author: jack@date: 17/05/19 11:48 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.example.lostincrowds.R;

/**
 * The type Board.
 */
public class BoardItem extends ConstraintLayout {

    private TextView textView;
    private NumberProgressBar numberProgressBar;

    /**
     * Instantiates a new Board.
     *
     * @param context the context
     */
    @SuppressLint("ResourceType")
    public BoardItem ( Context context ) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.board , this);
        textView = findViewById(R.id.textViewboard);
        numberProgressBar = findViewById(R.id.number_progress_bar_board);
        textView.setId(View.NO_ID);
        numberProgressBar.setId(View.NO_ID);
        numberProgressBar.setMax(5);
    }

    /**
     * Instantiates a new Board.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public BoardItem ( Context context , AttributeSet attrs ) {
        super(context , attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.board , this);
        textView = findViewById(R.id.textViewboard);
        numberProgressBar = findViewById(R.id.number_progress_bar_board);
        textView.setId(View.NO_ID);
        numberProgressBar.setId(View.NO_ID);
        numberProgressBar.setMax(5);
    }

    /**
     * Update.
     *
     * @param name  the name
     * @param level the level
     */
    public void update ( String name , Integer level ) {
        Log.v("Items",name);
        setting(name , level);
        invalidate();
    }

    private void setting ( String name , Integer level ) {
        textView.setText(name);
        numberProgressBar.setProgress(level);
    }
}
