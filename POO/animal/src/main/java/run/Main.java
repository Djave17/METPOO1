package run;

import models.*;
public class Main {
    public static void main(String[] args) {
        Gato g = new Gato("Misu", 2);
        g.sonido();

        Perro p = new Perro("Firulais", 3);
        p.sonido();
    }
}