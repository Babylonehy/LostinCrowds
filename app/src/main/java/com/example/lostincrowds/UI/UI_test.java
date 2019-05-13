package com.example.lostincrowds.UI;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.lostincrowds.R;

import at.wirecube.additiveanimations.additive_animator.AdditiveAnimator;

public class UI_test extends AppCompatActivity {
    Pencil pen = null;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        pen = new Pencil(this , R.drawable.arrow);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_ui_test);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View view ) {
                Snackbar.make(view , "Replace with your own action" , Snackbar.LENGTH_LONG)
                        .setAction("Action" , null).show();
            }
        });
        BasicImageView basicImageView = new BasicImageView(this , 0 , 50);
        basicImageView.setBasicImageView(R.drawable.gray , R.drawable.eyesclose);
        addContentView(basicImageView , basicImageView.getLayoutParams());
        MyImageView testview = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , 0 , 100 , 100);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(150 ,
                150);

        addContentView(testview , params);

        addContentView(pen , params);
    }

    @Override
    public boolean onTouchEvent ( MotionEvent event ) {
        AdditiveAnimator.animate(pen).x(event.getX()).y(event.getY()).setDuration(1000).start();
        return true;
    }

}
