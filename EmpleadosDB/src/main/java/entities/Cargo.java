package entities;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "Cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "nombre_cargo", length = 100, nullable = false)
    private String nombreCargo;

    public Cargo() {

    }

    public Cargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;

    }

    public Long getId() {
        return id;
    }

    // Eliminado: getNombre(Long id) ya que no es un getter válido y causa confusión
}
