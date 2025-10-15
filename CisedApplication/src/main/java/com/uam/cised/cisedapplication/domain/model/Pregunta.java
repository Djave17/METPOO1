package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column( nullable = false, length = 1000)
    private String texto;

    @NotBlank
    @Column( nullable = false, length = 40)
    private String tipo; // e.g., "abierta", "cerrada", "multiple", "likert"


    @Column( nullable = false)
    private Integer peso;

    // Nueva relación para permitir consultas por formularioId
    @ManyToOne
    @JoinColumn(name = "formulario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pregunta_formulario"))
    private Formulario formulario;

    // getters/setters (si usas Lombok, estos pueden no ser necesarios)
    public Formulario getFormulario() { return formulario; }
    public void setFormulario(Formulario formulario) { this.formulario = formulario; }

}
