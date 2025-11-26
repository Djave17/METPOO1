package uam.edu.ni.PracticaOlimpiadas.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ReadOnly;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    private Long id;

    @Column(length=50)
    private String nombre;

    @Required
    private double precio;

    @ManyToOne
    @JoinColumn(name="carrito")
    private Carrito carrito;
}
