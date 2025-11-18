package com.uam.olimpiadasJava;

import java.util.ArrayList;

public class EjerciciosNivel1_2 {
    public static int verMayor(){

        int[] nums = {5, 17, 2, 30, 14};
        int mayor = nums[0];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > mayor){
                mayor = nums[i];
            }

        }
        return mayor;
    }

    /*
     * EJERCICIO 4 — Contar letras “a” en un texto
     * Texto:
     * Java es maravilloso
     * Salida esperada:
     * Cantidad de 'a': 4
     * */
    public static int contarA(){

        int contador = 0;
        String a = "Java es maravilloso";
        for(int i =0; i < a.length(); i++){
            if (a.charAt(i) == 'a' || a.charAt(i) == 'A') {
                contador++;

            }
        }
        return contador;
    }


    /*
    EJERCICIO 5 — Suma de números del 1 al N

    N = 100
    Salida:
    Suma total: 5050

    */

    public static int suma(){
        int N = 100;
        int n = 0;
        for(int i =0; i <= N; i++){
            n += i;

        }
        return n;
    }

    /*
    Calcula el promedio de las notas.

    Cuenta cuántas notas están estrictamente por encima del promedio.

    Crea un nuevo ArrayList<Integer> que contenga solo las notas arriba del promedio.

    Imprime:

    El promedio

    Las notas arriba del promedio

    Cuántas son
    */

    public static double promedio(){
        int promedio;
        ArrayList<Integer> notas = new ArrayList<>();
        notas.add(70);
        notas.add(85);
        notas.add(90);
        notas.add(60);
        notas.add(75);
        notas.add(95);
        int suma = 0;

        for(int i: notas){
            suma += i;

        }

        promedio = suma / notas.size();
        return promedio;
    }

    public static ArrayList<Integer> notasMayores(){

        ArrayList<Integer> notas = new ArrayList<>();
        notas.add(70);
        notas.add(85);
        notas.add(90);
        notas.add(60);
        notas.add(75);
        notas.add(95);

        ArrayList<Integer> notasB = new ArrayList<>();

        double promedio = promedio();

        for (int i : notas){
            if(i > promedio)
            {
                notasB.add(i);
            }
        }

        return notasB;
    }

    public static void fibbonacci(){

        int actual = 0;
        int anterior = 1;
        int suma = '\0';

        for(int i = 2; i<10; i++){

            suma =  actual += anterior;

            System.out.println(suma);
            anterior = actual;
            actual = suma;

        }
    }
}
