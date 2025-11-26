package uam.edu.ni.PracticaOlimpiadas.modelo;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Tab(properties = "id")
@Setter
@View(members =
        "id;" +
    "Bebidas { bebida };" +
    "Postres { postre };" +
    "Platos { plato }"
)
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    private Long id;

    @OneToMany(mappedBy = "carrito")
    @ListProperties("nombre, precio")

    private List<Bebida> bebida;

    @OneToMany(mappedBy = "carrito")
    @ListProperties("nombre, precio")

    private List<Postre> postre;

    @OneToMany(mappedBy = "carrito")
    @ListProperties("nombre, precio")
    private List<Plato> plato;

}
