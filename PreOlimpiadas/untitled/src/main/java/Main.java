import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        int numero[] = {5, 15, 45, 135, 405,  };//5, 15, 45, 135, 405, ?
//
//        int siguienteNumero = calcularSiguienteNumero(numero);
//
//        System.out.println("El siguiente numero de la progresion geometrica es: " + siguienteNumero);

        ProgresionAritmetrica progresionAritmetrica = new ProgresionAritmetrica();
        System.out.printf("Ingrese la longitud que desea calcular: ");
        int longitud = sc.nextInt();
        int arreglo[] = new int[longitud];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.printf("Ingrese el numero %d: ", (i+1));
            arreglo[i] = sc.nextInt();
        }

        int resultado = progresionAritmetrica.calcularProgresionAlternada(arreglo);
        System.out.println("El resultado es: " + resultado);





    }








    public static int calcularSiguienteNumero(int numero[]){

        for (int i = 0; i < numero.length; i++) {
            //Calcular razon
        }

        return 0;
    }
}
