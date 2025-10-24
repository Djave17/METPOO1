package uam.edu.ni.uam_app.modelo;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.model.Identifiable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter @Setter
public class Estudiante  {

    @Id
    private String cif;

    @Column(name = "Nombre", length = 50, nullable = false)
    @Required(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name = "Apellido", length = 100, nullable = false)
    @Required(message = "El apellido es obligatorio")
    private String apellidos;

    @Column(name = "Fecha_Nacimiento")
    @Required(message = "La fecha de nacimiento es obligatoria")
    LocalDate fechaNacimiento;
}

