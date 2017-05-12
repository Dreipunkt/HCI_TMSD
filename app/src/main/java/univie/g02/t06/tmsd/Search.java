package univie.g02.t06.tmsd;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

import univie.g02.t06.tmsd.dataset.DataManagement;
import univie.g02.t06.tmsd.dataset.Song;
import univie.g02.t06.tmsd.MyAdapter;

public class Search extends AppCompatActivity {

    ListView listV;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<Song> tempArrayList = new ArrayList<Song>();;
    MyAdapter adapter;
    Context context;
    DataManagement data = new DataManagement();

    public Search() throws Exception {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Search");
        listV = (ListView) findViewById(R.id.list_view);
        final EditText editText = (EditText) findViewById(R.id.search_edit);

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                tempArrayList.clear();
                titles.clear();
                tempArrayList = data.findSongsByTitle(cs.toString().toLowerCase());
                for (Song x: tempArrayList){
                    titles.add(x.getSongName());
                }
                adapter = new MyAdapter(context,
                        R.layout.customlayout,
                        titles);
                listV.setAdapter(adapter);
            }
        });

    }

}
