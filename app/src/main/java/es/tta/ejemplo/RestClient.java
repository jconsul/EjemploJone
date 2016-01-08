package es.tta.ejemplo;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

import es.tta.ejemplo.modelo.Exercise;
import es.tta.ejemplo.modelo.Test;

/**
 * Created by jone on 27/12/15.
 */
public class RestClient
{
    private static String AUTH="Authorization";
    private static String baseURL;
    private final Map<String,String> properties = new HashMap<>();


    public RestClient(String baseUrl)
    {
        this.baseURL=baseUrl;
    }

    public void setHttpBasicAuth(String user, String passwd)
    {
        String basicAuth= Base64.encodeToString(String.format("%s%s",user,passwd).getBytes(),Base64.DEFAULT);
        properties.put(AUTH,String.format("Basic %s",basicAuth));

    }

    public String getAuthorization()
    {
        return properties.get(AUTH);
    }

    public void setAutorization(String auth)
    {
        properties.put(AUTH,auth);
    }

    public void setProperties(String name, String value)
    {
        properties.put(name,value);
    }

    private HttpURLConnection getConnection(String path) throws IOException
    {
        URL url=new URL(String.format("%s%s",baseURL,path));
        HttpURLConnection conn=(HttpURLConnection)url.openConnection(); //obtener instancia
        for (Map.Entry<String,String> property: properties.entrySet())
            conn.setRequestProperty(property.getKey(),property.getValue()); //Preparar la peticion,
        conn.setUseCaches(false);
        return conn;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String getString(String path) throws IOException
    {
        HttpURLConnection conn = null;
        try
        {
            conn=getConnection(path);
            try (BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream())))
            {
                return br.readLine();//Acceder a los datos de la Respuesta
            }
        }
        finally
        {
            if(conn!=null)
                conn.disconnect();

        }
    }

    public JSONObject getJSON(String path) throws IOException,JSONException
    {
        return new JSONObject(getString(path));
    }

    public int postFile(String path, InputStream is, String filename) throws IOException
    {
        return 0;

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public int postJSON(final JSONObject json, String path) throws IOException
    {
        HttpURLConnection conn =null;
        try
        {
            conn=getConnection(path);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            try(PrintWriter pw =new PrintWriter(conn.getOutputStream()))
            {
                pw.print(json.toString());
                return conn.getResponseCode();
            }
        }finally
        {
            if (conn != null )
                conn.disconnect();
        }
    }

    public void getExercise(int id) throws IOException,JSONException
    {
       /* RestClient rest=null;
        JSONObject json=rest.getJSON(String.format("getExercise?id=%d",id));

        String wording=json.getString("wording");
        Test.Choice.set

        Test test=new Test(wording,choice)

        wording="¿Qué color sale mezclando azul y amarillo?";
        String respuestas[]={"azul","verde","rojo","naranja","morado"};
        choice=new Test.Choice(respuestas,1);
*/
    }
}
