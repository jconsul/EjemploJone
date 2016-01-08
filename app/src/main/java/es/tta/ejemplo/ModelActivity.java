package es.tta.ejemplo;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by jone on 27/12/15.
 */
public class ModelActivity extends AppCompatActivity {}
    /*
    public static final String URL="http://server:8080/ServidorTta";

    protected RestClient rest;
    protected Business server;
    protected Preferences prefs;
    protected Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        data=new Data(getIntent().getExtras());
        rest=new RestClient(URL);
        String auth=data.getAuthToken();
        if (auth!=null)
            rest.setAutorization(auth);
        server=new Business(rest);
        prefs =new Preferences(this);
    }

     private <T>Intent newIntent(Class<T> cls) //función que vamos a usar después, para no repetir código
    {
        Intent intent = new Intent(getApplicationContext(), cls);
        intent.putExtras(data.getBundle());
        return intent;
    }


    protected <T> void startModelActivity(Class<T> cls)
    {
        Intent intent=newIntent(cls);
        startActivity(intent);
    }

    protected <T> void startModelActivityForResult(Class<T> cls,int requestCode)
    {
        Intent intent=newIntent(cls);
        startActivityForResult(intent, requestCode);
    }

}
*/