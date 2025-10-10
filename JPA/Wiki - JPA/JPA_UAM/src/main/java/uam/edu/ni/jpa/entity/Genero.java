package uam.edu.ni.jpa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String nombre;

    // Relación inversa: un género puede tener varias películas
    // Esto se hace con un mappedBy, y facilita la conexion
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pelicula> peliculas;

    public Genero() {}
    public Genero(String nombre) {
        this.nombre = nombre;
    }


    public Long getId() { return id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Pelicula> getPeliculas() { return peliculas; }

    public void setPeliculas(List<Pelicula> peliculas) { this.peliculas = peliculas; }

}
