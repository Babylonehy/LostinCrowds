/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Sandbox.java
 ******************************************************************************/

package com.example.lostincrowds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Sandbox extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandbox);
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
        webview.loadUrl("com/example/lostincrowds/UI/The Wisdom and_or Madness of Crowds.html");


    }
}
