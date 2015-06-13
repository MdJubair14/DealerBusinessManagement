package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateCompanyActivity extends ActionBarActivity {
    CompanyHandler ch;
    DealerHandler dh;
    EditText name,address,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_company);

        name = (EditText) findViewById(R.id.company_name);
        address = (EditText) findViewById(R.id.company_address);
        contact = (EditText) findViewById(R.id.company_contact);

        dh = new DealerHandler(this);
        ch = new CompanyHandler(this);
    }

    public void submit(View view)
    {
        String companyName = name.getText().toString();
        String companyAddress = address.getText().toString();
        String companyContact = contact.getText().toString();
        int correspondingDealer;

        correspondingDealer = dh.getID(HomePageActivity.del);

        if(companyName==null || companyAddress==null || companyContact==null)
            Toast.makeText(getApplicationContext(), "Please enter information correctly", Toast.LENGTH_SHORT).show();

        else if(correspondingDealer>0)
        {
            Company company = new Company(companyName,companyAddress,companyContact,correspondingDealer);
            ch.update(company);
            Intent ok = new Intent(UpdateCompanyActivity.this, MainActivity.class);
            startActivity(ok);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"user name doesn't match.",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_company, menu);
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
