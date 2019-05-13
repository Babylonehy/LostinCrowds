package com.example.lostincrowds.UI;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.DrawableRes;
import android.view.MotionEvent;

import at.wirecube.additiveanimations.additive_animator.AdditiveAnimator;

public class Pencil extends android.support.v7.widget.AppCompatImageView {

    public Pencil ( Context context , @DrawableRes int pen ) {
        super(context);
        Resources r = getResources();
        Bitmap penImage = ((BitmapDrawable) r.getDrawable(
                pen)).getBitmap();
        setImageBitmap(penImage);

    }

    @Override
    public boolean onTouchEvent ( MotionEvent event ) {
        AdditiveAnimator.animate(this).x(event.getX()).y(event.getY()).setDuration(1000).start();
        return true;
    }
}
