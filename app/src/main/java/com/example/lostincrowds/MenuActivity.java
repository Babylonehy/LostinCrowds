/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: MenuActivity.java@author: jack@date: 19-5-22 上午3:01@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.lostincrowds.Puzzle.Level1;
import com.example.lostincrowds.Puzzle.Sandbox;
import com.example.lostincrowds.UI.MyImageButton;

import java.util.logging.Level;

/**
 * The type Menu activity.
 */
public class MenuActivity extends AppCompatActivity {
    private Display display;
    private Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
        newgame.setPosition(display.getWidth()/3,display.getHeight()/8*2);
        conti.setPosition(display.getWidth()/3,display.getHeight()/8*3);
        sandbox.setPosition(display.getWidth()/3,display.getHeight()/8*4);
        levelboard.setPosition(display.getWidth()/3,display.getHeight()/8*5);
        mcontext = getApplicationContext();

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, Level1.class);
                finish();
                startActivity(intent);

            }
        });
        sandbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, Sandbox.class);
                finish();
                startActivity(intent);
            }
        });

        levelboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, LevelBoard.class);
                finish();
                startActivity(intent);

            }
        });


    }
    private boolean mIsExit;
    @Override
    /**
     * 双击返回键退出
     */
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
