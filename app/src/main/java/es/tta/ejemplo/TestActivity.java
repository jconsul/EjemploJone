package es.tta.ejemplo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import es.tta.ejemplo.modelo.Test;
import es.tta.ejemplo.presentacion.Data;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {


    private int correct=0;//opción correcta
    private int selected=0; //para saber cual elemos seleccionado


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        Data data=new Data();
        Test test=data.getTest();
        //Test test=new Test();

        //Poner el enunciado
        TextView textWording = (TextView) findViewById(R.id.test_wording);
        textWording.setText(test.getWording());

        //Rellenar opciones
        RadioGroup group = (RadioGroup) findViewById(R.id.test_choices);
        String opciones[]=test.getChoice().getOpc();

        for (int i=0;i<=opciones.length-1;i++)
        {
            RadioButton radio = new RadioButton(this);//crear el radio button
            radio.setText(opciones[i]);//poerle el texto
            radio.setOnClickListener(this);
            group.addView(radio);
        }
        correct=1;

    }

    @Override
    public void onClick(View v) { //PAra hacer visible el boton uqe hemos puesto invisible en el layout.

        findViewById(R.id.button_send_test).setVisibility(View.VISIBLE);
    }

    public void send(View view)
    {
        RadioGroup group = (RadioGroup) findViewById(R.id.test_choices);


        int choices = group.getChildCount();
        for(int i=0;i<choices;i++)
        {
            group.getChildAt(i).setEnabled(false);
        }
        //Borramos el botón de enviar
        LinearLayout layout = (LinearLayout)findViewById(R.id.test_layout);
        layout.removeView(findViewById(R.id.button_send_test));

        group.getChildAt(correct).setBackgroundColor(Color.GREEN);
        int selectedID=group.getCheckedRadioButtonId();
        View radioButton=group.findViewById(selectedID);
        selected=group.indexOfChild(radioButton);

        if (selected != correct) {
            group.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(), "Has fallado!", Toast.LENGTH_SHORT).show();

            //if(advise!=null && !advise.isEmpty())
            findViewById(R.id.button_view_advise).setVisibility(View.VISIBLE);
        }
        else
            Toast.makeText(getApplicationContext(), "Correcto!", Toast.LENGTH_SHORT).show();

    }

    public void showAdvise(View view)
    {
        Toast.makeText(getApplicationContext(),"Consejo", Toast.LENGTH_LONG).show();
    }




}
