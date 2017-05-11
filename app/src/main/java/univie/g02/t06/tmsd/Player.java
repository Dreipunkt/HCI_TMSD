package univie.g02.t06.tmsd;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by UserN1 on 08.05.17.
 */

public class Player extends Activity implements View.OnClickListener {

    private MediaPlayer player;

    private Button play;
    private Button next;
    private Button prev;

    private TextView songTitel;
    private SeekBar seek;

    private ImageView album_cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        songTitel = (TextView) findViewById(R.id.songTitel);

        play = (Button) findViewById(R.id.btnPlay);
        play.setOnClickListener(this);
        play.setText("||");

        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(this);
        next.setText(">|");


        prev = (Button) findViewById(R.id.btnPrev);
        prev.setOnClickListener(this);
        prev.setText("|<");

        seek = (SeekBar) findViewById(R.id.seekBar);

        //album_cover.setImageResource(R.raw.cover_placeholder);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                if (player == null) {
                    player = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("mask_off", "raw", getPackageName()));
                    player.start();

                    String songTitle = "test";
                    songTitel.setText(songTitle);
                }
                else if (player.isPlaying()) {
                    player.pause();
                }
                else {
                    player.start();
                }
                break;


            case R.id.btnPrev:
                //player.setDataSource();
                try {
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                player.start();
                break;

            case R.id.btnNext:
                //player.setDataSource();
                try {
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                player.start();
                break;

        }
    }

}