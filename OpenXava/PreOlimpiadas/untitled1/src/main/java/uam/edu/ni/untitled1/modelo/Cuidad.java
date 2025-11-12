package uam.edu.ni.untitled1.modelo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="cuidades")
@Getter @Setter
public class Cuidad {


    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String oid;

    @Size(min = 3, max = 60)
    @Column(name ="nombre_cuidad", nullable = false, length = 60 )
    @Required(message = "El nombre es obligatorio")
    private String nombre;


    @Column(name = "poblacion_cuidad", nullable = false)
    private int poblacion;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
