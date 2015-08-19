package com.shafaisoft.hazaragi;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.widget.ImageButton;

/**
 * Created by adamshafai on 06/08/15.
 */
public class playSdCard extends Activity
{
    private static final String MUSIC_DIR = "/music/";
    private ImageButton bak,spela, fram, bakground;

private MediaPlayer mplayer;
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playsdcard);

    bak = (ImageButton) findViewById(R.id.spela_bak);
    spela = (ImageButton) findViewById(R.id.spela);
    fram = (ImageButton) findViewById(R.id.spela_fram);
    bakground = (ImageButton) findViewById(R.id.bakgrund);


    // instance of mediaplayer
        mplayer=new MediaPlayer();

        // reading from the music directory(sdcard)
        String MusicDir=Environment.getExternalStorageDirectory()
        .getAbsolutePath()
        +MUSIC_DIR;


        //Show list of music files to choose

        Intent i = new Intent(this,ListFiles.class);
        i.putExtra("directory",MusicDir);
        startActivityForResult(i,0);

        }
}
