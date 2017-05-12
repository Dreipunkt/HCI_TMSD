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



public class PlaylistRemActivity extends AppCompatActivity {

    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTitle("Select Playlist to Delete");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlistrem);

        listView = (ListView) findViewById(R.id.list);

        final TinyDB tinydb = new TinyDB(this);
        listItems = (tinydb.getListString("Playlist"));
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(PlaylistRemActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + listItems.get(position));
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        listItems.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                        tinydb.putListString("Playlist", listItems);
                    }
                });
                adb.show();

            }
        });
    }

    public void addClick(View v) {
        Intent intent = new Intent(getApplicationContext(), PlaylistAddActivity.class);
        intent.putExtra("listItems", listItems);
        startActivity(intent);
    }

    public void listClick(View v){
        Intent intent = new Intent(getApplicationContext(), PlaylistActivity.class);
        startActivity(intent);
    }

}
