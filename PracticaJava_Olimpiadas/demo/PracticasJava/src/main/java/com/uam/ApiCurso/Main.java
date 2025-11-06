package com.uam.ApiCurso;

import java.lang.management.MemoryUsage;
import java.util.*;
public class Main {
    public static long fib(long n){
        // TODO: manejar n=0 y n=1
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long prev = 0, curr = n;
        // TODO: iterar de 2..n manteniendo dos variables

        for(int i = 2; i <=9; i++){
            long next = prev + curr;
            prev = curr;
            curr = next;

        }

        return curr; // reemplazar
    }

    public static String isPalindromo(String str){
        str = str.trim();
        str = str.replaceAll("\\s+", "");
        return new StringBuilder(str).reverse().toString().equalsIgnoreCase(str)?"Palindromo":"No es Palindromo";
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Menu();




    }

    public static void Menu(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while(opcion != 5) {
            System.out.println("Menu actividades de olimpiadas de programacion:");
            System.out.println("1. Calcular Fibonacci desde n con 9 iteraciones");
            System.out.println("2. Verificar palindromo");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" =Numero de iteraciones de Fibonacci=");
                    long n = sc.nextLong();
                    System.out.println(fib(n));
                    break;

                case 2:
                    System.out.println("Verificacion de palindromo desde n con 9 iteraciones");
                    System.out.println("Ingrese una cadena: ");
                    String palindromo = sc.next();
                    System.out.println(isPalindromo(palindromo));
                    break;
            }
        }
    }


}