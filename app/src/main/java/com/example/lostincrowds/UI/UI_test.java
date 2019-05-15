package com.example.lostincrowds.UI;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lostincrowds.R;

import java.util.ArrayList;

import mehdi.sakout.fancybuttons.FancyButton;

import static com.example.lostincrowds.ConstantValue.HEIGHT;
import static com.example.lostincrowds.ConstantValue.WIDTH;

public class UI_test extends AppCompatActivity {
    public ArrayList<MyImageView> unconnectivepair = new ArrayList<>();
    public ArrayList<MyImageView> ListForImageView = new ArrayList<>();
    private DrawLine drawLine;
    private Uncuttableline uncuttableline;
    private MyImageView testImageview;
    private MediaPlayer mp = new MediaPlayer();
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_ui_test);
        FloatingActionButton fab = findViewById(R.id.fab);

        play = (Button) findViewById(R.id.button);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bg_music);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        drawLine = findViewById(R.id.DrawLine);
        MyImageView imageView = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 50, 50, 100, "s1");
        ListForImageView.add(imageView);

        MyImageView imageView2 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 500, 500, 50, "s2");
        ListForImageView.add(imageView2);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(HEIGHT,
                WIDTH);

        drawLine.setImageView(ListForImageView);
        MyImageView imageView3 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 800, 600, 80, "s2");
        ListForImageView.add(imageView3);
        unconnectivepair.add(imageView3);
        unconnectivepair.add(imageView2);
        uncuttableline = findViewById(R.id.uncuttableline);
        uncuttableline.setUncuttable_pair(unconnectivepair);
        addContentView(imageView, params);
        addContentView(imageView2, params);
        addContentView(imageView3, params);
        testImageview = imageView3;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testImageview.setPercentage(testImageview.getPercentage() - 1);
//                Snackbar.make(view , "Replace with your own action" , Snackbar.LENGTH_LONG)
//                        .setAction("Action" , null).show();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }


}

