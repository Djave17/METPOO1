package models;

public class Gato extends Animal {

    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    public void sonido() {
        System.out.println("Miau");
        SoundPlayer.playResource("/sounds/cat.mp3");
    }
}

