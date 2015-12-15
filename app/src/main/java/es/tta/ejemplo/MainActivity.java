package es.tta.ejemplo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //constantes:
    public final static String EXTRA_LOGIN= "es.tta.ejemplo.login";
    public final static String EXTRA_PASSWD= "es.tta.ejemplo.passwd";


    public void login(View view)
    {
        Intent intent = new Intent(this.MenuActivity.class);
        EditText editLogin =(EditText)findViewById(R.id.login);//para leer datos
        EditText editPasswd =(EditText)findViewById(R.id.passwd);
        intent.putExtra(EXTRA_LOGIN,editLogin.getText().toString()); //Le podemos meter al intent lo que queramos
        intent.putExtra(EXTRA_PASSWD,editPasswd.getText().toString());
        startActivity(intent); //Arrancamos la nueva actividad encima de la anterior, que pasará a detenida.


    }

    public void recordAudio(View view)
    {
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
            Toast.makeText(this, R.string.no_micro, Toast.LENGTH_SHORT).show();
        else
        {
            Intent intent =new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if (intent.resolveActivity(getPackageManager())!=null)
                startActivityForResult(intent, AUDIO_REQUEST_CODE);
            else
                Toast.makeText(this, R.string.no_app, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) //comprobar que ha acabado correctamente
            return;
        switch (requestCode)
        {
            case READ_REQUEST_CODE;
                break;
            case VIDEO_REQUEST_CODE;
                break;
            case AUDIO_REQUEST_CODE;
                sendFile(data.getData());
                break;
            case PICTURE_REQUEST_CODE;
                sendFile(pictureUri);
                break;
        }

    }

    public void login(View view)
    {
        view.setEnabled(false);
    }


/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
   }
*/
}


