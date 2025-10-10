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

    public Long getId() {
        return id;
    }
    
    public String getNombre(){
        return this.nombreEmpleado;
    }
    
    
}
