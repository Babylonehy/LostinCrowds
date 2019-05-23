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

import com.example.lostincrowds.Network.Update;
import com.example.lostincrowds.R;
import com.example.lostincrowds.UI.DrawLine;
import com.example.lostincrowds.UI.MyImageButton;
import com.example.lostincrowds.UI.PlayButton;
import com.example.lostincrowds.UI.Stickline;
import com.freedom.lauzy.playpauseviewlib.PlayPauseView;
import com.hanks.htextview.line.LineTextView;

import java.io.IOException;

import static com.example.lostincrowds.ConstantValue.PARAMS;
import static com.example.lostincrowds.ConstantValue.Passwords;
import static com.example.lostincrowds.ConstantValue.Username;

/**
 * The type Basic activity.
 */
public class BasicActivity extends AppCompatActivity {
    /**
     * The Mp.
     */
    MediaPlayer mp;
    /**
     * The Play start.
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

    /**
     * The Button.
     */
    private MyImageButton start;
    /**
     * The Reset.
     */
    private MyImageButton reset;


    /**
     * The Fab.
     */
    FloatingActionButton fab;

    /**
     * Get line text view line text view.
     *
     * @return the line text view
     */
    public LineTextView getLineTextView(){
        return lineTextView;
    }
    private PlayPauseView playPauseView;


    private DrawLine drawLine;
    private Stickline stickline;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        playButton = new PlayButton(this);
        super.onCreate(savedInstanceState);
        init_windows();
        setContentView(R.layout.activity_basic);
        init_music();
        init_line();
        addContentView(playButton, PARAMS);
        fabsetting();
        init_button();
        init_textview();

    }


    /**
     * Init line.
     */
    protected void init_line() {
        drawLine = findViewById(R.id.DrawLineBasic);
        drawLine.setId(View.NO_ID);
        stickline = findViewById(R.id.SticklineBasic);
        stickline.setId(View.NO_ID);
    }

    /**
     * Init button.
     */
    protected void init_button() {
        reset = findViewById(R.id.reset);
        reset.setId(View.NO_ID);
        reset.setButtonName("Reset");
        start = findViewById(R.id.start);
        start.setId(View.NO_ID);
        start.setButtonName("Simulation");
    }

    /**
     * Fabsetting.
     */
    protected void fabsetting() {
       fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    /**
     * Init windows.
     */
    protected void init_windows() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    /**
     * Init music.
     */
    protected void init_music() {
        display = getWindowManager().getDefaultDisplay();
        playButton.setPosition(display.getWidth() - 200, 100);
        mp = MediaPlayer.create(this, R.raw.bg_music);
        mp.setLooping(true);
        mp.start();
        playPauseView = playButton.getPlayPauseView();
        playPauseView.setPlaying(true);
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

    }

    /**
     * Init textview.
     *
     * @param text the text
     * @param xpos the xpos
     * @param ypos the ypos
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void init_textview(String text, float xpos, float ypos) {
        lineTextView.setVisibility(View.VISIBLE);
        init_textview();
        lineTextView.animateText(text);
        lineTextView.setX(xpos);
        lineTextView.setY(ypos);
    }

    /**
     * Init textview.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void init_textview() {
        lineTextView = findViewById(R.id.lineTextView2);
        lineTextView.setAnimationDuration(Float.POSITIVE_INFINITY);
        Typeface typeface = getResources().getFont(R.font.patrickhandregular);
        lineTextView.setTypeface(typeface);
        lineTextView.setProgress(3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }
    //Todo ADD simulation or a new class for simulation


    /**
     * Gets draw line.
     *
     * @return the draw line
     */
    public DrawLine getDrawLine() {
        return drawLine;
    }

    /**
     * Gets stickline.
     *
     * @return the stickline
     */
    public Stickline getStickline() {
        return stickline;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public MyImageButton getStart() {
        return start;
    }

    /**
     * Gets reset.
     *
     * @return the reset
     */
    public MyImageButton getReset() {
        return reset;
    }

    /**
     * Gets fab.
     *
     * @return the fab
     */
    public FloatingActionButton getFab() {
        return fab;
    }

    public void update(String level) throws IOException {
        Update user = new Update(Username, Passwords, level);
        user.run();
    }
}
