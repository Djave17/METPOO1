import java.util.ArrayList;

public class ProgresionAritmetrica {

    private int numero;

    public ProgresionAritmetrica(){
        new ArrayList<>()
                // inicializar arraylist

    }

    public static int calcularProgresionAlternada(int numero[]){

        int numeroFinal;

        for (int i = 0; i < numero.length; i++) {
            numero[i] = (numero[i] + 2) * 2;
            System.out.printf("Valor final para índice %d: %d\n", i, numero[i]);
        }
        numeroFinal = numero.length > 0 ? numero[numero.length - 1] : 0;// Si
        return numeroFinal;
    }


}
