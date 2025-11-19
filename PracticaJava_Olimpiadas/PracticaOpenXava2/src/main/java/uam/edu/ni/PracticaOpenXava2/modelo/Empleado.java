package uam.edu.ni.PracticaOpenXava2.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity@Getter@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long id;


    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
}
