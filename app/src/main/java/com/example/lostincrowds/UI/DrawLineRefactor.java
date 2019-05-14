package com.example.lostincrowds.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class DrawLineRefactor extends View {
    public DrawLineRefactor ( Context context ) {
        this(context , null);
    }

    public DrawLineRefactor ( Context context , AttributeSet attrs ) {
        this(context , attrs , 0);
    }

    public DrawLineRefactor ( Context context , AttributeSet attrs , int defStyleAttr ) {
        super(context , attrs , defStyleAttr);
    }

    @Override
    protected void onSizeChanged ( int w , int h , int oldw , int oldh ) {
        super.onSizeChanged(w , h , oldw , oldh);
        init();
    }


    Paint paint;

    private void init () {
        //初始画笔
        paint = new Paint();
        paint.setColor(Color.parseColor("#00B7EE"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        setWillNotDraw(false);

    }


    @Override
    protected void onDraw ( Canvas canvas ) {
        super.onDraw(canvas);
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
                for (int i = 0; i < setImageView.size(); i++) {
                    MyImageView myImageView = setImageView.get(i);
                    if (event.getX() > myImageView.getX() && event.getX() < (myImageView.getX() + 150)
                            && event.getY() > myImageView.getY() && myImageView.getY() < (myImageView.getY() + 150)) {
                        startX = myImageView.getXpos();
                        startY = myImageView.getYpos();
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                endX = event.getX();
                endY = event.getY();
                onTouchEvent2(event);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                endX = event.getX();
                endY = event.getY();
                for (int i = 0; i < setImageView.size(); i++) {
                    MyImageView myImageView = setImageView.get(i);
                    if (event.getX() > myImageView.getX() && event.getX() < (myImageView.getX() + 150)
                            && event.getY() > myImageView.getY() && myImageView.getY() < (myImageView.getY() + 150)) {
                        endX = myImageView.getXpos();
                        endY = myImageView.getYpos();
                        float[] data2 = {startX , startY , endX , endY};
                        list.add(data2);
                        Line line = new Line(startX , startY , endX , endY , true);
                        connective_line.add(line);
                    }
                }


                break;
        }
        return true;
    }


    private float curX;
    private int curY;

    public boolean onTouchEvent2 ( MotionEvent event2 ) {
        Log.v("Drawline" , "GET In ontouch event2.");
        switch (event2.getAction()) {
            case MotionEvent.ACTION_MOVE:
                curX = event2.getX();
                curY = (int) (event2.getY());
                for (int i = 0; i < list.size(); i++) {
                    float[] data = list.get(i);
                    float a = ((data[1] - data[3]) / (data[0] - data[2]));
                    float b = ((data[0] * data[3] - data[1] * data[2]) / (data[0] - data[2]));
                    int now = (int) (curX * a + b);
                    Log.v("Drawline" , curX + " " + curY + " " + now + " " + (Math.abs(now - curY) < 500 ? "T" : "f"));
                    if (((curX > data[0] && curX < data[2]) || (curX < data[0] && curX > data[2])) && ((curY > data[1]
                            && curY < data[3]) || (curY < data[1] && curY > data[3]))) {
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

    ArrayList<MyImageView> setImageView = new ArrayList<>();

    public void setImageView ( ArrayList arrayList ) {
        this.setImageView = arrayList;

    }

    ArrayList<Line> connective_line = new ArrayList<>();

    public ArrayList<Line> getconnective_line () {
        return connective_line;
    }
}
