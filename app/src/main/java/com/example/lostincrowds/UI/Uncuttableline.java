package com.example.lostincrowds.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Uncuttableline extends View {
    public Uncuttableline(Context context) {
        this(context, null);
    }
    public Uncuttableline(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public Uncuttableline(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();
    }
    Paint paint;
    private void init(){
        //初始画笔
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);

    }
    private ArrayList<MyImageView> uncuttable_pair=new ArrayList<>();

    public void setUncuttable_pair(ArrayList<MyImageView> uncuttable_pair) {
        this.uncuttable_pair = uncuttable_pair;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(625,625,925,925,paint);

//        canvas.drawLine(startX, startY, endX, endY, paint);
        for (int i = 0; i < uncuttable_pair.size(); i=i+2) {
            if (uncuttableLine.size()<2){
                break;
            }else {
                MyImageView myImageView=uncuttable_pair.get(i);
                MyImageView myImageView1=uncuttable_pair.get(i+1);
                Log.v("Uncut", myImageView.getXpos()+" "+myImageView.getYpos()+" "+
                        myImageView1.getXpos()+" "+myImageView1.getYpos());
                canvas.drawLine(myImageView.getXpos(),myImageView.getYpos(),
                        myImageView1.getXpos(),myImageView1.getYpos(),paint);

            }

        }
    }

    public ArrayList<Line> uncuttableLine=new ArrayList<>();

    public ArrayList<Line> getUncuttableLine() {
        return uncuttableLine;
    }
    private float startx,starty,endx,endy;

    public void setEndx(float endx) {
        this.endx = endx;
    }
}
