package uam.edu.ni.OlimpiadasOpenXava.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Carrito {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Un carrito tiene muchos productos
    @OneToMany(mappedBy = "carrito")
    private List<Producto> productos;

}
