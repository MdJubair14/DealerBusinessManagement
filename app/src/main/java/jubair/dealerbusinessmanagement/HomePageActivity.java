package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class HomePageActivity extends ActionBarActivity {

    DealerHandler db;
    public static Dealer del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        db = new DealerHandler(this);
    }

    public void signIn(View view){

        EditText name = (EditText) findViewById(R.id.user_name);
        EditText password = (EditText) findViewById(R.id.user_password);

        String checkName = name.getText().toString();
        String checkPassword = password.getText().toString();

        del = new Dealer(checkName, checkPassword);

        if(checkName.equals("") ||  checkPassword.equals("") || checkName == null || checkPassword == null){
            Toast.makeText(HomePageActivity.this,"Please enter information correctly", Toast.LENGTH_SHORT).show();
        }
        else if( db.getID(del) > 0){
            Intent main = new Intent(HomePageActivity.this, MainActivity.class);
            startActivity(main);
        }
        else{
            Toast.makeText(HomePageActivity.this,"You currently don't Sing In\n Please Sign Up", Toast.LENGTH_SHORT).show();
        }
    }

    public void registerAct(View view){
        Intent register = new Intent(HomePageActivity.this, RegisterActivity.class);
        startActivity(register);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
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
