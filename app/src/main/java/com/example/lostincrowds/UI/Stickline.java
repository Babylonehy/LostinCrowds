package com.example.lostincrowds.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Stickline extends View {

    public ArrayList<Line> uncuttableLine = new ArrayList<>();
    private Paint paint;
    private ArrayList<MyImageView[]> uncuttable_pair = new ArrayList<>();

    public Stickline ( Context context ) {
        this(context , null);
    }

    public Stickline ( Context context , AttributeSet attrs ) {
        this(context , attrs , 0);
    }

    public Stickline ( Context context , AttributeSet attrs , int defStyleAttr ) {
        super(context , attrs , defStyleAttr);
    }

    @Override
    protected void onSizeChanged ( int w , int h , int oldw , int oldh ) {
        super.onSizeChanged(w , h , oldw , oldh);
        init();
    }

    private void init () {
        //初始画笔
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);

    }

    public void setUncuttable_pair ( ArrayList<MyImageView[]> uncuttable_pair ) {
        this.uncuttable_pair = uncuttable_pair;
    }

    @Override
    protected void onDraw ( Canvas canvas ) {
        super.onDraw(canvas);
        Log.v("Uncut" , "In to Uncut");
        for (int i = 0; i < uncuttable_pair.size(); i = i + 2) {
            if (uncuttableLine.equals(0)) {
                Log.v("Uncut" , "In to Uncut2" + uncuttable_pair.size());
                break;
            } else {
                Log.v("Uncut" , "In to Uncut3");
                MyImageView myImageView = uncuttable_pair.get(i)[0];
                MyImageView myImageView1 = uncuttable_pair.get(i)[1];
                Log.v("Uncut" , myImageView.getXpos() + " " + myImageView.getYpos() + " " +
                        myImageView1.getXpos() + " " + myImageView1.getYpos());
                canvas.drawLine(myImageView.getXpos() , myImageView.getYpos() ,
                        myImageView1.getXpos() , myImageView1.getYpos() , paint);

            }

        }
    }

    public ArrayList<Line> getUncuttableLine () {
        return uncuttableLine;
    }

    public Paint getPaint () {
        return paint;
    }

}
