package models;

public abstract class Figura {

    String color;
    public Figura(String color) {
        this.color = color;

    }

    public abstract double calcularArea();

    public String getColor() {
        return color;
    }
    public void mostrarColor() {
        System.out.println("El color de la figura es: " + color);
    }

}
