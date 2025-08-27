package run;

public class Libro {

    String nombre;
    String autor;
    String sinopsis;
    int anioPublicacion;
    int numeroPaginas;


    public String mostrarInfo(){
        return "Nombre: " + nombre + ", Autor: " + autor + ", Sinopsis: " + sinopsis + ", Año de Publicación: " + anioPublicacion + ", Número de Páginas: " + numeroPaginas;
    }
}
