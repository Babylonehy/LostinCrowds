package com.example.lostincrowds.Music;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import com.example.lostincrowds.R;

import java.io.IOException;

public class Music extends MediaPlayer {

    public Music ( String filename ) throws IOException {
        setDataSource(filename);
        setLooping(true);
    }

    @Override
    public void start () throws IllegalStateException {
        super.start();
    }

    @Override
    public boolean isPlaying () {
        return super.isPlaying();
    }
}
