package uam.edu.ni.PracticaOpenXava2.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Hidden;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Departamento {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=50)
    private String nombre;
}
