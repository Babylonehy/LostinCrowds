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

/**
 * The type Draw line.
 */
public class DrawLine extends View {

    private float startX, startY;
    private float pathStartX, pathStartY, pathEndX, pathEndY;
    private float endX, endY;
    /**
     * The List.
     */
    ArrayList<float[]> list = new ArrayList<>();
    /**
     * The Paint.
     */
    Paint paint;
    /**
     * The Pathpaint.
     */
    Paint Pathpaint = new Paint();

    /**
     * Instantiates a new Draw line.
     *
     * @param context the context
     */
    public DrawLine ( Context context ) {
        this(context , null);
    }

    /**
     * Instantiates a new Draw line.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public DrawLine ( Context context , AttributeSet attrs ) {
        this(context , attrs , 0);
    }

    /**
     * Instantiates a new Draw line.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     */
    public DrawLine ( Context context , AttributeSet attrs , int defStyleAttr ) {
        super(context , attrs , defStyleAttr);
    }

    @Override
    protected void onSizeChanged ( int w , int h , int oldw , int oldh ) {
        super.onSizeChanged(w , h , oldw , oldh);
        init();
    }

    private int maxLen = 15;
    private float addWidth = 3f;

    private Deque<PointF> pointFS = new ArrayDeque<>(maxLen);
    private Deque<PointF> pointFSClose = new ArrayDeque<>(maxLen);

    private Paint mPaint;
    private Shader mShader;//刀光填充颜色

    private boolean isDiff = false;
    //刀光减少
    private ArrayList positionlist;
    /**
     * The Diff.
     */
    Runnable diff = new Runnable() {
        @Override
        public void run () {
            PointF pointF = pointFS.pollFirst();
            int delayMillis = 50;
            if (null != pointF) {
                postInvalidate();
                postDelayed(diff , delayMillis);
                return;
            }

            if (isDiff) {
                postDelayed(diff , delayMillis);
            }
        }
    };
    /**
     * The Clear p.
     */
    Runnable clearP = new Runnable() {
        @Override
        public void run () {
            pointFS.clear();
            postInvalidate();
        }
    };
    private Rect outRect = new Rect();


    private void init () {
        //初始画笔
        paint = new Paint();
        paint.setColor(Color.parseColor("#00B7EE"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        setWillNotDraw(false);
        Pathpaint.setColor(Color.parseColor("#00B7EE"));
        Pathpaint.setAntiAlias(true);
        Pathpaint.setStrokeWidth(10);

        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setPathEffect(new CornerPathEffect(5));

        mShader = new LinearGradient(0 , 0 , 40 , 60 ,
                new int[]{
                        Color.parseColor("#f8f8f8") ,
                        Color.parseColor("#C0C0C0") ,
                        Color.parseColor("#f8f8f8") ,
                } ,
                null ,
                Shader.TileMode.CLAMP);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        if (widthPixels > 1080) {
            addWidth *= 2;
        }
    }

    @Override
    protected void onLayout ( boolean changed , int left , int top , int right , int bottom ) {
        getGlobalVisibleRect(outRect);
        super.onLayout(changed , left , top , right , bottom);
    }

    @Override
    protected void onDetachedFromWindow () {
        removeCallbacks(diff);
        removeCallbacks(clearP);
        super.onDetachedFromWindow();
    }

    @Override
    protected void onDraw ( Canvas canvas ) {
        super.onDraw(canvas);
//        canvas.drawLine(startX, startY, endX, endY, paint);
        for (int i = 0; i < list.size(); i++) {
            float[] data = list.get(i);
            canvas.drawLine(data[0] , data[1] , data[2] , data[3] , paint);
        }
        PointF start = pointFS.peek();
        if (start == null) return;

        Path path = creatPath();
        //边框
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setShader(null);
        canvas.drawPath(path , mPaint);

        //填充
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setShader(mShader);
        canvas.drawPath(path , mPaint);
        if (pathFlag)
            canvas.drawLine(pathStartX , pathStartY , pathEndX , pathEndY , Pathpaint);
    }

    private boolean pathFlag = false;
    private boolean cutFlag = true;
    @Override
    public boolean onTouchEvent ( MotionEvent event ) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                pathFlag = false;
                cutFlag=true;
                for (int i = 0; i < setImageView.size(); i++) {
                    MyImageView myImageView = setImageView.get(i);
                    float x=Math.abs(myImageView.getXpos()-event.getX());
                    float y=Math.abs(myImageView.getYpos()-event.getY());
                    if ((x*x+y*y)<10000){

                        startX = myImageView.getXpos();
                        startY = myImageView.getYpos();
                        cutFlag = false;
                        pathFlag=true;
                        break;
                    }

                }
//                PATH
                if (pathFlag){
                    pathStartX = event.getX();
                    pathStartY = event.getY();
                }


                isDiff = true;
                removeCallbacks(diff);
                removeCallbacks(clearP);
                postDelayed(diff , 80);
                pointFS.clear();

                pointFS.addLast(new PointF(event.getX() - outRect.left , event.getY() - outRect.top));
                postInvalidate();

                break;
            case MotionEvent.ACTION_MOVE:

                pathEndX = event.getX();
                pathEndY = event.getY();

                if (cutFlag) {
                    onTouchEvent2(event);
                }
                onMove(event.getX() , event.getY());
                postInvalidate();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                endX = event.getX();
                endY = event.getY();
                pathFlag = false;
                for (int i = 0; i < setImageView.size(); i++) {
                    MyImageView myImageView = setImageView.get(i);
                    float x=Math.abs(myImageView.getXpos()-event.getX());
                    float y=Math.abs(myImageView.getYpos()-event.getY());
                    if ((x*x+y*y)<10000){
                        endX = myImageView.getXpos();
                        endY = myImageView.getYpos();
                        float[] data2 = {startX , startY , endX , endY};
                        list.add(data2);
                        setConnectivepair();
                        break;

                    }
                }
                cutFlag = true;


                break;
        }
        return true;
    }

    private void onMove ( float x , float y ) {
        if (pointFS.size() >= maxLen - 1) {
            pointFS.pollFirst();
        }
        pointFS.addLast(new PointF(x , y));
    }

    private float curX;
    private float curY;

    /**
     * On touch event 2 boolean.
     *
     * @param event2 the event 2
     * @return the boolean
     */
    public boolean onTouchEvent2 ( MotionEvent event2 ) {
        Log.v("Drawline" , "GET In ontouch event2.");
        switch (event2.getAction()) {
            case MotionEvent.ACTION_MOVE:
                curX = event2.getX();
                curY = (event2.getY());
                for (int i = 0; i < list.size(); i++) {
                    float[] data = list.get(i);
                    float a= (float) Math.sqrt((curX-data[0])*(curX-data[0])+(curY-data[1])*(curY-data[1]));
                    float b= (float) Math.sqrt((curX-data[2])*(curX-data[2])+(curY-data[3])*(curY-data[3]));
                    float now =  a+b;
                    float or= (float) Math.sqrt((data[0]-data[2])*(data[0]-data[2])+(data[1]-data[3])*(data[1]-data[3]));
                    if (((curX >= data[0]-10 && curX <= data[2]+10) || (curX <= data[0]+10 && curX >= data[2]-10)) && ((curY >= data[1]-10
                            && curY <= data[3]+10) || (curY <= data[1]+10 && curY >= data[3]-10))) {

                        if (Math.abs(now - or) < 400) {
                            list.remove(i);
                            setConnectivepair();
                            Log.v("list", list + " "+connectivepair+" ");
                            break;
                        }
                    }
                    Log.v("Drawline", list+" "+ (Math.abs(now - or) < 200 ? "T" : "f"));
                    break;
                }
                break;
        }
        return true;
    }

    private Path creatPath () {
        PointF start = pointFS.peek();

        Path path = new Path();
        path.moveTo(start.x , start.y);

        int width = 1;

        PointF pre = null;
        PointF next = null;

        for (Iterator<PointF> iter = pointFS.iterator(); iter.hasNext(); ) {
            next = iter.next();
            if (iter.hasNext()) {

                float v = width / 2;
                float k = 0;
                if (pre != null) k = (next.y - pre.y) / (next.x - pre.x);
                if (Math.abs(1 - k) < 0.9) {
                    path.lineTo(next.x , next.y - v);
                    pointFSClose.addFirst(new PointF(next.x , next.y + v));
                } else {
                    path.lineTo(next.x - v , next.y - v);
                    pointFSClose.addFirst(new PointF(next.x + v , next.y + v));
                }

                pre = next;
            } else {
                path.lineTo(next.x , next.y);
            }

            width += addWidth;
        }

        for (; pointFSClose.peekFirst() != null; ) {
            PointF pf = pointFSClose.pollFirst();
            path.lineTo(pf.x , pf.y);
        }
        path.close();

        return path;
    }

    /**
     * The Set image view.
     */
    ArrayList<MyImageView> setImageView = new ArrayList<>();

    /**
     * Sets image view.
     *
     * @param arrayList the array list
     */
    public void setImageView ( ArrayList arrayList ) {
        this.setImageView = arrayList;

    }

    /**
     * The Connective line.
     */
    MyImageView[] connective_line=new MyImageView[2];
    ArrayList<MyImageView[]> connectivepair=new ArrayList<>();

    public void setConnectivepair() {

        for (int i = 0; i <list.size() ; i++) {
            int counter=0;
            for (MyImageView my :setImageView){
                if((Math.abs(my.getXpos()-list.get(i)[0])<1 &&Math.abs(my.getYpos()-list.get(i)[1])<1)||
                        (Math.abs(my.getXpos()-list.get(i)[2])<1 &&Math.abs(my.getYpos()-list.get(i)[3])<1)) {
                    connective_line[counter]=my;
                    counter=counter+1;
                }
            }
            connectivepair.add(connective_line);
        }

    }

    /**
     * Gets line.
     *
     * @return the line
     */
   
    public ArrayList<MyImageView[]> get_connectedImage(){
        return connectivepair;
    }
}
