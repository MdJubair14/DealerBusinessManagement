package jubair.dealerbusinessmanagement;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hp on 6/12/2015.
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    Activity context;
    List<Item> list;

    public ItemAdapter(Context context,List<Item> list) {
        super(context, R.layout.list_item2, list);
        this.context = (Activity)context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        if(convertView==null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            v = inflater.inflate(R.layout.list_item, null);

            TextView txtName = (TextView)v.findViewById(R.id.txtName);
            TextView txtPrice = (TextView)v.findViewById(R.id.txtPrice);
            TextView txtQuantity = (TextView)v.findViewById(R.id.txtQuantity);
            TextView txtPercentage = (TextView) v.findViewById(R.id.txtPercentage);

            Item i = list.get(position);

            txtName.setText(i.getName());
            txtPrice.setText(String.valueOf(i.getPrice()));
            txtQuantity.setText(String.valueOf(i.getQuantity()));
            txtPercentage.setText(String.valueOf(i.getPercentage()));

        }
        else
        {
            v = convertView;
        }
        return v;
    }
}
