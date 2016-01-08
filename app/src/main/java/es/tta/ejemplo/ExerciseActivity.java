package es.tta.ejemplo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExerciseActivity extends AppCompatActivity {

    private Uri pictureUri;
    static final int PICTURE_REQUEST_CODE=0;
    static final int VIDEO_REQUEST_CODE=1;
    static final int READ_REQUEST_CODE=2;
    static final int AUDIO_REQUEST_CODE=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void sacarFoto(View view)
    {
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            Toast.makeText(this, "No tienes una cámara disponible", Toast.LENGTH_SHORT).show();
        else
        {
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager()) != null)//Pregutnar si hay alguna actividad disponible para sacar laa foto
            {
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

                try {
                    File file = File.createTempFile("tta", "jpg", dir);
                    pictureUri = Uri.fromFile(file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
                    startActivityForResult(intent, PICTURE_REQUEST_CODE);
                } catch (IOException e) {

                }
            }
            else
                Toast.makeText(this,"error al sacar la foto",Toast.LENGTH_SHORT).show();


        }


    }

    public void grabarVideo(View view)
    {
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            Toast.makeText(this, "No tienes una cámara disponible", Toast.LENGTH_SHORT).show();
        else
        {
            Intent intent =new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if(intent.resolveActivity(getPackageManager())!=null)
                startActivityForResult(intent, VIDEO_REQUEST_CODE);
            else
                Toast.makeText(this,"error al grabar el video", Toast.LENGTH_SHORT).show();

        }
    }

    public void grabarAudio(View view)
    {
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
            Toast.makeText(this,"no hay un micrófono disponible", Toast.LENGTH_SHORT).show();
        else
        {
            Intent intent=new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if(intent.resolveActivity(getPackageManager())!=null)
                startActivityForResult(intent, AUDIO_REQUEST_CODE);
            else
                Toast.makeText(this, "Error al grabar el audio", Toast.LENGTH_SHORT).show();

        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        if(resultCode != Activity.RESULT_OK)
            return;
        switch (requestCode)
        {
            case READ_REQUEST_CODE:
                break;
            case VIDEO_REQUEST_CODE:
                break;
            case AUDIO_REQUEST_CODE:
                sendFile(data.getData());
                break;
            case PICTURE_REQUEST_CODE:
                sendFile(pictureUri);
                /*try {
                    PrintHelper photoPrinter = new PrintHelper(this);
                    photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.);
                    photoPrinter.printBitmap("tta.jpg", pictureUri);
                    Toast.makeText(this,"Pensabas que la habías visualizado, pero no", Toast.LENGTH_SHORT).show();;
                } catch (FileNotFoundException e) {
                    Toast.makeText(this,"no encuentra la foto", Toast.LENGTH_SHORT).show();
                }
                */
                break;
        }

    }

    private void sendFile(Uri data)
    {
        Toast.makeText(this, "No está implementada la función de subir al servidor", Toast.LENGTH_SHORT).show();
    }


    public void subirFichero(View view)
    {
        Toast.makeText(this, "No está implementado", Toast.LENGTH_SHORT).show();
    }

}


