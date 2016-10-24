package com.example.gpcorser.joke;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;


public class WombleService extends IntentService {

    public MediaPlayer mp;

    public WombleService() {
        super("WombleService");
    }

    @Override
    protected void onHandleIntent (Intent intent) {
        MediaPlayer mediaPlayer =
                MediaPlayer.create(getApplicationContext(), R.raw.wombling_song);
        mediaPlayer.start();
        mp = mediaPlayer;
    }
    @Override
    public void onDestroy() {
        // kill the music after 10
        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mp.stop();
        mp.release();
    }
}
