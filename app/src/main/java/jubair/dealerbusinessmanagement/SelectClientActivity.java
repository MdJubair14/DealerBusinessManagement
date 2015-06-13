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


public class SelectClientActivity extends ActionBarActivity {

    DealerHandler dh;
    ClientHandler ch;
    ListView lvClient;

    public static Client selected;

    int correspondingDealer;

    ClientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_client);

        dh = new DealerHandler(this);
        ch = new ClientHandler(this);
        lvClient = (ListView) findViewById(R.id.lvClient);

        correspondingDealer = dh.getID(HomePageActivity.del);


        List<Client> list = ch.getAllClients(correspondingDealer);

        if (list != null && list.size() > 0) {
            adapter = new ClientAdapter(this, list);
            lvClient.setAdapter(adapter);
        }

        lvClient.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object a = lvClient.getItemAtPosition(position);
                selected = (Client) a;
                selected.setDealersId(correspondingDealer);

                Intent intent = new Intent(SelectClientActivity.this, ClientOptionActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_client, menu);
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
