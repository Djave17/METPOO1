package uam.edu.ni.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(
                name = "Pelicula.entreFechas",
                query = "select p from Pelicula p " +
                        "where p.fechaEstreno between :desde and :hasta " +
                        "order by p.fechaEstreno, p.titulo"
        ),
        @NamedQuery(
                name = "Pelicula.delAnio",
                query = "select p from Pelicula p " +
                        "where extract(year from p.fechaEstreno) = :anio " +
                        "order by p.titulo"
        )
})
@Entity //TODO: INVESTIGAR
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental: TODO: INVESTIGAR ESTO
    private Long id;

    @Column(nullable = false, length = 150) //CREAMOS COLUMNA NOT NULL Y LONGITUD MAXIMA DE 150
    private String titulo;

    @Column(nullable = false, length = 100)
    private String director;

    @Column(name = "fecha_estreno", nullable = false)
    private LocalDate fechaEstreno;

    @Column(nullable = false)
    private double rating;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;

    public Pelicula() {}

    public Pelicula(String titulo, String director, LocalDate fechaEstreno, double rating, Genero genero) {
        this.titulo = titulo;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
        this.rating = rating;
        this.genero = genero;
    }

    // getters/setters
    public Long getId() { return id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDirector() { return director; }

    public void setDirector(String director) { this.director = director; }

    public LocalDate getFechaEstreno() { return fechaEstreno; }

    public void setFechaEstreno(LocalDate fechaEstreno) { this.fechaEstreno = fechaEstreno; }

    public double getRating() { return rating; }

    public void setRating(double rating) { this.rating = rating; }

    public Genero getGenero() { return genero; }

    public void setGenero(Genero genero) { this.genero = genero; }


}

/*Genero tiene una lista de Pelicula → @OneToMany.

Pelicula tiene un solo Genero → @ManyToOne con @JoinColumn("genero_id").

En la base de datos, Hibernate creará:

Una tabla generos con id y nombre.

Una tabla peliculas con genero_id como foreign key.*/