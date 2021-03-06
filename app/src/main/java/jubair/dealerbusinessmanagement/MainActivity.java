package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void accountActivity(View view){
        Intent account = new Intent(this, AccountActivity.class);
        startActivity(account);
    }

    public void companyActivity(View view){
        Intent company = new Intent(this, CompanyActivity.class);
        startActivity(company);
    }

    public void clientActivity(View view){
        Intent client = new Intent(this, ClientActivity.class);
        startActivity(client);
    }

    public void itemListActivity(View view){
        Intent itemList = new Intent(this, ItemListActivity.class);
        startActivity(itemList);
    }

    public void historyActivity(View view){
        Intent history = new Intent(this, HistoryActivity.class);
        startActivity(history);
    }

    public void statisticsActivity(View view){
        Intent statistics = new Intent(this, StatisticsActivity.class);
        startActivity(statistics);
    }

    public void exit(View view){
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
