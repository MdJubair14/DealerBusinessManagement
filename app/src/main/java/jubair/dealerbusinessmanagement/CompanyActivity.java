package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class CompanyActivity extends ActionBarActivity {

    EditText add, remove, up_old, up_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        add = (EditText) findViewById(R.id.add_company);
        remove = (EditText) findViewById(R.id.remove_company);
        up_old = (EditText) findViewById(R.id.previous_company);
        up_new = (EditText) findViewById(R.id.updated_company);
    }

    public void allCompany(View view){
        Intent allCom = new Intent(CompanyActivity.this, AllCompanyActivity.class);
        startActivity(allCom);
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
