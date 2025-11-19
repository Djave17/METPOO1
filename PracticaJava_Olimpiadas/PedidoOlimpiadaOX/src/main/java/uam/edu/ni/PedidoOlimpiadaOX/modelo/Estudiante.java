package uam.edu.ni.PedidoOlimpiadaOX.modelo;


import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    private Long id;

    private String nombre;

    private String apellido;

    private String cif;

    private String email;

    @ManyToOne
    @JoinColumn(name = "curso")
    private Curso curso;
}
