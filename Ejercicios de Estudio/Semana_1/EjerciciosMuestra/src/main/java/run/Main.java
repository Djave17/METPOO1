package run;

import java.util.Scanner;

import static run.Utils.limpiarConsola;
import static run.Utils.leerEntero;

public class Main {

    /// Scanner único para toda la clase
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        try {

            menu();
        } finally {
            SCANNER.close();
        }
       
    }



    public static void libroInfo(){

        System.out.println("===== Clase Libro =====");

        //Instancia de run.Libro
        Libro libro1 = new Libro();

        //Atributo nombre
        System.out.print("Ingresa el nombre del libro: ");
        libro1.nombre = SCANNER.nextLine();

        //Atributo Autor
        System.out.print("Ingresa el autor del libro: ");
        libro1.autor = SCANNER.nextLine();

        //Atributo sinopsis
        System.out.print("Ingresa la sinopsis del libro: ");
        libro1.sinopsis = SCANNER.nextLine();

        //Atributo Numero de paginas
        libro1.numeroPaginas = leerEntero("Ingresa el número de páginas del libro: ");

        //Atributo Año de publicación
        libro1.anioPublicacion = leerEntero("Ingresa el año de publicación del libro: ");

        //Limpiar consola
        limpiarConsola();


        //Metodo mostrar informacion
        System.out.println(libro1.mostrarInfo());


    }
    
    public static void automovilInfo(){

        System.out.println("===== Clase Automóvil =====");
        
        //Instancia de run.Automovil
        Automovil auto1 = new Automovil();

        //Atributo marca
        System.out.print("Ingresa la marca del automóvil: ");
        auto1.marca = SCANNER.nextLine();
        
        //Atributo año 
        auto1.año = leerEntero("Ingresa el año del automóvil: ");
        
        //Atributo Color 
        System.out.print("Ingresa el color del automóvil: "); 
        auto1.color = SCANNER.nextLine();
        
        //Atributo modelo 
        System.out.print("Ingresa el modelo del automóvil: "); 
        auto1.modelo = SCANNER.nextLine(); 
        
        //Limpiar Pantalla

        limpiarConsola();

        //Métodos de automóvil
        auto1.arrancar();
        System.out.println(auto1.mostrarInfo());

    }

    static void menu(){
        int opcion;

        do {
            System.out.println("===== Menú Principal =====");
            System.out.println("1. Información del Libro");
            System.out.println("2. Información del Automóvil");
            System.out.println("3. Salir");
            opcion = leerEntero("Selecciona una opción: ");

            limpiarConsola();


            switch (opcion) {
                case 1:
                    libroInfo();
                    break;
                case 2:
                    automovilInfo();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 3);
    }

}
