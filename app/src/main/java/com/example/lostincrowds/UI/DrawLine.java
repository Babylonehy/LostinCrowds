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

public class DrawLine extends View {
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
    private int maxLen = 15;    //最大轨迹长度
    private float addWidth = 3f;    //刀光增量宽度

    private Deque<PointF> pointFS = new ArrayDeque<>(maxLen);   //刀光上边框点集合
    private Deque<PointF> pointFSClose = new ArrayDeque<>(maxLen);  //刀光下边框点集合

    private Paint mPaint;
    private Shader mShader;//刀光填充颜色

    private boolean isDiff = false;
    //刀光减少
    private  ArrayList positionlist;
    Runnable diff = new Runnable() {
        @Override
        public void run() {
            PointF pointF = pointFS.pollFirst();
            int delayMillis = 50;
            if (null != pointF) {
                postInvalidate();
                postDelayed(diff, delayMillis);
                return;
            }

            if (isDiff) {
                postDelayed(diff, delayMillis);
            }
        }
    };
    Runnable clearP = new Runnable() {
        @Override
        public void run() {
            pointFS.clear();
            postInvalidate();
        }
    };
    private Rect outRect = new Rect();
    //初始化
    Paint paint;
    private void init(){
        //初始画笔
        paint = new Paint();
        paint.setColor(Color.parseColor("#00B7EE"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(33);
        setWillNotDraw(false);

        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setPathEffect(new CornerPathEffect(5));

        mShader = new LinearGradient(0, 0, 40, 60,
                new int[]{
                        Color.parseColor("#f8f8f8"),
                        Color.parseColor("#C0C0C0"),
                        Color.parseColor("#f8f8f8"),
                },
                null,
                Shader.TileMode.CLAMP);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        if (widthPixels > 1080) {
            addWidth *= 2;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        getGlobalVisibleRect(outRect);
        super.onLayout(changed, left, top, right, bottom);
    }
    @Override
    protected void onDetachedFromWindow() {
        removeCallbacks(diff);
        removeCallbacks(clearP);
        super.onDetachedFromWindow();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawLine(startX, startY, endX, endY, paint);
        for (int i = 0; i < list.size(); i++) {
            float [] data=list.get(i);
            canvas.drawLine(data[0],data[1],data[2],data[3],paint);
        }
        PointF start = pointFS.peek();
        if (start == null) return;

        Path path = creatPath();
        //边框
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setShader(null);
        canvas.drawPath(path, mPaint);

        //填充
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setShader(mShader);
        canvas.drawPath(path, mPaint);
    }

    private float startX, startY;

    private float endX,endY;
    ArrayList<float[]> list=new ArrayList<>();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (int i = 0; i <positionlist.size() ; i++) {
                    float [] data3= (float[]) positionlist.get(i);
                    if (event.getX()>data3[0]&&event.getX()<(data3[0]+150)&&event.getY()>data3[1]
                    &&event.getY()<(data3[1]+100)){
                        startX = event.getX();
                        startY = event.getY();
                    }

                }
//                if ((event.getX()>100 &&event.getY()>100&&event.getX()<250&&event.getY()<250)||
//                        (event.getX()>700 &&event.getY()>700&&event.getX()<850&&event.getY()<850)){
//
//                }

                isDiff = true;
                removeCallbacks(diff);
                removeCallbacks(clearP);
                postDelayed(diff, 80);
                pointFS.clear();

                pointFS.addLast(new PointF(event.getX() - outRect.left, event.getY() - outRect.top));
                postInvalidate();

                break;
            case MotionEvent.ACTION_MOVE:
                endX = event.getX();
                endY = event.getY();
                onTouchEvent2(event);
                onMove(event.getX() , event.getY() );
                postInvalidate();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                endX = event.getX();
                endY = event.getY();
                for (int i = 0; i <positionlist.size() ; i++) {
                    float [] data= (float[]) positionlist.get(i);
                    if (event.getX()>data[0]&&event.getX()<(data[0]+150)&&event.getY()>data[1]
                            &&event.getY()<(data[1]+100)){
                        float [] data2={startX,startY,endX,endY};
                        list.add(data2);
                    }

                }

//                if ((event.getX()>100 &&event.getY()>100&&event.getX()<250&&event.getY()<250)||
//                        (event.getX()>700 &&event.getY()>700&&event.getX()<850&&event.getY()<850)){
//
//
//                }

                break;
        }
        return true;
    }
    private void onMove(float x, float y) {
        if (pointFS.size() >= maxLen - 1) {
            pointFS.pollFirst();
        }
        pointFS.addLast(new PointF(x, y));
    }
    private float curX;
    private int curY;
    public boolean onTouchEvent2(MotionEvent event2) {
        Log.v("Drawline", "GET In ontouch event2.");
        switch (event2.getAction()) {
            case MotionEvent.ACTION_MOVE:
                curX = event2.getX();
                curY = (int) (event2.getY());
                for (int i = 0; i < list.size(); i++) {
                    float[] data = list.get(i);
                    float a = ((data[1] - data[3]) / (data[0] - data[2]));
                    float b = ((data[0] * data[3] - data[1] * data[2]) / (data[0] - data[2]));
                    int now = (int) (curX * a + b);
                    Log.v("Drawline", curX + " " + curY + " " + now + " " + (Math.abs(now - curY) < 500 ? "T" : "f"));
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
    private Path creatPath() {
        PointF start = pointFS.peek();

        Path path = new Path();
        path.moveTo(start.x, start.y);

        int width = 1;

        PointF pre = null;
        PointF next = null;

        for (Iterator<PointF> iter = pointFS.iterator(); iter.hasNext(); ) {
            next = iter.next();
            if (iter.hasNext()) {

                float v = width / 2;
                float k = 0; //计算斜率，解决45°角为一条线的BUG
                if (pre != null) k = (next.y - pre.y) / (next.x - pre.x);
                if (Math.abs(1 - k) < 0.9) {
                    path.lineTo(next.x, next.y - v);
                    pointFSClose.addFirst(new PointF(next.x, next.y + v));
                } else {
                    path.lineTo(next.x - v, next.y - v);
                    pointFSClose.addFirst(new PointF(next.x + v, next.y + v));
                }

                pre = next;
            } else {
                path.lineTo(next.x, next.y);
            }

            width += addWidth;
        }

        for (; pointFSClose.peekFirst() != null; ) {
            PointF pf = pointFSClose.pollFirst();
            path.lineTo(pf.x, pf.y);
        }
        path.close();

        return path;
    }
    public void setpositionlist(ArrayList arrayList){
        this.positionlist=arrayList;
    }
}
