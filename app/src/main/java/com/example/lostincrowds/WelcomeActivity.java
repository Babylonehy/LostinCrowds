package com.example.lostincrowds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import gr.net.maroulis.library.EasySplashScreen;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View easySplashScreenView = new EasySplashScreen(this)
                .withFullScreen()
                .withTargetActivity(LoginActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundResource(R.drawable.bkg2)
                .withFooterText("@Copyright 2019")
                .withBeforeLogoText("My cool company")
                .withLogo(R.drawable.simle)
                .withAfterLogoText("Some more details")
                .create();
        setContentView(easySplashScreenView);
    }
}
