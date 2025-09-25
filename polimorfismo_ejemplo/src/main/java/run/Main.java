package run;

import models.Circulo;
import models.Cuadrado;
import models.Figura;

public class Main {

    public static void main(String[] args) {
        Figura figura = new Circulo("rojo", 10);
        figura.mostrarColor();

        System.out.println("El area del circulo es: " + figura.calcularArea());

        figura = new Cuadrado("verde", 10);
        figura.mostrarColor();

        System.out.println("El area del cuadrado es: " + figura.calcularArea());
    }

}
