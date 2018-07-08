package com.example.android.mediaplayerapp;

import android.content.ContentResolver;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.play_button);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.night_and_day_1);
        playButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  mediaPlayer.start();
              }
          }
        );

        Button pauseButton = (Button) findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast toast = Toast.makeText(MainActivity.this, "I'm done!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
