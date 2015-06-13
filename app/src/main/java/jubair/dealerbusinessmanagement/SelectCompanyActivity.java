package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class SelectCompanyActivity extends ActionBarActivity {
    DealerHandler dh;
    CompanyHandler ch;
    ListView lvCompany;
    Company c;
    int correspondingDealer;

    CustomizedAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_company);

        dh = new DealerHandler(this);
        ch = new CompanyHandler(this);
        lvCompany = (ListView) findViewById(R.id.lvCompany);

        correspondingDealer = dh.getID(HomePageActivity.del);


        List<Company> list = ch.getAllCompanies(correspondingDealer);

        if (list != null && list.size() > 0) {
            adapter = new CustomizedAdapter(this, list);
            lvCompany.setAdapter(adapter);
        }
    }

    public void option(View view)
    {
        TextView name = (TextView) lvCompany.findViewById(R.id.txtName);
        TextView address = (TextView) lvCompany.findViewById(R.id.txtAddress);
        TextView contact = (TextView) lvCompany.findViewById(R.id.txtContact);

        String cName = name.toString();
        String cAddress = address.toString();
        String cContact = contact.toString();

        c = new Company(cName, cAddress, cContact, correspondingDealer);
        Intent intent = new Intent(SelectCompanyActivity.this, CompanyOptionActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_company, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
