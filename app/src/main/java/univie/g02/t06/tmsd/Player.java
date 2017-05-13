package univie.g02.t06.tmsd;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Context;


import static univie.g02.t06.tmsd.R.id.albumCover;
import static univie.g02.t06.tmsd.R.id.timePlayed;
import static univie.g02.t06.tmsd.R.layout.activity_player;

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

    private Button search;
    private Button playlist;

    private Button play;
    private Button next;
    private Button prev;

    private TextView songTitel;
    private TextView time;
    private SeekBar seek;

    public int i = 0;
    public int j = 0;

    ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 500);

    String[] genre = new String[]{"Rock", "pop", "blues", "easy listening", "etc", "pp", "usw"};

    private ImageView album_cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(activity_player);

        songTitel = (TextView) findViewById(R.id.songTitel);

        time = (TextView) findViewById(timePlayed);

        search = (Button) findViewById(R.id.btnSearch);
        search.setOnClickListener(this);

        playlist = (Button) findViewById(R.id.btnPlaylist);
        playlist.setOnClickListener(this);

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
        View v = new View(this);
        album_cover.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                Toast.makeText(getApplicationContext(), "Generiere Playlist", Toast.LENGTH_SHORT).show();
                j = (++j % 6);    i = 1;
                songTitel.setText(genre[j] + Integer.toString(i));
                toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,150);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnPlay:
                if (player == null) {
                    player = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("epic", "raw", getPackageName()));

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

                    String songTitle = "Epic Sax Guy";

                    songTitel.setText(songTitle);
                }
                else if (player.isPlaying()) {
                    player.pause();
                } else {
                    player.start();
                }
                break;


            case R.id.btnPrev:
                if (i > 1) {  i--; songTitel.setText(genre[j] + Integer.toString(i)); }
                if (player != null) {
                    player.seekTo(0);
                    player.stop();
                }
                toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,150);

                break;

            case R.id.btnNext:
                i++; songTitel.setText(genre[j] + Integer.toString(i));
                if (player != null) {
                    player.seekTo(0);
                    player.stop();
                }
                toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,150);

                break;

            case R.id.btnPlaylist:
                intent = new Intent(getApplicationContext(), PlaylistActivity.class);
                startActivity(intent);
                break;

            case R.id.btnSearch:
                intent = new Intent(this, Search.class);
                startActivity(intent);
                break;
        }
    }
}