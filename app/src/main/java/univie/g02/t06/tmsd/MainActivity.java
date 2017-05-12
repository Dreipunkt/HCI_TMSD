package univie.g02.t06.tmsd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_playMyMusic:
                intent = new Intent(getApplicationContext(), Player.class);
                startActivity(intent);
                break;

            case R.id.btn_playlists:
                intent = new Intent(getApplicationContext(), PlaylistActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_search:
                intent = new Intent(this, Search.class);
                startActivity(intent);
                break;
        }
    }
}