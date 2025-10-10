package models;

public class Circulo extends Figura {

    double radio;
    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.round(Math.PI * (radio * radio) * 100) / 100;
    }

}
