package uam.edu.ni.PracticaOpenXava2.modelo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Metodos {

    public static String invertirConRecursividad(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return invertirConRecursividad(str.substring(1)) + str.charAt(0);
    }

    public static int factorial(int n) {
        if (n <= 1) {      // Caso base
            return 1;
        }
        return n * factorial(n - 1);   // Paso recursivo
    }

    public static int sumarDigitos(int n) {
        if (n < 10) {          // Caso base: solo tiene un dígito
            return n;
        }
        // Paso recursivo: último dígito + suma del resto
        return (n % 10) + sumarDigitos(n / 10);
    }










}
