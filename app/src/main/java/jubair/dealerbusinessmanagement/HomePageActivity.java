package jubair.dealerbusinessmanagement;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class HomePageActivity extends ActionBarActivity {

    EditText name , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        checking();
    }

    public void checking(){

        name = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.user_password);

        String checkName = name.getText().toString();
        String checkPassword = password.getText().toString();

        signIn(checkName, checkPassword);

    }

    public void signIn(String checkName, String checkPassword){

        if(checkName.equals("jubair") && checkPassword.equals("jubair") ){
            final Button signUp = (Button) findViewById(R.id.btn_signUp);
            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mainActivity = new Intent(HomePageActivity.this, MainActivity.class);
                    startActivity(mainActivity);
                }
            });

        }
        else{
            Toast.makeText(HomePageActivity.this,"You currently don't Sing In\n Please Sign Up", Toast.LENGTH_SHORT).show();
        }
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
