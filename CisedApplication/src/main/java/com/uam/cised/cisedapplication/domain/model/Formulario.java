package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Formulario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombreFormulario;



    @Column(nullable=false)
    private boolean activo = true;

    //Existen tres tipos de formularios: Docente, Estudiante y Administrativo, por lo que se crea una clase tipo formulario para
    //diferenciar los tipos de formularios
    @ManyToOne(optional=false)
    @JoinColumn(name = "tipo_formulario_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_formulario_tipo"))
    private TipoFormulario tipo;


    @Column(nullable = false) // Incrementado para control de versiones
    @Version
    private Integer version;


    //Relacion con entidad Pregunta
    /**
     * COMPOSICIÓN:
     * - Unidireccional de Formulario → Pregunta
     * - Crea la FK formulario_id en la tabla pregunta.
     * - Cascade + orphanRemoval para que el ciclo de vida lo controle el agregado.
     * - @OrderBy asegura orden estable por 'orden'.
     */
    @OneToMany(mappedBy = "formulario", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC")
    private List<Pregunta> preguntas = new ArrayList<>();



    public Formulario(String nombreFormulario, TipoFormulario tipo, List<Pregunta> preguntas, boolean activo) {
        this.nombreFormulario = nombreFormulario;
        this.tipo = tipo;
        this.preguntas = preguntas;
        this.activo = activo;//por defecto un formulario se crea como activo

    }

    public Formulario() {}

    // getters/setters
    public Long getId() { return id; }
    public String getNombreFormulario() { return nombreFormulario; }
    public void setNombreFormulario(String nombreFormulario) { this.nombreFormulario = nombreFormulario; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
    public List<Pregunta> getPreguntas() { return preguntas; }
    public void setPreguntas(List<Pregunta> preguntas) { this.preguntas = preguntas; }


}
