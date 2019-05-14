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

import static com.example.lostincrowds.Network.ConstantValue.HEIGHT;
import static com.example.lostincrowds.Network.ConstantValue.WIDTH;

public class MyImageView extends ConstraintLayout {

    private BasicImageView image;
    private DonutProgress donutProgress;
    private float xpos;
    private float ypos;


    private String id;
    private float percentage;

    @SuppressLint("ResourceType")
    public MyImageView ( Context context , @DrawableRes int back , @DrawableRes int front , float xpos , float ypos , float percentage , String id ) {
        super(context);
        donutProgress = new DonutProgress(context);
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
        donutProgress.setTextSize(20);
        donutProgress.setMax(100);
        donutProgress.setProgress((int) percentage);
        donutProgress.setUnfinishedStrokeWidth(5);
        Log.v("Myview" , getXpos() + " " + getYpos());
        setMyAnimation();

    }


    private void setMyAnimation () {

        ViewAnimator
                .animate(this)
                .tada().duration(4000).repeatCount(-1)
                .start();
    }

    public float getXpos () {
        return (float) (xpos + WIDTH / 2.0);
    }

    public float getYpos () {
        return (float) (ypos + HEIGHT / 2.0);
    }

    public float getPercentage () {
        return percentage;
    }

    public void setPercentage ( float percentage ) {
        this.percentage = percentage;
        donutProgress.setProgress(percentage);
    }

    public String getViewId () {
        return id;
    }
//        image=new BasicImageView(context,back,front);
//        number_progress_bar=new NumberProgressBar(context);
//        number_progress_bar.setProgress((int) percentage);
//        number_progress_bar.setUnreachedBarColor(Color.BLACK);
//        number_progress_bar.setReachedBarColor(Color.BLUE);
//        number_progress_bar.setLayoutParams(params);
//        number_progress_bar.setMax(100);
//        image.getImageView().setX(0);
//        image.getImageView().setY(5);
//        image.getImageView().setLayoutParams(params);
}
