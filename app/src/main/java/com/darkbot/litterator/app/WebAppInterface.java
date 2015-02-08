package com.darkbot.litterator.app;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Fabled on 2/7/15.
 */
public class WebAppInterface {
    Context mContext;


    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showAudioWaveform(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showRecordingButton(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void hideAudioWaveform(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void hideRecordingButton(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void annotateAudioWaveform(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

}
