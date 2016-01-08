package es.tta.ejemplo.presentacion;

import android.os.Bundle;

import es.tta.ejemplo.ModelActivity;
import es.tta.ejemplo.modelo.Exercise;
import es.tta.ejemplo.modelo.Test;

/**
 * Created by jone on 27/12/15.
 */
public class Data extends ModelActivity {
    private Test test;

    public Data()
    {
        test=new Test();
        this.bundle=null;
    }

    public Test getTest()
    {
        return test;
    }

    private final static String EXTRA_USER= "es.tta.ejemplo.user";
    private final static String EXTRA_AUTH="es.tta.ejemplo.auth";
    private final static String EXTRA_NAME ="es.tta.ejemplo.name";
    private final static String EXTRA_EXERCISE_ID="es.tta.ejemplo.exerciseId";
    private final static String EXTRA_EXERCISE_WORDING="es.tta.ejemplo.exerciseWording";

    private final Bundle bundle;

    public Data(Bundle bundle)
    {
        if(bundle==null)
            bundle=new Bundle();
        this.bundle=bundle;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void putUserId(int id)
    {
        bundle.putInt(EXTRA_USER,id);
    }

    public int getUserId()
    {
        return bundle.getInt(EXTRA_USER);
    }

    public void putAuthToken(String auth)
    {
        bundle.putString(EXTRA_AUTH,auth);
    }

    public String getAuthToken()
    {
        return bundle.getString(EXTRA_AUTH);
    }

    public void putUserName(String name)
    {
        bundle.putString(EXTRA_NAME,name);
    }

    public String getUserName()
    {
        return bundle.getString(EXTRA_NAME);

    }

    public void putExercise(Exercise exercise)
    {
        bundle.putInt(EXTRA_EXERCISE_ID,exercise.getId());
        bundle.putString(EXTRA_EXERCISE_WORDING, exercise.getWording());
    }

    public Exercise getExercise()
    {
        Exercise exercise =new Exercise();
        exercise.setId(bundle.getInt(EXTRA_EXERCISE_ID));
        exercise.setWording(bundle.getString(EXTRA_EXERCISE_WORDING));
        return exercise;
    }

}
