package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SingleClientActivity extends ActionBarActivity {

    ClientHandler clientHandler;
    DealerHandler dh;
    EditText name,address,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_client);

        name = (EditText) findViewById(R.id.client_name);
        address = (EditText) findViewById(R.id.client_address);
        contact = (EditText) findViewById(R.id.client_info);

        dh = new DealerHandler(this);
        clientHandler = new ClientHandler(this);
    }

    public void submit(View view){
        String clientName = name.getText().toString();
        String clientAddress = address.getText().toString();
        String clientContact = contact.getText().toString();

        int correspondingDealer;

        correspondingDealer = dh.getID(HomePageActivity.del);

        if(clientName==null || clientAddress==null || clientContact==null)
            Toast.makeText(getApplicationContext(), "Please enter information correctly", Toast.LENGTH_SHORT).show();
        else if(correspondingDealer>0)
        {
            Client client = new Client(clientName,clientAddress,clientContact,correspondingDealer);
            clientHandler.insert(client);
            Intent ok = new Intent(SingleClientActivity.this, MainActivity.class);
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
        getMenuInflater().inflate(R.menu.menu_single_client, menu);
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
