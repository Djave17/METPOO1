package com.uam.cised.cisedapplication.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity(name = "programa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 250)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;

    @OneToMany(mappedBy = "programa", orphanRemoval = false)
    private List<Asignatura> asignaturas = new java.util.ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "nivel_formacion_id",
            foreignKey = @ForeignKey(name = "fk_programa_nivel_formacion"))
    private NivelFormacion nivelFormacion;

    @Column(name = "edicion")
    private Integer edicion;
}
