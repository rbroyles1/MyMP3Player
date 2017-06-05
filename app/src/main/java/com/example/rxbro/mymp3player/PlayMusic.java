package com.example.rxbro.mymp3player;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.UnsupportedSchemeException;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class PlayMusic extends Service {

    MediaPlayer mediaPlayer;
    public static final String MESSAGE_KEY = "Message";
    public static final String PLAY = "Play";
    public static final String STOP = "Stop";

    public PlayMusic() {}


    @Override
    @Nullable
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet created...");
    }
    @Override
    public int onStartCommand(Intent intent, int flag, int startId) {
        Toast.makeText(this, "Service began...", Toast.LENGTH_SHORT).show();
        MediaPlayer mediaPlayer = getMediaPlayer();
        String message = intent.getExtras().getString(MESSAGE_KEY);
        if (message != null) {
            switch (message) {
                case PLAY:
                    mediaPlayer.start();
                    break;
                case STOP:
                    mediaPlayer.stop();
                    break;
            }
        }
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Destroy Service...", Toast.LENGTH_SHORT).show();
        mediaPlayer.release();
        mediaPlayer = null;
        super.onDestroy();
    }
    private MediaPlayer getMediaPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.swtim);
        }
        return mediaPlayer;
    }


}
