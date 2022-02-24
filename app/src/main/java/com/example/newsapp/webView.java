package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class webView extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity);

        toolbar = findViewById(R.id.toolbarview);
        setSupportActionBar(toolbar);
        webView = findViewById(R.id.webview);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        webView.loadUrl(url);


    }
}
