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
    public ArrayList<float[]> listforposition=new ArrayList<>();
    private DrawLine drawLine;
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

        drawLine=findViewById(R.id.DrawLine);

        BasicImageView testview = new BasicImageView( this,100, 100);
        testview.setBasicImageView(R.drawable.gray,R.drawable.eyesclose);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(HEIGHT ,
                WIDTH);
        float []  postion={100,100};
        listforposition.add(postion);
        BasicImageView testview2=new BasicImageView(this,700,700);
        testview2.setBasicImageView(R.drawable.gray,R.drawable.eyesclose);
        float []  postion2={700,700};
        listforposition.add(postion2);
        drawLine.setpositionlist(listforposition);
        addContentView(testview , params);
        addContentView(testview2, params);
        addContentView(pen , params);

    }

    public ArrayList getListforposition() {
        return listforposition;
    }
}
