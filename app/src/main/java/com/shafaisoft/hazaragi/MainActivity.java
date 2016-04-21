package com.shafaisoft.hazaragi;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

// testing git hub
public class MainActivity extends Activity {


    private ImageButton bak, spela, fram,bakground,sdcard;
    private MediaPlayer mplayer;
    //final String MUSIC_DIR = "/music/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bak = (ImageButton) findViewById(R.id.spela_bak);
        // find the xml view by its id
        spela = (ImageButton) findViewById(R.id.spela);
        fram = (ImageButton) findViewById(R.id.spela_fram);
        bakground = (ImageButton) findViewById(R.id.bakgrund);
        Button sdcard = (Button) findViewById(R.id.button);


        sdcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "play from sd card", Toast.LENGTH_LONG).show();


                startActivities(new Intent[]{new Intent(MainActivity.this, playSdCard.class)});

            }
        });
        /*
        Intent i = new Intent(this,playSdCard.class);
        i.putExtra("directory",0);
        startActivityForResult(i, 0);
        */

        spela.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                mplayer = MediaPlayer.create(MainActivity.this, R.raw.bahar);
                mplayer.start();
                mplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()//when sound ends
                {
                    @Override
                    public void onCompletion(MediaPlayer mp)
                    {
                        mplayer.release();// Release system resources
                    }
                });


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

