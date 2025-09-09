/*
* 10. Gestor de Cadenas
* Objetivo: Clase Cadena que contenga una cadena de texto. Métodos para:
•    Convertir a mayúsculas/minúsculas.
•    Invertir cadena.
•    Verificar si es palíndromo.
•    Contar vocales y consonantes.
*/
import java.text.Normalizer;

public class Cadena {

    private String cadena;

    private static char[] VOCALES = new char[]{'a','e','i','o','u','y'};

    public Cadena(String cadena) {
        this.cadena = cadena;
    }

    //Convertir a mayuscula
    public String aMayusculas() {
        return cadena.toUpperCase();
    }

    //Convertir a minuscula
    public String aMinusculas() {
        return cadena.toLowerCase();
    }

    //Invertir cadena
    public String invertir() {
        return new StringBuilder(cadena).reverse().toString();
    }

    //Verificar una frase es palindromo
    public boolean isPalindromo(String cadena){
        cadena = cadena.replaceAll("[^a-z0-9]", "").toLowerCase().trim();
        String cadenaReverse = new StringBuilder(cadena).reverse().toString();
        return cadena.equals(cadenaReverse);

    }

    //Contar Vocales
    public int contarVocales(String cadena) {
        cadena = normaliza(cadena);
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i); // Asigna el caracter actual al char c
            if (Character.isLetter(c) && esVocal(c)) contador++; // Si es letra y es vocal, incrementa el contador
        }
        return contador;
    }

    //Contar Consonantes Regex
    public int contarConsonantes(String cadena) {
        cadena = normaliza(cadena);
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (Character.isLetter(c) && !esVocal(c)) contador++;
        }
        return contador;

    }

    //


    // --- Utilidades internas ---
    private static String normaliza(String s) {
        if (s == null) return "";
        // NFD separa letra+tilde y luego se quitan los diacríticos. ToLower para comparar.
        return Normalizer.normalize(s, Normalizer.Form.NFD)
                .replaceAll("\\p{M}+","")
                .toLowerCase();
    }

    private static boolean esVocal(char c) {
        for (char v : VOCALES) if (c == v) return true;
        return false;
    }


    //Constructores
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}
