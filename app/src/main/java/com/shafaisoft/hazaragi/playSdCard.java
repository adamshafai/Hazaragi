package com.shafaisoft.hazaragi;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by adamshafai on 06/08/15.
 */
public class playSdCard extends Activity
{
    private static final String MUSIC_DIR = "/music/";
    private ImageButton bak,spela, fram, bakground, Home;

    private MediaPlayer mplayer;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playsdcard);

    bak = (ImageButton) findViewById(R.id.spela_bak);
    spela = (ImageButton) findViewById(R.id.spela);
    fram = (ImageButton) findViewById(R.id.spela_fram);
    bakground = (ImageButton) findViewById(R.id.bakgrund);
    /*
    Home.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
        }
    });
    //Button Home = (Button) findViewById(R.layout.activity_main);

     instance of mediaplayer
     */
        mplayer = new MediaPlayer();

        // reading from the music directory(sdcard)
        String MusicDir = Environment.getExternalStorageDirectory()
        .getAbsolutePath()
        +MUSIC_DIR;


        //Show list of music files to choose

        Intent i = new Intent(this,ListFiles.class);
        i.putExtra("directory",MusicDir);
        startActivityForResult(i,0);

        }
}
