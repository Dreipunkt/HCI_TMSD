package univie.g02.t06.tmsd;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends ArrayAdapter {
    private List<String> list;
    ArrayList<String> origData = new ArrayList<String>();
    private Context context;
    MyAdapterAdapt adapt;
    ListView listView;
    Intent intent;


    public MyAdapter(Context context, int resources, ArrayList<String> list) {
        super(context, resources, list);
        this.list = list;
        this.context = context;
        this.origData = list;
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
        listItemText.setText(list.get(position));

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
                /*final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setTitle("Title...");
                listView = (ListView) dialog.findViewById(R.id.list_view1);
                adapt = new MyAdapterAdapt(context ,R.layout.custom_dialog, Current.Names);
                listView.setAdapter(adapt);
                dialog.show();*/
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
