package es.tta.ejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //constantes:
    public final static String EXTRA_LOGIN= "es.tta.ejemplo.login";
    public final static String EXTRA_PASSWD= "es.tta.ejemplo.passwd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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


    public void login(View view)//recogemos los datos del login y lanzamos actividad nueva (MenuActivity)
    {
        Intent intent = new Intent(this,MenuActivity.class);
        EditText editLogin =(EditText)findViewById(R.id.login);//para leer datos
        EditText editPasswd =(EditText)findViewById(R.id.passwd);
        intent.putExtra(EXTRA_LOGIN,editLogin.getText().toString()); //Le podemos meter al intent lo que queramos
        intent.putExtra(EXTRA_PASSWD, editPasswd.getText().toString());
        startActivity(intent); //Arrancamos la nueva actividad encima de la anterior, que pasará a detenida.
    }



}
