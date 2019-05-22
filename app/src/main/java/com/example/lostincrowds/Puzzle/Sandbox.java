/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Sandbox.java@author: jack@date: 18/05/19 1:59 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lostincrowds.MenuActivity;
import com.example.lostincrowds.R;
import com.example.lostincrowds.UI.MyImageButton;

/**
 * The type Sandbox.
 */
public class Sandbox extends AppCompatActivity {
    private MyImageButton myImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init_windows();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandbox);
        load(this);
        initButton();
    }

    /**
     * Init windows.
     */
    protected void init_windows() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }


    private void initButton() {
        myImageButton = findViewById(R.id.backtoMenu);
        myImageButton.setButtonName("Back to Main");
        myImageButton.setX(20);
        myImageButton.setY(20);
        myImageButton.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sandbox.this, MenuActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private void load(Context context) {
        WebView webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(false);
        webSettings.setLoadsImagesAutomatically(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl(getString(R.string.sandbox));
    }
}
