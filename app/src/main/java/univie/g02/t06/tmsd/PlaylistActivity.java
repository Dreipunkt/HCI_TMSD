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


public class PlaylistActivity extends AppCompatActivity {

    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        listView = (ListView) findViewById(R.id.list);

        final TinyDB tinydb = new TinyDB(this);
        listItems = (tinydb.getListString("Playlist"));
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(adapter);

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
