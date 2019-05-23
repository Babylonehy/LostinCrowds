/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: MenuActivity.java@author: jack@date: 19-5-22 上午3:01@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.lostincrowds.Puzzle.Level1;
import com.example.lostincrowds.Puzzle.Level2;
import com.example.lostincrowds.Puzzle.Level3;
import com.example.lostincrowds.Puzzle.Sandbox;
import com.example.lostincrowds.UI.Introduce;
import com.example.lostincrowds.UI.MyImageButton;

/**
 * The type Menu activity.
 */
public class MenuActivity extends AppCompatActivity {
    private Display display;
    private Context mcontext;
    private MediaPlayer mp;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        String LoginMessage = intent.getStringExtra("MessageFromLogin");
        level = intent.getIntExtra("LevelFromLogin",-1);
        Toast.makeText(this , LoginMessage + " Level:" + level , Toast.LENGTH_LONG).show();

        MyImageButton newgame=findViewById(R.id.button);
        newgame.setButtonName("NEW GAME");
        MyImageButton conti=findViewById(R.id.button3);
        conti.setButtonName("CONTINUE");
        MyImageButton sandbox=findViewById(R.id.sandbox);
        sandbox.setButtonName("SANDBOX");
        MyImageButton levelboard=findViewById(R.id.button5);
        levelboard.setButtonName("LEVELBOARD");
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.bkg);
        this.getWindow().setBackgroundDrawable(drawable);
        display = getWindowManager().getDefaultDisplay();
        newgame.setPosition(display.getWidth()/3,display.getHeight()/8);
        conti.setPosition(display.getWidth()/3,display.getHeight()/8*2);
        sandbox.setPosition(display.getWidth()/3,display.getHeight()/8*3);
        levelboard.setPosition(display.getWidth()/3,display.getHeight()/8*4);
        mcontext = getApplicationContext();
        MyImageButton help=findViewById(R.id.help);
        help.setButtonName("HELP");
        help.setPosition(display.getWidth()/3,display.getHeight()/8*5);

        newgame.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, Level1.class);
                finish();
                startActivity(intent);
                mp.release();

            }
        });
        sandbox.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, Sandbox.class);
                finish();
                startActivity(intent);
                mp.release();
            }
        });

        levelboard.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, LevelBoard.class);
                startActivity(intent);

            }
        });
        help.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, Introduce.class);
                startActivity(intent);
            }
        });

        conti.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (level){
                    case 1:
                        intent=new Intent(mcontext, Level1.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        intent=new Intent(mcontext, Level2.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 3:
                        intent=new Intent(mcontext, Level3.class);
                        startActivity(intent);
                        finish();
                        break;
                     default:
                         intent=new Intent(mcontext, Level1.class);
                         startActivity(intent);
                         finish();
                         break;
                }

            }
        });
        mp = MediaPlayer.create(this , R.raw.bg_music);
        mp.setLooping(true);
        mp.start();

    }
    private boolean mIsExit;

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mIsExit) {
                this.finish();

            } else {
                Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
                mIsExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit = false;
                    }
                }, 2000);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
