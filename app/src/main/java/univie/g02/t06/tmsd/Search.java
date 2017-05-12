package univie.g02.t06.tmsd;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

import univie.g02.t06.tmsd.dummydata.DummyAPIData;
import univie.g02.t06.tmsd.dummydata.DummySong;
import univie.g02.t06.tmsd.MyAdapter;

public class Search extends AppCompatActivity {

    ListView listV;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<DummySong> listSongs = new ArrayList<DummySong>();
    MyAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listV = (ListView) findViewById(R.id.list_view);
        final EditText editText = (EditText) findViewById(R.id.search_edit);

        listSongs = DummyAPIData.getAllDummySongs();
        for (int i = 0; i < listSongs.size(); i++) {
            listItems.add(listSongs.get(i).getDummyArtistTitle());
            titles.add(listSongs.get(i).getDummyTitle());
        }
        adapter = new MyAdapter(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listV.setAdapter(adapter);

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                //String text = editText.getText().toString().toLowerCase(Locale.getDefault());
                //adapter.filter(text);
                //listV.setAdapter(adapter);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                int textlength = cs.length();
                ArrayList<String> tempArrayList = new ArrayList<String>();
                for(String c: listItems){
                    if (textlength <= c.length()) {
                        if (c.toLowerCase().contains(cs.toString().toLowerCase())) {
                            tempArrayList.add(c);
                        }
                    }
                }
                adapter = new MyAdapter(context,
                        R.layout.customlayout,
                        tempArrayList);
                listV.setAdapter(adapter);
            }
        });

    }

}
