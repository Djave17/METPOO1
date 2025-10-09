package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carreras")
@Getter @Setter
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_carrera", length = 100, nullable = false)
    private String nombre;

    @Column(name = "precio_carrera", nullable = false)
    private float precio;

    @Override
    public String toString() {
        return "Datos de la Carrera" + '\n' +
                "id: " + id +
                "| nombre: '" + nombre + '\n' +
                "| precio: " + precio + '\n' +
                "=================================================";
    }

    public Carrera(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Carrera(){}


}
