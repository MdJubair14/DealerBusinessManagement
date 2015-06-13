package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;


public class CompanyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_company);
    }

    public void showCompany(View view){
        Intent showCom = new Intent(CompanyActivity.this, AllCompanyActivity.class);
        startActivity(showCom);
    }

    public void selectCompany(View view){
        Intent selectCom = new Intent(CompanyActivity.this, SelectCompanyActivity.class);
        startActivity(selectCom);
    }

    public void updateCompany(View view){
        Intent upCom = new Intent(CompanyActivity.this, UpdateCompanyActivity.class);
        startActivity(upCom);
    }

    public void singleCompany(View view){
        Intent sinCom = new Intent(CompanyActivity.this, SingleCompanyActivity.class);
        startActivity(sinCom);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_company, menu);
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
