/******************************************************************************
 * Copyright (c) 2019. Xiaorong Ma From Australian National University CECS  All Rights Reserved. FileName: HandlePuzzle.java@author: jack@date: 5/21/19 2:10 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.UI;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.lostincrowds.R;
import com.freedom.lauzy.playpauseviewlib.PlayPauseView;

import java.util.ArrayList;

import static com.example.lostincrowds.ConstantValue.HEIGHT;
import static com.example.lostincrowds.ConstantValue.WIDTH;

/**
 * The type Ui test.
 */
public class UI_test extends AppCompatActivity {
    /**
     * The Unconnectivepair.
     */
    public ArrayList<MyImageView> unconnectivepair = new ArrayList<>();
    /**
     * The List for image view.
     */
    public ArrayList<MyImageView> ListForImageView = new ArrayList<>();
    private DrawLine drawLine;
    private Stickline stickline;
    private MyImageView testImageview;
    private PlayPauseView playPauseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_ui_test);
        FloatingActionButton fab = findViewById(R.id.fab);


        drawLine = findViewById(R.id.DrawLine);
        MyImageView imageView = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 50, 50, 100, "s1");
        ListForImageView.add(imageView);

        MyImageView imageView2 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 500, 500, 50, "s2");
        ListForImageView.add(imageView2);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(HEIGHT,
                WIDTH);

        drawLine.setImageView(ListForImageView);
        MyImageView imageView3 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 800, 800, 80, "s2");
        MyImageView imageView4 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 800, 100, 80, "s2");
        MyImageView imageView5 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 300, 400, 80, "s2");

        ListForImageView.add(imageView3);
        ListForImageView.add(imageView4);
        ListForImageView.add(imageView5);
        unconnectivepair.add(imageView3);
        unconnectivepair.add(imageView2);
        stickline = findViewById(R.id.uncuttableline);
        //stickline.setUncuttable_pair(unconnectivepair);
        addContentView(imageView, params);
        addContentView(imageView2, params);
        addContentView(imageView3, params);
        addContentView(imageView4, params);
        addContentView(imageView5, params);
        testImageview = imageView3;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testImageview.setPercentage(30);
//                Snackbar.make(view , "Replace with your own action" , Snackbar.LENGTH_LONG)
//                        .setAction("Action" , null).show();
                testImageview.getImage().updatebackImageView(R.drawable.peepsred);
            }
        });
        // example for Playbutton.
        PlayButton playButton = new PlayButton(this);

        playButton.setPosition(400, 400);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bg_music);
        mp.setLooping(true);
        playPauseView = playButton.getPlayPauseView();
        playPauseView.setPlayPauseListener(new PlayPauseView.PlayPauseListener() {
            @Override
            public void play() {
                mp.start();

            }

            @Override
            public void pause() {
                // do something

                mp.pause();

            }
        });

        addContentView(playButton, params);
    }
}

