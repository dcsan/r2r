package com.darkbot.litterator.app;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.melnykov.fab.FloatingActionButton;

import java.io.IOException;


public class MainActivity extends Activity {
    private static final String LOG_TAG = "AudioRecordManager";
    private String recordingFileLocation = null;

    public WebView litWebView;
    public FloatingActionButton fab;
    private boolean startRecording = true;
    AudioManager audioManager;

    public MainActivity() {
        recordingFileLocation = Environment.getExternalStorageDirectory().getAbsolutePath();
        recordingFileLocation += "/audiorecordtest.3gp";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = new AudioManager();

        litWebView = (WebView) findViewById(R.id.litWebView);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        litWebView.loadUrl("http://r2r.meteor.com");
        litWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        litWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = litWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startRecording){
                    audioManager.startRecording();
                    fab.setColorNormal(Color.GREEN);

                }else{
                 audioManager.stopRecording();
                    fab.setColorNormal(Color.parseColor("#ff5722"));
                }


                startRecording = !startRecording;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && litWebView.canGoBack()) {
            litWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        audioManager.releaseMedia();

    }

}
