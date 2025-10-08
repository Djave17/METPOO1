import java.util.Calendar;
import java.util.Scanner;

public class TiposVariables {
    
    public static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {

        

       MenuPrincipal(args);
    }

    public static void MenuPrincipal(String[] args) {

        //While
        int opcion = 0;
        while (opcion != 8) {
            System.out.println("Aplicacion de aprendizaje de tipos de variables en java");
            System.out.println("Menú:");
            System.out.println("1. String");
            System.out.println("2. Int");
            System.out.println("3. Char");
            System.out.println("4. Double");
            System.out.println("5. Arrays (Menú)");
            System.out.println("6. Boolean");
            System.out.println("7. Fecha y hora");
            System.out.println("8. Salir");

           
            System.out.println("Ingrese una opción:");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("=============String=============");
                    System.out.println("String es una secuencia de caracteres.");
                    System.out.println("Ejemplo: String nombre = \"David\";");
                    System.out.println("Presione Enter para continuar con los metodos...");
                    scanner.nextLine();
                    scanner.nextLine();

                    MetodoString(args);
                    break;
                case 2:
                    System.out.println("=============Int=============");
                    System.out.println("Int es un tipo de dato numérico entero.");
                    System.out.println("Ejemplo: int edad = 30;");
                    System.out.println("Presione Enter para continuar con los metodos...");
                    scanner.nextLine();
                    scanner.nextLine();
                    MetodoEntero(args);
                    break;
                case 3:
                    System.out.println("=============Char=============");
                    System.out.println("Char es un tipo de dato que representa un solo carácter.");
                    System.out.println("Ejemplo: char letra = 'D';");
                    System.out.println("Presione Enter para continuar con los metodos...");
                    scanner.nextLine();
                    scanner.nextLine();
                    MetodoChar(args);
                    break;
                case 4:
                    System.out.println("=============Double=============");
                    System.out.println("Double es un tipo de dato numérico de punto flotante.");
                    System.out.println("Ejemplo: double salario = 2500.50;");
                    System.out.println("Presione Enter para continuar con los metodos...");
                    scanner.nextLine();
                    scanner.nextLine();
                    MetodoDouble(args);
                    break;
                case 5:
                    System.out.println("Usted seleccionó Arrays (Menú)");
                    Arreglos(args);


                    break;
                case 6:
                    System.out.println("=============Boolean=============");
                    System.out.println("Boolean es un tipo de dato que puede tener dos valores: verdadero o falso.");
                    System.out.println("Ejemplo: boolean esMayorDeEdad = true;");
                    System.out.println("Presione Enter para continuar con los metodos...");
                    scanner.nextLine();
                    scanner.nextLine();

                    MetodoBoolean(args);
                    break;
                case 7:
                    fecha(args);

                case 8:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        }
    }

    public static void Arreglos(String[] args) {
        //Arreglo de enteros
        int opcion = 0;
        
        while (opcion != 3) {
            System.out.println("Menú de Arreglos:");
            System.out.println("1. Arreglo de enteros");
            System.out.println("2. Arreglo de cadenas");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("=============Arreglos=============");
                    System.out.println("Los arreglos son estructuras que permiten almacenar múltiples valores del mismo tipo.");
                    System.out.println("Ejemplo: int[] edades = {30, 25, 28};");
                    
                    int[] edades = {30, 25, 28};
                    for (int e : edades) {
                        System.out.println("Edad: " + e);
                    }
                    break;
                case 2:
                    System.out.println("=============Arreglos de Cadenas=============");
                    System.out.println("Los arreglos de cadenas permiten almacenar múltiples cadenas de texto.");
                    System.out.println("Ejemplo: String[] nombres = {\"David\", \"Ana\", \"Luis\"};");

                    String[] nombres = {"David", "Ana", "Luis"};
                    for (String n : nombres) {
                        System.out.println("Nombre: " + n);
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del menú de arreglos...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }


    }
    

    //Funciones con los metodos de cada tipo de variable
    public static void MetodoString(String[] args) {

        System.out.println("=============Metodos=============");
        String texto = "Hola, mundo!";
        System.out.println("Texto: " + texto);
        System.out.println("Longitud: " + texto.length());
        System.out.println("Texto en mayúsculas: " + texto.toUpperCase());
        System.out.println("Texto en minúsculas: " + texto.toLowerCase());
        System.out.println("Texto reemplazado Mundo por Java:  " + texto.replace("mundo", "Java"));
        //Equals
        String texto2 = "Hola, mundo!";
        System.out.println("Texto igual a 'Hola, mundo!': " + texto2.equals(texto2));
        System.out.println("Texto igual a 'Hola, Mundo!': " + texto2.equals("Hola, Mundo!"));
        System.out.println("Texto igual (variable.equalsIgnoreCase) a 'Hola, mundo!': " + texto2.equalsIgnoreCase("Hola, mundo!"));

        // SubString
        System.out.println("Texto (SubString): " + texto.substring(0, 5));

        
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    public static void MetodoEntero(String[] args) {
        System.out.println("=============Metodos=============");
        int numero = 42;
        System.out.println("Número: " + numero);
        System.out.println("Número en binario (Integer.toBinaryString): " + Integer.toBinaryString(numero));
        System.out.println("Número en octal (Integer.toOctalString): " + Integer.toOctalString(numero));
        System.out.println("Número en hexadecimal (Integer.toHexString): " + Integer.toHexString(numero));
        //Metodos Utiles
        System.out.println("Número máximo (Integer.MAX_VALUE): " + Integer.MAX_VALUE);
        System.out.println("Número mínimo (Integer.MIN_VALUE): " + Integer.MIN_VALUE);
        System.out.println("Número promedio (Integer.sum): " + Integer.sum(10, 20));
        System.out.print("Número actual (Integer.valueOf): " + Integer.valueOf(numero));
        System.out.print("Número actual (Integer.parseInt): " + Integer.parseInt("42"));
        System.out.print("Número absoluto (Math.abs): " + Math.abs(-numero));
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        //limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void MetodoChar(String[] args) {
        System.out.println("=============Metodos=============");
        char letra = 'A';
        System.out.println("Carácter: " + letra);
        System.out.println("Carácter en minúscula (Character.toLowerCase): " + Character.toLowerCase(letra));
        System.out.println("Carácter en mayúscula (Character.toUpperCase): " + Character.toUpperCase(letra));
        System.out.println("¿Es dígito? (Character.isDigit): " + Character.isDigit(letra));
        System.out.println("¿Es letra? (Character.isLetter): " + Character.isLetter(letra));
        System.out.println("¿Es espacio en blanco? (Character.isWhitespace): " + Character.isWhitespace(letra));
        System.out.println("¿Es mayúscula? (Character.isUpperCase): " + Character.isUpperCase(letra));
        System.out.println("¿Es minúscula? (Character.isLowerCase): " + Character.isLowerCase(letra));
        System.out.println("¿Es letra mayúscula? (Character.isUpperCase): " + Character.isUpperCase(letra));
        System.out.println("¿Es letra minúscula? (Character.isLowerCase): " + Character.isLowerCase(letra));
        System.out.println("¿Es letra? (Character.isLetter): " + Character.isLetter(letra));


        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        //limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void MetodoDouble(String[] args) {

        System.out.println("=============Metodos=============");
        double decimal = 3.14;
        System.out.println("Número decimal: " + decimal);
        System.out.println("Número decimal (Math.round): " + Math.round(decimal));
        System.out.println("Número decimal (Math.ceil): " + Math.ceil(decimal));
        System.out.println("Número decimal (Math.floor): " + Math.floor(decimal));
        System.out.println("Número decimal (Double.MAX_VALUE): " + Double.MAX_VALUE);
        System.out.println("Número decimal (Double.MIN_VALUE): " + Double.MIN_VALUE);
        System.out.println("Número decimal (Double.valueOf): " + Double.valueOf(decimal));
        System.out.println("Número decimal (Double.parseDouble): " + Double.parseDouble("3.14"));
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        //limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void MetodoBoolean(String[] args) {
        System.out.println("=============Metodos=============");
        boolean verdadero = true;
        boolean falso = false;
        System.out.println("Valor booleano verdadero: " + verdadero);
        System.out.println("Valor booleano falso: " + falso);
        System.out.println("¿Es verdadero? (Boolean.TRUE): " + Boolean.TRUE);
        System.out.println("¿Es falso? (Boolean.FALSE): " + Boolean.FALSE);
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        //limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
    }

    public static void fecha(String[] args){ 
        System.out.println("=============Fecha=============");
        System.out.println("Calendar es una clase que permite trabajar con fechas y horas en Java.");
        System.out.println("Ejemplo:");
        // Crear un objeto Calendar
        Calendar calendario = Calendar.getInstance();
        System.out.println("Fecha y hora actual (Calendar.getTime): " + calendario.getTime());
        System.out.println("Año actual (Calendar.get(Calendar.YEAR)): " + calendario.get(Calendar.YEAR));
        System.out.println("Mes actual (Calendar.get(Calendar.MONTH)): " + calendario.get(Calendar.MONTH));
        System.out.println("Día actual (Calendar.get(Calendar.DAY_OF_MONTH)): " + calendario.get(Calendar.DAY_OF_MONTH));
        System.out.println("Hora actual (Calendar.get(Calendar.HOUR)): " + calendario.get(Calendar.HOUR));
        System.out.println("Minuto actual (Calendar.get(Calendar.MINUTE)): " + calendario.get(Calendar.MINUTE));
        System.out.println("Segundo actual (Calendar.get(Calendar.SECOND)): " + calendario.get(Calendar.SECOND));
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        //limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



}
