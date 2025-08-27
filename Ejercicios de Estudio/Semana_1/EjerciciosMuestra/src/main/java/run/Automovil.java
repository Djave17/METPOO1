package run;

public class Automovil {

    String marca;
    int año;
    String color;
    String modelo;

    public String mostrarInfo(){
        return "Marca: " + marca + ", Año: " + año + ", Color: " + color + ", Modelo: " + modelo;
    }

    public void arrancar(){
        System.out.println("El automóvil ha arrancado.");
    }

}
