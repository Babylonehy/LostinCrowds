package com.example.lostincrowds.UI;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lostincrowds.R;

import java.util.ArrayList;
import java.util.List;

public class UI_test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        BasicImgineView basicImgineView=new BasicImgineView(this);
        basicImgineView.setBasicImageView(R.drawable.gray,R.drawable.eyesclose,0,0);
        DrawLine drawLine=new DrawLine(this);
        this.addContentView(basicImgineView.getImageView(),new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT));
        ArrayList list =drawLine.list;
        System.out.println(list);
    }

}
