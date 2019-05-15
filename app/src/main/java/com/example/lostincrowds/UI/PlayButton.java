package com.example.lostincrowds.UI;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.example.lostincrowds.R;
import com.freedom.lauzy.playpauseviewlib.PlayPauseView;

/**
 * The type Play button.
 */
public class PlayButton extends ConstraintLayout {

    private PlayPauseView playPauseView;
    private float xpos;
    private float ypos;

    /**
     * Instantiates a new Play button.
     *
     * @param context the context
     */
    public PlayButton ( Context context ) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.playbutton , this);
        playPauseView = findViewById(R.id.play_pause_view);
        playPauseView.setId(View.NO_ID);

    }

    /**
     * Instantiates a new Play button.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public PlayButton ( Context context , AttributeSet attrs ) {
        super(context , attrs);
    }

    /**
     * Gets play pause view.
     *
     * @return the play pause view
     */
    public PlayPauseView getPlayPauseView () {
        return playPauseView;
    }

    /**
     * Pause.
     */
    public void pause () {
        playPauseView.pause();
    }

    /**
     * Play.
     */
    public void play () {
        playPauseView.play();
    }

    /**
     * Is playing boolean.
     *
     * @return the boolean
     */
    public boolean isPlaying () {
        return playPauseView.isPlaying();
    }

    /**
     * Sets position.
     *
     * @param xpos the xpos
     * @param ypos the ypos
     */
    public void setPosition ( float xpos , float ypos ) {
        this.xpos = xpos;
        this.ypos = ypos;
        setX(xpos);
        setY(ypos);
    }
}
