package run;

public class Ejercicio1 {

    public static void main(String[] args) {

        // Create two instances of Persona and display their data
        Persona persona1 = new Persona();
        persona1.nombre = "Juan";
        persona1.edad = 25;

        // Second instance
        Persona persona2 = new Persona();
        persona2.nombre = "María";
        persona2.edad = 30;

        // Display data of both instances
        System.out.println(persona1.mostrarDatos());
        System.out.println(persona2.mostrarDatos());
    }

}
