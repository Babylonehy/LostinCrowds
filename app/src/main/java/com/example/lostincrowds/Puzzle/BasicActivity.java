/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: BasicActivity.java@author: jack@date: 18/05/19 1:51 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.lostincrowds.R;
import com.example.lostincrowds.UI.DrawLine;
import com.example.lostincrowds.UI.PlayButton;
import com.example.lostincrowds.UI.Stickline;
import com.freedom.lauzy.playpauseviewlib.PlayPauseView;
import com.hanks.htextview.line.LineTextView;

import static com.example.lostincrowds.ConstantValue.PARAMS;

/**
 * The type Basic activity.
 */
public class BasicActivity extends AppCompatActivity {
    MediaPlayer mp;
    /**
     * The Play button.
     */
    PlayButton playButton;
    /**
     * The Display.
     */
    Display display;
    /**
     * The Line text view.
     */
    LineTextView lineTextView;

    public Button getButton() {
        return button;
    }

    /**
     * The Button.
     */
    Button button;

    public Button getButton2() {
        return button2;
    }

    Button button2;
    private PlayPauseView playPauseView;

    public DrawLine getDrawLine() {
        return drawLine;
    }

    public Stickline getStickline() {
        return stickline;
    }

    private DrawLine drawLine;
    private Stickline stickline;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        playButton = new PlayButton(this);
        super.onCreate(savedInstanceState);
        init_windows();
        setContentView(R.layout.activity_basic);
        init_music();
        init_line();
        init_button();
        addContentView(playButton , PARAMS);
        fabsetting();

    }


    protected void init_line () {
        drawLine = findViewById(R.id.DrawLineBasic);
        drawLine.setId(View.NO_ID);
        stickline = findViewById(R.id.SticklineBasic);
        stickline.setId(View.NO_ID);
    }

    protected void init_button () {
        button2=findViewById(R.id.start2);
        button2.setId(View.NO_ID);
        button = findViewById(R.id.start);
        button.setId(View.NO_ID);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {

            }
        });
    }

    protected void fabsetting () {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View view ) {

            }
        });
    }

    protected void init_windows () {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    protected void init_music () {
        display = getWindowManager().getDefaultDisplay();
        playButton.setPosition(display.getWidth() - 200 , 100);
        mp = MediaPlayer.create(this , R.raw.bg_music);
        mp.setLooping(true);
        mp.start();
        playPauseView = playButton.getPlayPauseView();
        playPauseView.setPlaying(true);
        playPauseView.setPlayPauseListener(new PlayPauseView.PlayPauseListener() {
            @Override
            public void play () {
                mp.start();
            }

            @Override
            public void pause () {
                // do something
                mp.pause();
            }
        });

    }

    /**
     * Init textview.
     *
     * @param text the text
     * @param xpos the xpos
     * @param ypos the ypos
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void init_textview ( String text , float xpos , float ypos ) {
        lineTextView.setVisibility(View.VISIBLE);
        init_textview();
        lineTextView.animateText(text);
        lineTextView.setX(xpos);
        lineTextView.setY(ypos);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void init_textview () {
        lineTextView.setVisibility(View.INVISIBLE);
        lineTextView = findViewById(R.id.lineTextView2);
        lineTextView.setAnimationDuration(Float.POSITIVE_INFINITY);
        Typeface typeface = getResources().getFont(R.font.patrickhandregular);
        lineTextView.setTypeface(typeface);
        lineTextView.setProgress(-1);
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        mp.release();
    }
    //Todo ADD simulation or a new class for simulation
}
