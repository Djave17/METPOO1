package uam.edu.ni.PedidoOlimpiadaOX.modelo;


import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    private Long id;

    private String codigo;

    private String nombre;

    @OneToMany
    @JoinColumn(name = "estudiante_id")
    private List<Estudiante> estudiantes;

    @ManyToOne
    @JoinColumn(name = "facultad")
    private Facultad facultad;


}
