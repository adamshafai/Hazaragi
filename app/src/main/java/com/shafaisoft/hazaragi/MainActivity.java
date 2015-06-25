package com.shafaisoft.hazaragi;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button bak, spela, fram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bak = (Button) findViewById(R.id.spela_bak);
        spela = (Button) findViewById(R.id.spela);
        fram = (Button) findViewById(R.id.spela_fram);


        final MediaPlayer sound = MediaPlayer.create(MainActivity.this, R.raw.music);

        bak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.stop();
            }
        });

        spela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.start();
            }

        });

        fram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.pause();
            }

        });

    }
}
