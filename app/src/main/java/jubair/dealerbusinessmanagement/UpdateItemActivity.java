package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateItemActivity extends ActionBarActivity {

    ItemHandler ih;
    DealerHandler dh;
    EditText name, price, quantity, percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);

        name = (EditText) findViewById(R.id.item_name);
        price = (EditText) findViewById(R.id.item_price);
        quantity = (EditText) findViewById(R.id.item_quantity);
        percentage = (EditText) findViewById(R.id.profit_item);

        dh = new DealerHandler(this);
        ih = new ItemHandler(this);
    }

    public void work(View view)
    {
        String iName = name.getText().toString();
        Double  iPrice = Double.parseDouble(price.getText().toString());
        Double  iQuantity = Double.parseDouble(quantity.getText().toString());
        Double iPercentage = Double.parseDouble(percentage.getText().toString());

        int correspondingDealer;

        correspondingDealer = dh.getID(HomePageActivity.del);

        if(iName==null || iPrice==null  || iQuantity== null || iPercentage==null)
            Toast.makeText(getApplicationContext(), "Please enter information correctly", Toast.LENGTH_SHORT).show();

        else if(correspondingDealer>0)
        {
            Item item = new Item(iName, iPrice, iQuantity, iPercentage, correspondingDealer);
            ih.update(item);
            Intent ok = new Intent(UpdateItemActivity.this, MainActivity.class);
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
        getMenuInflater().inflate(R.menu.menu_update_item, menu);
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
