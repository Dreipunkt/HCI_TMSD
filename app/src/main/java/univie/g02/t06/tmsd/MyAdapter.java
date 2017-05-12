package univie.g02.t06.tmsd;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import univie.g02.t06.tmsd.subsetdata.SubsetSong;


public class MyAdapter extends ArrayAdapter {
    private List<String> list;
    ArrayList<String> origData = new ArrayList<String>();
    ArrayList<String> playlists = new ArrayList<String>();
    private Context context;
    Intent intent;
    TinyDB tinyDB;
    int positionclick;
    ArrayList<String> listorig = new ArrayList<String>();


    public MyAdapter(Context context, int resources, ArrayList<String> list) {
        super(context, resources, list);
        this.list = list;
        this.context = context;
        this.origData = list;
        tinyDB = new TinyDB(context);
        playlists = tinyDB.getListString("Playlist");
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.customlayout, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(origData.get(position));

        listItemText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //play Song
                intent = new Intent(context, Player.class);
                context.startActivity(intent);
            }
        });

        //Handle buttons and add onClickListeners
        Button addBtn = (Button)view.findViewById(R.id.delete_btn);

        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //add to Playlist
                //positionclick=(Integer)v.getTag();
                CharSequence[] cs = playlists.toArray(new CharSequence[playlists.size()]);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Choose Playlist").setItems(cs, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                                String clickedplaylist = playlists.get(which);
                                //ArrayList<SubsetSong> playlist = tinyDB.getListSubsetSong(clickedplaylist);
                                //SubsetSong song = origData.get(position);
                                //playlist.add(song);
                                //tinyDB.putListSubsetSong(clickedplaylist, playlist);
                    }
                });
                alertDialogBuilder.create();
                alertDialogBuilder.show();
            }
        });

        return view;
    }
}