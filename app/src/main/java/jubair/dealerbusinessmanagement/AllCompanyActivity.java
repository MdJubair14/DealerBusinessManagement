package jubair.dealerbusinessmanagement;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;


public class AllCompanyActivity extends ActionBarActivity {
    DealerHandler dh;
    CompanyHandler ch;
    ListView lvCompany;

    CustomizedAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_company);


        dh = new DealerHandler(this);
        ch = new CompanyHandler(this);
        lvCompany = (ListView) findViewById(R.id.lvCompany);
        int correspondingDealer;

        correspondingDealer = dh.getID(HomePageActivity.del);


        List<Company> list = ch.getAllCompanies(correspondingDealer);

        if(list != null && list.size() > 0){
            adapter = new CustomizedAdapter(this, list);
            lvCompany.setAdapter(adapter);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all_company, menu);
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
