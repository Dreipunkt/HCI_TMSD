package univie.g02.t06.tmsd;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import univie.g02.t06.tmsd.subsetdata.SubsetData;
import univie.g02.t06.tmsd.subsetdata.SubsetSong;

public class Search extends AppCompatActivity {

    ListView listV;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<SubsetSong> tempArrayList = new ArrayList<>();;
    MyAdapter adapter;
    Context context;
    SubsetData data;
    EditText editText;

    public Search() throws Exception {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Search");
        listV = (ListView) findViewById(R.id.list_view);
        editText = (EditText) findViewById(R.id.search_edit);
        new MyTask().execute();
    }

    private class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                data = new SubsetData();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {

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
                    tempArrayList = data.findSongsbyArtistTitle(cs.toString().toLowerCase());
                    for (SubsetSong x: tempArrayList){
                        titles.add(x.getArtistTitle());
                    }
                    adapter = new MyAdapter(context,
                            R.layout.customlayout,
                            titles, tempArrayList);
                    listV.setAdapter(adapter);
                }
            });
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

}
