package models;

public class Carrera {


   //Atributos
    private String nombre;
    private String codigo;
    private double precio;

    //Constructor
    public Carrera() {

    }

    public Carrera(String nombre, String codigo, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
    }


    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }


    //Setters
    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve una representación en cadena de la carrera, incluyendo nombre, código y precio.
     * @return String con los atributos de la carrera.
     */
    @Override
    public String toString() {
        return "Carrera{" + "nombre = '" + nombre + '\'' + ", codigo = '" + codigo + '\'' + ", precio = " + precio + '}';
    }




}
