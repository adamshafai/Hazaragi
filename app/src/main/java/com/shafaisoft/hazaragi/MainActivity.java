package com.shafaisoft.hazaragi;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    private ImageButton bak, spela, fram,bakground;
    private MediaPlayer mplayer;
    final String MUSIC_DIR = "/music/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bak = (ImageButton) findViewById(R.id.spela_bak);
        spela = (ImageButton) findViewById(R.id.spela);
        fram = (ImageButton) findViewById(R.id.spela_fram);
        bakground = (ImageButton) findViewById(R.id.bakgrund);



        mplayer = MediaPlayer.create(MainActivity.this, R.raw.bahar);



        spela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mplayer.start();


            }

        });

        bak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mplayer.stop();
            }
        });



        fram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mplayer.pause();
            }

        });



    }



}

