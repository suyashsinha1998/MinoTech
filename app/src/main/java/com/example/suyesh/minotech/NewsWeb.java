package com.example.suyesh.minotech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class NewsWeb extends AppCompatActivity {

    WebView web ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_web);

        web=(WebView)findViewById(R.id.wvNews);
        String url=getIntent().getExtras().getString("url");
        web.loadUrl(url);
    }
}
