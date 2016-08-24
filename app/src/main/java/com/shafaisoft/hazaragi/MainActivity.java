package com.shafaisoft.hazaragi;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import static android.nfc.NdefRecord.createUri;

// testing git hub
public class MainActivity extends Activity {

    private int pos = 0;
    private ImageButton play, stop, forward, bakground, backward;
    private MediaPlayer mplayer;
    private int[] sounds = {R.raw.bahar,R.raw.bazi,R.raw.hamasaya,R.raw.pato,R.raw.shahrestani,
                            R.raw.tanha,R.raw.tobamani};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backward = (ImageButton) findViewById(R.id.backward);

        play = (ImageButton) findViewById(R.id.play);
        forward = (ImageButton) findViewById(R.id.forward);
        bakground = (ImageButton) findViewById(R.id.bakgrund);
        backward = (ImageButton) findViewById(R.id.backward);
        stop = (ImageButton) findViewById(R.id.stop);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setVisibility(View.INVISIBLE);
                soundPlay();
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if(pos ==0) {
                        forward.setEnabled(true);
                        backward.setEnabled(false);

                    }
                else {
                        soundStop();
                        pos--;
                        soundPlay();
                        Toast.makeText(MainActivity.this,"The first song",Toast.LENGTH_SHORT).show();
                        soundPlay(0);


                    }
            }
        });


        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos>=(sounds.length-1)){
                    forward.setEnabled(false);
                    backward.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Last song", Toast.LENGTH_SHORT).show();
                }
                else {
                    soundStop();
                    pos++;
                    soundPlay();

                }
            }

        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundStop();
                play.setVisibility(View.VISIBLE);

            }
        });
    }

    public void soundPlay() {
        //if(mplayer == null)

        mplayer = MediaPlayer.create(this, sounds[pos]);
        mplayer.setLooping(true);
        mplayer.start();
    }

    public void soundStop()
    {
        if(mplayer !=null && mplayer.isPlaying()) {
            mplayer.stop();
            mplayer.release();
        }
    }


    public void soundPlay(int n) {
        //if(mplayer == null)

        mplayer = MediaPlayer.create(this, sounds[pos]);
        mplayer.setLooping(true);
        mplayer.start();
    }
}
