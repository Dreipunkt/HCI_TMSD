package univie.g02.t06.tmsd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erwin on 12.05.2017.
 */

public class MyAdapterAdapt extends ArrayAdapter {

    private List<String> list;
    ArrayList<String> origData = new ArrayList<String>();
    private Context context;


    public MyAdapterAdapt(Context context, int resources, ArrayList<String> list) {
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
            view = inflater.inflate(R.layout.custom_dialog, null);
        }

        //Handle TextView and display string from your list
        ListView listItemText = (ListView) view.findViewById(R.id.list_view1);

        listItemText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
