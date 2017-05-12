package univie.g02.t06.tmsd;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import univie.g02.t06.tmsd.subsetdata.SubsetSong;



public class PlaylistSongsActivity extends AppCompatActivity {

    ArrayList<SubsetSong> listSongs = new ArrayList<>();
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlistsongs);

        listView = (ListView) findViewById(R.id.song_ListView);

        final String PlaylistName = getIntent().getStringExtra("PlaylistName");
        setTitle("Playlist: " + PlaylistName);
        final TinyDB tinydb = new TinyDB(this);
        listSongs = (tinydb.getListSubsetSong(PlaylistName));

        for(int i = 0; i < listSongs.size(); i++){
            listItems.add(listSongs.get(i).getSubsetArtistTitle());
        }

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, final int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(PlaylistSongsActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + listItems.get(position));
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        listItems.remove(positionToRemove);
                        listSongs.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                        tinydb.putListSubsetSong(PlaylistName, listSongs);
                    }
                });
                adb.show();
            }
        });

        String nameText = (String) getIntent().getStringExtra("nameText");
        if (nameText != null){
            adapter.add(nameText);
            tinydb.putListString("Playlist", listItems);
        }
    }

    public void addClick(View v) {
        Intent intent = new Intent(getApplicationContext(), PlaylistAddActivity.class);
        intent.putExtra("listItems", listItems);
        startActivity(intent);
    }

    public void removeClick(View v){
        Intent intent = new Intent(getApplicationContext(), PlaylistRemActivity.class);
        startActivity(intent);
    }

}
