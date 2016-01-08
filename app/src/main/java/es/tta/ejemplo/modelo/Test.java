package es.tta.ejemplo.modelo;

/**
 * Created by jone on 26/12/15.
 */
public class Test {


    private String wording;
    private Choice choice;

    public Test()
    {
        wording="¿Qué color sale mezclando azul y amarillo?";
        String respuestas[]={"azul","verde","rojo","naranja","morado"};
        choice=new Choice(respuestas,1);
    }

    public Test(String wording, Choice choice)
    {
        this.wording = wording;
        this.choice = choice;
    }

    public String getWording()
    {
        return wording;
    }

    public Choice getChoice()
    {
        return choice;
    }


    public class Choice
    {
        private String[] opc;
        private int correct;
        private int adviceType;

        public Choice(String[] opc,int correct){
            this.opc=opc;
            this.correct=correct;
        }

        public String[] getOpc(){ return opc;  }

        public int getCorrect()
        {
            return correct;
        }
    }
}

