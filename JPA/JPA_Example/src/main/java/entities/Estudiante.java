package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estudiantes")
@Getter @Setter
public class Estudiante {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cif", length = 8, nullable = false, unique = true)
    private String cif;

    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @ManyToOne
    @JoinColumn(name = "carrera_id", nullable = false)
    private Carrera carrera;

    public Estudiante(String cif, String nombres, String apellidos, Carrera carrera) {
        this.cif = cif;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.carrera = carrera;
    }

    public Estudiante() {
    }


}
