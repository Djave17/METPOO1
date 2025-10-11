package entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Empleado")
@Getter
@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_empleado", length = 100, nullable = false)
    private String nombreEmpleado;

    @Column(name = "salario", nullable = false)
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private Cargo cargo;

    public Empleado() {

    }

    public Empleado(String nombreEmpleado, Double salario, Cargo cargo) {
        this.nombreEmpleado = nombreEmpleado;
        this.salario = salario;
        this.cargo = cargo;
    }

    // --- Getters (necesarios para listar en tablas/combos de la UI) ---
    public Long getId() { return id; }
    public String getNombreEmpleado() { return nombreEmpleado; }
    public Double getSalario() { return salario; }
    public Cargo getCargo() { return cargo; }

    public void setId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del empleado no puede ser nulo.");
        }
        this.id = id;
    }
    public void setNombreEmpleado(String nombreEmpleado) {
        if (nombreEmpleado == null || nombreEmpleado.isBlank()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío.");
        }
        this.nombreEmpleado = nombreEmpleado.trim();

    }
    public void setSalario(Double salario) {
        if (salario <= 0 ) {
            throw new IllegalArgumentException("El salario no puede ser negativo.");
        }else if (salario == null) {
            throw new IllegalArgumentException("El salario no puede ser nulo.");
        }
        this.salario = salario;
    }

    public void setCargo(Cargo cargo) {
        if (cargo == null) {
            throw new IllegalArgumentException("El cargo no puede ser nulo.");
        }
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return String.format("Empleado [id = %d, nombreEmpleado = '%s', salario = %.2f, cargo = %s]", id, nombreEmpleado, salario, cargo);
    }
}
