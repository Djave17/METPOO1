package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Cargo")
@Getter @Setter
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        if (nombreCargo == null || nombreCargo.isBlank()) {
            throw new IllegalArgumentException("El nombre del cargo no puede estar vacío.");
        }
        this.nombreCargo = nombreCargo.trim();
    }

}
