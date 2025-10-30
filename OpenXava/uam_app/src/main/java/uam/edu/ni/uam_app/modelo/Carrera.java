package uam.edu.ni.uam_app.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carrera {

    @Id
    private String id;

    @Column
    private String nombre;


}
