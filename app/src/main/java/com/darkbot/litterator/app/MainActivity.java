package com.darkbot.litterator.app;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.darkbot.litterator.app.math.Complex;
import com.darkbot.litterator.app.math.FFT;
import com.darkbot.litterator.app.visualizer.VisualizerView;
import com.darkbot.litterator.app.visualizer.renderer.LineRenderer;
import com.melnykov.fab.FloatingActionButton;

import java.io.IOException;


public class MainActivity extends Activity {
    private static final String LOG_TAG = "AudioRecordManager";

    public WebView litWebView;
    public FloatingActionButton fab;
    private VisualizerView visualizerView;



    private boolean startRecording = true;
    AudioRecord audioRecorder;
    AudioManager audioManager;

    int channel_config;
    int format;
    int sampleSize;
    int bufferSize;




    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = new AudioManager();
        //audioRecorder = new AudioRecord(MediaRecorder.AudioSource.MIC);

        channel_config = AudioFormat.CHANNEL_CONFIGURATION_MONO;
        format = AudioFormat.ENCODING_PCM_16BIT;
        sampleSize = 8000;
        bufferSize = AudioRecord.getMinBufferSize(sampleSize, channel_config, format);

        audioRecorder = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleSize, channel_config, format, bufferSize);


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
                    //audioManager.startRecording();
                    byte[] audioBuffer = new byte[bufferSize];

                    audioRecorder.startRecording();



                    while (startRecording){
                        audioRecorder.read(audioBuffer, 0, bufferSize);

                        //byte to double conversion
                        double[] micBufferData = new double[bufferSize];//size may need to change
                        final int bytesPerSample = 2; // As it is 16bit PCM
                        final double amplification = 1.0; // choose a number as you like
                        for (int index = 0, floatIndex = 0; index < bufferSize - bytesPerSample + 1; index += bytesPerSample, floatIndex++) {
                            double sample = 0;
                            for (int b = 0; b < bytesPerSample; b++) {
                                int v = audioData[index + b];
                                if (b < bytesPerSample - 1 || bytesPerSample == 1) {
                                    v &= 0xFF;
                                }
                                sample += v << (b * 8);
                            }
                            double sample32 = amplification * (sample / 32768.0);
                            micBufferData[floatIndex] = sample32;
                        }

                        //User converted values
                        Complex[] fftTempArray = new Complex[bufferSize];
                        for (int i=0; i<bufferSize; i++)
                        {
                            fftTempArray[i] = new Complex(audio[i], 0);
                        }
                        Complex[] fftArray = FFT.fft(fftTempArray);

                    }


                    fab.setColorNormal(Color.GREEN);

                }else{
                 audioManager.stopRecording();
                    audioRecorder.stop();
                    //visualizerView.disableVisualizer();
                    fab.setColorNormal(Color.parseColor("#ff5722"));
                }


                startRecording = !startRecording;
            }
        });




        // We need to link the visualizer view to the media player so that
        // it displays something
        //visualizerView = (VisualizerView) findViewById(R.id.visualizerView);
        //visualizerView.link(audioRecorder);

        // Start with just line renderer
        addLineRenderer();
    }

    private void addLineRenderer()
    {
        Paint linePaint = new Paint();
        linePaint.setStrokeWidth(1f);
        linePaint.setAntiAlias(true);
        linePaint.setColor(Color.argb(88, 0, 128, 255));

        Paint lineFlashPaint = new Paint();
        lineFlashPaint.setStrokeWidth(5f);
        lineFlashPaint.setAntiAlias(true);
        lineFlashPaint.setColor(Color.argb(188, 255, 255, 255));
        LineRenderer lineRenderer = new LineRenderer(linePaint, lineFlashPaint, true);
        visualizerView.addRenderer(lineRenderer);
    }


    @Override
    protected void onPause() {
        super.onPause();
        //audioManager.releaseMedia();
        audioRecorder.release();
        visualizerView.release();


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
       // audioManager.releaseMedia();
        audioRecorder.release();
        visualizerView.release();

    }

}
