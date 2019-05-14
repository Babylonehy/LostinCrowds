package com.example.lostincrowds.UI;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.example.lostincrowds.R;

public class MyImageView extends ConstraintLayout {

    private BasicImageView image;
    private NumberProgressBar number_progress_bar;
    private float xpos;
    private float ypos;

    public MyImageView ( Context context , @DrawableRes int back , @DrawableRes int front , float xpos , float ypos , float percentage ) {
        super(context);
        YoYo.with(Techniques.Bounce).duration(5000).repeat(-1).playOn(this);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.myimageview , this);
        Log.v("MyImageView" , "Constructe");

        this.xpos = xpos;
        this.ypos = ypos;

        image = findViewById(R.id.basicImageView);
        image.setBasicImageView(back , front);
        number_progress_bar = findViewById(R.id.number_progress_bar);
        number_progress_bar.setProgress((int) percentage);
        number_progress_bar.setMax(100);
        setX(xpos);
        setY(ypos);
    }


    public void setMyAnimation ( Techniques animation , int duration ) {

        YoYo.with(animation).duration(duration).repeat(-1).playOn(this);
    }

    public float getXpos () {
        return xpos;
    }

    public float getYpos () {
        return ypos;
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
