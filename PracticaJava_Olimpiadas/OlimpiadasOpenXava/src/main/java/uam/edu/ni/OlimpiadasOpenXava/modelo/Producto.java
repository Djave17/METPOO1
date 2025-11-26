package uam.edu.ni.OlimpiadasOpenXava.modelo;

import lombok.*;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Required
    private double precio;

    @Required
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "carrito_id") // Columna FK en la tabla PRODUCTO
    private Carrito carrito;




}
