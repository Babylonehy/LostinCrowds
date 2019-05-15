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
    private Uncuttableline uncuttableline;
    private MyImageView testImageview;
    private PlayPauseView playPauseView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_ui_test);
        FloatingActionButton fab = findViewById(R.id.fab);


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
        uncuttableline = findViewById(R.id.uncuttableline);
        uncuttableline.setUncuttable_pair(unconnectivepair);
        addContentView(imageView , params);
        addContentView(imageView2 , params);
        addContentView(imageView3 , params);
        testImageview = imageView3;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View view ) {
                testImageview.setPercentage(30);
//                Snackbar.make(view , "Replace with your own action" , Snackbar.LENGTH_LONG)
//                        .setAction("Action" , null).show();
                testImageview.getImage().updatebackImageView(R.drawable.peepsred);
            }
        });
        // example for Playbutton.
        PlayButton playButton = new PlayButton(this);
//        playButton.getPlayPauseView().setPlayPauseListener(new PlayPauseView.PlayPauseListener() {
//            @Override
//            public void play () {
//
//            }
//
//            @Override
//            public void pause () {
//
//            }
//        });
        playButton.setPosition(400 , 400);
        final MediaPlayer mp =MediaPlayer.create(this, R.raw.bg_music);
        mp.setLooping(true);
        playPauseView=playButton.getPlayPauseView();
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

        addContentView(playButton , params);
    }
}

