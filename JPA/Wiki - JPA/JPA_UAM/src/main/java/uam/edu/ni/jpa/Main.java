package uam.edu.ni.jpa;
import uam.edu.ni.jpa.vistas.PeliculaConsola;
import jakarta.persistence.EntityManager;
import uam.edu.ni.jpa.util.JpaUtil;
import uam.edu.ni.jpa.entity.Genero;
import uam.edu.ni.jpa.entity.Pelicula;
import java.time.LocalDate;
public class Main {

    public static void main(String[] args) {

        PeliculaConsola p = new PeliculaConsola();
        p.menu();
    }

}
