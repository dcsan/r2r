package com.darkbot.litterator.app;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.melnykov.fab.FloatingActionButton;

import java.io.IOException;


public class MainActivity extends Activity {
    private static final String LOG_TAG = "AudioRecordTest";
    private String mFileName = null;

    public WebView litWebView;
    private MediaRecorder mRecorder = null;
    private boolean startRecording = true;

    public MainActivity() {
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/audiorecordtest.3gp";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        litWebView = (WebView) findViewById(R.id.litWebView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        litWebView.loadUrl("http://r2r.meteor.com");
        litWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        litWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = litWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startRecording) {
                    mRecorder = new MediaRecorder();
                    mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    mRecorder.setOutputFile(mFileName);
                    mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    //TODO Decide on color changes while recording
                    try {
                        mRecorder.prepare();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "prepare() failed");
                    }

                    mRecorder.start();


                } else {
                    mRecorder.stop();
                    mRecorder.release();
                    mRecorder = null;
                }
                startRecording = !startRecording;
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }
    }

}
