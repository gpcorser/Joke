package com.example.gpcorser.joke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public Boolean isOn = false;
    public Intent intentOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, DelayedMessageService.class);
        intent.putExtra(DelayedMessageService.EXTRA_MESSAGE,
                getResources().getString(R.string.button_response));
        startService(intent);
    }

    public void onClickWomble(View view) {
        if (!isOn) {
            Intent intent = new Intent(this, WombleService.class);
            startService(intent);
            intentOn = intent;
            isOn = true;
        } else {
            stopService(new Intent(MainActivity.this, WombleService.class));
            isOn = false;
        }

    }
}
