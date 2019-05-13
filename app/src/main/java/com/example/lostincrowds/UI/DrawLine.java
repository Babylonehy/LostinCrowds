package com.example.lostincrowds.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawLine extends View {
    Paint paint;
    ArrayList<float[]> list = new ArrayList<>();
    private float startX, startY;
    private float endX, endY;
    private float curX, curY;

    public DrawLine(Context context) {
        this(context, null);
    }


    public DrawLine(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#00B7EE"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(startX, startY, endX, endY, paint);
        for (int i = 0; i < list.size(); i++) {
            float[] data = list.get(i);
            canvas.drawLine(data[0], data[1], data[2], data[3], paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                startX = event.getX();
                startY = event.getY();



                break;
            case MotionEvent.ACTION_MOVE:
                endX = event.getX();
                endY = event.getY();
                onTouchEvent2(event);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                float[] data = {startX, startY, endX, endY};
                list.add(data);
                break;


        }
        return true;
    }

    public boolean onTouchEvent2(MotionEvent event2) {
            Log.v("Drawline", "GET In ontouch event2.");
            switch (event2.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    curX =  event2.getX();
                    curY = (int) (event2.getY());
                    for (int i = 0; i < list.size(); i++) {
                        float[] data = list.get(i);
                        float a =  ((data[1] - data[3]) / (data[0] - data[2]));
                        float b =  ((data[0] * data[3] - data[1] * data[2]) / (data[0] - data[2]));
                        int now = (int) (curX * a + b);
                        Log.v("Drawline", curX + " " + curY+" "+now+" "+(Math.abs(now - curY) < 500?"T":"f"));
                        if (((curX>data[0] && curX<data[2])||(curX<data[0] && curX>data[2]))&&((curY>data[1]
                                && curY<data[3])||(curY<data[1] && curY>data[3]))){
                            if (Math.abs(now - curY) < 200) {
                                list.remove(i);
                                break;
                            }
                        }

                    }
                    break;

            }
        return true;
    }
}
