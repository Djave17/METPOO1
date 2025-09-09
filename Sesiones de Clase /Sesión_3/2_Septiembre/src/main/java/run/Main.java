package run;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PruebaEncapsulacion pe = new PruebaEncapsulacion();


        System.out.println("Ingrese su nombre: ");
        String name = pe.setName(sc.nextLine());
        System.out.println("Su nombre es: " + pe.getName());
    }
}
