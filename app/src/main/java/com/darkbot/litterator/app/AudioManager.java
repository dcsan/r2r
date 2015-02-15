package com.darkbot.litterator.app;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Fabled on 2/8/15.
 */
public class AudioManager {
    private static final String LOG_TAG = "AudioRecordManager";

    private String recordingFileLocation = null;
    private MediaRecorder mediaRecorder = null;
    private MediaPlayer mediaPlayer = null;



    public AudioManager(){
        recordingFileLocation = Environment.getExternalStorageDirectory().getAbsolutePath();
        recordingFileLocation += "/audiorecordtest.3gp";

    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void startRecording(){

            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(recordingFileLocation);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            //TODO Decide on color changes while recording
            try {
                mediaRecorder.prepare();
            } catch (IOException e) {
                Log.e(LOG_TAG, "prepare() failed");
            }

            mediaRecorder.start();

    }

    public void stopRecording(){
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;

    }

    public MediaPlayer startPlaying(){
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(recordingFileLocation);
            mediaPlayer.prepare();
            mediaPlayer.start();
            return mediaPlayer;
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        return mediaPlayer;

    }

    public void stopPlaying(){
        mediaPlayer.release();
        mediaPlayer = null;

    }

    public void releaseMedia(){
        if (mediaRecorder != null) {
            mediaRecorder.release();
            mediaRecorder = null;
        }
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
