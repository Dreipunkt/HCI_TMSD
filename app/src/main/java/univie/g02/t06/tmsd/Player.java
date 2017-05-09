package univie.g02.t06.tmsd;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by UserN1 on 08.05.17.
 */

public class Player extends Activity implements View.OnClickListener {

    MediaPlayer player;

    private Button play;
    private Button next;
    private Button prev;

    private TextView songTitel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        songTitel = (TextView) findViewById(R.id.songTitel);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);

        play = (Button) findViewById(R.id.btnPlay);
        play.setOnClickListener(this);
        play.setText("||");

        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(this);
        next.setText(">|");


        prev = (Button) findViewById(R.id.btnPrev);
        prev.setOnClickListener(this);
        prev.setText("<|");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                if (player.isPlaying()) {
                    player.pause();
                }
                else {
                    player.reset();
                    //player.setDataSource();
                    try {
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.start();

                    String songTitle = "test";
                    songTitel.setText(songTitle);
                }
                break;
            case R.id.btnPrev:

                break;
            case R.id.btnNext:

                break;
        }

    }

}