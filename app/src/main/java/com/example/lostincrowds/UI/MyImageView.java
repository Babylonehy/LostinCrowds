package com.example.lostincrowds.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.lostincrowds.R;
import com.github.florent37.viewanimator.ViewAnimator;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.Random;

import static com.example.lostincrowds.ConstantValue.HEIGHT;
import static com.example.lostincrowds.ConstantValue.WIDTH;

/**
 * The type My image view.
 */
public class MyImageView extends ConstraintLayout {


    private BasicImageView image;
    private DonutProgress donutProgress;
    private float xpos;
    private float ypos;


    private String id;
    private float percentage;

    /**
     * Instantiates a new My image view.
     *
     * @param context    the context
     * @param back       the back
     * @param front      the front
     * @param xpos       the xpos
     * @param ypos       the ypos
     * @param percentage the percentage
     * @param id         the id
     */
    @SuppressLint("ResourceType")
    public MyImageView ( Context context , @DrawableRes int back , @DrawableRes int front , float xpos , float ypos , float percentage , String id ) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.myimageview , this);
        Log.v("MyImageView" , "Constructe");

        this.xpos = xpos;
        this.ypos = ypos;
        this.id = id;
        setX(xpos);
        setY(ypos);
        this.percentage = percentage;

        image = findViewById(R.id.basicImageView);
        image.setId(View.NO_ID);
        image.setBasicImageView(back , front);
        image.setAdjustViewBounds(true);
//        number_progress_bar = findViewById(R.id.number_progress_bar);
//        number_progress_bar.setProgress((int) percentage);
//        number_progress_bar.setMax(100);
        donutProgress = findViewById(R.id.donut_progress);
        donutProgress.setId(View.NO_ID);
//        donutProgress.setDonut_progress(String.valueOf(percentage));
        donutProgress.setFinishedStrokeWidth(10);
        donutProgress.setTextSize(30);
        donutProgress.setMax(100);
        donutProgress.setStartingDegree(-90);
        donutProgress.setProgress((int) percentage);
        donutProgress.setUnfinishedStrokeWidth(5);
        Log.v("Myview" , id + ": " + getXpos() + " " + getYpos());
        setMyAnimation();

    }


    private void setMyAnimation () {

        Random random = new Random();
        ViewAnimator
                .animate(this)
                .tada().duration(random.nextInt(4000) + 3000).repeatCount(-1)
                .start();
    }

    /**
     * Sets text size.
     *
     * @param size the size
     */
    public void setTextSize ( float size ) {
        donutProgress.setTextSize(size);
        invalidate();
    }

    /**
     * Gets xpos.
     *
     * @return the xpos
     */
    public float getXpos () {
        return (float) (xpos + WIDTH / 2.0);
    }

    /**
     * Gets ypos.
     *
     * @return the ypos
     */
    public float getYpos () {
        return (float) (ypos + HEIGHT / 2.0);
    }

    /**
     * Gets percentage.
     *
     * @return the percentage
     */
    public float getPercentage () {
        return percentage;
    }

    /**
     * Sets percentage.
     *
     * @param percentage the percentage
     */
    public void setPercentage ( float percentage ) {
        if (percentage >= 0 && percentage <= 100) {
            this.percentage = percentage;
            donutProgress.setProgress(percentage);
            invalidate();
        }
    }

    /**
     * Gets view id.
     *
     * @return the view id
     */
    public String getViewId () {
        return id;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public BasicImageView getImage () {
        return image;
    }

}
