package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;


public class SelectItemActivity extends ActionBarActivity {
    DealerHandler dh;
    ItemHandler ih;
    ListView lvItem;

    public static Item selected;

    int correspondingDealer;

    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_item);

        dh = new DealerHandler(this);
        ih = new ItemHandler(this);
        lvItem = (ListView) findViewById(R.id.lvItem);

        correspondingDealer = dh.getID(HomePageActivity.del);


        List<Item> list = ih.getAllItems(correspondingDealer);

        if (list != null && list.size() > 0) {
            adapter = new ItemAdapter(this, list);
            lvItem.setAdapter(adapter);
        }

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object a = lvItem.getItemAtPosition(position);
                selected = (Item) a;
                selected.setDealerId(correspondingDealer);

                Intent intent = new Intent(SelectItemActivity.this, ItemOptionActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_item, menu);
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
