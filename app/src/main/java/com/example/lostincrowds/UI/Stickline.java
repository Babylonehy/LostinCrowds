/******************************************************************************
 * Copyright (c) 2019. Xiaorong Ma From Australian National University CECS  All Rights Reserved. FileName: HandlePuzzle.java@author: jack@date: 5/21/19 2:10 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * The type Stickline.
 */
public class Stickline extends View {

    /**
     * The Uncuttable line.
     */
    public ArrayList<Line> uncuttableLine = new ArrayList<>();
    private Paint paint;
    private ArrayList<MyImageView[]> uncuttable_pair = new ArrayList<>();

    /**
     * Instantiates a new Stickline.
     *
     * @param context the context
     */
    public Stickline(Context context) {
        this(context, null);
    }

    /**
     * Instantiates a new Stickline.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public Stickline(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * Instantiates a new Stickline.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     */
    public Stickline(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();
    }

    private void init() {
        //初始画笔
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);

    }

    /**
     * Sets uncuttable pair.
     *
     * @param uncuttable_pair the uncuttable pair
     */
    public void setUncuttable_pair(ArrayList<MyImageView[]> uncuttable_pair) {
        this.uncuttable_pair = uncuttable_pair;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v("Uncut", "In to Uncut");
        for (int i = 0; i < uncuttable_pair.size(); i = i + 1) {
            if (uncuttableLine.equals(0)) {
                Log.v("Uncut", "In to Uncut2" + uncuttable_pair.size());
                break;
            } else {
                Log.v("Uncut", "In to Uncut3");
                MyImageView myImageView = uncuttable_pair.get(i)[0];
                MyImageView myImageView1 = uncuttable_pair.get(i)[1];
                Log.v("Uncut", myImageView.getXpos() + " " + myImageView.getYpos() + " " +
                        myImageView1.getXpos() + " " + myImageView1.getYpos());
                canvas.drawLine(myImageView.getXpos(), myImageView.getYpos(),
                        myImageView1.getXpos(), myImageView1.getYpos(), paint);

            }

        }
    }

    /**
     * Gets uncuttable line.
     *
     * @return the uncuttable line
     */
    public ArrayList<Line> getUncuttableLine() {
        return uncuttableLine;
    }

    /**
     * Gets paint.
     *
     * @return the paint
     */
    public Paint getPaint() {
        return paint;
    }

}
