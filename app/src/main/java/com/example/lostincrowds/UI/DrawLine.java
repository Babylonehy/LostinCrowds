package com.example.lostincrowds.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawLine extends View {
    public DrawLine ( Context context ) {
        this(context , null);
    }

    public DrawLine ( Context context , AttributeSet attrs ) {
        this(context , attrs , 0);
    }

    public DrawLine ( Context context , AttributeSet attrs , int defStyleAttr ) {
        super(context , attrs , defStyleAttr);
    }

    @Override
    protected void onSizeChanged ( int w , int h , int oldw , int oldh ) {
        super.onSizeChanged(w , h , oldw , oldh);
        init();
    }

    Paint paint;

    private void init () {
        paint = new Paint();
        paint.setColor(Color.parseColor("#00B7EE"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
    }


    @Override
    protected void onDraw ( Canvas canvas ) {
        super.onDraw(canvas);
        canvas.drawLine(startX , startY , endX , endY , paint);
        for (int i = 0; i < list.size(); i++) {
            float[] data = list.get(i);
            canvas.drawLine(data[0] , data[1] , data[2] , data[3] , paint);
        }
    }

    private float startX, startY;

    private float endX, endY;
    ArrayList<float[]> list = new ArrayList<>();

    @Override
    public boolean onTouchEvent ( MotionEvent event ) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                endX = event.getX();
                endY = event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                float[] data = {startX , startY , endX , endY};
                list.add(data);
                break;
        }
        return true;
    }
}
