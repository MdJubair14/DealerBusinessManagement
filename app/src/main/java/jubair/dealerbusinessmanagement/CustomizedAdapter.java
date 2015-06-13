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
public class CustomizedAdapter extends ArrayAdapter<Company> {

    Activity con;
    List<Company> list;
    public CustomizedAdapter(Context context,List<Company> list) {
        super(context, R.layout.list_item, list);
        this.con = (Activity)context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        if(convertView==null)
        {
            LayoutInflater inflater = con.getLayoutInflater();
            v = inflater.inflate(R.layout.list_item, null);

            TextView txtName = (TextView)v.findViewById(R.id.txtName);
            TextView txtAddress = (TextView)v.findViewById(R.id.txtAddress);
            TextView txtContact = (TextView)v.findViewById(R.id.txtContact);

            Company c = list.get(position);

            txtName.setText(c.getName());
            txtAddress.setText(c.getAddress());
            txtContact.setText(c.getContactInfo());

        }
        else
        {
            v = convertView;
        }
        return v;
    }
}
