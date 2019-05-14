package com.example.lostincrowds.UI;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.lostincrowds.R;

import static com.example.lostincrowds.Network.ConstantValue.HEIGHT;
import static com.example.lostincrowds.Network.ConstantValue.WIDTH;

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
        BasicImageView basicImageView = new BasicImageView(this , 100 , 600);
        basicImageView.setBasicImageView(R.drawable.gray , R.drawable.eyesclose);
        addContentView(basicImageView , basicImageView.getLayoutParams());

        MyImageView testview = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , 100 , 600 , 50 , "S1");
        MyImageView testview2 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , 300 , 600 , 100 , "S2");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(HEIGHT ,
                WIDTH);
        addContentView(testview , params);
        testview.setPercentage(40);
        addContentView(testview2 , new LinearLayout.LayoutParams(HEIGHT , WIDTH));
        testview2.setPercentage(60);
        Log.v("Myview" , testview.equals(testview2) ? "T" : "F");
    }

}
