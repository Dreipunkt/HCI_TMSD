package univie.g02.t06.tmsd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**

 Startseite

 **/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_playMyMusic = (Button) findViewById(R.id.btn_playMyMusic);
        btn_playMyMusic.setOnClickListener(this);

        Button btn_playlists = (Button) findViewById(R.id.btn_playlists);
        btn_playlists.setOnClickListener(this);

        Button btn_search = (Button) findViewById(R.id.btn_search);
        btn_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_playMyMusic:

                break;

            case R.id.btn_playlists:

                break;

            case R.id.btn_search:

                break;
        }
    }
}