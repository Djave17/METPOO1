import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Menu
        Cadena c = new Cadena("");
        menu();

    }

    private static void menu() {
        Cadena c = new Cadena("");
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while(opcion != 5){

            System.out.println("=== Sistema de cadenas ===");
            System.out.println("1. Verificar palindromo");
            System.out.println("2. Convertir a minuscula");
            System.out.println("3. Convertir a mayuscula");
            System.out.println("4. Invertir cadena");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Verificar palindromo");
                    System.out.print("Ingrese una frase: ");
                    String cadena = sc.nextLine();
                    c = new Cadena(cadena);
                    System.out.println("La frase  '" + c.invertir() + "' es palindromo: " + c.isPalindromo(cadena));
                    break;
                case 2:
                    System.out.println("Convertir a minuscula");
                    System.out.print("Ingrese una frase: ");
                    cadena = sc.next();
                    c = new Cadena(cadena);
                    System.out.println("La frase ' " + c.aMinusculas() + " ' en minuscula");
                    break;
                case 3:
                    System.out.println("Convertir a mayuscula");
                    System.out.print("Ingrese una frase: ");
                    cadena = sc.next();
                    c = new Cadena(cadena);
                    System.out.println("La frase '" + c.aMayusculas() + "'en mayuscula");
                    break;
                case 4:
                    System.out.println("Invertir cadena");
                    System.out.print("Ingrese una frase: ");
                    cadena = sc.next();
                    c = new Cadena(cadena);
                    System.out.println("La frase " + c.invertir() + " invertida");
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
        sc.close();



    }


}

