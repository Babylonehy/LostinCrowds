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

import java.util.ArrayList;

import at.wirecube.additiveanimations.additive_animator.AdditiveAnimator;

import static com.example.lostincrowds.Network.ConstantValue.HEIGHT;
import static com.example.lostincrowds.Network.ConstantValue.WIDTH;

public class UI_test extends AppCompatActivity {
    Pencil pen = null;
    public ArrayList<MyImageView> unconnectivepair = new ArrayList<>();
    public ArrayList<MyImageView> ListForImageView = new ArrayList<>();
    private DrawLine drawLine;
    private Uncuttableline uncuttableline;

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

        drawLine = findViewById(R.id.DrawLine);
        MyImageView imageView = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , 50 , 50 , 100 , "s1");
        ListForImageView.add(imageView);

        MyImageView imageView2 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , 500 , 500 , 50 , "s2");
        ListForImageView.add(imageView2);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(HEIGHT ,
                WIDTH);

        drawLine.setImageView(ListForImageView);
        MyImageView imageView3 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , 800 , 800 , 80 , "s2");

        unconnectivepair.add(imageView3);
        unconnectivepair.add(imageView2);
        uncuttableline=findViewById(R.id.uncuttableline);
        uncuttableline.setUncuttable_pair(unconnectivepair);
        addContentView(imageView , params);
        addContentView(imageView2 , params);
        addContentView(imageView3 , params);


    }

}
