package com.example.lostincrowds.UI;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lostincrowds.AutoImageView;

public class BasicImgineView extends android.support.v7.widget.AppCompatImageView {
    public float x;
    public float y;
    public BasicImgineView(Context context) {
        super(context);
    }
    public void setBasicImageView(Activity a,@DrawableRes int id1, @DrawableRes int id2,float x,float y){
        Drawable drawable1=getResources().getDrawable(id1);
        Drawable drawable2=getResources().getDrawable(id2);

        ImageView imageView1=new AutoImageView(this.getContext());
        imageView1.setImageDrawable(drawable1);

        ImageView imageView2=new AutoImageView(this.getContext());
        imageView2.setImageDrawable(drawable2);

        a.addContentView(imageView1,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT));
        a.addContentView(imageView2,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT));

    }
}
