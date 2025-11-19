package uam.edu.ni.PedidoOlimpiadaOX.modelo;


import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Tab(name = "id")
@View(name =
        "id;" +
                "Curso : { cursos } "
)
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    private Long id;

    @Column(length = 200)
    private String nombre;

    @OneToMany
    @JoinColumn(name = "curso_id")
    private List<Curso> cursos;






}
