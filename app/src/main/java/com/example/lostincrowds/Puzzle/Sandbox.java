/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Sandbox.java@author: jack@date: 18/05/19 1:59 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lostincrowds.R;

public class Sandbox extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        init_windows();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sandbox);
        load(this);
    }
    protected void init_windows () {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    private void load(Context context){
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
            public boolean shouldOverrideUrlLoading ( WebView view , String url ) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl(getString(R.string.sandbox));
    }

}
