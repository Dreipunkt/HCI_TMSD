package univie.g02.t06.tmsd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;
import univie.g02.t06.tmsd.dummydata.DummyAPIData;
import univie.g02.t06.tmsd.dummydata.DummySong;

public class Search extends AppCompatActivity {

    ListView listV;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<DummySong> listSongs = new ArrayList<DummySong>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listV = (ListView) findViewById(R.id.list_view);
        SearchView searchView = (SearchView) findViewById(R.id.search_view);

        listSongs = DummyAPIData.getAllDummySongs();
        for(int i = 0; i < listSongs.size(); i++){
            listItems.add(listSongs.get(i).getDummyArtistTitle());
            titles.add(listSongs.get(i).getDummyTitle());
        }
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listV.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                listV.setAdapter(adapter);
                return false;
            }

            public void callSearch(String query) {

            }

        });

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String Title = titles.get(position);
                Intent intent = new Intent(getApplicationContext(), Player.class);
                intent.putExtra("SongId", Title);
                startActivity(intent);
            }
        });
    }
}
