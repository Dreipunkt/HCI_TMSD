package univie.g02.t06.tmsd;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Context;


import static univie.g02.t06.tmsd.R.id.albumCover;
import static univie.g02.t06.tmsd.R.id.imageView;
import static univie.g02.t06.tmsd.R.id.timePlayed;

/**
 * Created by UserN1 on 08.05.17.
 * Info: Per Intend String Array übergeben mit dem filenamen in lower case Buchstaben (String.toLowerCase() und ohne Endung)
 * Die Datei muss sich im RAW Ordner befinden!
 */

public class Player extends Activity implements View.OnClickListener {

    //Intent intent = getIntent();
    //String songName = intent.getStringExtra("SONGTITEL");

    //notificationIntent.putExtra("SONGTITEL", name);
    //String[] songTitel = notificationIntent.getStringArrayExtra("SONGTITEL");

    private MediaPlayer player;
    private OnSwipeTouchListener swipe;

    private Button play;
    private Button next;
    private Button prev;

    private TextView songTitel;
    private TextView time;
    private SeekBar seek;

    private ImageView album_cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        songTitel = (TextView) findViewById(R.id.songTitel);

        time = (TextView) findViewById(timePlayed);

        play = (Button) findViewById(R.id.btnPlay);
        play.setOnClickListener(this);
        play.setText("||");

        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(this);
        next.setText(">|");


        prev = (Button) findViewById(R.id.btnPrev);
        prev.setOnClickListener(this);
        prev.setText("|<");

        album_cover = (ImageView) findViewById(albumCover);
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
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }

        });
    }

    /*
    Player.setOnTouchListener(new OnSwipeTouchListener(Activity.this) {
        public void onSwipeRight() {
            Toast.makeText(Player.this, "right", Toast.LENGTH_SHORT).show();
        }
        public void onSwipeLeft() {
            Toast.makeText(Player.this, "left", Toast.LENGTH_SHORT).show();
        }
    });
    */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                if (player == null) {
                    player = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("mask_off", "raw", getPackageName()));

                    seek.setMax(player.getDuration()/1000);
                    player.start();

                    final Handler mHandler = new Handler();
                    this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (player != null) {
                                int position = player.getCurrentPosition() / 1000;
                                seek.setProgress(position);

                                int min = (position % 3600) / 60;
                                int sec = position % 60;
                                String timePlayed = String.format("%02d:%02d", min, sec);

                                time.setText(timePlayed);
                                }
                                mHandler.postDelayed(this, 250);
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

