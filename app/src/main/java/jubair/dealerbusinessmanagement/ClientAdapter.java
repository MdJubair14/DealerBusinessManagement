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
 * Created by hp on 6/14/2015.
 */
public class ClientAdapter  extends ArrayAdapter<Client> {
    Activity activity;
    List<Client> list;

    public ClientAdapter(Context context,List<Client> list) {
        super(context, R.layout.list_item, list);
        this.activity = (Activity)context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        if(convertView==null)
        {
            LayoutInflater inflater = activity.getLayoutInflater();
            v = inflater.inflate(R.layout.list_item, null);

            TextView txtName = (TextView)v.findViewById(R.id.txtName);
            TextView txtAddress = (TextView)v.findViewById(R.id.txtAddress);
            TextView txtContact = (TextView)v.findViewById(R.id.txtContact);

            Client client  = list.get(position);

            txtName.setText(client.getName());
            txtAddress.setText(client.getAddress());
            txtContact.setText(client.getContactInfo());

        }
        else
        {
            v = convertView;
        }
        return v;
    }
}
