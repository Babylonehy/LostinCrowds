package com.example.lostincrowds.UI;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.lostincrowds.R;
import com.freedom.lauzy.playpauseviewlib.PlayPauseView;

public class PlayButton extends ConstraintLayout {

    private PlayPauseView playPauseView;
    private float xpos;
    private float ypos;

    public PlayButton ( Context context ) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.playbutton , this);
        playPauseView = findViewById(R.id.play_pause_view);
        playPauseView.setId(View.NO_ID);

//        playPauseView.setPlayPauseListener(new PlayPauseView.PlayPauseListener() {
//            @Override
//            public void play() {
//
//            }
//
//            @Override
//            public void pause() {
//                // do something
//
//            }
//        });
    }

    public PlayButton ( Context context , AttributeSet attrs ) {
        super(context , attrs);
    }

    public PlayPauseView getPlayPauseView () {
        return playPauseView;
    }

    public void pause () {
        playPauseView.pause();
    }

    public void play () {
        playPauseView.play();
    }

    public boolean isPlaying () {
        return playPauseView.isPlaying();
    }

    public void setPosition ( float xpos , float ypos ) {
        this.xpos = xpos;
        this.ypos = ypos;
        setX(xpos);
        setY(ypos);
    }
}
