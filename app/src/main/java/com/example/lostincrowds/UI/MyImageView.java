package com.example.lostincrowds.UI;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.example.lostincrowds.Network.Login;
import com.example.lostincrowds.R;

public class MyImageView extends ConstraintLayout {

    private BasicImageView image;
    private NumberProgressBar number_progress_bar;
    private float xpos;
    private float ypos;


    private ConstraintLayout constraintLayout = null;

    public MyImageView ( Context context , @DrawableRes int back , @DrawableRes int front , float xpos , float ypos , float percentage ) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.myimageview , this);
        Log.v("MyImageView" , "Constructe");
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
        this.xpos = xpos;
        this.ypos = ypos;

        image = findViewById(R.id.basicImageView);
        image.setBasicImageView(back , front);
//
        number_progress_bar = findViewById(R.id.number_progress_bar);
        number_progress_bar.setProgress((int) percentage);
        number_progress_bar.setMax(100);
        setX(xpos);
        setY(ypos);

    }

}
