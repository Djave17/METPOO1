package clases;

public class Jugador {

    // Atributos
    private String nombre;
    private char ficha;


    //Constructores
    public Jugador(String nombre, char ficha) {
        this.nombre = nombre;
        this.ficha = ficha;
    }

   public Jugador() {}


    //Getters y Setters

    //Nombre
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Ficha
    public char getFicha() { return ficha; }

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }

}
