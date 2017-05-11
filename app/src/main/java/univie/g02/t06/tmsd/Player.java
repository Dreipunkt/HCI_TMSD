package univie.g02.t06.tmsd;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

import static android.R.attr.id;

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

        album_cover = (ImageView) findViewById(R.id.albumCover);
        album_cover.setImageResource(R.drawable.cover_placeholder);

        seek = (SeekBar) findViewById(R.id.seekBar);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (player != null && fromUser) {
                    player.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                if (player == null) {
                    player = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("mask_off", "raw", getPackageName()));

                    int duration = player.getDuration()/1000;
                    seek.setMax(duration);
                    player.start();

                    final Handler mHandler = new Handler();
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (player != null) {
                                int mCurrentPosition = player.getCurrentPosition() / 1000;
                                seek.setProgress(mCurrentPosition);
                                }
                                mHandler.postDelayed(this, 100);
                                }
                    });

                    String songTitle = "test";

                        songTitel.setText(songTitle);
                }
                else if (player.isPlaying()) {
                    player.pause();
                } else {
                    player.start();
                }
                break;


            case R.id.btnPrev:

                break;

            case R.id.btnNext:

                break;
        }
    }
}