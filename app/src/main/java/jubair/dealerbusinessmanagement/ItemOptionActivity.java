package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ItemOptionActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_option);
    }

    public void update(View view){
        Intent intent = new Intent(ItemOptionActivity.this, UpdateItemActivity.class);
        startActivity(intent);
    }

    public void remove(View view){
        ItemHandler ih=new ItemHandler(this);
        //Toast.makeText(getApplicationContext(), SelectCompanyActivity.deleted.toString(),Toast.LENGTH_SHORT).show();
        Item item = SelectItemActivity.selected;
        ih.delete(item);

        Intent intent = new Intent(ItemOptionActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void purchase(View view)
    {
        Intent intent = new Intent(ItemOptionActivity.this, PurchaseItemActivity.class);
        startActivity(intent);
    }

    public void sell(View view)
    {
        Intent intent = new Intent(ItemOptionActivity.this, SellItemActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_option, menu);
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
