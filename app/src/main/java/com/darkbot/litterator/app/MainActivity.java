package com.darkbot.litterator.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.melnykov.fab.FloatingActionButton;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView litWebView  = (WebView)findViewById(R.id.litWebView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        litWebView.loadUrl("http://r2r.meteor.com");
        litWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        litWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = litWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);





    }



}
